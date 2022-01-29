package mc.leaf.core.interfaces.impl;

import mc.leaf.core.api.command.PluginCommandImpl;
import mc.leaf.core.events.LeafListener;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.interfaces.ILeafModule;
import mc.leaf.core.internal.DefaultCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.logging.Logger;

public abstract class LeafModule implements ILeafModule {

    private final ILeafCore                core;
    private final JavaPlugin               plugin;
    private final List<Listener>           registeredListeners;
    private final Map<String, TabExecutor> commandExecutors;
    private       boolean                  enabled = false;

    /**
     * Creates a new {@link ILeafModule} instance.
     *
     * @param core
     *         The {@link ILeafCore} to use for this module.
     * @param plugin
     *         The {@link JavaPlugin} to which this {@link ILeafModule} belongs.
     */
    public LeafModule(ILeafCore core, JavaPlugin plugin) {

        this.core                = core;
        this.plugin              = plugin;
        this.registeredListeners = new ArrayList<>();
        this.commandExecutors    = new HashMap<>();
    }

    /**
     * Alias method.
     *
     * @param message
     *         The message to log
     */
    private void info(String message) {

        this.getPlugin().getLogger().info(message);
    }

    /**
     * Enable this {@link ILeafModule}.
     *
     * @return True if the {@link ILeafModule} has been enabled without errors.
     */
    @Override
    public final boolean enable() {

        try {
            this.onEnable();
            Logger logger = this.getPlugin().getLogger();

            for (Listener listener : this.getListeners()) {
                logger.info("Registering listener " + listener.getClass().getName() + "...");
                Bukkit.getPluginManager().registerEvents(listener, this.getPlugin());
                this.registeredListeners.add(listener);
            }

            this.getCommands().forEach((label, handler) -> {
                logger.info("Registering command '" + label + "' using " + handler.getClass().getName() + "...");
                PluginCommand command = Bukkit.getPluginCommand(label);

                if (command == null) {
                    this.info(String.format("Unable to register command '%s': Did you added it in your plugin.yml file ?", label));
                    return;
                }

                command.setExecutor(handler);
                this.commandExecutors.put(label, handler);
            });

            this.enabled = true;
        } catch (Exception e) {
            this.getPlugin().getLogger().severe(e.getMessage());
            this.enabled = false;
        }

        return this.enabled;
    }

    /**
     * Disable this {@link ILeafModule}.
     *
     * @param mayUseDefaultCommand
     *         Define if a default command should replace the old command.
     *
     * @return True if the {@link ILeafModule} has been disabled without errors.
     */
    @Override
    public final boolean disable(boolean mayUseDefaultCommand) {

        try {
            this.onDisable();
            Logger logger = this.getPlugin().getLogger();

            for (Listener listener : this.registeredListeners) {
                logger.info("Unregistering listener " + listener.getClass().getName() + "...");
                HandlerList.unregisterAll(listener);
            }
            this.registeredListeners.clear();

            for (String label : this.commandExecutors.keySet()) {
                logger.info("Unregistering command '" + label + "'...");
                PluginCommand command = Bukkit.getPluginCommand(label);
                if (command != null && command.getExecutor() == this.commandExecutors.get(label)) {
                    command.setExecutor(mayUseDefaultCommand ? new DefaultCommand() : null);
                }
            }

            this.enabled = false;
        } catch (Exception e) {
            this.enabled = true;
        }

        return !this.enabled;
    }

    /**
     * Check whether this {@link ILeafModule} is enabled or not.
     *
     * @return True if enabled, false otherwise.
     */
    @Override
    public final boolean isEnabled() {

        return this.enabled;
    }

    /**
     * Get the {@link JavaPlugin} to which this {@link ILeafModule} belongs.
     *
     * @return A {@link JavaPlugin}
     */
    @Override
    public final JavaPlugin getPlugin() {

        return this.plugin;
    }

    /**
     * Retrieve the {@link ILeafCore} instance in use for this {@link ILeafModule}.
     *
     * @return An {@link ILeafCore} implementation instance.
     */
    @Override
    public final ILeafCore getCore() {

        return this.core;
    }

    /**
     * Retrieve the {@link LeafListener} that this {@link ILeafModule} should use.
     *
     * @return A {@link List} of {@link LeafListener}
     */
    @Override
    public List<Listener> getListeners() {

        return Collections.emptyList();
    }

    /**
     * Retrieve the {@link PluginCommandImpl}s that this {@link ILeafModule} should use.
     *
     * @return A {@link Map} where the key is the command label and the value the {@link PluginCommandImpl} handling the
     *         command.
     */
    @Override
    public Map<String, PluginCommandImpl> getCommands() {

        return new HashMap<>();
    }

}
