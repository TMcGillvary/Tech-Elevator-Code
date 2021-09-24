package com.techelevator;

public class DealerApp {
    // anyone can call it, void = returns nothing
    public static void main(String[] args) {
        Card card = new Card("Spades", "Ace", true);

        //calling the .getRank and .getSuit that we created in Card
        //System.out.println(card.getRank() + " of " + card.getSuit());
        System.out.println(card.toString());
        card.setFaceUp(false);
        System.out.println(card.toString());

        System.out.println();
        System.out.println();

        Deck newDeck = new Deck();
        newDeck.shuffle(); // shuffles cards before the loop

        for ( Card cardInDeck : newDeck.getCards()) {
            // cards are default facedown b/c we picked the constructor that only uses two, so we need to flip them over
            cardInDeck.setFaceUp(true);
            System.out.println(cardInDeck.toString());
        }
    }
}
