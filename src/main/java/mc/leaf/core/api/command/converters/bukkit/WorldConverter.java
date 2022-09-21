package mc.leaf.core.api.command.converters.bukkit;

import mc.leaf.core.api.command.interfaces.ArgumentConverter;
import org.bukkit.Bukkit;
import org.bukkit.World;

import javax.annotation.Nullable;

/**
 * ArgumentConverter to use when you want to convert a command argument to a World instance.
 *
 * @author alexpado
 */
public class WorldConverter implements ArgumentConverter<World> {

    /**
     * Return the world with the provided name.
     *
     * @param input
     *         Name of the world
     *
     * @return World instance, or null if no world is found.
     */
    @Nullable
    @Override
    public World convert(String input) {

        World world = null;
        for (World serverWorld : Bukkit.getWorlds()) {
            if (serverWorld.getName().equalsIgnoreCase(input)) {
                world = serverWorld;
                break;
            }
        }
        return world;
    }

}
