package com.techelevator.farm;

import java.math.BigDecimal;

public class Egg implements Sellable {

    // instance variables
    private BigDecimal price;

    public Egg() {
        this.price = new BigDecimal("0.25"); // pass values as strings for BigDecimal constructors
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }
}
