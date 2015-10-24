package problem04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Weightlifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, Long>> players = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            String exercise = input[1];
            long weight = Long.parseLong(input[2]);

            if(!players.containsKey(name)) {
                players.put(name, new TreeMap<>());
            }

            if(players.get(name).containsKey(exercise)) {
                players.get(name)
                        .put(exercise,
                                players.get(name).get(exercise)
                                        + weight);
            } else {
                players.get(name).put(exercise, weight);
            }
        }

        for (String player : players.keySet()) {
            System.out.print(player + " : ");

            List<String> exercises = new ArrayList<>();

            for (String exercise : players.get(player).keySet()) {
                exercises.add(String.format("%s - %d kg",
                                                exercise,
                                                players.get(player).get(exercise)));
            }

            System.out.println(exercises.toString().substring(1, exercises.toString().length() - 1));
        }
    }
}
