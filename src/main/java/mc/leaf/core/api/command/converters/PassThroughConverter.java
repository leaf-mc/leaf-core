package mc.leaf.core.api.command.converters;

import mc.leaf.core.api.command.interfaces.ArgumentConverter;
import org.jetbrains.annotations.NotNull;

/**
 * Default converter for all arguments. The output will be the same as the input.
 *
 * @author alexpado
 */
public class PassThroughConverter implements ArgumentConverter<String> {

    /**
     * Return the value provided without any mutation.
     *
     * @param input
     *         The value to return
     *
     * @return The value provided
     */
    @Override
    @NotNull
    public String convert(String input) {

        return input;
    }

}
