package com.techelevator.farm;

import java.math.BigDecimal;

// farm animal is-a for the interface, farm animal is a singable class
public class FarmAnimal implements Singable, Sellable {
	private String name;
	private String sound;
	private BigDecimal price;

	public FarmAnimal(String name, String sound, BigDecimal price) {
		this.name = name;
		this.sound = sound;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

	public String getIndefiniteArticleForSound() {
		return "a";
	}

	@Override
	public BigDecimal getPrice() {
		return this.price;
	}

}