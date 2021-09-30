package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Tests {

    @Test
    public void equals_true_when_n_is_18() {
        // Arrange
        int n = 18;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void equals_true_when_n_is_19() {
        // Arrange
        int n = 19;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void equals_false_when_n_is_20() {
        // Arrange
        int n = 20;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void equals_true_when_n_is_38() {
        // Arrange
        int n = 38;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void equals_true_when_n_is_39() {
        // Arrange
        int n = 39;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void equals_false_when_n_is_40() {
        // Arrange
        int n = 40;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void equals_false_when_n_is_17() {
        // Arrange
        int n = 17;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void equals_false_when_n_is_21() {
        // Arrange
        int n = 21;
        Less20 less20 = new Less20();

        // Acts
        boolean actual = less20.isLessThanMultipleOf20(n);

        // Assert
        Assert.assertEquals(false, actual);
    }
}
