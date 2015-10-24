package problem04;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> durations = new TreeMap<>();
		Map<String, Set<String>> ipAdresses = new TreeMap<>();
		
		int numberOfLogs = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < numberOfLogs; i++) {
			String[] input = scanner.nextLine().split("\\s+");
			String ip = input[0];
			String name = input[1];
			int duration = Integer.parseInt(input[2]);
			
			addDuration(durations, name, duration);
			addIp(ipAdresses, name, ip);
		}
		
		for (String user : ipAdresses.keySet()) {
			printTheOutput(durations, ipAdresses, user);
		}
	}

	private static void printTheOutput(Map<String, Integer> durations, Map<String, Set<String>> ipAdresses,
			String user) {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format(
				"%s: %d ", user, durations.get(user)));
		output.append(ipAdresses.get(user));
		System.out.println(output);
	}

	private static void addIp(Map<String, Set<String>> ipAdresses, String name, String ip) {
		
		if (!ipAdresses.containsKey(name)) {
			ipAdresses.put(name, new TreeSet<String>());
		}
		
		ipAdresses.get(name).add(ip);
	}

	private static void addDuration(Map<String, Integer> durations, String name, int duration) {
		
		if (!durations.containsKey(name)) {
			durations.put(name, 0);
		}
		durations.put(name, durations.get(name) + duration);
	}
}