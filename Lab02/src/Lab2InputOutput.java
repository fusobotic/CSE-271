/*
 * Lab2InputOutput.java
 * 
 * Reads in a file and outputs a version with line numbers
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-03-17
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab2InputOutput {

	public static void main(String[] args) throws Exception {
		// Not using throw/catching here because this is a IO exercise
		String filename = args[0]; //storing args to string
		Scanner in = new Scanner(new File(filename));
		Scanner keyIn = new Scanner(System.in);
		
		//prompting user for input
		System.out.println("What would you like to name the file?");
		PrintWriter out = new PrintWriter(keyIn.next());
		
		//reading text file into array list by lines
		ArrayList<String> inText = new ArrayList<String>();
		while(in.hasNextLine()){
			inText.add(in.nextLine());
		}
		
		//rewriting arraylist to include line numbers
		for(int i = 0; i < inText.size(); i++){
			//adds "/* # */" formatted line numbers at beginning
			inText.set(i, '/'+"* "+(i+1)+" *"+'/'+" "+inText.get(i)+"\n");
			out.print(inText.get(i));
		}
		
		//closing scanners and writers
		keyIn.close();
		in.close();
		out.close();
	} //end main

}//end Lab2InputOutput
