package edu.miamioh.coppolcm.lab08;
import java.util.ArrayList;

/**
 * @author Christian Coppoletti
 * 
 * University.java
 * 
 * Stores a list of people that belong to the university.
 * Can also print out that list.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class University {
	/**
	 * ArrayList of people in the University.
	 */
	private ArrayList<Person> people;
	
	/**
	 * Constructor that fills the university with a given ArrayList.
	 * @param people an ArrayList of people to fill university.
	 */
	public University(ArrayList<Person> people){
		this.people = people;
	}//end University constructor

	/**
	 * Return an ArrayList of all the people in the university.
	 * Can be manipulated without a setter.
	 * @return all people in the university.
	 */
	public ArrayList<Person> getPeople() {
		return people;
	}//end getPeople

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Returns people inside University.
	 * @return String with a person on each line.
	 */
	@Override
	public String toString() {
		String res = "People in University:\n";
		for(Person p : people){
			res += p.toString() + "\n";
		}
		return res;
	}//end toString()
	
}//end University
