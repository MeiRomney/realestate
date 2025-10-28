package realestate;

import java.util.logging.*;

/**
 * Represents a general real estate property.
 */
public class RealEstate implements PropertyInterface, Comparable<RealEstate> {
    private static final Logger LOGGER = LoggerConfig.getLogger(RealEstate.class.getName());

    private String city;
    private double price;
    private int sqm;
    private double numberOfRooms;
    private Genre genre;

    /**
     * Default constructor.
     */
    public RealEstate() {
        LOGGER.info("RealEstate() constructor called");
    }

    /**
     * Constructs a real estate object with specified details.
     */
    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        LOGGER.info("RealEstate(String, double, int, double, Genre) constructor called");
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    /** @return the city name */
    public String getCity() { LOGGER.info("getCity() called"); return city; }

    /** @param city the city to set */
    public void setCity(String city) { LOGGER.info("setCity() called"); this.city = city; }

    /** @return the price */
    public double getPrice() { LOGGER.info("getPrice() called"); return price; }

    /** @param price sets a new price */
    public void setPrice(double price) { LOGGER.info("setPrice() called"); this.price = price; }

    /** @return the area in square meters */
    public int getSqm() { LOGGER.info("getSqm() called"); return sqm; }

    /** @param sqm the new area in square meters */
    public void setSqm(int sqm) { LOGGER.info("setSqm() called"); this.sqm = sqm; }

    /** @return the number of rooms */
    public double getNumberOfRooms() { LOGGER.info("getNumberOfRooms() called"); return numberOfRooms; }

    /** @param numberOfRooms sets number of rooms */
    public void setNumberOfRooms(double numberOfRooms) { LOGGER.info("setNumberOfRooms() called"); this.numberOfRooms = numberOfRooms; }

    /** @return the genre */
    public Genre getGenre() { LOGGER.info("getGenre() called"); return genre; }

    /** @param genre the property genre */
    public void setGenre(Genre genre) { LOGGER.info("setGenre() called"); this.genre = genre; }

    /** {@inheritDoc} */
    @Override
    public void makeDiscount(int percentage) {
        LOGGER.info("makeDiscount(" + percentage + ") called");
        try {
            double discount = price * (percentage / 100.0);
            price -= discount;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error applying discount: {0}", e.getMessage());
        }
    }

    /** {@inheritDoc} */
    @Override
    public int getTotalPrice() {
        LOGGER.info("getTotalPrice() called");
        double total = price * sqm;
        switch (city.toLowerCase()) {
            case "budapest": total *= 1.30; break;
            case "debrecen": total *= 1.20; break;
            case "nyiregyhaza": total *= 1.15; break;
        }
        return (int) total;
    }

    /** {@inheritDoc} */
    @Override
    public double averageSqmPerRoom() {
        LOGGER.info("averageSqmPerRoom() called");
        if (numberOfRooms <= 0) return 0.0;
        return sqm / numberOfRooms;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        LOGGER.info("toString() called");
        return "RealEstate{" +
                "city='" + city + '\'' +
                ", price=" + price +
                ", sqm=" + sqm +
                ", numberOfRooms=" + numberOfRooms +
                ", genre=" + genre +
                ", Total Price=" + getTotalPrice() +
                ", Avg Sqm/Room=" + averageSqmPerRoom() +
                '}';
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(RealEstate o) {
        LOGGER.info("compareTo() called");
        return Double.compare(this.price, o.price);
    }
}
