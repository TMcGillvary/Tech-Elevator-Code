package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	// creating an abstract meaning the class can't have instances made specifically of it

	public static final String FARM_NAME = "Old MacDonald's Farm";
	// public = anyone can access
	// static = shareable, it's only the one
	// final = it can't be changed
	private String name;
	private String sound;
	private boolean asleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
		this.asleep = false;
	}

	public String getName( ) {
		return name;
	}

	public String getSound( ) {
		if (asleep) {
			return "ZZZ...";
		}
		return sound;
	}

	public boolean isAsleep() {
		return asleep;
	}

	public void setAsleep(boolean asleep) {
		this.asleep = asleep;
	}

	public abstract void eat();
	// the code will be used in the child classes
	// abstract means that the child classes HAVE to use it

	@Override
	public String toString() {
		return name + " " + sound;
	}

}