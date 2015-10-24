package problem04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SchoolSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String, Map<String, List<Double>>> students = new TreeMap<>();
		
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numberOfRows; i++) {
			addInformationFromTheConsole(scanner, students);
		}
		
		for (String name : students.keySet()) {
			printTheOutput(name, students);
		}
	}
	
	private static void addInformationFromTheConsole(Scanner scanner, Map<String, Map<String, List<Double>>> students) {
		String[] input = scanner.nextLine().split("\\s+");
		
		String name = input[0] + " " + input[1];
		String subject = input[2];
		double grade = Integer.parseInt(input[3]);
		
		if(!students.containsKey(name)) {
			students.put(name, new TreeMap<>());
		}
		
		if (!students.get(name).containsKey(subject)) {
			students.get(name).put(subject, new ArrayList<>());
		}
		
		students.get(name).get(subject).add(grade);
	}
	
	private static void printTheOutput(String name, Map<String, Map<String, List<Double>>> students) {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format("%s: [", name));
		
		for (String subject : students.get(name).keySet()) {
			output.append(String.format("%s - ", subject));
			
			double sum = 0;
			
			for (double grade: students.get(name).get(subject)) {
				sum += grade;
			}
			
			double average = sum / students.get(name).get(subject).size();
			
			output.append(String.format("%.2f", average));
			
			if (subject.equals(getlastKey(name, students))) {
				output.append("]");
			} else {
				output.append(", ");
			}
		}
		
		System.out.println(output);
	}

	private static String getlastKey(String name, Map<String, Map<String, List<Double>>> students) {
		String lastKey = "";
		
		for (String key : students.get(name).keySet()) {
			lastKey = key;
		}
		
		return lastKey;
	}
}