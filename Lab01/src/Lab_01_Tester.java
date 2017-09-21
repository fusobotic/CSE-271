/*
 * Lab_01_Tester.java
 * 
 * Creates and writes random sorted and unsorted arrays
 * and counts character types in words.txt
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 1-30-17
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Lab_01_Tester {
	
	//prints output to console and files also calls other functions
	public static void main(String[] args) throws Exception {
		// initializes scanners and creates random array
		PrintWriter out = new PrintWriter(new File ("Lab_01_nums.txt"));
		Scanner in = new Scanner(new File("words.txt"));
		int[] randArray = Lab_01_ArrayUtilities.buildIntArray (20, 10, 29);
		
		//prints and writes array at different stages
		resultsPrinter(out, randArray);
		evenSwap(randArray);
		resultsPrinter(out, randArray);
		Arrays.sort(randArray);
		resultsPrinter(out, randArray);
		
		System.out.println("Odd values: " + countOdd(randArray));
		
		//using ArrayList here because words.txt could be any length
		//also using String type because next() does not support characters
		ArrayList<String> words = new ArrayList<String>();
		//useDelimiter allows us to next() each letter instead of words
		in.useDelimiter("");
		while(in.hasNext()){
			words.add(in.next());
		}
		
		in.close();
		out.close();
		
		//getting counts of different character types
		int vowel = countVowels(words), 
			cons = countConsonants(words), 
			other = countOther(words);
		//finally printing results to console
		System.out.printf("There were %d vowels, %d consonants and %d other "
				        + "characters in the text file.", vowel, cons, other);
	}//end main
	
	//counts the vowels in the words file array list
	public static int countVowels(ArrayList<String> words){
		String[] vowels = {"a","e","i","o","u"};
		int count = 0;
		
		for(String letter : words){
			for(String v : vowels){
				if(letter.toLowerCase().equals(v)){
					count++;
				}
			}
		}
		return count;
	}//end countVowels
	
	//counts the consonant in the words file array list
	public static int countConsonants(ArrayList<String> words){
		int count = 0;
		String[] cons = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", 
				         "p", "q", "r", "s", "t", "v", "x", "z", "w", "y"};
		
		for(String letter : words){
			for(String c : cons){
				if(letter.toLowerCase().equals(c)){
					count++;
				}
			}
		}
		return count;
	}//end countConsonants
	
	//counts other characters in the array list not including white space
	public static int countOther(ArrayList<String> words){
		int count = 0;
		for(String letter : words){
			if (!Character.isLetter(letter.charAt(0)) &&
				!Character.isWhitespace(letter.charAt(0))){
				count++;
			}
		}
		return count;
	}// end countOther
	
	//swaps values from even indexes to odd indexes
	public static void evenSwap(int[] nums){
		for(int i = 0; i < nums.length; i++){
			if(i%2 == 0 && i != nums.length - 1){
				Lab_01_ArrayUtilities.swap(nums, i, i+1);
			}
		}
	}//end evenSwap
	
	//checks division by 2 and returns count of odd numbers
	public static int countOdd(int[] nums){
		int count = 0;
		for (int n : nums){
			if(n%2 != 0){
				count++;
			}
		}
		return count;
	}//end countOdd
	
	//cleans up the main method a little bit, takes output and array
	public static void resultsPrinter(PrintWriter out, int[] nums){
		System.out.println(Arrays.toString(nums));
		out.println(Arrays.toString(nums));
	}//end resultsPrinter

}//end class Lab_01_Tester
