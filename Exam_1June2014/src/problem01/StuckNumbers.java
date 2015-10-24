package problem01;

import java.util.Scanner;

public class StuckNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		String[] input = scanner.nextLine().split("\\s+");
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		boolean stuckNumberHasFound = false;
		
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = 0; c < n; c++) {
					for (int d = 0; d < n; d++) {
						if ((numbers[a]) != numbers[b] &&
								numbers[a] != numbers[c] &&
								numbers[a] != numbers[d] &&
								numbers[b] != numbers[c] &&
								numbers[b] != numbers[d] &&
								numbers[c] != numbers[d]) {
							
							String first = "" + numbers[a] + numbers[b];
							String second = "" + numbers[c] + numbers[d];
							
							if (first.equals(second)) {
								stuckNumberHasFound = true;
								System.out.printf("%d|%d==%d|%d\n",
										numbers[a], 
										numbers[b],
										numbers[c], 
										numbers[d]);
							}
						}
					}
				}
			}
		}
		
		if (!stuckNumberHasFound) {
			System.out.println("No");
		}
	}
}