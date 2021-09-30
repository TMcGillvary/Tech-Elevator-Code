package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaxEnd3Tests {

    @Test
    public void returns_3_when_3_is_largest_at_ends() {
        // Arrange
        int[] testArray = {1, 2, 3};
        MaxEnd3 maxEnd3 = new MaxEnd3();

        // Acts
        int[] actual = maxEnd3.makeArray(testArray);

        // Assert
        Assert.assertArrayEquals(new int[]{3, 3, 3}, actual);
    }

    @Test
    public void returns_11_when_11_is_largest_at_ends() {
        // Arrange
        int[] testArray = {11, 5, 9};
        MaxEnd3 maxEnd3 = new MaxEnd3();

        // Acts
        int[] actual = maxEnd3.makeArray(testArray);

        // Assert
        Assert.assertArrayEquals(new int[]{11, 11, 11}, actual);
    }

    @Test
    public void returns_5_when_5_is_largest_on_end_even_if_middle_is_larger() {
        // Arrange
        int[] testArray = {1, 11, 5};
        MaxEnd3 maxEnd3 = new MaxEnd3();

        // Acts
        int[] actual = maxEnd3.makeArray(testArray);

        // Assert
        Assert.assertArrayEquals(new int[]{5, 5, 5}, actual);
    }

    @Test
    public void returns_6_when_all_values_are_equal() {
        // Arrange
        int[] testArray = {6, 6, 6};
        MaxEnd3 maxEnd3 = new MaxEnd3();

        // Acts
        int[] actual = maxEnd3.makeArray(testArray);

        // Assert
        Assert.assertArrayEquals(new int[]{6, 6, 6}, actual);
    }

    @Test
    public void returns_negative_1_when_negative_1_is_largest_at_end() {
        // Arrange
        int[] testArray = {-1, -3, -5};
        MaxEnd3 maxEnd3 = new MaxEnd3();

        // Acts
        int[] actual = maxEnd3.makeArray(testArray);

        // Assert
        Assert.assertArrayEquals(new int[]{-1, -1, -1}, actual);
    }


}
