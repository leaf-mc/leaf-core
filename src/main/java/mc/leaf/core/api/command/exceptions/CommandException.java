package mc.leaf.core.api.command.exceptions;

public abstract class CommandException extends RuntimeException {

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {

        super(message, cause);
    }

}
