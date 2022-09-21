package mc.leaf.core.api.command.converters.types;

import mc.leaf.core.api.command.interfaces.ArgumentConverter;

public class BooleanConverter implements ArgumentConverter<Boolean> {

    @Override
    public Boolean convert(String in) {

        if (in.equals("true") || in.equals("1") || in.equals("yes") || in.equals("enable") || in.equals("enabled") || in.equals("on")) {
            return true;
        } else if (in.equals("false") || in.equals("0") || in.equals("no") || in.equals("disable") || in.equals("disabled") || in.equals("off")) {
            return false;
        }
        throw new IllegalStateException("Invalid boolean value for string " + in);
    }

}
