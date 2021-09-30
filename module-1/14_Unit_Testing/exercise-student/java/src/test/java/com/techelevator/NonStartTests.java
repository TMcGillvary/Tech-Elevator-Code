package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTests {

    @Test
    public void remove_h_and_t_return_ellohere() {
        // Arrange
        String a = "Hello";
        String b = "There";
        NonStart nonStart = new NonStart();

        // Acts
        String actual = nonStart.getPartialString(a, b);

        // Assert
        Assert.assertEquals("ellohere", actual);
    }

    @Test
    public void remove_j_and_c_return_avaode() {
        // Arrange
        String a = "java";
        String b = "code";
        NonStart nonStart = new NonStart();

        // Acts
        String actual = nonStart.getPartialString(a, b);

        // Assert
        Assert.assertEquals("avaode", actual);
    }

    @Test
    public void remove_s_and_j_return_hotlava() {
        // Arrange
        String a = "shotl";
        String b = "java";
        NonStart nonStart = new NonStart();

        // Acts
        String actual = nonStart.getPartialString(a, b);

        // Assert
        Assert.assertEquals("hotlava", actual);
    }

    @Test
    public void remove_h_and_m_return_ie() {
        // Arrange
        String a = "hi";
        String b = "me";
        NonStart nonStart = new NonStart();

        // Acts
        String actual = nonStart.getPartialString(a, b);

        // Assert
        Assert.assertEquals("ie", actual);
    }

    @Test
    public void return_empty_string_if_length_less_than_1() {
        // Arrange
        String a = "h";
        String b = "m";
        NonStart nonStart = new NonStart();

        // Acts
        String actual = nonStart.getPartialString(a, b);

        // Assert
        Assert.assertEquals("", actual);
    }

}
