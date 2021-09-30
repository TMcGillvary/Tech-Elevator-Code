package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Tests {

    @Test
    public void array_has_no_1s_and_no_3s_returns_true() {
        // Arrange
        int[] testArray = { 0, 2, 4 };
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void array_has_1s_and_3s_returns_false() {
        // Arrange
        int[] testArray = { 1, 2, 3 };
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void array_has_negatives_returns_true() {
        // Arrange
        int[] testArray = { -1, -2, -3 };
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void array_has_3s_but_no_1s_returns_false() {
        // Arrange
        int[] testArray = { 5, 2, 3 };
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void array_has_1s_but_no_3s_returns_false() {
        // Arrange
        int[] testArray = { 6, 1, 8 };
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void null_array_does_not_contains_1_or_3_so_returns_true() {
        // Arrange
        int[] testArray = null;
        Lucky13 lucky13 = new Lucky13();

        // Acts
        boolean actual = lucky13.getLucky(testArray);

        // Assert
        Assert.assertEquals(true, actual);
    }

}
