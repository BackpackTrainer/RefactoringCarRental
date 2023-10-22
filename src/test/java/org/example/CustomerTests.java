package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTests {
    Customer uut;
    String expectedResult;
    String actualResult;

    @BeforeEach
    public void setUp() {
        uut = new Customer("Fred");
    }
    @AfterEach
    public void tearDown() {
        uut = null;
        expectedResult = null;
        actualResult = null;
    }

    @Test
    public void shouldProduceEmptyStatementWithoutRentals() {
        expectedResult = "Rental Record for Fred\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldAddStandardRentalToStatement() {
        uut.addRental(new Rental(new Car("Test Car", Car.STANDARD), 1));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t200.0\n"+
                "Amount owed is 200.0\n" +
                "You earned 1 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldAddStandardLongRentalToStatement() {
        uut.addRental(new Rental(new Car("Test Car", Car.STANDARD), 3));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t350.0\n"+
                "Amount owed is 350.0\n" +
                "You earned 1 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void shouldAddLuxuryRentalToStatement() {
        uut.addRental(new Rental(new Car("Test Car", Car.LUXURY), 1));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t500.0\n"+
                "Amount owed is 500.0\n" +
                "You earned 1 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void LongLuxuryAddsExtraFrequentRenterPoints() {
        uut.addRental(new Rental(new Car("Test Car", Car.LUXURY), 2));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t1000.0\n"+
                "Amount owed is 1000.0\n" +
                "You earned 2 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void shouldAddCompactRentalToStatement() {
        uut.addRental(new Rental(new Car("Test Car", Car.COMPACT), 1));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t150.0\n"+
                "Amount owed is 150.0\n" +
                "You earned 1 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldAddLongCompactRentalToStatement() {
        uut.addRental(new Rental(new Car("Test Car", Car.COMPACT), 4));
        expectedResult = "Rental Record for Fred\n" +
                "\tTest Car\t300.0\n"+
                "Amount owed is 300.0\n" +
                "You earned 1 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }

//note: this test will fail if cars are added in reverse order
    @Test
    public void shouldAddMultipleRentalsToStatement() {
        uut.addRental(new Rental(new Car("Test Standard Car", Car.STANDARD), 1));
        uut.addRental(new Rental(new Car("Test Luxury Car", Car.LUXURY), 1));

        expectedResult = "Rental Record for Fred\n" +
                "\tTest Standard Car\t200.0\n"+
                "\tTest Luxury Car\t500.0\n"+
                "Amount owed is 700.0\n" +
                "You earned 2 frequent renter points";

        actualResult = uut.statement();

        assertEquals(expectedResult, actualResult);
    }
}
