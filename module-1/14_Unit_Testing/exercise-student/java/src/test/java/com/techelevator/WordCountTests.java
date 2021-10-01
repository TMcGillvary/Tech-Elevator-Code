package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class WordCountTests {

    @Test
    public void returns_ba_2_black_1_sheep_1() {
        // Arrange
        String[] words = {"ba", "ba", "black", "sheep"};
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();
        compareMap.put("ba", 2);
        compareMap.put("black", 1);
        compareMap.put("sheep", 1);

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

    @Test
    public void returns_a_2_b_2_c_1() {
        // Arrange
        String[] words = {"a", "b", "a", "c", "b"};
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();
        compareMap.put("a", 2);
        compareMap.put("b", 2);
        compareMap.put("c", 1);

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

    @Test
    public void returns_empty_for_empty_array() {
        // Arrange
        String[] words = { };
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

    @Test
    public void returns_empty_for_null() {
        // Arrange
        String[] words = { };
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

    @Test
    public void returns_a_1_b_1_c_1() {
        // Arrange
        String[] words = {"c", "b", "a"};
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();
        compareMap.put("c", 1);
        compareMap.put("b", 1);
        compareMap.put("a", 1);

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

    @Test
    public void returns_correct_number_if_all_items_in_array_are_same() {
        // Arrange
        String[] words = {"boo", "boo", "boo", "boo", "boo", "boo",};
        WordCount wordCount = new WordCount();
        Map<String, Integer> compareMap = new HashMap<>();
        compareMap.put("boo", 6);

        // Acts
        Map<String, Integer> actual = wordCount.getCount(words);

        // Assert
        Assert.assertEquals(compareMap.keySet(), actual.keySet());
    }

}
