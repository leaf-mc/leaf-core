package mc.leaf.core.interfaces;

import mc.leaf.core.api.command.PluginCommandImpl;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Map;

public interface ILeafModule {

    /**
     * Enable this {@link ILeafModule}.
     *
     * @return True if the {@link ILeafModule} has been enabled without errors.
     */
    boolean enable();

    /**
     * Disable this {@link ILeafModule}.
     *
     * @param mayUseDefaultCommand
     *         Define if a default command should replace the old command.
     *
     * @return True if the {@link ILeafModule} has been disabled without errors.
     */
    boolean disable(boolean mayUseDefaultCommand);

    /**
     * Called when this {@link ILeafModule} starts.
     */
    void onEnable();

    /**
     * Called when this {@link ILeafModule} stops.
     */
    void onDisable();

    /**
     * Retrieve the {@link ILeafCore} instance in use for this {@link ILeafModule}.
     *
     * @return An {@link ILeafCore} implementation instance.
     */
    ILeafCore getCore();

    /**
     * Retrieve the name of this {@link ILeafModule}.
     *
     * @return The {@link ILeafModule}'s name.
     */
    String getName();

    /**
     * Check whether this {@link ILeafModule} is enabled or not.
     *
     * @return True if enabled, false otherwise.
     */
    boolean isEnabled();

    /**
     * Get the {@link JavaPlugin} to which this {@link ILeafModule} belongs.
     *
     * @return A {@link JavaPlugin}
     */
    JavaPlugin getPlugin();

    /**
     * Retrieve the {@link Listener} that this {@link ILeafModule} should use.
     *
     * @return A {@link List} of {@link Listener}
     */
    List<Listener> getListeners();

    /**
     * Retrieve the {@link PluginCommandImpl}s that this {@link ILeafModule} should use.
     *
     * @return A {@link Map} where the key is the command label and the value the {@link PluginCommandImpl} handling the
     *         command.
     */
    Map<String, PluginCommandImpl> getCommands();

}
