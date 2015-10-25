package problem01;

import java.util.Scanner;

public class DozensOfEggs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final int NumberOfInputLines = 7;
		final int oneDozen = 12;
		
		int sumOfDozens = 0;
		int sumOfEggs = 0;
		
		for (int i = 0; i < NumberOfInputLines; i++) {
			String[] input = scanner.nextLine().trim().split("\\s+");
			
			int number = Integer.parseInt(input[0]);
			String countMeasure = input[1];
			
			switch (countMeasure) {
			
			case "dozens":
				sumOfDozens += number;
				break;
				
			case "eggs":
				sumOfEggs += number;
				break;
				
			default:
				throw new IllegalArgumentException("This should never happend");	
			}
			
			int dozents = sumOfEggs / oneDozen;
			
			sumOfDozens += dozents;
			sumOfEggs -= dozents * oneDozen;
		}
		
		System.out.printf("%d dozens + %d eggs%n",
				sumOfDozens,
				sumOfEggs);
	}
}