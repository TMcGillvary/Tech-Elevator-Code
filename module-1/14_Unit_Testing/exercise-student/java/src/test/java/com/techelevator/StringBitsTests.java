package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTests {

    @Test
    public void hello_yields_hlo() {
        // Arrange
        String str = "Hello";
        StringBits stringBits = new StringBits();

        // Acts
        String actual = stringBits.getBits(str);

        // Assert
        Assert.assertEquals("Hlo", actual);
    }

    @Test
    public void hi_yields_h() {
        // Arrange
        String str = "Hi";
        StringBits stringBits = new StringBits();

        // Acts
        String actual = stringBits.getBits(str);

        // Assert
        Assert.assertEquals("H", actual);
    }

    @Test
    public void heeololeo_yields_hello() {
        // Arrange
        String str = "Heeololeo";
        StringBits stringBits = new StringBits();

        // Acts
        String actual = stringBits.getBits(str);

        // Assert
        Assert.assertEquals("Hello", actual);
    }

    @Test
    public void null_yields_empty_string() {
        // Arrange
        String str = null;
        StringBits stringBits = new StringBits();

        // Acts
        String actual = stringBits.getBits(str);

        // Assert
        Assert.assertEquals("", actual);
    }

    @Test
    public void one_char_string_returns_that_char() {
        // Arrange
        String str = "H";
        StringBits stringBits = new StringBits();

        // Acts
        String actual = stringBits.getBits(str);

        // Assert
        Assert.assertEquals("H", actual);
    }

}
