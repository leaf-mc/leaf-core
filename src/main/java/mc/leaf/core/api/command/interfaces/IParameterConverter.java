package mc.leaf.core.api.command.interfaces;

public interface IParameterConverter<I, O> {

    O convert(I in);

}
