package kata;

class ChildrenPrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
