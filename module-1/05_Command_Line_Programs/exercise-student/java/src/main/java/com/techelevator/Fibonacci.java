package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	/*
	THIS IS A CONDITION:
Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number:

Please enter a number: 17

0, 1, 1, 2, 3, 5, 8, 13

THIS IS A CONDITION:
If the input is a number that appears in the Fibonacci sequence, print the sequence up to and including that number:

Please enter a number: 34

0, 1, 1, 2, 3, 5, 8, 13, 21, 34

THIS IS A CONDITION:
The Fibonacci sequence always starts with 0 and 1. If the input is 0 or a negative number, print "0, 1":

Please enter a number: 0

0, 1

THIS IS A CONDITION:
If the input is 1, print "0, 1, 1":

Please enter a number: 1

0, 1, 1
	 */


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// system.in is listening from the keyboard - scanner waits for keyboard

		System.out.println("Welcome to the Fibonacci Sequencer");

		System.out.print("Please enter a number: ");
		String chosenNumStr = scanner.nextLine();
		int chosenNum = Integer.parseInt(chosenNumStr); // output the entered number from String to int

		// setting the variables for the fibonacci sequencer
		int fibSum = 0;
		int firstNumInFib = 0;
		int secondNumInFib = 1;

		if (chosenNum <= 0) {
			System.out.print("0, 1");
		} else {
			while (fibSum <= chosenNum) {
				System.out.print(fibSum + ", ");
				firstNumInFib = secondNumInFib;
				secondNumInFib = fibSum;
				fibSum = firstNumInFib + secondNumInFib;
			}
		}

	}
}