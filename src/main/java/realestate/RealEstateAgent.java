package realestate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.*;

/**
 * Handles a collection of real estate properties.
 */
public class RealEstateAgent {
    private static final Logger LOGGER = LoggerConfig.getLogger(RealEstateAgent.class.getName());
    static TreeSet<RealEstate> stock = new TreeSet<>();

    /**
     * Constructs a RealEstateAgent and loads property data from "realestates.txt".
     */
    public RealEstateAgent() {
        LOGGER.info("RealEstateAgent() constructor called");
        try {
            File inputFile = new File("realestates.txt");
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LOGGER.info("Processing line: " + line);
                // (same parsing logic as original)
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "File not found: {0}", e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: {0}", e.getMessage());
        }
    }
}
