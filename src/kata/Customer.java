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
        String result = getRentalRecordName() + "\n";
        for(Rental each : this.rentals){
            result += "\t" + getMovieTitle(each) + "\t";
            result += getMovieCharge(each)+ "\n";
        }
        result += getOwed() + "\n";
        result += getEarned();
        return result;
    }

    public String statementHTML() {
        String result = "<h1>" + getRentalRecordName() + "</h1>";
        result += "<table>";
        for(Rental each : this.rentals){
            result += "<tr>";
            result += "<td>" + getMovieTitle(each)  + "</td>";
            result += "<td>" + getMovieCharge(each) + "</td>";
            result += "</tr>";
        }
        result += "</table>";
        result += "<p>" + getOwed() + "</p>";
        result += "<p>" + getEarned() + "</p>";
        return result;
    }

    private String getRentalRecordName() {
        return "Rental Record for " + getName();
    }

    private String getMovieTitle(Rental rental) {
        return rental.getMovie().getTitle();
    }

    private String getMovieCharge(Rental rental) {
       return String.valueOf(rental.getCharge());
    }

    private String getOwed() {
        return "Amount owed is " + String.valueOf(getTotalCharge());
    }

    private String getEarned() {
        return "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
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

