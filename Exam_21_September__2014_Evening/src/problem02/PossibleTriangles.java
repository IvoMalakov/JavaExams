package problem02;

import java.util.Arrays;
import java.util.Scanner;

public class PossibleTriangles {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean triangleHasFound = false;
		
		while (true) {
			String command = scanner.nextLine();
			
			if (command.equals("End")) {
				break;
			}
			
			String[] input = command.split("\\s+");
			
			double sides[] = new double[3];	
			sides[0] = Double.parseDouble(input[0]);
			sides[1] =  Double.parseDouble(input[1]);
			sides[2] =  Double.parseDouble(input[2]);
			
			Arrays.sort(sides);
			
			if (sides[0] + sides[1] > sides[2]) {
				
				System.out.printf("%.2f+%.2f>%.2f%n",
						sides[0], 
						sides[1],
						sides[2]);
				
				triangleHasFound = true;
			}
		}
		
		if (!triangleHasFound) {
			System.out.println("No");
		}
	}
}