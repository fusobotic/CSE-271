package edu.miamioh.coppolcm.lab11;

import java.util.Arrays;

/**
 * RecursiveFinder.java
 * 
 * Recursively determines the largest integer in an array.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-21-17
 */

public class RecursiveFinder {

	/**
	 * Integer arrays to test
	 */
	private static int[] testAr1 = { 0, 1, 2, 6, 4, 5, 4, 3, 2, 1, 0 };
	private static int[] testAr2 = { 9, 9, 9, 9, 9, 9 };
	private static int[] testAr3 = { 10, 8, 7, 9, 5, 4 };

	/**
	 * Main method tests the functionality of largestElement.
	 * 
	 * @param args Arguments not used in this main.
	 */
	public static void main(String[] args) {
		System.out.print(Arrays.toString(testAr1) + " Largest: ");
		System.out.println(largestElement(testAr1));
		System.out.print(Arrays.toString(testAr2) + " Largest: ");
		System.out.println(largestElement(testAr2));
		System.out.print(Arrays.toString(testAr3) + " Largest: ");
		System.out.println(largestElement(testAr3));
	}// end main

	/**
	 * Breaks down array by comparing value of first and last numbers. Shortens
	 * array until left with highest number.
	 * 
	 * @param arr Array to scan.
	 * @return The largest number in an array.
	 */
	public static int largestElement(int[] arr) {
		// new array to be trimmed
		int[] res;
		// if array is empty don't process it
		if (arr.length == 0) {
			return 0;
		}

		// if only left with one number return it
		if (arr.length < 2) {
			return arr[0];
		}

		// if first number is greater trim array on right
		if (arr[0] > arr[arr.length - 1]) {
			res = Arrays.copyOf(arr, arr.length - 1);
			return largestElement(res);
		}
		// if last number is greater trim array on left
		else {
			res = new int[arr.length - 1];
			// loop shifting elements left in one smaller array
			for (int i = 1; i < arr.length; i++)
				res[i - 1] = arr[i];
			return largestElement(res);
		}
	}// end largestElement

}// end RecursiveFinder
