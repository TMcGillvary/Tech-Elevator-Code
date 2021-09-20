package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		String helloTheHardWay = new String("hello");

		String hello = "hello";

		String anotherHello = "hello";

		System.out.println(helloTheHardWay == hello);
		System.out.println(hello == anotherHello);

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		String filename = "happy.bunny.jpg";
		System.out.println( "The length of filename is " + filename.length());
		System.out.println( "Does the filename end with JPG? " + filename.endsWith(".jpg"));
		System.out.println("Where does index of bunny exist? " + filename.indexOf("bunny"));
		System.out.println("Where does last index of bunny exist? " + filename.lastIndexOf("bunny"));
		// only difference is the last index runs from right to left instead of left to right

		// Find how many . are in the filename
		int count = 0;
		boolean notDone = true;
		int dotIndex = 0;

		while (notDone) {
			dotIndex = filename.indexOf(".", dotIndex);
			if (dotIndex == -1) {
				notDone = false;
			} else {
				count++;
				dotIndex++;
			}
		}
		System.out.println("Number of dots in filename is " + count);

		//				    0....+....1....+....2
		String greeting  = "Hello, everyone";
		String everyone = greeting.substring(7);
		System.out.println("everyone = " + everyone);

		String firstWord = greeting.substring(0, 5);
		//substring last index is UP TO but NOT INCLUDING which is why it's one past the final value
		//it's also not gonna stop you from going beyond with this substring
		System.out.println("hello = " + firstWord);

		String mixedCase = "First Last";
		//mixedCase.toLowerCase();
		//System.out.println(mixedCase);
		// ** prints nothing different because you're not putting value into new var
		mixedCase = mixedCase.toLowerCase();
		System.out.println(mixedCase);

		String fullName = "First Last";
		String uppercase = fullName.toUpperCase();
		// by adding String in front of fullName on 2nd line, you're defining var again rather than replacing
		// what's in the OG string so it requires new var
		System.out.println(uppercase);

		String hasSpaces = "   abc   ";
		System.out.println("hasSpaces = [" + hasSpaces + "]");
		// OR you can include hasSpaces.trim() in above print and it'll fix it inline
		String spacesRemoved = hasSpaces.trim();
		System.out.println("hasSpaces = [" + spacesRemoved + "]");

		boolean letters = false;
		String abc = "ABC";
		if (abc.charAt(0) == 'A') {
			letters = true;
		}
		System.out.println(letters);
		// should always print true

		String nullStr = null;
		if (nullStr == null) {
			//do something
			nullStr = "positive";
		}
		System.out.println(nullStr);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();



		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		String hello1 = "";
		String hello2 = "";
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
