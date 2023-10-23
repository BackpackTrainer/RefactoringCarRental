package org.example;

public class Car {

    public static final int COMPACT = 1;
    public static final int STANDARD = 2;
    public static final int LUXURY = 3;

    private String makeModel;
    private int priceCode;

    public Car(String makeModel, int priceCode) {
        this.makeModel = makeModel;
        this.priceCode = priceCode;
    }

    int getFrequentRenterPoints(int numberOfDaysRented) {
        if ((getPriceCode() == LUXURY) && numberOfDaysRented > 1) {
            return 2;
        }else{
            return 1;
        }
    }

    double getCharge(int numberOfDaysRented) {
        double result = 0;
        switch (getPriceCode()) {
            case Car.STANDARD:
                result += 200;
                if (numberOfDaysRented > 2) {
                    result += (numberOfDaysRented -2)*150;
                }
                break;

            case Car.LUXURY:
                result += numberOfDaysRented * 500;
                break;

            case Car.COMPACT:
                result += 150;
                if (numberOfDaysRented > 3) {
                    result += (numberOfDaysRented -3)*150;
                }
                break;
        }
        return result;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
