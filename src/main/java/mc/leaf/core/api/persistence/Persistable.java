package mc.leaf.core.api.persistence;

import mc.leaf.core.interfaces.ILeafModule;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Function;

public abstract class Persistable {

    private final ILeafModule module;

    public Persistable(ILeafModule module) {

        this.module = module;
    }

    public static <K extends ILeafModule, T extends Persistable> Optional<T> from(Class<T> clazz, K module, PersistentDataHolder holder, NamespacedKey key, Function<K, T> creator) {

        PersistentDataType<PersistentDataContainer, T> handler   = new PersistentHandler<>(module, clazz, creator);
        PersistentDataContainer                        container = holder.getPersistentDataContainer();
        return Optional.ofNullable(container.get(key, handler));
    }

    public static <K extends ILeafModule, T extends Persistable> void persist(Class<T> clazz, K module, PersistentDataHolder holder, T data) {

        PersistentDataType<PersistentDataContainer, T> handler   = new PersistentHandler<>(module, clazz, null);
        PersistentDataContainer                        container = holder.getPersistentDataContainer();
        data.onPersisting(holder);
        container.set(data.getNamespacedKey(), handler, data);
        data.onPersisted(holder);
    }

    public static <K extends ILeafModule, T extends Persistable> void desist(PersistentDataHolder holder, T data) {

        PersistentDataContainer container = holder.getPersistentDataContainer();
        container.remove(data.getNamespacedKey());
        data.onDesisted(holder);
    }

    /**
     * Retrieve the {@link NamespacedKey} in which this {@link Persistable} can be read/written.
     *
     * @return The {@link NamespacedKey} for this {@link Persistable}.
     */
    public abstract NamespacedKey getNamespacedKey();

    /**
     * Called right after a call to {@link Persistable#persist(Class, ILeafModule, PersistentDataHolder, Persistable)}
     * succeeded.
     *
     * @param holder
     *         {@link PersistentDataHolder} in which this {@link Persistable} has been written to.
     */
    public void onPersisted(@NotNull PersistentDataHolder holder) {}

    /**
     * Called right before writing the persistence data into the provided {@link PersistentDataHolder}
     *
     * @param holder
     *         {@link PersistentDataHolder} in which this {@link Persistable} will be written to.
     *
     * @return True if allowed to write data, false otherwise.
     */
    public boolean onPersisting(@NotNull PersistentDataHolder holder) {

        return true;
    }

    /**
     * Called right after a call to {@link Persistable#desist(PersistentDataHolder, Persistable)} succeeded.
     *
     * @param holder
     *         {@link PersistentDataHolder} in which this {@link Persistable} has been removed from.
     */
    public void onDesisted(@NotNull PersistentDataHolder holder) {}

    /**
     * Retrieve the {@link ILeafModule} associated with this {@link Persistable}.
     *
     * @return A {@link ILeafModule}.
     */
    @NotNull
    public final ILeafModule getModule() {

        return this.module;
    }

}
