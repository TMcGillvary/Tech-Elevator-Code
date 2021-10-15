package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class HotelReservationTest {

    @Test
    public void estimated_total_calculated_correctly() {
        // Arrange
        HotelReservation reservation = new HotelReservation("John Doe", 2);

        // Act
        BigDecimal actual = reservation.getEstimatedTotal();
        BigDecimal expected = new BigDecimal("119.98");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returns_correct_price_if_cleaning_true_and_minibar_true() {
        // Arrange
        HotelReservation reservation = new HotelReservation("John Doe", 2);

        // Act
        BigDecimal actual = reservation.finalizedGrandTotal(true, true);
        BigDecimal expected = new BigDecimal("202.95");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returns_correct_price_if_cleaning_false_and_minibar_true() {
        // Arrange
        HotelReservation reservation = new HotelReservation("John Doe", 2);

        // Act
        BigDecimal actual = reservation.finalizedGrandTotal(false, true);
        BigDecimal expected = new BigDecimal("132.97");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returns_correct_price_if_cleaning_true_and_minibar_false() {
        // Arrange
        HotelReservation reservation = new HotelReservation("John Doe", 2);

        // Act
        BigDecimal actual = reservation.finalizedGrandTotal(true, false);
        BigDecimal expected = new BigDecimal("154.97");

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void returns_correct_price_if_cleaning_false_and_minibar_false() {
        // Arrange
        HotelReservation reservation = new HotelReservation("John Doe", 2);

        // Act
        BigDecimal actual = reservation.finalizedGrandTotal(false, false);
        BigDecimal expected = new BigDecimal("119.98");

        // Assert
        Assert.assertEquals(expected, actual);
    }

}
