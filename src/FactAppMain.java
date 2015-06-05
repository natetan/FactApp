// Author: Yulong Tan
// Date: 5.23.15
// FactAppMain contains a program that generates n number of
// random facts based on user input. It then prints the facts
// out based on the input file. Afterwards, the program will
// ask if the user wants to play again. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FactAppMain {
	
	// If true, no matter what the user enters, the file used will
	// always be facts.txt. Must be set to false if they want to switch
	// files in the file method. 
	public static final boolean FORCE = false;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		giveIntro();
		FactApp facts = new FactApp();
		addToFile(facts, console);
		printFact(facts, console);
	}
	
	// Adds the data from the file to use
	public static void addToFile(FactApp facts, Scanner console) throws FileNotFoundException {
		Scanner input = new Scanner(new File(getFile(console)));
		// stores the facts line by line into an array
		facts.toArray(input);
	}
	
	// Gives an introduction to the program
	public static void giveIntro() {
		System.out.println("This program will try to simulate the FunFacts app I wrote");
		System.out.println("on Android Studio and just like the one there, this can have");
		System.out.println("multiple facts repeating itself, since there's a Random object");
		System.out.println("being used.");
		System.out.println();
	}
	
	// This method takes in a Scanner as a parameter that asks the user
	// for the file to use and returns that file. If force is set to true,
	// this will always return the facts.txt file.
	public static String getFile(Scanner console) {
		System.out.print("What file do you want to use? ");
		String file = console.next();
		if (FORCE) {
			file = "facts.txt";
		}
		return file;
	}
	
	// This method takes in the FactApp object and a Scanner as parameters
	// and prints out a number of random facts determined by the user. It also
	// prompts the user if they want the facts to be reversed.
	public static void printFact(FactApp facts, Scanner console) throws FileNotFoundException {
		System.out.println("This file has " + facts.getFactCount() + " facts.");
		System.out.print("How many random facts do you want to generate? ");
		int number = console.nextInt();
		System.out.print("Do you want the facts completely reversed? (y/n) ");
		String response = console.next().trim().toLowerCase();
		facts.printFact(number, response);
		moreFacts(facts, console);
	}
	
	// This method takes in a FactApp object and a Scanner as parameters 
	// and prompts the user to see if they want to play the game again.
	// It will keep prompting the user until they enter something that
	// starts with a y or an n. Case is ignored. 
	public static void moreFacts(FactApp facts, Scanner console) throws FileNotFoundException {
		System.out.println();
		System.out.print("Do you want some more facts? (y/n) ");
		String response = console.next().trim().toLowerCase();
		if (response.startsWith("y") || response.contains("sure")) {
			switchFile(facts, console);
			printFact(facts, console);
		} else if (response.startsWith("n")) {
			System.out.println();
			System.out.println("Thanks for trying out this program!");
			System.out.println("It was nice showing you random facts!");
			System.out.println("Have a nice day!");
		} else { // user types neither yes or no, so ask again
			System.out.println("That's not a valid response!");
			System.out.println("Please give me a response that makes sense!");
			moreFacts(facts, console);
		}
	}
	
	// This method takes in a Scanner to see if the user wants to
	// switch files to use for the list of facts. 
	public static void switchFile(FactApp facts, Scanner console) throws FileNotFoundException {
		System.out.print("Do you want to switch files? (y/n) ");
		String response = console.next().trim().toLowerCase();
		if (response.startsWith("y") || response.contains("sure")) {
			addToFile(facts, console);
		}
	}
}
