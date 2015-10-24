package problem01;

import java.util.Scanner;

public class GandalfsStash {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int happinest = Integer.parseInt(scanner.nextLine());
		String input = scanner.nextLine().toLowerCase();
		String[] food = input.split("[\\s\\W_]+");
				
		for (String meal : food) {
			happinest = eatAMeal(happinest, meal);
		}
		
		String mood = checkGandalfsMood(happinest);
		
		System.out.println(happinest);
		System.out.println(mood);
	}

	private static String checkGandalfsMood(int happinest) {
		String mood;
		if (happinest < -5) {
			mood = "Angry";
		} else if ((happinest >= -5) && (happinest < 0)) {
			mood = "Sad";
		} else if ((happinest >= 0) && (happinest < 15)) {
			mood = "Happy";
		} else {
			mood = "Special JavaScript mood";
		}
		return mood;
	}

	private static int eatAMeal(int happinest, String meal) {
		if (meal.equals("cram")) {
			happinest += 2;
		} else if (meal.equals("lembas")) {
			happinest += 3;
		} else if (meal.equals("apple")) {
			happinest += 1;
		} else if (meal.equals("melon")) {
			happinest += 1;
		} else if (meal.equals("honeycake")) {
			happinest += 5;
		} else if (meal.equals("mushrooms")) {
			happinest -= 10;
		} else {
			happinest -= 1;
		}
		return happinest;
	}
}