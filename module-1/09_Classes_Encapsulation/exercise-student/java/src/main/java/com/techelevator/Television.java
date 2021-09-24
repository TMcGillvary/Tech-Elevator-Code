package com.techelevator;

public class Television {

    // set variables
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    // NO CONSTRUCTOR NEEDED because default values have been added to variables

    // getters & setters

    public boolean isOn() {
        return this.isOn;
    }

    public int getCurrentChannel() {
        return this.currentChannel;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    // Methods
    public void turnOff() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            if (newChannel >= 3 && newChannel <= 18) {
                currentChannel = newChannel;
            }
        }
    }

    public void channelUp() {
        if (isOn) {
            if (currentChannel < 18) {
                currentChannel++;
            } else {
                currentChannel = 3;
            }
        }
    }

    public void channelDown() {
        if (isOn) {
            if (currentChannel > 3) {
                currentChannel--;
            } else {
                currentChannel = 18;
            }
        }
    }

    public void raiseVolume() {
        if (isOn) {
            if (currentVolume < 10) {
                currentVolume++;
            } else {
                currentVolume = 10;
            }
        }
    }

    public void lowerVolume() {
        if (isOn) {
            if (currentVolume > 0) {
                currentVolume--;
            } else {
                currentVolume = 0;
            }
        }
    }
}
