package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        // listening to keyboard input
        try (Scanner scanner = new Scanner(System.in)) {

            //creating word find
            System.out.println("What is the search word?");
            String findWord = scanner.nextLine();
            if ((findWord == null) || (findWord.isEmpty())) {
                System.out.println("You didn't enter a findable word, please try again");
                System.exit(1);
            }

            //creating word replace
            System.out.println("What is the replacement word?");
            String replacementWord = scanner.nextLine();
            if ((replacementWord == null) || (replacementWord.isEmpty())) {
                System.out.println("You didn't enter a replaceable word, please try again");
                System.exit(1);
            }

            //creating source file
            System.out.println("What is the source file?");
            String sourcePath = scanner.nextLine();
            File inputSourceFile = new File(sourcePath);

            //creating destination file
            System.out.println("What is the destination file?");
            String destinationPath = scanner.nextLine();
            File destinationFile = new File(destinationPath);


            // Open inputted file for reading and write to destination file
            try (Scanner sourceFile = new Scanner(inputSourceFile);
                 PrintWriter destinationWriter = new PrintWriter(destinationFile)) {

                // Read the source file and write to new file with original word replaced
                // nothing fancy needed since case is important
                while (sourceFile.hasNextLine()) {
                    String line = sourceFile.nextLine();
                    destinationWriter.println(line.replaceAll(findWord, replacementWord));
                }

            } catch (FileNotFoundException e) {
                if (!inputSourceFile.exists() || !inputSourceFile.isFile()) {
                    System.out.println("Your source file doesn't work.");
                }
                if (!destinationFile.exists() || !destinationFile.isFile()) {
                    System.out.println("Your destination file doesn't work.");
                }
                System.out.println("Please try again.");
            }
        }
    }
}
