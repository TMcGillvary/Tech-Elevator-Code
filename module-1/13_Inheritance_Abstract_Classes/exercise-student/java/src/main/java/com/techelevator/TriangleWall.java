package com.techelevator;

public class TriangleWall extends Wall {

    // instance variables
    private int base;
    private int height;

    // constructors
    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    // getters (but no setters)

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    // helper Methods

    public int getArea() {
        return base * height / 2;
    }

    @Override
    public String toString() {
        return getName() + " (" + getBase() + "x" + getHeight() + ") triangle";
    }
}
