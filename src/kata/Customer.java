package kata;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for(Rental each : this.rentals){
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getCharge()) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double totalCharge = 0.0;
        for(Rental each : this.rentals){
            totalCharge += each.getCharge();
        }
        return totalCharge;
    }

    private int getTotalFrequentRenterPoints(){
        int totalFrequentRenterPoints = 0;
        for(Rental each : this.rentals){
            totalFrequentRenterPoints += each.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
}

