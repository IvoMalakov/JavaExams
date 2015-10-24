package problem02;

import java.util.Scanner;

public class SumCards {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] input = scanner.nextLine().split("\\s+");
			
		int sum = 0;
		int prevCardValue = -1;
		int count = 0;

		for (String card : input) {
			int cardValue = getCardValue(card);
			
			sum += cardValue;
			
			if (cardValue == prevCardValue) {
				count++;
			} else {
				count = 1;
			}
			
			if (count == 2) {
				sum += 2 * cardValue;
			}
			
			if (count > 2) {
				sum += cardValue;
			}
			
			prevCardValue = cardValue;
		}
		
		System.out.println(sum);
	}

	private static int getCardValue(String card) {
		if (card.startsWith("2")) return 2;
		if (card.startsWith("3")) return 3;
		if (card.startsWith("4")) return 4;
		if (card.startsWith("5")) return 5;
		if (card.startsWith("6")) return 6;
		if (card.startsWith("7")) return 7;
		if (card.startsWith("8")) return 8;
		if (card.startsWith("9")) return 9;
		if (card.startsWith("10")) return 10;
		if (card.startsWith("J")) return 12;
		if (card.startsWith("Q")) return 13;
		if (card.startsWith("K")) return 14;
		if (card.startsWith("A")) return 15;
		throw new IllegalArgumentException("Invalid card: " + card);
	}
}