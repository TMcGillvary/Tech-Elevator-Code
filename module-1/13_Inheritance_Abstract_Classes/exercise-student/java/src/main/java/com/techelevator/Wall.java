package com.techelevator;

public abstract class Wall {

    // instance variables
    private String name;
    private String color;

    // constructors
    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // getters (no setters)

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    // helper Methods

    public abstract int getArea();

}
