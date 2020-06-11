package mc.leaf.core.api.command.annotations;

import mc.leaf.core.api.command.converters.PassThroughConverter;
import mc.leaf.core.api.command.interfaces.IParameterConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark a method's parameter as a parameter receiving a dynamic a value coming from the
 * user's input.
 *
 * @author alexpado
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Param {

    Class<? extends IParameterConverter<String, ?>> converter() default PassThroughConverter.class;

}
