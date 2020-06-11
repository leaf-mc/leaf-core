package mc.leaf.core.events.interfaces;

import mc.leaf.core.interfaces.ILeafModule;

/**
 * Interface used as event bridging between {@link ILeafModule}s and {@link mc.leaf.core.LeafCore}.
 *
 * This is required as Bukkit doesn't provide a way to unregister {@link org.bukkit.event.Listener} without using
 * reflection (shame).
 *
 * @author alexpado
 */
public interface IEventBridge extends ILeafListener {

    /**
     * Register the provided {@link ILeafListener} under the provided {@link ILeafModule}.
     *
     * @param module
     *         The {@link ILeafModule} registering the {@link ILeafListener}.
     * @param listener
     *         The {@link ILeafListener} to register.
     */
    void register(ILeafModule module, ILeafListener listener);

    /**
     * Remove all {@link ILeafListener}s registered by the provided {@link ILeafModule}.
     *
     * @param module
     *         The {@link ILeafModule} from which all {@link ILeafModule}s will be unregistered.
     */
    void unregister(ILeafModule module);

}
