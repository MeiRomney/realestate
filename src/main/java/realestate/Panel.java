package realestate;

import java.util.logging.*;

/**
 * Represents a panel-type real estate with additional attributes.
 */
public class Panel extends RealEstate implements PanelInterface {
    private static final Logger LOGGER = LoggerConfig.getLogger(Panel.class.getName());

    private int floor;
    private boolean isInsulated;

    public Panel(String city, double price, int sqm, double numberOfRooms, Genre genre, int floor, boolean isInsulated) {
        super(city, price, sqm, numberOfRooms, genre);
        LOGGER.info("Panel() constructor called");
        this.floor = floor;
        this.isInsulated = isInsulated;
    }

    /** {@inheritDoc} */
    @Override
    public int getTotalPrice() {
        LOGGER.info("Panel.getTotalPrice() called");
        double total = super.getTotalPrice();
        if (floor >= 0 && floor <= 2) total *= 1.05;
        else if (floor == 10) total *= 0.95;
        if (isInsulated) total *= 1.05;
        return (int) total;
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasSameAmount(RealEstate other) {
        LOGGER.info("hasSameAmount() called");
        return this.getTotalPrice() == other.getTotalPrice();
    }

    /** {@inheritDoc} */
    @Override
    public int roomPrice() {
        LOGGER.info("roomPrice() called");
        if (getNumberOfRooms() <= 0) return 0;
        return (int) ((getTotalPrice() * getSqm()) / getNumberOfRooms());
    }
}
