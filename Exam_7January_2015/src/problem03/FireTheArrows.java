package problem03;

import java.util.Scanner;

public class FireTheArrows {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		
		char[][] matrix = new char[numberOfRows][];
		
		for (int i = 0; i < numberOfRows; i++) {
			matrix[i] = scanner.nextLine().toCharArray();
		}
		
		moveTheArrows(matrix);
		
		printTheOutput(matrix);
	}

	private static void moveTheArrows(char[][] matrix) {
		boolean hasMoved;
		do {
			hasMoved = false;
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					
					switch(matrix[i][j]) {
					
					case 'v':
						if ((i + 1 <= matrix.length - 1) &&
								matrix[i + 1][j] == 'o') {
							
							hasMoved = true;
							matrix[i][j] = 'o';
							matrix[i + 1][j] = 'v';
						}
						break;
						
					case '^':
						if ((i - 1 >= 0) && 
								matrix[i - 1][j] == 'o') {
							
							hasMoved = true;
							matrix[i][j] = 'o';
							matrix[i - 1][j] = '^';
						}
						break;
						
					case '<':
						if ((j - 1 >= 0) &&
								matrix[i][j - 1] == 'o') {
							
							hasMoved = true;
							matrix[i][j] = 'o';
							matrix[i][j - 1] = '<';
						}
						break;
						
					case '>':
						if ((j + 1 <= matrix[i].length - 1) &&
								matrix[i][j + 1] == 'o') {
							
							hasMoved = true;
							matrix[i][j] = 'o';
							matrix[i][j + 1] = '>';
						}
						break;
						
					case 'o':
						//Nothing should happen here
						break;
						
						default:
							throw new IllegalArgumentException(
									"This should never happend");
					}
				}
			}
		} while (hasMoved);
	}
	
	private static void printTheOutput(char[][] matrix) {
		for (char[] row : matrix) {
			for (char symbol : row) {
				System.out.print(symbol);
			}
			
			System.out.println();
		}
	}
}