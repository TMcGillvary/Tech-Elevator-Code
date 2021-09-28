package com.techelevator.farm;

public class Tractor implements Singable {

    // instance variables
    private String name;
    private String sound;

    public Tractor() {
        this.name = "Tractor";
        this.sound = "vroom!";
    }

    public String getName() {
        return this.name;
    }

    public String getSound() {
        return this.sound;
    }

    public String getIndefiniteArticleForSound() {
        return "a"; // need to repeat because tractor is not under farm animal
    }
}
