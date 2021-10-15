package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	// instance variables
	public static List<HotelReservation> reservations = new ArrayList<HotelReservation>();

	public static void main(String[] args) {

//		HotelReservation reservation = new HotelReservation("John Doe", 2);
//
//		System.out.println(reservation.toString());
//
//		BigDecimal grandTotal = reservation.finalizedGrandTotal(true, true);
//		String finalizedGrandTotal = String.format("Final Total: $%.2f%n", grandTotal);
//
//		System.out.println(finalizedGrandTotal);

		File inputFile = new File("data-files/HotelInput.csv");

		try (Scanner scanningFile = new Scanner(inputFile)) {

			while (scanningFile.hasNextLine()) {
				String line = scanningFile.nextLine();
				String[] reservationArray = line.split(",");

				String name = reservationArray[0];
				int numberOfNights = Integer.parseInt(reservationArray[1]);

				HotelReservation reservation = new HotelReservation(name, numberOfNights);

				reservations.add(reservation);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		String formattedEstimatedTotals = String.format("Estimated Total for All Reservations: $%s", addAllEstimatedTotals(reservations));
		System.out.println(formattedEstimatedTotals);

	}

	// helper Methods
	public static BigDecimal addAllEstimatedTotals(List<HotelReservation> reservations) {
		BigDecimal totalEstimatedTotal = new BigDecimal("0.00");
		for (HotelReservation reservation : reservations) {
			totalEstimatedTotal = totalEstimatedTotal.add(reservation.getEstimatedTotal());
		}
		return totalEstimatedTotal;
	}

}
