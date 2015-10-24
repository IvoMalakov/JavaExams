package problem02;

import java.util.Scanner;

public class LettersChangeNumbers {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split("\\s+");
		
		double totalSum = 0;
		
		for (String string : input) {
			double stringSum = calculateStringSum(string);
			totalSum += stringSum;
		}
		
		System.out.printf("%.2f", totalSum);
	}

	private static double calculateStringSum(String string) {
		String numberAsString = string.substring(1, string.length() - 1);
		double stringSum = Integer.parseInt(numberAsString);
		
		stringSum = executeFirstChar(string.charAt(0), stringSum);
		stringSum = executeSecondChar(string.charAt(string.length() - 1), stringSum);
		
		return stringSum;
	}

	private static double executeFirstChar(char letter, double number) {
		double lettersValue;
		
		if (letter >= 65 && letter <= 90) {
			lettersValue = number / (letter - 64);
		} else {
			lettersValue = number * (letter - 96);
		}
		
		return lettersValue;
	}

	private static double executeSecondChar(char letter, double number) {
		double lettersValue;
		
		if (letter >= 65 && letter <= 90) {
			lettersValue = number - (letter - 64);
		} else {
			lettersValue = number + (letter - 96);
		}
		
		return lettersValue;
	}
}