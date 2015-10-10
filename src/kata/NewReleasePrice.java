package kata;

class NewReleasePrice extends Price {
    @Override
    double getCharge(int daysRented) {
        return daysRented * 3.0;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
