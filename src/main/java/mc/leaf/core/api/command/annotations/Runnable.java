package mc.leaf.core.api.command.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark a method as a command method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Runnable {

    /**
     * Define the syntax string for the annotated command. This syntax will be then used by the {@link
     * mc.leaf.core.services.completion.interfaces.ICompletionService}.
     *
     * @return The syntax string
     */
    String value();

    /**
     * Define the permission needed to execute the annotated command. If the permission is left empty, no permission
     * will be required.
     *
     * You may want to let this empty if you want to use your own way to filter {@link
     * org.bukkit.command.CommandSender}
     *
     * @return The permission needed
     */
    String permission() default "";

    /**
     * Define if the command annotated can be executed by a {@link org.bukkit.command.ConsoleCommandSender}
     *
     * @return True if console is allowed, false instead.
     */
    boolean allowConsole() default false;

    /**
     * Define if the command annotated can be executed by {@link org.bukkit.entity.Player}
     *
     * @return True if players are allowed, false instead.
     */
    boolean allowPlayer() default true;

    /**
     * Define if the command annotated can be executed by a {@link org.bukkit.command.BlockCommandSender}
     *
     * @return True if console is allowed, false instead.
     */
    boolean allowCommandBlock() default false;

    /**
     * Define if the command annotated can be executed only by {@link org.bukkit.entity.Player} with operator
     * privileges.
     *
     * @return True if the command need operator privileges, false instead.
     */
    boolean opOnly() default false;

}
