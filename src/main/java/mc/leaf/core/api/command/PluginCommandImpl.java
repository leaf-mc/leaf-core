package mc.leaf.core.api.command;

import mc.leaf.core.api.command.annotations.Param;
import mc.leaf.core.api.command.annotations.MinecraftCommand;
import mc.leaf.core.api.command.annotations.Sender;
import mc.leaf.core.api.command.exceptions.CommandException;
import mc.leaf.core.api.command.exceptions.*;
import mc.leaf.core.api.command.interfaces.IPluginCommand;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.services.completion.CompletionServiceImpl;
import mc.leaf.core.services.completion.SyntaxContainer;
import mc.leaf.core.services.completion.interfaces.ICompletionService;
import mc.leaf.core.services.completion.interfaces.IMatchingResult;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PluginCommandImpl implements IPluginCommand {

    public static final String PREFIX = "§l[§aLeaf§bCore§r§l]§r";

    private final ILeafCore                        core;
    private final HashMap<Method, SyntaxContainer> commandMap = new HashMap<>();

    protected PluginCommandImpl(ILeafCore core) {

        this.core = core;
    }

    private static void validateExecutableStatus(CommandSender sender, MinecraftCommand minecraftCommand) {

        if (sender instanceof ConsoleCommandSender && !minecraftCommand.allowConsole()) {
            throw new IllegalCommandSenderException("Running this command as console isn't supported.");
        } else if (sender instanceof BlockCommandSender && !minecraftCommand.allowCommandBlock()) {
            throw new IllegalCommandSenderException("Running this command in a command block isn't supported.");
        } else if (sender instanceof Player && !minecraftCommand.allowPlayer()) {
            throw new IllegalCommandSenderException("Running this command as player isn't supported.");
        }

        if ((minecraftCommand.opOnly() && !sender.isOp()) || (!minecraftCommand.permission().isEmpty() && !sender
                .hasPermission(minecraftCommand.permission()))) {
            throw new PermissionException("You do not have the permission to do this.");
        }
    }

    private List<Object> generateParameterList(IMatchingResult<Method> matchingResult, Method method, CommandSender sender) {

        MinecraftCommand minecraftCommand = method.getAnnotation(MinecraftCommand.class);
        List<Object>     methodParameters = new ArrayList<>();

        List<Class<?>> consoleClasses = Arrays.asList(CommandSender.class, ConsoleCommandSender.class);
        List<Class<?>> blockClasses   = Arrays.asList(CommandSender.class, BlockCommandSender.class);
        List<Class<?>> playerClasses  = Arrays.asList(CommandSender.class, Player.class);

        for (Parameter parameter : method.getParameters()) {
            if (parameter.isAnnotationPresent(Sender.class)) {
                boolean console = !minecraftCommand.allowConsole() || consoleClasses.contains(parameter.getType());
                boolean block   = !minecraftCommand.allowCommandBlock() || blockClasses.contains(parameter.getType());
                boolean player  = !minecraftCommand.allowPlayer() || playerClasses.contains(parameter.getType());

                if (!console || !block || !player) {
                    throw new ConfigurationException("The @Sender field is wrongly configured: Please check that allowed entity types match the field type.");
                }

                methodParameters.add(sender);
            } else if (parameter.isAnnotationPresent(Param.class)) {
                Param  param = parameter.getAnnotation(Param.class);
                String name  = param.value().isEmpty() ? parameter.getName() : param.value();
                try {
                    Object converted = this.core.getConverters()
                                                .get(parameter.getType())
                                                .convert(matchingResult.getParameter(name));
                    methodParameters.add(converted);
                } catch (Exception e) {
                    throw new ConfigurationException(String.format("The `%s` parameter is wrongly configured: Unable to create or use the provided converter.", name), e);
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

    @Override
    public final ICompletionService<Method> getCompletionService() {

        return new CompletionServiceImpl<>(this.commandMap);
    }

    @Override
    public final ILeafCore getCore() {

        return this.core;
    }

    private IMatchingResult<Method> getMatch(String... args) {

        return this.getCompletionService().getMatchingIdentifier(String.join(" ", args))
                   .orElseThrow(() -> new SyntaxException("Command not found. Please check your syntax."));
    }

    @Override
    public void handle(CommandException exception, CommandSender sender) {

        sender.sendMessage(String.format("%s §c%s", PREFIX, exception.getMessage()));
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
            this.readCommandData();
            IMatchingResult<Method> matchingResult = this.getMatch(args);
            Method           exec             = matchingResult.getIdentifier();
            MinecraftCommand minecraftCommand = exec.getAnnotation(MinecraftCommand.class);
            PluginCommandImpl.validateExecutableStatus(sender, minecraftCommand);
            List<Object> parameters = this.generateParameterList(matchingResult, exec, sender);
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

        this.readCommandData();
        return this.getCompletionService().complete(String.join(" ", args));
    }

    private void readCommandData() {

        this.commandMap.clear();
        for (Method declaredMethod : this.getClass().getDeclaredMethods()) {
            if (declaredMethod.getAnnotation(MinecraftCommand.class) != null) {
                MinecraftCommand r         = declaredMethod.getAnnotation(MinecraftCommand.class);
                List<String>     args      = Arrays.asList(r.value().split(" "));
                SyntaxContainer  container = this.core.createContainer(args);
                this.commandMap.put(declaredMethod, container);
            }
        }
    }

    @Override
    public final void register(String name) {

        PluginCommand command = Bukkit.getPluginCommand(name);
        if (command != null) {
            command.setExecutor(this);
            command.setTabCompleter(this);
        }
    }

}
