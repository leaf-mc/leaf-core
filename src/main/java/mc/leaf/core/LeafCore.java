package mc.leaf.core;

import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.interfaces.ILeafModule;
import mc.leaf.core.interfaces.impl.LeafModule;
import mc.leaf.core.internal.LeafCommand;
import mc.leaf.core.internal.LeafInternalListener;
import mc.leaf.core.services.completion.SyntaxContainer;
import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class LeafCore extends JavaPlugin implements ILeafCore {

    private final List<ILeafModule>         modules = new ArrayList<>();
    private       Map<String, List<String>> dynamicOptions;

    /**
     * Create a {@link SyntaxContainer} for the provided {@link List} of {@link String}
     *
     * @param items
     *         The {@link List} to convert.
     *
     * @return A {@link SyntaxContainer}.
     */
    @Override
    public SyntaxContainer createContainer(List<String> items) {

        return new SyntaxContainer(items.stream().map(item -> ISyntax.getSyntax(item, this.dynamicOptions))
                .collect(Collectors.toList()));
    }

    @Override
    public void onDisable() {

        this.modules.forEach(module -> {
            String moduleName = module.getName();
            Logger logger     = this.getLogger();

            logger.info("Disabling " + moduleName + "...");

            if (module.disable(false)) {
                logger.info("Successfully disabled " + moduleName);
            } else {
                logger.warning("Unable to disable " + moduleName);
            }
        });
        this.dynamicOptions = null;
        this.modules.clear();
    }

    @Override
    public void onEnable() {

        this.dynamicOptions = new HashMap<>();
        new LeafCommand(this).register("leaf");
        Bukkit.getPluginManager().registerEvents(new LeafInternalListener(this), this);

        this.registerDynamicOptions("player", Bukkit.getOnlinePlayers().stream().map(Player::getName).toList());
        this.registerDynamicOptions("actionState", Arrays.asList("enable", "disable"));
        this.registerDynamicOptions("newState", Arrays.asList("enabled", "disabled"));
        this.registerDynamicOptions("booleanState", Arrays.asList("true", "false"));
        this.registerDynamicOptions("namedState", Arrays.asList("on", "off"));
        this.registerDynamicOptions("numState", Arrays.asList("1", "0"));

        BukkitRunnable runnable = new BukkitRunnable() {

            @Override
            public void run() {

                Logger logger = LeafCore.this.getLogger();

                logger.info("Enabling modules...");

                for (ILeafModule module : LeafCore.this.modules) {
                    String moduleName = module.getName();

                    logger.info(" Enabling " + moduleName + "...");
                    if (module.enable()) {
                        logger.info(" Successfully enabled " + moduleName);
                    } else {
                        logger.warning(" Unable to enable " + moduleName);
                    }
                }
            }
        };
        runnable.runTaskLater(this, 1L);
    }

    @Override
    public void registerDynamicOptions(String name, List<String> options) {

        this.dynamicOptions.put(name, options);
    }

    @Override
    public List<ILeafModule> getLeafModules() {

        return this.modules;
    }

    @Override
    public void registerModule(LeafModule module) {

        this.modules.add(module);
        this.registerDynamicOptions("modules", this.modules.stream().map(ILeafModule::getName).toList());
    }

    /**
     * Retrieve this {@link ILeafCore} in its {@link JavaPlugin} instance.
     *
     * @return A {@link JavaPlugin}
     */
    @Override
    public JavaPlugin asPlugin() {

        return this;
    }

}
