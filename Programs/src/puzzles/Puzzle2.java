// Print all sequences of 32 digits to stdout, such that each digit is a 1 or 0,
// each sequence is exactly 32 digits long, and no sequence has 2 adjacent 1s.
// This is done by sequentially iterating through all binary numbers up to 2^32
// and printing numbers with no adjacent 1s.

// This is modified from the base description to allow the user to specify how
// large a solution space should be examined, as going through all possible
// combinations and printing a subset takes a very long time, O(n^2).

package puzzles;

import java.util.Scanner;

public class Puzzle2 {
	
//	Accept keyboard input.
	static Scanner scan = new Scanner(System.in);
	
//	Method to do the output string creation, checking, and printing.
	public static void printBinaryStrings(double n) {
		
//		binaryString is a string of 1s and 0s, it holds the iterator's value in binary.
		String binaryString;
		
//		Flag to check that the current string has no adjacent 1s.
		boolean noAdjacent1s = true;
		
//		Iterate through all integers up to 2^n (which would be 32 in the puzzle).
		for (int i = 0; i < n; i++) {
			
//			Convert i to a binary string of length 32.
			binaryString = String.format("%32s", Integer.toBinaryString(i)).replace(" ", "0");
			
//			Iterate across the binary string and check for adjacent 1s.
			for (int j = 0; j < binaryString.length() - 1; j++) {
				
//				A pair of adjacent 1s is found, this string will not be printed.
				if ((binaryString.charAt(j) == '1') && (binaryString.charAt(j+1) == '1')) {
					noAdjacent1s = false;
				}
			}
			
//			Print the binary string if it has no adjacent 1s, or reset the flag.
			if (noAdjacent1s) {
				System.out.println(binaryString);
			}
			else {
				noAdjacent1s = true;
			}
		}
	}

	public static void main(String[] args) {
		
//		Explain to the user how the program works.  Get the size of the solution space to examine, l, which is the length of the unpadded binary string.
		System.out.println("This will print all binary strings of the input length, padded with 0s to reach 32 characters in length, and excluding strings with adjacent 1s.");
		System.out.println("Printing strings of lengths > 25 will take a long time and may cause memory problems.  This puzzle is asking for 32 as input here.");
		System.out.print("Please enter a string length: ");
		int l = scan.nextInt();
		
//		n = 2^l, this will test all binary strings up to length l and print only strings without adjacent 1s.
		double n = Math.pow(2, l);
		printBinaryStrings(n);
		
	}
}
