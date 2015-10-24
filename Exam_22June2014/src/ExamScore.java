import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExamScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		Map<Integer, Map<String, Double>> scores = new TreeMap<>();
		final int RowsToBeSkipped = 3;
		
		skipFirstLines(scanner, RowsToBeSkipped);
		
		addInformationFromTheConsole(scanner, scores);
		
		for (Integer score : scores.keySet()) {
			printOutput(scores, score);
		}
	}

	private static void skipFirstLines(Scanner scanner, final int RowsToBeSkipped) {
		for (int i = 0; i < RowsToBeSkipped; i++)
		{
			scanner.nextLine();
		}
	}

	private static void addInformationFromTheConsole(Scanner scanner, Map<Integer, Map<String, Double>> scores) {
		while (true) {
			String[] input = scanner.nextLine().split("\\s*\\|\\s*");
			
			if (input.length < 4) {
				break;
			}
			
			String student = input[1];
			int score = Integer.parseInt(input[2]);
			double grade = Double.parseDouble(input[3]);
			
			if (!scores.containsKey(score)) {
				scores.put(score, new TreeMap<>());
			}
			scores.get(score).put(student, grade);			
		}
	}

	private static void printOutput(Map<Integer, Map<String, Double>> scores, Integer score) {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format("%s -> ", score));
		output.append(scores.get(score).keySet());
		
		double sum = 0;
		for (double grade : scores.get(score).values()) { 
			sum += grade;
		}
		
		double average = sum / scores.get(score).values().size();
		
		output.append(String.format("; avg=%.2f", average));
		System.out.println(output);
	}
}