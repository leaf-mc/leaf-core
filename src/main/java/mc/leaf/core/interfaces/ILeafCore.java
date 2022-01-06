package mc.leaf.core.interfaces;

import mc.leaf.core.events.interfaces.IEventBridge;
import mc.leaf.core.services.completion.SyntaxContainer;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.List;

public interface ILeafCore {

    /**
     * Create a {@link SyntaxContainer} for the provided {@link List} of {@link String}
     *
     * @param items
     *         The {@link List} to convert.
     *
     * @return A {@link SyntaxContainer}.
     */
    SyntaxContainer createContainer(List<String> items);

    /**
     * Retrieve an implementation instance of {@link IEventBridge}.
     *
     * @return An instance implementing {@link IEventBridge}.
     */
    IEventBridge getEventBridge();

    /**
     * Register a new dynamic option for command completion. If the name provided have already been registered, the list
     * of options will be replaced.
     *
     * @param name
     *         The name of the dynamic option
     * @param options
     *         List of completions available for this option.
     */
    void registerDynamicOptions(String name, List<String> options);

    /**
     * Retrieve all {@link ILeafModule} registered.
     *
     * @return All registered {@link ILeafModule}
     */
    List<ILeafModule> getLeafModules();

    /**
     * Register a new module.
     *
     * @param module
     *         The module.
     */
    void registerModule(ILeafModule module);

    PluginDescriptionFile getDescription();

}
