package problem03;

import java.util.Scanner;

public class Biggest3PrimeNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner
				.nextLine()
				.trim()
				.split("[\\s()]+");
		
		int[] numbers = new int[input.length - 1];
		int numbersSize = numbers.length;
		
		for (int i = 0; i < numbersSize; i++) {
			numbers[i] = Integer.parseInt(input[i + 1]);
		}
		
		boolean nonRepeatingPrimeNumbersHasFound = false;
		
		int bestSum = 0;
		
		for (int i = 0; i < numbersSize; i++) {
			boolean isFirstNumberPrime = isPrime(numbers[i]);
			
			if (!isFirstNumberPrime)
			{
				continue;
			}
			
			for (int j = i + 1; j < numbersSize; j++) {
				boolean isSecondNumberPrime = isPrime(numbers[j]);
				
				if (!isSecondNumberPrime)
				{
					continue;
				}
				
				for (int k = j + 1; k < numbers.length; k++) {
					boolean isThirdNumberPrime = isPrime(numbers[k]);
					
					if (!isThirdNumberPrime)
					{
						continue;
					}
					
					if ((numbers[i] != numbers[j])
							&& (numbers[i] != numbers[k])
							&& (numbers[j] != numbers[k])) {
						
							nonRepeatingPrimeNumbersHasFound = true;
							int sum = numbers[i] + numbers[j] + numbers[k];
							
							if (sum > bestSum) {
								bestSum = sum;
							}
					}
				}
			}
		}
		
		if (nonRepeatingPrimeNumbersHasFound) {
			System.out.println(bestSum);
		} else {
			System.out.println("No");
		}
	}

	private static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		} else {
			boolean isPrime = true;
			
			for (int i = 2; i < number; i++) {
				int remainder = number % i;
				
				if (remainder == 0) {
					isPrime = false;
				}
			}
			
			return isPrime;
		}
	}
}