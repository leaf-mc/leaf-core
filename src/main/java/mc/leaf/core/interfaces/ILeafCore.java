package mc.leaf.core.interfaces;

import mc.leaf.core.events.interfaces.IEventBridge;

import java.util.List;
import java.util.Map;

public interface ILeafCore {

    /**
     * Register a new dynamic option for command completion. If the name provided have already been registered, the
     * list of options will be replaced.
     *
     * @param name The name of the dynamic option
     * @param options
     */
    void registerDynamicOptions(String name, List<String> options);

    /**
     * Retrieve every dynamic options registered.
     *
     * @return A list of dynamic options for command completion.
     */
    Map<String, List<String>> getDynamicOptions();

    /**
     * Retrieve an implementation instance of {@link IEventBridge}.
     *
     * @return An instance implementing {@link IEventBridge}.
     */
    IEventBridge getEventBridge();

}
