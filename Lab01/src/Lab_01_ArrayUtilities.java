/*
 * Lab_01_ArrayUtilities.java
 * 
 * Utilities for Lab_01_Tester.java
 * has methods for creating random arrays and swapping values
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 1-30-17
 */

public class Lab_01_ArrayUtilities {
	
	public static void main (String[] args){
		int nums[] = buildIntArray(20, 0, 5);
		
		for(int n : nums){
			System.out.print(n + " ");
		}
	}
	
	//creates an array with random numbers given a length and range to use
	public static int[] buildIntArray (int length, int fromNum, int toNum){
		int[] nums = new int[length];
		
		//assigns random integer to each index
		for(int i = 0; i < length; i++){
			nums[i] = (fromNum + (int)(Math.random() * toNum));
			//sauce: 
			//http://stackoverflow.com/questions/363681/generating-random-integers-in-a-specific-range
		}

		return nums;
	}//end buildIntArray
	
	//swaps given two indexes of an array
	public static void swap(int[] nums, int i, int j){
		//precaution against index out of bounds exception
		if(i >= nums.length || j >= nums.length){
			System.out.println("Swap Error: Please use proper indexes.");
			return;
		}
		
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}//end swap

}//end class Lab_01_ArrayUtilities
