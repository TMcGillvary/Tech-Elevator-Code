package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lecture {

    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);

        /*
         * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
         * modify file system objects.
         *
         * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
         *
         * A new instance of File can be created from a String that contains a file system path
         */

        File pwd = new File(".");
        System.out.println(pwd.getAbsolutePath());

        File unsorted = new File("unsorted.txt");
        System.out.println("unsorted.txt exists? " + unsorted.exists());
        System.out.println("Size:" + unsorted.getTotalSpace());
        System.out.println("Size: 4 " + unsorted.length());


        // Open unsorted.txt for reading and sorted.txt for writing
        try (Scanner unsortedScanner = new Scanner(unsorted);
             PrintWriter sortedWriter = new PrintWriter("sorted.txt");
             PrintWriter appendingSortWriter = new PrintWriter(new FileWriter("appendSorted.txt", true))) {

            readSortAndPrint(unsortedScanner, sortedWriter);

            // move this code to a separate method below and comment this code out
//            // Read the unsorted lines into a List<String>
//            List<String> lines = new ArrayList<String>();
//            while (unsortedScanner.hasNextLine()) {
//                String line = unsortedScanner.nextLine();
//                lines.add(line);
//            }
//
//            // sort using the Collections import
//            Collections.sort(lines);
//
//            // use the PrintWriter to write to the sorted.txt (will replace entire file each time)
//            for (String line : lines) {
//                sortedWriter.println(line);
//            }
//
//            // Write the lines to appendingSortWriter which will add onto the end
//            for (String line : lines) {
//                appendingSortWriter.println(line);
//            }

            // the appendSortWriter was not moved so it needed commented out as well
        }

    }

    public static void readSortAndPrint(Scanner unsortedScanner, PrintWriter sortedWriter) {

        // Read the unsorted lines into a List<String>
        List<String> lines = new ArrayList<String>();
        while (unsortedScanner.hasNextLine()) {
            String line = unsortedScanner.nextLine();
            lines.add(line);
        }

        // sort using the Collections import
        Collections.sort(lines);

        // use the PrintWriter to write to the sorted.txt (will replace entire file each time)
        for (String line : lines) {
            sortedWriter.println(line);
        }

    }

}
