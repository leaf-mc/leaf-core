package mc.leaf.core.api.command.interfaces;

import org.jetbrains.annotations.Nullable;

/**
 * Interface providing a way to avoid having to cast/load each argument from a command (which can be tedious when
 * dealing with a lot of parameters).
 *
 * @param <OUT>
 *         Type of the target parameter
 */
public interface ArgumentConverter<OUT> {

    /**
     * Return a value of the defined type corresponding to the provided input.
     *
     * @param input
     *         String value of the target type (name, class or anything else allowing identifying the targeted object)
     *
     * @return An instance of the output type needed.
     */
    @Nullable
    OUT convert(String input);

}
