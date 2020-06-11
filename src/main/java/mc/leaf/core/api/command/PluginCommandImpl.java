package mc.leaf.core.api.command;

import mc.leaf.core.api.command.annotations.Param;
import mc.leaf.core.api.command.annotations.Runnable;
import mc.leaf.core.api.command.annotations.Sender;
import mc.leaf.core.api.command.exceptions.*;
import mc.leaf.core.api.command.exceptions.CommandException;
import mc.leaf.core.api.command.interfaces.IParameterConverter;
import mc.leaf.core.api.command.interfaces.IPluginCommand;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.services.completion.CompletionServiceImpl;
import mc.leaf.core.services.completion.interfaces.ICompletionService;
import mc.leaf.core.services.completion.interfaces.IMatchingResult;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class PluginCommandImpl implements IPluginCommand {

    private static final String PREFIX   = "§l[§aLeaf§bCore§r§l]";
    private static final String PREFIX_C = "[§aLeaf§bCore§r]";

    private final ILeafCore                     core;
    private final HashMap<Method, List<String>> commandMap = new HashMap<>();

    protected PluginCommandImpl(ILeafCore core) {
        this.core = core;
        this.readCommandData();
    }

    private void readCommandData() {
        for (Method declaredMethod : this.getClass().getDeclaredMethods()) {
            if (declaredMethod.getAnnotation(Runnable.class) != null) {
                Runnable r = declaredMethod.getAnnotation(Runnable.class);
                this.commandMap.put(declaredMethod, Arrays.asList(r.value().split(" ")));
            }
        }
    }

    @Override
    public final ILeafCore getCore() {
        return this.core;
    }

    @Override
    public final ICompletionService<Method> getCompletionService() {
        return new CompletionServiceImpl<>(this.commandMap, this.core.getDynamicOptions());
    }

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command (if defined) will be sent to the
     * player.
     *
     * @param sender
     *         Source of the command
     * @param command
     *         Command which was executed
     * @param label
     *         Alias of the command which was used
     * @param args
     *         Passed command arguments
     *
     * @return true if a valid command, otherwise false
     */
    @Override
    public final boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        try {
            IMatchingResult<Method> matchingResult = this.getMatch(args);
            Method                  exec           = matchingResult.getIdentifier();
            Runnable                runnable       = exec.getAnnotation(Runnable.class);
            PluginCommandImpl.validateExecutableStatus(sender, runnable);
            List<Object> parameters = PluginCommandImpl.generateParameterList(matchingResult, exec, sender);
            this.call(exec, parameters);
        } catch (CommandException e) {
            Bukkit.getLogger().severe(String
                    .format("[LeafCore] An error occurred while handling the '%s' command: %s", label, e.getMessage()));
            this.handle(e, sender);
        }
        return true;
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender
     *         Source of the command.  For players tab-completing a command inside of a command block, this will be the
     *         player, not the command block.
     * @param command
     *         Command which was executed
     * @param alias
     *         The alias used
     * @param args
     *         The arguments passed to the command, including final partial argument to be completed and command label
     *
     * @return A List of possible completions for the final argument, or null to default to the command executor
     */
    @Override
    public final @NotNull List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return this.getCompletionService().complete(String.join(" ", args));
    }

    @Override
    public final void register(String name) {
        PluginCommand command = Bukkit.getPluginCommand(name);
        if (command != null) {
            command.setExecutor(this);
            command.setTabCompleter(this);
        }
    }

    @Override
    public void handle(CommandException exception, CommandSender sender) {
        sender.sendMessage(String.format("%s §r§c%s", PREFIX, exception.getMessage()));
    }

    private Map<Method, List<String>> getCommandMapping() {
        Map<Method, List<String>> map = new HashMap<>();

        for (Method declaredMethod : this.getClass().getDeclaredMethods()) {
            Runnable runnable = declaredMethod.getAnnotation(Runnable.class);

            if (runnable != null) {
                map.put(declaredMethod, Arrays.asList(runnable.value().split(" ")));
            }
        }

        return map;
    }

    private IMatchingResult<Method> getMatch(String... args) {
        return this.getCompletionService().getMatchingIdentifier(String.join(" ", args))
                .orElseThrow(() -> new SyntaxException("Command not found. Please check your syntax."));
    }

    private static void validateExecutableStatus(CommandSender sender, Runnable runnable) {
        if (sender instanceof ConsoleCommandSender && !runnable.allowConsole()) {
            throw new IllegalCommandSenderException("Running this command as console isn't supported.");
        } else if (sender instanceof BlockCommandSender && !runnable.allowCommandBlock()) {
            throw new IllegalCommandSenderException("Running this command in a command block isn't supported.");
        } else if (sender instanceof Player && !runnable.allowPlayer()) {
            throw new IllegalCommandSenderException("Running this command as player isn't supported.");
        }

        if ((runnable.opOnly() && !sender.isOp()) || (!runnable.permission().isEmpty() && !sender
                .hasPermission(runnable.permission()))) {
            throw new PermissionException("You do not have the permission to do this.");
        }
    }

    private static List<Object> generateParameterList(IMatchingResult<Method> matchingResult, Method method, CommandSender sender) {
        Runnable     runnable              = method.getAnnotation(Runnable.class);
        List<Object> methodParameters = new ArrayList<>();

        List<Class<?>> consoleClasses = Arrays.asList(CommandSender.class, ConsoleCommandSender.class);
        List<Class<?>> blockClasses   = Arrays.asList(CommandSender.class, BlockCommandSender.class);
        List<Class<?>> playerClasses  = Arrays.asList(CommandSender.class, Player.class);

        for (Parameter parameter : method.getParameters()) {
            if (parameter.isAnnotationPresent(Sender.class)) {
                boolean console = !runnable.allowConsole() || consoleClasses.contains(parameter.getType());
                boolean block   = !runnable.allowCommandBlock() || blockClasses.contains(parameter.getType());
                boolean player  = !runnable.allowPlayer() || playerClasses.contains(parameter.getType());

                if (!console || !block || !player) {
                    throw new ConfigurationException("The @Sender field is wrongly configured: Please check that allowed entity types match the field type.");
                }

                methodParameters.add(sender);
            } else if (parameter.isAnnotationPresent(Param.class)) {
                Param param = parameter.getAnnotation(Param.class);

                Class<? extends IParameterConverter<String, ?>> converter = param.converter();
                try {
                    IParameterConverter<String, ?> pConverter = converter.newInstance();
                    methodParameters.add(pConverter.convert(matchingResult.getParameter(parameter.getName())));
                } catch (Exception e) {
                    throw new ConfigurationException(String.format("The `%s` is wrongly configured: Unable to create or use the provided converter.", parameter.getName()));
                }
            }
        }

        return methodParameters;
    }

    private void call(Method method, List<Object> values) {
        try {
            method.invoke(this, values.toArray());
        } catch (Exception e) {
            throw new ExecutionException(e, "Unable to execute the command.");
        }
    }

}
