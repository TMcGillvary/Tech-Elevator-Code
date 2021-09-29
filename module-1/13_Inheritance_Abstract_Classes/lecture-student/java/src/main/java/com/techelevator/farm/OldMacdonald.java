package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal cow = new Cow();
		cow.setAsleep(true);

		FarmAnimal pig = new Pig();
		pig.setAsleep(true);
		pig.eat();
		// had to create a new farm animal because that's where the asleep lives

		Cat cat = new Cat();
		cat.setAsleep(true);

		// so this doesn't work because of the abstract in farm animals "can't instantiate"
		// FarmAnimal mickeyMouse = new FarmAnimal("Mickey", "oh boy!");

		Singable[] singables =
				new Singable[] {cow, new Chicken(), pig, new Tractor(), cat};
		// these are anonymous instances when they're new Animal()

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}