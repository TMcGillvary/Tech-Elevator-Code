package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTests {

    @Test
    public void returns_true_when_array_is_3_length_and_ends_are_equal() {
        // Arrange
        int[] nums = {1, 2, 1};
        SameFirstLast sameFirstLast = new SameFirstLast();

        // Acts
        boolean actual = sameFirstLast.isItTheSame(nums);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void returns_false_when_array_is_3_length_but_ends_are_unequal() {
        // Arrange
        int[] nums = {1, 2, 3};
        SameFirstLast sameFirstLast = new SameFirstLast();

        // Acts
        boolean actual = sameFirstLast.isItTheSame(nums);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void returns_true_when_array_is_4_length_and_ends_are_equal() {
        // Arrange
        int[] nums = {1, 2, 3, 1};
        SameFirstLast sameFirstLast = new SameFirstLast();

        // Acts
        boolean actual = sameFirstLast.isItTheSame(nums);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void returns_false_when_array_is_not_length_1_or_more() {
        // Arrange
        int[] nums = {};
        SameFirstLast sameFirstLast = new SameFirstLast();

        // Acts
        boolean actual = sameFirstLast.isItTheSame(nums);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void returns_true_when_array_is_only_length_1() {
        // Arrange
        int[] nums = {1};
        SameFirstLast sameFirstLast = new SameFirstLast();

        // Acts
        boolean actual = sameFirstLast.isItTheSame(nums);

        // Assert
        Assert.assertEquals(true, actual);
    }

}
