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
        double result = 0.0;
        // determine amounts for each line
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDaysRented() > 2)
                    result += (this.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += this.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (this.getDaysRented() > 3)
                    result += (this.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    int getFrequentRenterPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}