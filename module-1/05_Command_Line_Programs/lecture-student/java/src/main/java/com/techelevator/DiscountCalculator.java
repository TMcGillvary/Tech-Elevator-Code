package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // system.in is listening from the keyboard - scanner waits for keyboard

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double


        System.out.print("Enter the discount amount (w/out percent sign): ");
        String discountAmountStr = scanner.nextLine(); // set variable type, variable name implying this is the string form of the discount amount
        double discountAmount = Double.parseDouble(discountAmountStr); // set variable type as double as we need to convert # to percent
        // parse means to read something and then convert to something else
        // move System.out.println("You Entered " + discountAmountStr); to underneath and change var to discountAmount to get the double
        discountAmount /= 100; // discountAmount = discountAmount / 100;
        //System.out.println("You entered " + discountAmount);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesStr = scanner.nextLine(); // set variable type, variable name implying this is the string form of price, always use scanner.nextLine();
        String[] priceStrs = pricesStr.split(" ");
            for (int i = 0; i < priceStrs.length; i++) {
                // System.out.println(priceStrs[i]);
                double price = Double.parseDouble(priceStrs[i]); // converting the string to double again

                double priceDiscount = price * discountAmount; // do the math

                double priceAfterDiscount = price - priceDiscount; // more math

                //System.out.println("Price: " + price + " Discount: " + priceDiscount + " Final Price: " + priceAfterDiscount);

                System.out.format("Price: $%9.2f Discount: $%9.2f Final Price: $%9.2f %n", price, priceDiscount, priceAfterDiscount);
            }

        System.out.println("Thank you for using the Discount Calculator!");


    }

}