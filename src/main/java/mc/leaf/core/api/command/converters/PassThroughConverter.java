package mc.leaf.core.api.command.converters;

import mc.leaf.core.api.command.interfaces.IParameterConverter;

public class PassThroughConverter implements IParameterConverter<String, String> {
    @Override
    public String convert(String in) {
        return in;
    }
}
