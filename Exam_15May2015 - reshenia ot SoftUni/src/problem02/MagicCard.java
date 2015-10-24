package problem02;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] cards = scan.nextLine().split("\\s+");
        String oddOrEven = scan.nextLine();
        String magicCard = scan.nextLine();

        String magicCardValue = magicCard.replaceAll("[SHDC]", "");
        String magicCardSuit = magicCard.replaceAll("[0-9JQKA]+", "");

        Map<Character, Integer> specialValues = new HashMap<>();
        specialValues.put('J', 120);
        specialValues.put('Q', 130);
        specialValues.put('K', 140);
        specialValues.put('A', 150);

        int magicSum = 0;

        int i;

        if (oddOrEven.equals("odd")) {
        	i = 1;
        } else {
        	i = 0;
        }

            for (; i < cards.length; i += 2) {

            	String card = cards[i];
                int cardValue;

                if (isSpecial(card)) {
                    cardValue = specialValues.get(card.charAt(0));
                } else {
                    cardValue = Integer.parseInt(card.replaceAll("[SHDC]", ""))
                            * 10;
                }

                if (card.contains(magicCardValue)) {
                    cardValue *= 3;
                } else if (card.contains(magicCardSuit)) {
                    cardValue *= 2;
                }

                magicSum += cardValue;
            }

        System.out.println(magicSum);
    }

    private static boolean isSpecial(String s) {
        return !(s.charAt(0) >= '1' && s.charAt(0) <= '9');
    }
}
