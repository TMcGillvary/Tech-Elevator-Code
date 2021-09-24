package com.techelevator;

public class Elevator {

    // set variables
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    // constructor
    public Elevator(int numberOfLevels) {
        this.currentFloor = 1;
        this.doorOpen = false;
        this.numberOfFloors = numberOfLevels;
    }

    // getters & setters
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public int getNumberOfFloors() {
        return this.numberOfFloors;
    }

    public boolean isDoorOpen() {
        return this.doorOpen;
    }

    // Methods
    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen) {
            if (desiredFloor >= currentFloor && desiredFloor <= numberOfFloors) {
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen) {
            if (desiredFloor >= 1 && desiredFloor <= currentFloor) {
                currentFloor = desiredFloor;
            }
        }
    }
}
