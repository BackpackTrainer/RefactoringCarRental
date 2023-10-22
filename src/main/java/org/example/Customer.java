package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals;

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
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (each.getCar().getPriceCode()) {
                case Car.STANDARD:
                    thisAmount += 200;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented()-2)*150;
                    }
                    break;

                case Car.LUXURY:
                    thisAmount += each.getDaysRented() * 500;
                    break;

                case Car.COMPACT:
                    thisAmount += 150;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented()-3)*150;
                    }
                    break;
            }

            frequentRenterPoints++;
            if ((each.getCar().getPriceCode() == Car.LUXURY) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getCar().getMakeModel() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;

        }
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    return result;

    }
}
