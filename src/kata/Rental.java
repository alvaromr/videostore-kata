package kata;

class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double getCharge() {
        return this.getMovie().getCharge(this.daysRented);
    }

    int getFrequentRenterPoints() {
        return this.getMovie().getFrequentRenterPoints(this.daysRented);
    }
}