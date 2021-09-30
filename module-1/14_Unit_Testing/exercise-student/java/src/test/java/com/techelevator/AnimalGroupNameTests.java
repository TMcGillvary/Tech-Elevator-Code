package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTests {

    @Test
    public void elephant_returns_herd() {
        // Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();

        // Act
        String actual = animalGroupName.getHerd("Elephant");

        // Assert
        Assert.assertEquals("Herd", actual);
    }

    @Test
    public void empty_string_returns_unknown() {
        // Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();

        // Act
        String actual = animalGroupName.getHerd("");

        // Assert
        Assert.assertEquals("unknown", actual);
    }

    @Test
    public void uppercase_elephant_returns_herd() {
        // Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();

        // Act
        String actual = animalGroupName.getHerd("ELEPHANT");

        // Assert
        Assert.assertEquals("Herd", actual);
    }

    @Test
    public void null_returns_unknown() {
        // Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();

        // Act
        String actual = animalGroupName.getHerd(null);

        // Assert
        Assert.assertEquals("unknown", actual);
    }

    @Test
    public void unicorn_returns_unknown() {
        // Arrange
        AnimalGroupName animalGroupName = new AnimalGroupName();

        // Act
        String actual = animalGroupName.getHerd("Unicorn");

        // Assert
        Assert.assertEquals("unknown", actual);
    }
}
