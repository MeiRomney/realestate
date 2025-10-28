package realestate;

import java.util.logging.*;

/**
 * Entry point for the RealEstate application.
 */
public class Main {
    private static final Logger LOGGER = LoggerConfig.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LOGGER.info("Main.main() started");

        try {
            RealEstate re = new RealEstate("Budapest", 4000, 50, 3, Genre.CONDOMINIUM);
            Panel pa = new Panel("Debrecen", 3500, 100, 5, Genre.FAMILYHOUSE, 2, true);
            RealEstateAgent ra = new RealEstateAgent();

            System.out.println(re);
            re.makeDiscount(10);
            System.out.println(re);

            System.out.println(pa);
            pa.makeDiscount(20);
            System.out.println(pa);

            System.out.println(ra.stock);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in Main.main(): {0}", e.getMessage());
        }

        LOGGER.info("Main.main() finished");
    }
}
