package mc.leaf.core.async;


import mc.leaf.core.interfaces.ILeafCore;
import mc.leaf.core.interfaces.ILeafManager;
import mc.leaf.core.interfaces.ILeafModule;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * The manager class is the main class for managing long running task and/or task that needs to be split to avoid
 * performance issue.
 *
 * @param <T>
 *         The type of entity the manager will accept.
 */
public abstract class LeafManager<T> implements ILeafManager<T> {

    public final  BlockingDeque<T> holder = new LinkedBlockingDeque<>();
    private final JavaPlugin       plugin;
    private       BukkitTask       task;

    public LeafManager(ILeafModule module) {

        this.plugin = module.getPlugin();
    }

    public LeafManager(ILeafCore core) {

        this.plugin = core.asPlugin();
    }

    /**
     * Offer an entity to this manager.
     *
     * @param offer
     *         The entity to offer
     */
    @Override
    public void offer(T offer) {

        this.holder.offer(offer);
    }

    /**
     * Start the manager.
     */
    @Override
    public final void start() {

        this.task = Bukkit.getScheduler().runTaskTimer(this.plugin, this, 0L, 1L);
        this.onStart();
    }

    /**
     * Stop the manager.
     */
    @Override
    public final void stop() {

        Bukkit.getScheduler().cancelTask(this.task.getTaskId());
        this.task = null;
        this.onStop();
    }

    /**
     * Retrieve the {@link BlockingDeque} holding all objects.
     *
     * @return A {@link BlockingDeque}
     */
    @Override
    public final BlockingDeque<T> getHolder() {

        return this.holder;
    }

}
