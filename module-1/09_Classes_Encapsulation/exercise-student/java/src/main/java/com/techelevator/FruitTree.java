package com.techelevator;

public class FruitTree {

    // set variables
    private String typeOfFruit;
    private int startingPiecesOfFruit;
    private int piecesOfFruitLeft;

    // constructor
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.startingPiecesOfFruit = startingPiecesOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    // getters & setters
    public String getTypeOfFruit() {
        return this.typeOfFruit;
    }

    public int getStartingPiecesOfFruit() {
        return this.startingPiecesOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return this.piecesOfFruitLeft;
    }

    // Methods
    public boolean pickFruit(int numberOfPiecesToRemove) {

        if (piecesOfFruitLeft > 0) {
            if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
                piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            }
            return true;
        }
        return false;
    }
}
