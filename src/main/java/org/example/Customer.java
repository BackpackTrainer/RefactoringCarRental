package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;
    int frequentRentalPoints = 0;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void addRental(Rental arg) {
        rentals.add(arg);
    }



    public String statement() {
        double totalAmount = 0;
        int totalFrequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : rentals) {
            result += "\t" + each.getCar().getMakeModel() + "\t" + String.valueOf(each.getCharge()) + "\n";

            totalAmount += each.getCharge();
            totalFrequentRenterPoints += each.getFrequentRenterPoints();
        }
        frequentRentalPoints += totalFrequentRenterPoints;

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";
        return result;
    }

}
