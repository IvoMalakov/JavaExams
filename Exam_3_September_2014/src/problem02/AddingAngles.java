package problem02;

import java.util.Scanner;

public class AddingAngles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = scanner.nextLine().split("\\s+");
		
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		boolean setOfNumbersHasFound = false;
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					
					int sum = numbers[i] + numbers[j] + numbers[k];
					
					if (sum % 360 == 0) {
						setOfNumbersHasFound = true;
						
						System.out.printf("%d + %d + %d = %d degrees%n",
								numbers[i],
								numbers[j],
								numbers[k],
								sum);
					}
				}
			}
		}
		
		if (!setOfNumbersHasFound) {
			System.out.println("No");
		}
	}
}