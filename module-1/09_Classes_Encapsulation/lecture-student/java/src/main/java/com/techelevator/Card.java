package com.techelevator;

public class Card {

    private String suit; // default is null
    private String rank; // default is null
    private boolean faceUp; // default is false, false would imply facedown

    //Brian's question on default card where Default creates Ace of Spades
//    public Card() {
//        this.suit = "Spades";
//        this.rank = "Ace";
//    }

    // constructor #1
    public Card(String suit, String rank, boolean faceUp) {
        // for this new card being created...
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
        // passing the values provided down into the code
    }

    // we can take multiple constructors... in this case
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        // faceUp would default to false now because boolean default is false, and we did
        // not include our this.faceUp from our value above to make it default to true
    }

    // getter
    public String getSuit() { //getters never take parameters
        // call the suit of the card that is created above
        return this.suit;
    }

    // getter
    public String getRank() {
        // call the rank of the card that is created above
        return this.rank;
    }

    // getter
    public boolean isFaceUp() {
        return this.faceUp;
    }

    // setter
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public String toString() {
        if (this.faceUp) { // if faceUp is the default true
            return this.rank + " of " + this.suit;
        } else {
            return "##"; // ## means this card is face down
        }
    }
}
