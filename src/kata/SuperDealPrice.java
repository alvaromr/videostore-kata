package kata;

public class SuperDealPrice extends Price{
    @Override
    double getCharge(int daysRented) {
        return daysRented * 1.0;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 0;
    }
}
