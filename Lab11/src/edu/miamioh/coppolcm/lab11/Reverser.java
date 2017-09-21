package edu.miamioh.coppolcm.lab11;

/**
 * Reverser.java
 * 
 * Class containing a method for reversing the order of characters in a string.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-21-17
 */

public class Reverser {
	
	/**
	 * Strings to test
	 */
	private static String test1 = "Test!",
						  test2 = "    WoW    ",
						  test3 = "123456789";
	
	/**
	 * Main method prints results of tests.
	 * @param args Not used in this case.
	 */
	public static void main (String[] args){
		System.out.println(reverse(test1));
		System.out.println(reverse(test2));
		System.out.println(reverse(test3));
	}//end main
	
	/**
	 * Shortens string and adds last character to end
	 * Loops recursively.
	 * @param text String to reverse.
	 * @return Reversed String.
	 */
	public static String reverse(String text){
		//if text is small enough return it
		if(text.length() < 2) return text;
		//else call reverse method with shortened string
		return reverse(text.substring(1, text.length())) + text.charAt(0);
	}//end reverse
	
}//end Reverser

