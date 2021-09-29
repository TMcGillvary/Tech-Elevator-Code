package com.techelevator.farm;

public class Cat extends FarmAnimal {

    public Cat() {
        super("Cat", "meow");
    }

    @Override
    public String getSound() {
        return "meow!";
    }
    // this overrides the fact that we set the cat asleep in the main code


    @Override
    public void eat() {
        System.out.println("The cat is eating cat food.");
    }

}
