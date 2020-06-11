package mc.leaf.core.api.command.interfaces;

import mc.leaf.core.api.command.exceptions.*;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.services.completion.interfaces.ICompletionService;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.lang.reflect.Method;

/**
 * Interface representing a Minecraft command with auto-completion provided by Leaf.
 *
 * @author alexpado
 */
public interface IPluginCommand extends TabExecutor {

    ILeafCore getCore();

    ICompletionService<Method> getCompletionService();

    void register(String name);

    void handle(CommandException exception, CommandSender sender);

}
