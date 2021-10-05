package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

    public static void main(String[] args) {

        // listening to keyboard input
        Scanner scanner = new Scanner(System.in);

        // creating destination file
        System.out.println("Welcome to the FizzBuzz creator! Where would you like this file saved?");
        String destinationPath = scanner.nextLine();


        try (PrintWriter newFizzBuzzFileWriter = new PrintWriter(destinationPath)) {

            // fizzbuzz loop, with numbers starting at 1
            for (int i = 1; i <= 300; i++) {
                if (i % 15 == 0) {
                    newFizzBuzzFileWriter.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    newFizzBuzzFileWriter.println("Fizz");
                } else if (i % 5 == 0) {
                    newFizzBuzzFileWriter.println("Buzz");
                } else {
                    newFizzBuzzFileWriter.println(i);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Your destination file doesn't work. Please try again.");
        }
    }

}
