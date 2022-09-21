package mc.leaf.core.api.persistence.wrappers;

import org.bukkit.NamespacedKey;

import java.util.function.Function;

public record LocationKeyWrapper(Function<String, NamespacedKey> keySpace, String key) {

    public NamespacedKey getW() {

        return this.keySpace.apply(String.format("%s.w", this.key));
    }

    public NamespacedKey getX() {

        return this.keySpace.apply(String.format("%s.x", this.key));
    }

    public NamespacedKey getY() {

        return this.keySpace.apply(String.format("%s.y", this.key));
    }

    public NamespacedKey getZ() {

        return this.keySpace.apply(String.format("%s.z", this.key));
    }

}
