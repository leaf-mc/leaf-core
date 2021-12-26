package mc.leaf.core.internal;

import mc.leaf.core.api.command.PluginCommandImpl;
import mc.leaf.core.api.command.annotations.Runnable;
import mc.leaf.core.api.command.annotations.Sender;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.interfaces.ILeafModule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;

public class LeafCommand extends PluginCommandImpl {

    public LeafCommand(ILeafCore core) {

        super(core);
    }

    @Runnable(value = "version", allowConsole = true)
    public void getCoreVersion(@Sender CommandSender sender) {

        sender.sendMessage(String.format("%s Plugin version 0.1-dev", PluginCommandImpl.PREFIX));
    }

    @Runnable(value = "modules", allowConsole = true)
    public void getLoadedModules(@Sender CommandSender sender) {

        for (ILeafModule module : this.getCore().getLeafModules()) {
            sender.sendMessage(Component.text(module.getName()).color(TextColor.color(0, 255, 255)));
        }
    }

}
