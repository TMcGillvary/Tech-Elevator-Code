package com.techelevator;

public class Airplane {

    // set variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;

    private int totalCoachSeats;
    private int bookedCoachSeats;

    //constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    // getters & setters
    public String getPlaneNumber() {
        return this.planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return this.totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return this.bookedFirstClassSeats;
    }

    // derived
    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats - this.bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return this.totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return this.bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    // Method
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {

        int availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        int availableCoachSeats = totalCoachSeats - bookedCoachSeats;

        if (availableFirstClassSeats >= totalNumberOfSeats) {
            if (forFirstClass) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        }

        if (availableCoachSeats >= totalNumberOfSeats) {
            if (!forFirstClass) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }
}
