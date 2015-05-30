// Author: Yulong Tan
// Date: 5.23.15
// This program gets random facts ad returns them.

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FactApp {
	private String[] facts;

	// Initializes the fields
	public FactApp() {
		this.facts = null;
	}

	// This method takes in a Scanner as a parameter and
	// returns an array that stores each fact in an element
	public String[] toArray(Scanner facts) {
		List<String> factList = new ArrayList<String>();
		while (facts.hasNextLine()) {
			String line = facts.nextLine().trim();
			factList.add(line);
		}
		this.facts = new String[factList.size()];
		for (int i = 0; i < factList.size(); i++) {
			this.facts[i] = factList.get(i);
		}
		return this.facts;
	}

	// Returns a random fact
	public String getFact() {
		Random r = new Random();
		return this.facts[r.nextInt(this.facts.length)];
	}

	// This method takes in a String fact as a parameter
	// and reverses it so it is backwards. 
	public String reverseFact(String fact) {
		return new StringBuffer(fact).reverse().toString();
	}

	// This method takes an int number and a String response
	// to print out the facts in regular order or reverse,
	// depending on user response. 
	public void printFact(int number, String response) {
		int characters = 0;
		int words = 0;
		if (number > 0) {
			for (int i = 1; i <= number; i ++) {
				String fact = this.getFact();
				if (response.startsWith("y") || response.contains("sure")) {
					System.out.println("Reversed Fact #" + i + ": " 
							+ this.reverseFact(fact));
				} else { // user types no, so print regular facts
					System.out.println("Fact #" + i + ": " + fact);
				}
				characters += this.characterCount(fact);
				words += this.wordCount(fact);
			}
		} else {
			System.out.println("No facts were printed out.");
		}
		System.out.println();
		System.out.println("Total characters: " + characters);
		System.out.println("Total words: " + words);
	}

	// This method takes a String fact as a parameter and returns 
	// the number of characters the fact has.
	public int characterCount(String fact) {
		return fact.length();
	}
	
	// This method takes a String fact as a parameter and returns
	// the number of words the fact has. 
	public int wordCount(String fact) {
		// Splits the words by the spaces
		String[] words = fact.trim().split("\\s+");
		return words.length;
	}
	
	public int getFactCount() {
		return this.facts.length;
	}
}
