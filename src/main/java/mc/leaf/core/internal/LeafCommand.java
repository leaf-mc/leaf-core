package mc.leaf.core.internal;

import mc.leaf.core.api.command.PluginCommandImpl;
import mc.leaf.core.api.command.annotations.MinecraftCommand;
import mc.leaf.core.api.command.annotations.Param;
import mc.leaf.core.api.command.annotations.Sender;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.interfaces.ILeafModule;
import mc.leaf.core.utils.MinecraftColors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LeafCommand extends PluginCommandImpl {

    public LeafCommand(ILeafCore core) {

        super(core);
    }

    @MinecraftCommand(value = "", allowConsole = true, allowCommandBlock = true)
    public void noArgs(@Sender CommandSender sender) {

        sender.sendMessage(
                String.format("%s Plugin version %s",
                        PluginCommandImpl.PREFIX,
                        this.getCore().asPlugin().getPluginMeta().getVersion()
                )
        );

    }

    @MinecraftCommand(value = "modules", allowConsole = true)
    public void getLoadedModules(@Sender CommandSender sender) {

        if (this.getCore().getLeafModules().isEmpty()) {
            sender.sendMessage(String.format("%s There is no module available.", PluginCommandImpl.PREFIX));
            return;
        }

        List<Component> components = new ArrayList<>();
        for (ILeafModule module : this.getCore().getLeafModules()) {
            String description = module.getPlugin().getPluginMeta().getDescription();

            Component moduleNameComponent = Component
                    .text(module.getName())
                    .color(module.isEnabled() ? MinecraftColors.GREEN : MinecraftColors.RED);

            Component moduleVersionComponent = Component
                    .text(module.getPlugin().getPluginMeta().getVersion())
                    .color(MinecraftColors.AQUA);

            Component moduleDescriptionComponent;
            if (description == null) {
                moduleDescriptionComponent = Component
                        .text("No description provided")
                        .style(Style.style(TextColor.color(MinecraftColors.GRAY), TextDecoration.ITALIC));
            } else {
                moduleDescriptionComponent = Component
                        .text(description)
                        .color(MinecraftColors.WHITE);
            }

            components.add(Component
                    .text()
                    .append(moduleNameComponent)
                    .append(Component.space())
                    .append(moduleVersionComponent)
                    .append(Component.newline())
                    .append(moduleDescriptionComponent)
                    .asComponent()
            );
        }

        TextComponent.Builder builder = Component.text();
        for (int i = 0; i < components.size(); i++) {
            builder.append(components.get(i));

            if (i + 1 != components.size()) {
                builder.append(Component.newline()).append(Component.newline());
            }
        }

        sender.sendMessage(builder.asComponent());
    }

    @MinecraftCommand("modules {modules} {actionState}")
    public void switchModuleState(@Sender CommandSender sender, @Param String modules, @Param String actionState) {

        Optional<ILeafModule> moduleSearch = this.getCore().getLeafModules().stream()
                .filter(module -> module.getName().equalsIgnoreCase(modules)).findFirst();

        if (moduleSearch.isEmpty()) {
            sender.sendMessage(String.format("%s This module doesn't exists.", PluginCommandImpl.PREFIX));
            return;
        }

        ILeafModule module = moduleSearch.get();

        if (actionState.equalsIgnoreCase("enable") && module.isEnabled()) {
            sender.sendMessage(String.format("%s The module is already enabled.", PluginCommandImpl.PREFIX));
        } else if (actionState.equalsIgnoreCase("disable") && !module.isEnabled()) {
            sender.sendMessage(String.format("%s The module is already disabled.", PluginCommandImpl.PREFIX));
        } else if (actionState.equalsIgnoreCase("enable")) {
            module.onEnable();
            sender.sendMessage(String.format("%s The module has been enabled.", PluginCommandImpl.PREFIX));
        } else if (actionState.equalsIgnoreCase("disable")) {
            module.onDisable();
            sender.sendMessage(String.format("%s The module has been disabled.", PluginCommandImpl.PREFIX));
        }
    }

}
