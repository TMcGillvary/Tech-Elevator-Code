package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTests {

    @Test
    public void returns_false_when_cigars_under_40_and_not_weekend() {
        // Arrange
        int cigars = 30;
        boolean isWeekend = false;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void returns_true_when_cigars_between_40_and_60_and_not_weekend() {
        // Arrange
        int cigars = 50;
        boolean isWeekend = false;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void returns_false_when_cigars_over_60_and_not_weekend() {
        // Arrange
        int cigars = 70;
        boolean isWeekend = false;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void returns_true_when_cigars_over_60_and_weekend() {
        // Arrange
        int cigars = 70;
        boolean isWeekend = true;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(true, actual);
    }

    @Test
    public void returns_false_when_cigars_under_40_and_weekend() {
        // Arrange
        int cigars = 30;
        boolean isWeekend = true;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(false, actual);
    }

    @Test
    public void returns_true_when_cigars_between_40_and_60_and_weekend() {
        // Arrange
        int cigars = 50;
        boolean isWeekend = true;
        CigarParty cigarParty = new CigarParty();

        // Act
        boolean actual = cigarParty.haveParty(cigars, isWeekend);

        // Assert
        Assert.assertEquals(true, actual);
    }
}
