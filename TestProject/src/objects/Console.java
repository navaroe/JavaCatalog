package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	public static String[] unitNamesList = { "pcs.", "pack.", "net weight in kg." };

	public static void main(String[] args) throws IOException {
		Command decoder = new Command();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Console.help();
		while (true) {			
			decoder.read(reader.readLine());
		}
	}
	
	public static void help() {
		System.out.println("Command list:");
		System.out.println("help - calling the help subsystem of commands");
		System.out.println("catalog pages - show the number of catalog pages");
		System.out.println("catalog page {page number} - show catalog page");
		System.out.println("catalog add {category ID} - manual addition a category to the catalog");
		System.out.println("catalog remove {category ID} - manual removal a category to the catalog");
		System.out.println("category pages {category ID} - show the number of selected category pages");
		System.out.println("category show all - show all existing categories");
		System.out.println("category show page {category ID} {page number} - page display of items contained in the category");
		System.out.println("category create {category ID} {position name} - category creation");
		System.out.println("category rename {category ID} {position name} - renaming (may be combined with creating) a category");
		System.out.println("category add {category ID} {position name} - manual addition a position to a category");
		System.out.println("category remove {category ID} {position name} - manual removal a position to a category");
		System.out.println("position create {category ID} {position name} {unit number} {price} {quantity} - creating a position in the specified category with the specified characteristics");
		System.out.println("position show {category ID} all - showing all existing positions in a category");
		System.out.println("position show {category ID} {position name} - showing the characteristics of the selected position in the specified category");
		System.out.println("position price {category ID} {position name} {price} - changing the price of a position in the specified category");
		System.out.println("position increase {category ID} {position name} {quantity} - increasing quantity of the selected item in the specified category");
		System.out.println("position decrease {category ID} {position name} {quantity} - decreasing quantity of the selected item in the specified category");
	}

}


