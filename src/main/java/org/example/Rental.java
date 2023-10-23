package org.example;

public class Rental {
    private Car car;
    private int daysRented;

    public Rental(Car car, int daysRented) {
        this.car = car;
        this.daysRented = daysRented;
    }

    int getFrequentRenterPoints() {
        if ((getCar().getPriceCode() == Car.LUXURY) && getDaysRented() > 1) {
            return 2;
        }else{
            return 1;
        }
    }

    double getCharge() {
        double result = 0;

        switch (getCar().getPriceCode()) {
            case Car.STANDARD:
                result += 200;
                if (getDaysRented() > 2) {
                    result += (getDaysRented()-2)*150;
                }
                break;

            case Car.LUXURY:
                result += getDaysRented() * 500;
                break;

            case Car.COMPACT:
                result += 150;
                if (getDaysRented() > 3) {
                    result += (getDaysRented()-3)*150;
                }
                break;
        }
        return result;
    }

    public Car getCar() {
        return car;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
