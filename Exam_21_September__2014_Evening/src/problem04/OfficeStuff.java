package problem04;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OfficeStuff {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Integer>> companies = new TreeMap<>();
		
		int numberOfRows = Integer.parseInt(scanner.nextLine());
		
		addInformationFromTheConsole(scanner, companies, numberOfRows);
		
		printTheOutput(companies);
	}

	private static void addInformationFromTheConsole(Scanner scanner, Map<String, Map<String, Integer>> companies,
			int numberOfRows) {
		for (int i = 0; i < numberOfRows; i++) {
			String input[] = scanner
					.nextLine()
					.trim()
					.split("[\\s-|]+");
			
			String company = input[1];
			int amount = Integer.parseInt(input[2]);
			String product = input[3];
			
			if (!companies.containsKey(company)) {
				companies.put(company, new LinkedHashMap<>());
			}
			
			if (companies.get(company).containsKey(product)) {
				companies
				.get(company)
				.put(product,companies
						.get(company)
						.get(product) + amount);
			} else {
				companies.get(company).put(product, amount);
			}
		}
	}
	
	private static void printTheOutput(Map<String, Map<String, Integer>> companies) {
		StringBuilder output = new StringBuilder();
		
		for (String company : companies.keySet()) {
			output.append(String.format("%s: ",company));
			
			for (String product : companies.get(company).keySet()) {
				output.append(String.format("%s-%d", 
						product, 
						companies.get(company).get(product)));
				
				String lastProduct = getLastProduct(company, companies);
				
				if (product.equals(lastProduct)) {
					output.append("\n");
				} else {
					output.append(", ");
				}
			}
		}
		
		System.out.println(output);
	}

	private static String getLastProduct(String company, Map<String, Map<String, Integer>> companies) {
		String lastProduct = "";
		
		for (String product : companies.get(company).keySet()) {
			lastProduct = product;
		}
		
		return lastProduct;
	}
}