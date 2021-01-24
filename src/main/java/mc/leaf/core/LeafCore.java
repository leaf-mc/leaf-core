package mc.leaf.core;

import mc.leaf.core.events.interfaces.IEventBridge;
import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.internal.LeafCommand;
import mc.leaf.core.services.completion.SyntaxContainer;
import mc.leaf.core.services.completion.impl.MatchSyntax;
import mc.leaf.core.services.completion.interfaces.ISyntax;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        return new SyntaxContainer(items.stream().map(item -> ISyntax.getSyntax(item, this.dynamicOptions)).collect(Collectors.toList()));
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
