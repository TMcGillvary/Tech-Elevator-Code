package com.techelevator;

import java.math.BigDecimal;

public class HotelReservation {

    // instance variables
    private String name;
    private int numberOfNights;
    private BigDecimal estimatedTotal;

    // constructor
    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        estimatedTotal = new BigDecimal("59.99").multiply(BigDecimal.valueOf(numberOfNights));
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public BigDecimal getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(BigDecimal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    // helper Methods
    @Override
    public String toString() {
        return String.format("RESERVATION - %s - $%s", getName(), getEstimatedTotal());
    }

    public BigDecimal finalizedGrandTotal(boolean requiresCleaning, boolean usedMiniBar) {
        BigDecimal grandTotal;
        BigDecimal cleaningFee = new BigDecimal("34.99");
        BigDecimal miniBarFee = new BigDecimal("12.99");
        BigDecimal times2 = new BigDecimal("2");

        if (usedMiniBar) {
            grandTotal = miniBarFee.add(estimatedTotal);
            if (requiresCleaning) {
                grandTotal = grandTotal.add(cleaningFee.multiply(times2));
            }
            return grandTotal;
        } else if (requiresCleaning) {
            grandTotal = cleaningFee.add(estimatedTotal);
            return grandTotal;
        } else {
            return estimatedTotal;
        }
    }


}
