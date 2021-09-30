package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTests {

    @Test
    public void returns_cho_twice() {
        // Arrange
        String str = "Chocolate";
        int n = 2;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("ChoCho", actual);
    }

    @Test
    public void returns_cho_three_times() {
        // Arrange
        String str = "Chocolate";
        int n = 3;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("ChoChoCho", actual);
    }

    @Test
    public void returns_abc_three_times() {
        // Arrange
        String str = "Abc";
        int n = 3;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("AbcAbcAbc", actual);
    }

    @Test
    public void returns_hi_four_times() {
        // Arrange
        String str = "Hi";
        int n = 4;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("HiHiHiHi", actual);
    }

    @Test
    public void returns_empty_string_for_null() {
        // Arrange
        String str = null;
        int n = 2;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("", actual);
    }

    @Test
    public void returns_empty_string_for_empty_string() {
        // Arrange
        String str = "";
        int n = 2;
        FrontTimes frontTimes = new FrontTimes();

        // Acts
        String actual = frontTimes.generateString(str, n);

        // Assert
        Assert.assertEquals("", actual);
    }

}
