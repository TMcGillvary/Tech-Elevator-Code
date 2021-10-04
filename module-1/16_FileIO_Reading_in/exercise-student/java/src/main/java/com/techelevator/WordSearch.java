package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {

        // listening to keyboard input
        Scanner scanner = new Scanner(System.in);

        //creating File instance to reference text file in Java using Scanner
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String path = scanner.nextLine();
        File inputFile = new File(path);

        //creating word search
        System.out.println("What is the search word you are looking for?");
        String searchWord = scanner.nextLine();

        // creating case sensitive input
        System.out.println("Should the search be case sensitive? (Y\\N)");
        String wordCase = scanner.nextLine().substring(0, 1); // this will only take y or n if user inputs yes or no instead of y or n

        //Creating Scanner instance to read File in Java
        try (Scanner newFile = new Scanner(inputFile)) {
            int startOfFile = 1; // line numbers begin at 1, not 0

            while (newFile.hasNextLine()) {
                String line = newFile.nextLine();
                if (wordCase.equalsIgnoreCase("N")) {
                    // put everything to one case type since case doesn't matter
                    if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                        System.out.println(startOfFile + ") " + line);
                    }
                } else {
                    if (line.contains(searchWord)) {
                        System.out.println(startOfFile + ") " + line);
                    }
                }
                startOfFile++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Your file doesn't exist");
        }
    }
}
