package com.techelevator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		int x = 5; // primitive type on the stack
		Integer xInteger = new Integer(5); // object of primitive type on the heap
		// also written as (using different var b/c can't have same one but it should be same)
		Integer xInt = 5; // object of primitive type on the heap

		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################\n");

		ArrayList<String> animals2 = new ArrayList<String>();
		// I want an ArrayList of String, with a constructor () that takes no arguments (no values passed in yet by default)
		// it really should be written as
		List<String> animals = new ArrayList<String>();

		animals.add("dog");
		animals.add("cat");

		System.out.println("The size of the List currently is " + animals.size()); //size is the same as length for array
		System.out.println("The animal at the first zero index is " + animals.get(0)); // get(0) is the same as animals[0] for a regular array

		List<Integer> numbers = new ArrayList<Integer>(); // can't use int primitive type, gotta do Integer
		numbers.add(5); // it knows int 5 should be Integer 5 within the collection
		numbers.add(63);
		Integer indexZero = numbers.get(0); // declared list of Integer so Integer indexZero = Integer 5
		int indexOne = numbers.get(1); // autoboxing magic happens and it still knows to convert the Integer 63 down to int 63

		List<String> otherAnimals = new ArrayList<String>(Arrays.asList("dog", "cat"));
		// how to start a new ArrayList with arguments added

		System.out.println("\n####################");
		System.out.println("Lists are ordered");
		System.out.println("####################\n");

		animals.add(1, "bird");
		// printing the List in order
		System.out.println(animals);

		System.out.println("\n####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################\n");

		animals.add(0, "bird");
		System.out.println(animals);
		animals.add("7"); // type safe, animals.add(7); would not work
		// notice when try to print, b/c the add is after the print, the list is still bird, dog, bird, cat and there's no mention of the 7
		// animals.add(7, "7"); throws exception because the list is only 5 long

		System.out.println("\n####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################\n");

		// this is the same as the animals.add(0, bird), it just means you can insert anywhere within the current size with an index

		System.out.println("\n####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################\n");

		System.out.println("Before Remove: " + animals);
		String removedAnimals = animals.remove(2); // removes 2nd bird
		System.out.println("After Remove: " + animals);
		System.out.println("Removed " + removedAnimals); // prints that we removed bird specifically b/c we set it to a string variable

		animals.add("cat");
		boolean catRemoved = animals.remove("cat");
		System.out.println("catRemoved = " + catRemoved);
		System.out.println("Remove first instance of cat: " + animals);
		// you would need a loop to remove all instances, with a condition of while animals.remove("cat") == true

		System.out.println("\n####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################\n");

		boolean raptorFound = animals.contains("raptor");
		System.out.println("Raptor Found? " + raptorFound);

		System.out.println("\n####################");
		System.out.println("Find index of item in List");
		System.out.println("####################\n");

		System.out.println(animals);
		int indexOfDog = animals.indexOf("dog");
		System.out.println("First Dog is at index of " + indexOfDog);
		// to search through the index for all instances or for past the first dog, you'll need to loop

		System.out.println("\n####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################\n");

		String[] animalsArray = animals.toArray(new String[0]);
		System.out.println(animalsArray.length); //prints out the number in the new animalsArray

		System.out.println("\n####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################\n");

		Collections.sort(animals); // to sort list unicode alphabetical
		// works in place, meaning it just does the existing List and then anything after will be changed, it doesn't affect anything prior
		System.out.println("After sorting: " + animals);

		System.out.println("\n####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################\n");

		Collections.reverse(animals);
		System.out.println("After reversing: " + animals);

		System.out.println("\n####################");
		System.out.println("       FOREACH");
		System.out.println("####################\n");

		for (int i = 0; i < animals.size(); i++) {
			String currentAnimal = animals.get(i);
			System.out.println("Animal: " + currentAnimal);
			// OR System.out.println("Animal: " + animals.get(i))
		}

		// Collections is always plural, foreach (or enhanced loop) is a shorthand way to write a normal for loop
		for (String animal : animals) {
			System.out.println(animal);
		}
		// you can't use a foreach loop for where you currently are in the list

	}
}
