package problem01;

import java.util.Scanner;

public class Enigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int m;
        for (int i = 0; i < n; i++) {
            String lines = scan.nextLine();
            m = lines
                    .replaceAll("[\\s\\d]+", "")
                    .length() / 2;

            for (int j = 0; j < lines.length(); j++) {
                char currChar = lines.charAt(j);

                if((currChar >= '0' && currChar <= '9')
                        || currChar == ' ') {
                    System.out.print(currChar);
                    continue;
                }

                char c = (char)(currChar + m);
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
