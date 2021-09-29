package com.techelevator;

public class SquareWall extends RectangleWall {

    // no variables because they're all in rectangle

    // constructors
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
    }

    // nothing else needed here

    // helper Methods

    @Override
    public String toString() {
        return getName() + " (" + getLength() + "x" + getHeight() + ") square";
    }
}
