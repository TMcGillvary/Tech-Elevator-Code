package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class LectureTest {

    @Test
    public void read_sort_and_print_correctly_sorts() {
        //Arrange
        String sep = System.lineSeparator(); // building in the correct line separator

        Scanner inputScanner = new Scanner("banana" + sep + "apple");

        // to test that the println works correctly:
//        while (inputScanner.hasNextLine()) {
//            System.out.println(inputScanner.nextLine());
//        }

        StringWriter strWriter = new StringWriter(); // writing to string instead of file since this is a test
        // this is the "actual" for the assert as well ^
        PrintWriter sortedWriter = new PrintWriter(strWriter);
        // passing the string into printwriter as if it were a file ^

        String expectedSort = "apple" + sep + "banana" + sep;

        //Act

        Lecture.readSortAndPrint(inputScanner, sortedWriter);

        String actual = strWriter.toString();

        //Assert

        Assert.assertEquals(expectedSort, actual);

    }

    // an example when I want it to come up in the test rather than catch it within the try/catch in the class
    @Test(expected = NullPointerException.class)
    public void some_test() {
        String bad = null;
        bad.length();
    }
}
