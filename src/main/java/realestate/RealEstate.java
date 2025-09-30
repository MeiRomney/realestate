package realestate;

public class RealEstate implements PropertyInterface {
    private String city;
    private double price;
    private int sqm;
    private double numberOfRooms;
    private Genre genre;

    public RealEstate() {
    }

    public RealEstate(String city, double price, int sqm, double numberOfRooms, Genre genre) {
        this.city = city;
        this.price = price;
        this.sqm = sqm;
        this.numberOfRooms = numberOfRooms;
        this.genre = genre;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSqm() {
        return sqm;
    }

    public void setSqm(int sqm) {
        this.sqm = sqm;
    }

    public double getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(double numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public void makeDiscount(int percentage) {
        double p = price;
        double discount = p*(percentage/100.0);
        price -= discount;
    }

    @Override
    public int getTotalPrice() {
        double total = this.price * this.sqm;

        switch (this.city.toLowerCase()) {
            case "budapest":
                total *= 1.30;
                break;
            case "debrecen":
                total *= 1.20;
                break;
            case "nyiregyhaza":
                total *= 1.15;
                break;
            default:
                break;
        }
        return (int)total;
    }

    @Override
    public double averageSqmPerRoom() {
        if (numberOfRooms <= 0) return 0.0;
        return (double) sqm / numberOfRooms;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "city='" + city + '\'' +
                ", price=" + price +
                ", sqm=" + sqm +
                ", numberOfRooms=" + numberOfRooms +
                ", genre=" + genre +
                ", Total Price=" + getTotalPrice() +
                ", Average Sqm/Room=" + averageSqmPerRoom() +
                '}';
    }
}
