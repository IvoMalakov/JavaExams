import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StraightFlush {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Set<String> existingCards = new HashSet<>();
		
		String input = scanner.nextLine();
		String[] cards = input.split("\\W+");
		
		existingCards.addAll(Arrays.asList(cards));
		int count = 0;
		
		for (String startCard : existingCards) {
			String cardFace = startCard.substring(0, startCard.length() - 1);
			String cardSuit = startCard.substring(startCard.length() - 1);
			List<String> strightFlush = new ArrayList<>();
			
			for (int i = 0; i < 5; i++) {
				strightFlush.add(cardFace + cardSuit);
				cardFace = getNextCard(cardFace);
			}
			
			if (existingCards.containsAll(strightFlush)) {
				System.out.println(strightFlush);
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("No Straight Flushes");
		}
	}

	private static String getNextCard(String cardFace) {
		String[] cardFaces = {
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"J",
				"Q",
				"K",
				"A"
		};
		
		int cardFacesSize = cardFaces.length;
		
		for (int i = 1; i < cardFacesSize; i++) {
			if (cardFaces[i - 1].equals(cardFace)) {
				return cardFaces[i];
			}
		}
		
		return null;
	}
}