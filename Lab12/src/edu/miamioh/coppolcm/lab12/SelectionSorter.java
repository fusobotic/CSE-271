package edu.miamioh.coppolcm.lab12;

/**
 * SelectionSorter.java
 * 
 * Selection sort algorithm that sorts from 
 * largest integer to smallest integer.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-28-17
 */

public class SelectionSorter {
	/**
	 * Sorts the given integer array in largest to smallest
	 * @param a The integer array to sort
	 */
	public static void sort (int[] a){
		for(int i = 0; i < a.length - 1; i++){
			int maxPos = maxPosition(a, i);
			ArrayUtil.swap(a, maxPos, i);
		}
	}//end sort
	
	/**
	 * Finds the position of the largest integer in an array.
	 * @param a The integer array to scan.
	 * @param from The index to start from.
	 * @return Returns the index of the maximum integer.
	 */
	private static int maxPosition(int[] a, int from){
		int maxPos = from;
		for(int i = from + 1; i < a.length; i++){
			if (a[i] > a[maxPos]) { maxPos = i; }
		}
		return maxPos;
	}//end maxPosition
}//end SelectionSorter
