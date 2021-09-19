package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// system.in is listening from the keyboard - scanner waits for keyboard

		System.out.println("Welcome to the Decimal to Binary Converter");

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String chosenNumStr = scanner.nextLine();
		String[] chosenNumbers = chosenNumStr.split(" ");

		for (int i = 0; i < chosenNumbers.length; i++) {
			int decimalInteger = Integer.parseInt(chosenNumbers[i]); // output the entered number from String to int
			String binaryValue = Integer.toBinaryString(decimalInteger);
			System.out.format("%d in binary is %s%n", decimalInteger, binaryValue);
		}

	}

}
