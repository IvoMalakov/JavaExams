package problem02;

import java.util.Scanner;

public class TerroristsWin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.nextLine();
		char[] inputAsCharArray = input.toCharArray();
		
		int startIndex = input.indexOf("|", 0);
		int endIndex = 0;
		int asciiSum = 0;
		int bombPower = 0;
		
		while (startIndex != -1) {
			asciiSum = 0;
			endIndex = input.indexOf("|", startIndex + 1);
			
			if (endIndex <= startIndex) {
				break;
			}
			
			for (int i = startIndex + 1; i < endIndex; i++) {
				asciiSum += inputAsCharArray[i];
				inputAsCharArray[i] = '.';
			}
			
			String asciiSumAsString = "" + asciiSum;
			String bombPowerAsString = "" 
			+ asciiSumAsString
			.charAt(asciiSumAsString.length() - 1);
			
			bombPower = Integer.parseInt(bombPowerAsString);
			
			for (int i = startIndex; i >= startIndex - bombPower; i--) {
				
				if (i < 0) {
					break;
				}
				
				inputAsCharArray[i] = '.';
			}
			
			for (int i = endIndex; i <= endIndex + bombPower; i++) {
				
				if (i > inputAsCharArray.length - 1) {
					break;
				}
				
				inputAsCharArray[i] = '.';
			}
			
			startIndex = input.indexOf("|", endIndex + 1);
		}
		
		for (char symbol : inputAsCharArray) {
			
			System.out.print(symbol);
		}
		
		System.out.println();
	}
}