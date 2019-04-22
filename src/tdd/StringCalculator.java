package tdd;

import java.util.List;
import java.util.ArrayList;

public class StringCalculator {
	public static int add(final String numbers) {
		String delimiter = ",|n";
		String numbersWithoutDelimiter = numbers;
		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDelimiter = numbers.substring(numbers.indexOf(delimiter) + 1);
		}
		return add(numbersWithoutDelimiter, delimiter);
	}
	
	private static final int add(final String numbers, final String delimiter) {
		int returnValue = 0;
		String[] numbersArray = numbers.split(delimiter);
//		if (numbersArray.length > 2) {
//			throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
//		} else {
//		}
		List negativeNumbers = new ArrayList();
		for (String number : numbersArray) {
			if (!number.trim().isEmpty()) {
				int numberInt = Integer.parseInt(number.trim()); // If it is not a number, parseInt will throw an exception
				if (numberInt < 0) {
					negativeNumbers.add(numberInt);
				} else if (numberInt <= 1000) {
					returnValue += numberInt;	
				}
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		}
		return returnValue; // Added return
	}
}
