package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // system.in is listening from the keyboard - scanner waits for keyboard

        System.out.println("Welcome to the Measurement Converter");

		/* Instructions from ReadMe:
		Please enter the length: 58
		Is the measurement in (m)eter, or (f)eet? f
		58f is 17m.

		m to f: m = f * 0.3048
		f to m: f = m * 3.2808399
		 */

        System.out.print("Please enter the length: ");
        String measurementInputStr = scanner.nextLine();
        int measurementInput = Integer.parseInt(measurementInputStr); // output the entered number from String to int

        System.out.print("Is the measurement in (m)eters, or (f)eet?\n" +
                "Please enter \"M\" for Meters or \"F\" for Feet: ");
        String measurementTypeStr = scanner.nextLine(); //output either M or F

        System.out.print("Calculating... \n");

        int convertedMeasurement = 0;
        //Meter conversions
        if (measurementTypeStr.equals("M") || measurementTypeStr.equals("m")) {
            convertedMeasurement = (int) (measurementInput * 3.2808399);
            System.out.format("%dm is %df%n", measurementInput, convertedMeasurement);
        }
        // Feet conversions
        else if (measurementTypeStr.equals("F") || measurementTypeStr.equals("f")) {
            convertedMeasurement = (int) (measurementInput * 0.3048);
            System.out.format("%df is %dm%n", measurementInput, convertedMeasurement);
        }

        System.out.println("Thank you for using the Measurement Converter! :)");
    }

}
