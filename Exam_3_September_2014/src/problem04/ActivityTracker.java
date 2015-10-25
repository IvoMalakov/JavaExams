package problem04;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivityTracker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<Integer, Map<String, Double>> mounths = new TreeMap<>();
		
		int n = Integer.parseInt(scanner.nextLine());
		
		addInformationFromTheConsole(scanner, mounths, n);
		
		printTheOutput(mounths);
	}

	private static void addInformationFromTheConsole(Scanner scanner, Map<Integer, Map<String, Double>> mounths,
			int n) {
		for (int i = 0; i < n; i++) {
			
			String[] input = scanner
					.nextLine()
					.trim()
					.split("[\\s\\/]+");
			
			int mounth = Integer.parseInt(input[1]);
			String user = input[3];
			double distance = Double.parseDouble(input[4]);
			
			if (!mounths.containsKey(mounth)) {
				mounths.put(mounth, new TreeMap<>());
			}
			
			if (mounths.get(mounth).containsKey(user)) {
				mounths
				.get(mounth)
				.put(user, mounths.get(mounth).get(user) + distance);
			} else {
				mounths.get(mounth).put(user, distance);
			}
		}
	}
	
	private static void printTheOutput(Map<Integer, Map<String, Double>> mounths) {
		StringBuilder output = new StringBuilder();
		
		for (int mounth : mounths.keySet()) {
			output.append(String.format("%d: ", mounth));
			
			for (String user : mounths.get(mounth).keySet()) {
				output.append(String.format("%s(%.0f)", 
						user,
						mounths.get(mounth).get(user)));
				
				String lastUser = getLastUser(mounth, mounths);
				
				if (user.equals(lastUser)) {
					output.append("\n");
				} else {
					output.append(", ");
				}
			}
		}
		
		System.out.println(output);
	}

	private static String getLastUser(int mounth, Map<Integer, Map<String, Double>> mounths) {
		String lastUser = "";
		
		for (String user : mounths.get(mounth).keySet()) {
			lastUser = user;
		}
		
		return lastUser;
	}
}