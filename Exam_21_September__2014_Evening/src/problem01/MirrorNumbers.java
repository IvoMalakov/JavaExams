package problem01;

import java.util.Scanner;

public class MirrorNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = scanner.nextLine().split("\\s+");
		
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		boolean mirrorNumberHasFound = false;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				
				String firstNumberAsString = Integer.toString(numbers[i]);
				char[] secondNumbersAsCharArray = Integer
						.toString(numbers[j])
						.toCharArray();
				
				int secondNumberFullSize = secondNumbersAsCharArray.length;
				int secondNumberHalfSize = secondNumberFullSize / 2;
				
				reverseTheSecondNumber(secondNumbersAsCharArray, secondNumberFullSize, secondNumberHalfSize);
				
				String secondNumberReversed = new String(secondNumbersAsCharArray);
				
				if (firstNumberAsString.equals(secondNumberReversed)) {
					mirrorNumberHasFound = true;
					
					System.out.printf("%d<!>%d%n",
							numbers[i],
							numbers[j]);
				}
			}
		}
		
		if (!mirrorNumberHasFound) {
			
			System.out.println("No");
		}
	}

	private static void reverseTheSecondNumber(char[] secondNumbersAsCharArray, int secondNumberFullSize,
			int secondNumberHalfSize) {
		for (int k = 0; k < secondNumberHalfSize; k++) {
			
			char prevValue = secondNumbersAsCharArray[k];
			secondNumbersAsCharArray[k] = secondNumbersAsCharArray[secondNumberFullSize - 1 - k];
			secondNumbersAsCharArray[secondNumberFullSize - 1 - k] = prevValue;
		}
	}
}