package mc.leaf.core.interfaces;

import mc.leaf.core.interfaces.impl.LeafModule;
import mc.leaf.core.services.completion.SyntaxContainer;
import org.bukkit.plugin.java.JavaPlugin;

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
    void registerModule(LeafModule module);

    /**
     * Retrieve this {@link ILeafCore} in its {@link JavaPlugin} instance.
     *
     * @return A {@link JavaPlugin}
     */
    JavaPlugin asPlugin();

}
