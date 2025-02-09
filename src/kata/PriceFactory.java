package kata;

public class PriceFactory {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    public static final int SUPER_DEAL = 3;

    static Price newPriceByCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                return new RegularPrice();
            case CHILDRENS:
                return new ChildrenPrice();
            case NEW_RELEASE:
                return new NewReleasePrice();
            case SUPER_DEAL:
                return new SuperDealPrice();
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }
}
