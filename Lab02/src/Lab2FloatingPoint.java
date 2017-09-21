/*
 * Lab2FloatingPoint.java
 * 
 * Validates input is a number and if not gives the user another try
 * Also adds the numbers inputed and prints the total
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-03-17
 */

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2FloatingPoint {

	public static void main(String[] args) {
		//only variables needed
		int errors = 0;
		float total = 0f; //using floats since that's the name of the class
		
		//Optional use instructions
		System.out.println("Enter a set of floating point numbers to add");
		System.out.println("Enter a letter twice in a row to get total");
		
		//main loop that tries and catches any improper input
		//exits loop if there are two errors in a row
		while(errors < 2){
			try{
				//ignore warning, closing this scanner causes runtime error
				Scanner sysIn = new Scanner(System.in);
				total += sysIn.nextFloat();
				//errors only resets if exception isn't triggered
				errors = 0;
			}
			catch (InputMismatchException except){
				//if next is not a float at all or out of range
				errors += printError();
			}
			catch (NoSuchElementException except){
				//if input is exhausted
				errors += printError();
			}
		}

		//printing sum of floats given
		System.out.println("The total of your set is: " + total);
	}//end main
	
	public static int printError(){
		//exists so I don't have to write the same thing over for exceptions
		System.out.println("Error: Please enter proper floating point number.");
		return 1;
	}//end printError

}//end Lab2FloatingPoint
