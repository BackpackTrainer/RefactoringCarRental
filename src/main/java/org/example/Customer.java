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
            result += "\t" + each.getCar().getMakeModel() + "\t" + String.valueOf(getThisAmount(each)) + "\n";

            totalAmount += getThisAmount(each);
            totalFrequentRenterPoints += getFrequentRenterPointsFor(each);
        }
        frequentRentalPoints += totalFrequentRenterPoints;
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPointsFor(Rental rental) {
        int thisFrequentRenterPoints = 1;

        if ((rental.getCar().getPriceCode() == Car.LUXURY) && rental.getDaysRented() > 1) {
            thisFrequentRenterPoints++;
        }

        return thisFrequentRenterPoints;
    }

    private  double getThisAmount(Rental rental) {
        double thisAmount = 0;

        switch (rental.getCar().getPriceCode()) {
            case Car.STANDARD:
                thisAmount += 200;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented()-2)*150;
                }
                break;

            case Car.LUXURY:
                thisAmount += rental.getDaysRented() * 500;
                break;

            case Car.COMPACT:
                thisAmount += 150;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented()-3)*150;
                }
                break;
        }
        return thisAmount;
    }
}
