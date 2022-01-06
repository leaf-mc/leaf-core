package mc.leaf.core.interfaces;

import org.bukkit.plugin.java.JavaPlugin;

public interface ILeafModule {

    void onEnable();

    void onDisable();

    ILeafCore getCore();

    String getName();

    boolean isEnabled();

    JavaPlugin getPlugin();

}
