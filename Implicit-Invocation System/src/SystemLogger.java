import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/*
Source: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/logging/Logger.html#method_summary
        https://stackoverflow.com/questions/15758685/how-to-write-logs-in-text-file-when-using-java-util-logging-logger
 */
public class SystemLogger implements Observer {

    private static final Logger LOGGER = Logger.getLogger(SystemLogger.class.getName());

    public SystemLogger() {
        // Subscribe this logger to the EV_SHOW event on the EventBus
        EventBus.subscribeTo(EventBus.EV_SHOW, this);

        try {
            // Initialize FileHandler to write log messages to "system.log"
            FileHandler fileHandler = new FileHandler("system.log");
            // Disable logging to the console
            LOGGER.setUseParentHandlers(false);
            // Set formatter to SimpleFormatter to format log messages
            fileHandler.setFormatter(new SimpleFormatter());
            // Add the FileHandler to LOGGER
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to initialize FileHandler", e);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        // Log the message with INFO level when an update is received
        if (arg instanceof String) {
            LOGGER.log(Level.INFO, (String) arg);
        }
    }
}
