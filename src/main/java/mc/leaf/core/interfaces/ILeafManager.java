package mc.leaf.core.interfaces;

import java.util.concurrent.BlockingDeque;

/**
 * @param <T>
 *         The managed type of this manager.
 */
public interface ILeafManager<T> extends Runnable {

    /**
     * Offer an entity to this manager.
     *
     * @param offer
     *         The entity to offer
     */
    void offer(T offer);

    /**
     * Start the manager.
     */
    void start();

    /**
     * Stop the manager.
     */
    void stop();

    /**
     * Called when this manager started.
     */
    void onStart();

    /**
     * Called when this manager is stopped.
     */
    void onStop();

    /**
     * Retrieve the {@link BlockingDeque} holding all objects.
     *
     * @return A {@link BlockingDeque}
     */
    BlockingDeque<T> getHolder();

}
