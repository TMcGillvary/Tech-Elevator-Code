package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTests {

    @Test
    public void returns_2_when_you_are_5_and_date_is_10() {
        // Arrange
        int you = 5;
        int date = 10;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(2, actual);
    }

    @Test
    public void returns_2_when_you_are_10_and_date_is_3() {
        // Arrange
        int you = 10;
        int date = 3;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(2, actual);
    }

    @Test
    public void returns_0_when_you_are_5_and_date_is_2() {
        // Arrange
        int you = 5;
        int date = 2;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(0, actual);
    }

    @Test
    public void returns_1_when_you_and_date_are_5() {
        // Arrange
        int you = 5;
        int date = 5;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(1, actual);
    }

    @Test
    public void returns_0_when_you_are_2_and_date_is_10() {
        // Arrange
        int you = 2;
        int date = 10;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(0, actual);
    }

    @Test
    public void returns_2_when_you_and_date_are_8() {
        // Arrange
        int you = 8;
        int date = 8;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(2, actual);
    }

    @Test
    public void returns_2_when_you_and_date_are_10() {
        // Arrange
        int you = 10;
        int date = 10;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(2, actual);
    }

    @Test
    public void returns_0_when_you_and_date_are_1() {
        // Arrange
        int you = 1;
        int date = 1;
        DateFashion dateFashion = new DateFashion();

        // Acts
        int actual = dateFashion.getATable(you, date);

        // Assert
        Assert.assertEquals(0, actual);
    }
}
