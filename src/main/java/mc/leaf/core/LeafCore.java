package mc.leaf.core;

import mc.leaf.core.events.interfaces.IEventBridge;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.internal.LeafCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class LeafCore extends JavaPlugin implements ILeafCore {

    private Map<String, List<String>> dynamicOptions = new HashMap<>();

    @Override
    public void onEnable() {
        new LeafCommand(this).register("leaf");
    }

    @Override
    public void registerDynamicOptions(String name, List<String> options) {
        this.dynamicOptions.put(name, options);
    }

    @Override
    public Map<String, List<String>> getDynamicOptions() {
        return this.dynamicOptions;
    }

    /**
     * Retrieve an implementation instance of {@link IEventBridge}.
     *
     * @return An instance implementing {@link IEventBridge}.
     */
    @Override
    public IEventBridge getEventBridge() {
        return null;
    }

}
