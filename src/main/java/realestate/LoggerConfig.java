package realestate;

import java.io.IOException;
import java.util.logging.*;

/**
 * Utility class to configure a global logger for the RealEstate application.
 */
public class LoggerConfig {
    private static final Logger LOGGER = Logger.getLogger(LoggerConfig.class.getName());
    private static boolean isConfigured = false;

    /**
     * Configures the logging system to log both to console and to a file named 'realEstateApp.log'.
     * @return the configured logger
     */
    public static Logger getLogger(String className) {
        if (!isConfigured) {
            try {
                LogManager.getLogManager().reset();
                Logger rootLogger = Logger.getLogger("");

                FileHandler fileHandler = new FileHandler("realEstateApp.log", true);
                fileHandler.setFormatter(new SimpleFormatter());
                rootLogger.addHandler(fileHandler);

                ConsoleHandler consoleHandler = new ConsoleHandler();
                consoleHandler.setFormatter(new SimpleFormatter());
                rootLogger.addHandler(consoleHandler);

                rootLogger.setLevel(Level.ALL);
                isConfigured = true;
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error configuring logger: {0}", e.getMessage());
            }
        }
        return Logger.getLogger(className);
    }
}
