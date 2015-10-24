package problem03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LegoBlocks {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	List<List<Integer>> firstArray = new ArrayList<>();
    	List<List<Integer>> secondArray = new ArrayList<>();
    	
    	int numberOfRows = Integer.parseInt(scanner.nextLine());
    	
    	firstArray = fillTheArray(scanner, numberOfRows, firstArray);
    	secondArray = fillTheArray(scanner, numberOfRows, secondArray);
    	
    	List<List<Integer>> finalArray = new ArrayList<>();
    	
    	combineArrays(firstArray, secondArray, numberOfRows, finalArray);
    	
    	boolean isRectangular = checkTheFinalArrayIsRectangular(finalArray);
    	
    	printTheOutput(finalArray, isRectangular);	
    }

	private static void printTheOutput(List<List<Integer>> finalArray, boolean isRectangular) {
		if (isRectangular) {
    		for (List<Integer> currentRow : finalArray) {
    			System.out.println(currentRow);
    		}
    	} else {
    		int count = 0;
    		
    		for (List<Integer> currentRow : finalArray) {
    			count += currentRow.size();
    		}
    		
    		System.out.printf("The total number of cells is: %d", count);
    	}
	}

	private static boolean checkTheFinalArrayIsRectangular(List<List<Integer>> finalArray) {
		boolean isRectangular = false;
    	int size = finalArray.get(0).size();
    	
    	for (int i = 1; i < finalArray.size(); i++) {
    		if (size == finalArray.get(i).size()) {
    			isRectangular = true;
    		} else {
    			isRectangular = false;
    			break;
    		}
    	}
    	
    	return isRectangular;
	}

	private static void combineArrays(List<List<Integer>> firstArray, List<List<Integer>> secondArray, int numberOfRows,
			List<List<Integer>> finalArray) {
		for (int i = 0; i < numberOfRows; i++) {
    		finalArray.add(new ArrayList<>());
    		finalArray.get(i).addAll(firstArray.get(i));
    		
    		Collections.reverse(secondArray.get(i));
    		finalArray.get(i).addAll(secondArray.get(i));
    	}
	}

	private static List<List<Integer>> fillTheArray(Scanner scanner, int numberOfRows, List<List<Integer>> array) {
		for (int i = 0; i < numberOfRows; i++) {
			array.add(new ArrayList<>());
			String[] numbersAsString = scanner.nextLine().trim().split("\\s+");
			
			for (String numberString : numbersAsString) {
				array.get(i).add(Integer.parseInt(numberString));
			}
		}
		
		return array;
	}
}