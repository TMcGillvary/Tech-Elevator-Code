package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		// NOTE: no indexing to Maps b/c unordered List

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> stateMap = new HashMap<String, String>();
		stateMap.put("OH", "Ohio");
		stateMap.put("KY", "Kentucky");
		stateMap.put("IN", "Indiana");
		stateMap.putIfAbsent("OH", "Ohi."); // does not overwrite value b/c OH key is present
		stateMap.putIfAbsent("HI", "Hawaii"); // adds HI key b/c does not exist in Map

		System.out.println(stateMap.size()); // prints # of pairs not individual values within pairs
		System.out.println("OH = " + stateMap.get("OH"));
		System.out.println("HI = " + stateMap.get("HI"));

		if (stateMap.containsKey("AK")) {
			// checks whether the Key exists before running the code in order to prevent a null
			System.out.println("AK = " + stateMap.get("AK"));
		}

		System.out.println("\n####################");
		System.out.println("     Map Looping");
		System.out.println("####################");
		System.out.println();

		// Looping using .keySet()
		Set<String> stateKeys = stateMap.keySet();
		for (String stateKey : stateKeys) { // no guaranteed order
			String stateName = stateMap.get(stateKey);
			System.out.println(stateKey + ", " + stateName);
		}

		// Looping using .entrySet()
		Set<Map.Entry<String, String>> stateNames = stateMap.entrySet();
		for (Map.Entry<String, String> stateName : stateNames) {
			String key = stateName.getKey();
			String value = stateName.getValue();
			System.out.println(key + ", " + value);
		}

		System.out.println("\n####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		Set<Long> couponNums = new HashSet<Long>();
		couponNums.add(53L);
		long butter = 21L; // declaring a var for a Long
		couponNums.add(butter);
		System.out.println(couponNums);
		System.out.println(couponNums.add(butter)); // prints out false because the value has already been added

		// sets can ONLY be looped through with a for-each

		for (Long coupon : couponNums) {
			// insert code here
			return;
		}

	}

}
