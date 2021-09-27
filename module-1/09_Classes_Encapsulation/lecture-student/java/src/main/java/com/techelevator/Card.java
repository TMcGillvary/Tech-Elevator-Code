package com.techelevator;

public class Card {

    // static typically comes before any instance variables
    // shared by all instances of card

    private static int cardCounter; // only want one no matter how many card instances there are
    // you could make 300 cards and there's only one cardCounter, that would count the value as 300

    /*
    Instances variables. Each new card gets its own sut, rank, and faceUp
     */

    private String suit; // default is null
    private String rank; // default is null
    private boolean faceUp; // default is false, false would imply facedown

    //Brian's question on default card where Default creates Ace of Spades
//    public Card() {
//        this.suit = "Spades";
//        this.rank = "Ace";
//    }

    public Card() {
        this("Spades", "Ace", false); // calling a constructor within a class
        // this.suit = "Spades";
        // this.rank = "Ace";
        // you can use other code after this but the constructor has to be first, AND it's very rare to have code after
        // this constructor also redirects down to constructor #1
    }

    // constructor #1
    public Card(String suit, String rank, boolean faceUp) {
        // for this new card being created...
        this.suit = suit;
        this.rank = rank;
        this.faceUp = faceUp;
        // passing the values provided down into the code

        Card.cardCounter++;
    }

    // we can take multiple constructors... in this case
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        // faceUp would default to false now because boolean default is false, and we did
        // not include our this.faceUp from our value above to make it default to true
        Card.cardCounter++;
        // I had to add card counter again because I did not convert this constructor to call the original
        // constructor like the lecture code does [see lecture code]
        // without the card counter here, my deck doesn't have the card counter included and running the card counter
        // would only pull my one card that does use the constructor with the boolean included
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

    // Methods
    public String toString() {
        if (this.faceUp) { // if faceUp is the default true
            return this.rank + " of " + this.suit;
        } else {
            return "##"; // ## means this card is face down
        }
    }

    public static int getCardCounter() {
        return Card.cardCounter; // no 'this' because it's a static method, instead gotta call Class
        // static method only has access to static variables
        // static methods can't modify instance variables
    }

}
