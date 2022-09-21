package mc.leaf.core.api.command.converters.types;

import mc.leaf.core.api.command.interfaces.ArgumentConverter;

import javax.annotation.Nullable;

/**
 * ArgumentConverter to use when you want to convert a command argument to an Integer instance.
 *
 * @author alexpado
 */
public class IntegerConverter implements ArgumentConverter<Integer> {

    /**
     * Return the integer value of the provided string value.
     *
     * @param input
     *         The number as string
     *
     * @return The integer value, or null if the argument couldn't be converted.
     */
    @Nullable
    @Override
    public Integer convert(String input) {

        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return null;
        }
    }

}
