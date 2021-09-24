package com.techelevator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards; // collection that's going to hold all our cards
    // reference types default to null

    // uppercase letter implies constructor
    public Deck() { // constructors don't have return type
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        this.cards = new ArrayList<Card>();
        // building our ArrayList for our List<Card>

        for (String suit : suits) { // this loop will run 4 times, one for each suit in the array
            for (String rank : ranks) { // nested loop to now go through rank
                Card card = new Card(suit, rank); // this is where we chose the constructor where faceUp defaults to false
                cards.add(card); // add to List, also don't need variable here could put line above here
            }
        }
    }

    public List<Card> getCards() {
        return this.cards; // return our built list from Deck above
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
