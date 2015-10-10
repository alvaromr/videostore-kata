package kata;

public class Movie {
    private String title;
    private Price price;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.price = PriceFactory.newPriceByCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return this.price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return this.price.getFrequentRenterPoints(daysRented);
    }
}