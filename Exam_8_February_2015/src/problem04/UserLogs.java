package problem04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Integer>> users = new TreeMap<>();
		
		addUserInformation(scanner, users);	
		
		printTheOutput(users);
	}

	private static void printTheOutput(Map<String, Map<String, Integer>> users) {
		StringBuilder output = new StringBuilder();
		
		for (String user : users.keySet()) {
			output.append(String.format("%s: \n", user));
			
			for (String ip : users.get(user).keySet()) {
				output.append(String.format("%s => %d", 
						ip, users.get(user).get(ip)));
				
				if(ip.equals(getlastkey(users, user))) {
					output.append(".\n");
				} else {
					output.append(", ");
				}
			}
		}
		
		System.out.println(output);
	}

	private static String getlastkey(Map<String, Map<String, Integer>> users, String user) {
		String out = "";
		
		for (String ip : users.get(user).keySet()) {
			out = ip;
		}
		
		return out;
	}

	private static void addUserInformation(Scanner scanner, Map<String, Map<String, Integer>> users) {
		while (true) {
			String command = scanner.nextLine();
			
			if (command.equals("end")) {
				break;
			}
			
			String[] input = command.split("\\s+");
			String ip = input[0].replaceAll("IP=", "");
			String user = input[2].replaceAll("user=", "");
			
			if (!users.containsKey(user)) {
				users.put(user, new LinkedHashMap<>());
				users.get(user).put(ip, 1);
			} else {
				Integer count = 0;
				
				if (users.get(user).containsKey(ip)) {
					count = users.get(user).get(ip);
				}
				
				users.get(user).put(ip, count + 1);
			}
		}
	}
}