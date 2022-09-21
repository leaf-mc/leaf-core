package mc.leaf.core.api.command.exceptions;

public class ConfigurationException extends CommandException {

    public ConfigurationException(String message) {

        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {

        super(message, cause);
    }

}
