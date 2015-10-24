import java.util.Scanner;

public class Durts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int centerX = scanner.nextInt();
		int centerY = scanner.nextInt();
		int sizeR = scanner.nextInt();
		int numberOfPoints = scanner.nextInt();
		
		for (int i = 0; i < numberOfPoints; i++) {
			int cordinateX = scanner.nextInt();
			int cordinateY = scanner.nextInt();
			boolean isPointInsideFigure = checkIfPointIsInsideFigure(centerX, centerY, sizeR, cordinateX, cordinateY);
			
			if (isPointInsideFigure) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static boolean checkIfPointIsInsideFigure(int centerX, int centerY, int sizeR, int cordinateX, int cordinateY) {
		boolean isPointInsideFigure = false;
		
		if (((cordinateX >= centerX - sizeR)
				&& (cordinateX <= centerX + sizeR))
				&& (cordinateY >= centerY - sizeR)
				&& (cordinateY <= centerY + sizeR)) {
			double internalPartOfFigureUp = centerY + (0.5 * sizeR);
			double internalPartOfFigureDown = centerY - (0.5 * sizeR);
			
			if ((cordinateY >= internalPartOfFigureDown) 
					&& (cordinateY <= internalPartOfFigureUp)) {
				isPointInsideFigure = true;
			} else {
				double externalPartOfFigureLeft = centerX - (0.5 * sizeR);
				double externalPartOfFigureRight = centerX + (0.5 * sizeR);
				
				if ((cordinateX >= externalPartOfFigureLeft)
						&& (cordinateX <= externalPartOfFigureRight)) {
					isPointInsideFigure = true;
				}
			}
			
		}
		
		return isPointInsideFigure;
	}
}