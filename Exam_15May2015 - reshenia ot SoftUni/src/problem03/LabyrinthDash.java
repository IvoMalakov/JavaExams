package problem03;

import java.util.Scanner;

public class LabyrinthDash {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		
		char[][] matrix = new char [numberOfRows][];
		
		for (int i = 0; i < numberOfRows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		char[] moves = scanner.nextLine().toCharArray();
		
		int livesLeft = 3;
		int currentRow = 0;
		int currentCol = 0;
		int movesMade = 0;
		
		for (char move : moves) {
			int previousRow = currentRow;
			int previousCol = currentCol;
			
			switch (move) {
			case 'v':
				currentRow++;
				break;
			case '^':
				currentRow--;
				break;
			case '<':
				currentCol--;
				break;
			case '>':
				currentCol++;
				break;
			default:
				throw new IllegalArgumentException(
						"This should never happend");
			}
			
			if (!(isSellIsInsideMatrix(currentRow, currentCol, matrix)) 
					|| matrix[currentRow][currentCol] == ' ') {
				
				System.out.println("Fell off a cliff! Game Over!");
				movesMade++;
				break;
				
			} else if ((matrix[currentRow][currentCol] == '_') 
					|| (matrix[currentRow][currentCol] == '|')) {
				
				System.out.println("Bumped a wall.");
				currentRow = previousRow;
				currentCol = previousCol;
				
			} else if (isSellIsObstacle(currentRow, currentCol, matrix)) {
				livesLeft--;
				movesMade++;
				
				System.out.printf("Ouch! That hurt! Lives left: %d%n",
						livesLeft);
				
				if (livesLeft <= 0) {
					System.out.println("No lives left! Game Over!");
					break;
				}
				
			} else if (matrix[currentRow][currentCol] == '$') {
				livesLeft++;
				movesMade++;
				matrix[currentRow][currentCol] = '.';
				
				System.out.printf("Awesome! Lives left: %d%n",
						livesLeft);
			} else {
				movesMade++;
				
				System.out.println("Made a move!");
			}
		}
		
		System.out.printf("Total moves made: %d%n", movesMade);
	}

	private static boolean isSellIsObstacle(int row, int col, char[][] matrix) {
		
		switch (matrix[row][col]) {
		case '@':
		case '#':
		case '*':
			return true;
		default:
				return false;
		}
	}

	private static boolean isSellIsInsideMatrix(int row, int col, char[][] matrix) {
		
		boolean isRowInsideMatrix = 0 <= row && row < matrix.length;
		
		if (!isRowInsideMatrix) {
			return false;
		}
		
		boolean isColInRange = 0 <= col && col < matrix[row].length;
		
		return isColInRange;
	}
}