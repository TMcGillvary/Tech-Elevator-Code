package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TempConvert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // system.in is listening from the keyboard - scanner waits for keyboard

        System.out.println("Welcome to the Temperature Converter");

		/* Instructions from ReadMe:
		Please enter the temperature: 58
		Is the temperature in (C)elsius, or (F)ahrenheit? F
		58F is 14C.

		F to C: Tc = (Tf - 32) / 1.8
		C to F: Tf = Tc * 1.8 + 32
		 */

        System.out.print("Please enter the temperature: ");
        String tempInputStr = scanner.nextLine();
        int tempInput = Integer.parseInt(tempInputStr); // output the entered number from String to int

        System.out.println("You entered: " + tempInputStr);

        System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit?\n" +
                "Please enter \"F\" for Fahrenheit or \"C\" for Celsius: ");
        String tempTypeStr = scanner.nextLine(); //output either F or C

        System.out.println("You entered: " + tempTypeStr);
        System.out.print("Calculating... \n");

        int convertedTemp = 0;
        //Celsius conversions
        if (tempTypeStr.equalsIgnoreCase("C")) {
            convertedTemp = (int) (tempInput * 1.8 + 32);
            System.out.format("%dC is %dF%n", tempInput, convertedTemp);
        }
        // Fahrenheit conversions
        else if (tempTypeStr.equalsIgnoreCase("F")) {
            convertedTemp = (int) ((tempInput - 32) / 1.8);
            System.out.format("%dF is %dC%n", tempInput, convertedTemp);
        }

        System.out.println("Thank you for using the Temperature Converter! :)");

    }

}
