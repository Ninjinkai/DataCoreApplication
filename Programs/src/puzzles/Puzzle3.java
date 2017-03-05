// Given a non-empty string of alphanumeric characters, print its longest run.

package puzzles;

import java.util.Scanner;

public class Puzzle3 {

//	Accept keyboard input.
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		Get the input string from the user.
		System.out.print("Enter a string of alphanumeric characters: ");
		String inputString = scan.nextLine();
		
//		Get the string's length.
		int stringLength = inputString.length();
		
//		Initialize variables to hold the current run's starting index and running character.
		int runStart = 0;
		char currentRunChar = ' ';
		
//		Initialize variables to hold the longest run and its length.
		String maxRunString = "";
		int maxRunLength = 0;
		
//		Iterate across the string.
		for (int i = 0; i < stringLength; i++) {
			
//			The current run has ended, indicated by the current run character not matching
//			the character at index i.
			if (inputString.charAt(i) != currentRunChar) {
				
//				The current run is longer than or as long as the longest run, its length
//				being i - runStart. Save this substring as the longest run and save its
//				length.
				if((i - runStart) >= maxRunLength) {
					maxRunString = inputString.substring(runStart, i);
					maxRunLength = i - runStart;
				}
				
//				Reset the run starting index and running character.
				runStart = i;
				currentRunChar = inputString.charAt(i);
				
			}
		}
		
//		If the longest run is at the end of the string, the for loop will end before the
//		run is counted.  This catches that special case.
		if((stringLength - runStart) >= maxRunLength) {
			maxRunString = inputString.substring(runStart, stringLength);
			maxRunLength = stringLength - runStart;
		}
		
//		Print the longest run to stdout.
		System.out.println("Longest run: " + maxRunString);
	}
}
