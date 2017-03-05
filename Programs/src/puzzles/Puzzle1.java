// Given a string of 1s and 0s, print the offset of each run longer than 1.

package puzzles;

import java.util.Scanner;

public class Puzzle1 {
	
//	Accept keyboard input.
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
//		Get input string of 1s and 0s.  No type checking or input verification is done.
		System.out.print("Please enter a string of 1s and 0s: ");
		String inputString = scan.nextLine();

//		debugString is used to trace program operation.
		@SuppressWarnings("unused")
		String debugString = " ";
		
//		result is the output string, runLength is the length of the current run,
//		runStart is the current run's starting index, and currentRunChar is the
//		character that repeats in the current run.
		String result = "";
		int runLength = 1;
		int runStart = 0;
		char currentRunChar = ' ';
		
//		Iterate through the string.
		for (int i = 0; i < inputString.length(); i++) {
			
//			Track key variables if necessary.
			debugString = 
					"i: " + i + 
					", runStart: " + runStart +
					", currentValue: " + currentRunChar +
					", runLength: " + runLength +
					", result: " + result;
//			System.out.println(debugString);
			
//			There is a run taking place, increment its length counter.
			if (inputString.charAt(i) == currentRunChar) {
				runLength++;
			}
			
//			The current run has ended, indicated by the current run
//			character not matching the character at index i.
			else {
				
//				The current run is longer than 1, save its offset.
				if (runLength > 1) {
					result += String.valueOf(runStart) + ", ";
				}
				
//				Start a new run at index i with the new character.
				runLength = 1;
				runStart = i;
				currentRunChar = inputString.charAt(i);
			}
		}
		
//		Add the last run offset to the output, correct output formatting.
		if (runLength > 1) {
			result += String.valueOf(runStart);
		}
		else {
			result = result.substring(0, result.length() - 2);
		}
		
//		Print the result to the console.
		System.out.println(result);

	}

}