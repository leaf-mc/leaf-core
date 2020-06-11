package mc.leaf.core.api.command.exceptions;

public class ExecutionException extends CommandException {

    private final Exception cause;

    public ExecutionException(Exception cause, String message) {
        super(message);
        this.cause = cause;
    }

    @Override
    public Exception getCause() {
        return this.cause;
    }

}
