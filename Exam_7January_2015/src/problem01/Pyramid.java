package problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		
		int[][] pyramid = new int[numberOfRows][];
		
		for (int i = 0; i < numberOfRows; i++) {
			fillARowOfThePyramid(scanner, pyramid, i);
		}
		
		List<Integer> outputList = new ArrayList<>();
		
		outputList.add(pyramid[0][0]);
		
		int prevNumber = pyramid[0][0];
		boolean hasBiggerNumber = false;
		
		for (int i = 1; i < numberOfRows; i++) {
			Arrays.sort(pyramid[i]);
			
			for (int number : pyramid[i]) {
				if (number > prevNumber) {
					
					outputList.add(number);
					prevNumber = number;
					hasBiggerNumber = true;
					break;
				}
			}
			
			if (!hasBiggerNumber) {
				prevNumber++;
				continue;
			}
		}
		
		printTheOutPut(outputList);
	}

	private static void fillARowOfThePyramid(Scanner scanner, int[][] pyramid, int i) {
		String[] rowAsString = scanner.nextLine().trim().split("\\s+");
		int rowSize = rowAsString.length;
		
		pyramid[i] = new int[rowSize];
		
		for (int j = 0; j < rowSize; j++) {
			pyramid[i][j] = Integer.parseInt(rowAsString[j]);
		}
	}
	
	private static void printTheOutPut(List<Integer> outputList) {
		StringBuilder output = new StringBuilder();
		
		for (int number : outputList) {
			output.append(String.format("%d", number));
			
			if (number == getLastNumber(outputList)) {
				output.append("\n");
			} else {
				output.append(", ");
			}
		}
		
		System.out.print(output);
	}

	private static int getLastNumber(List<Integer> outputList) {
		int lastNumber = Integer.MIN_VALUE;
		
		for (int number : outputList) {
			lastNumber = number;
		}
		
		return lastNumber;
	}
}