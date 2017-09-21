package edu.miamioh.coppolcm.lab12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Person.java
 * 
 * Stores a person's name, has toString and is Comparable.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-28-17
 */

@SuppressWarnings("rawtypes")
public class Person implements Comparable {
	
	/**
	 * Name of the Person
	 */
	private String name;
	
	/**
	 * Constructor for person.
	 * @param name String of person's name.
	 */
	public Person(String name){
		this.name = name;
	}//end Person constructor
	
	/**
	 * Main method takes user input of 10 names
	 * adds them to an ArrayList, then sorts the ArrayList.
	 * Also prints the first and last names of the sorted ArrayList.
	 * @param args Command Line args not used here.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		//ArrayList to be added to and sorted
		ArrayList<Person> people = new ArrayList<Person>();
		
		//scanner for input
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		//asks user for input and then cycles through adding with next()
		System.out.println("Please input 10 names: ");
		for(int i = 0; i < 10; i++){
			people.add(new Person(in.next()));
		}
		
		Collections.sort(people);
		
		//printing results
		System.out.println("\nFirst and last person: ");
		System.out.println(people.get(0));
		System.out.println(people.get(9));
	}//end main
	
	/**
	 * Gets name of Person.
	 * @return String of person's name.
	 */
	public String getName() {
		return name;
	}//end getName

	/**
	 * Sets name of Person.
	 * @param name String to set person's name to.
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName

	/**
	 * Compares name of otherPerson alphabetically and returns 0, 1 or -1
	 * @param otherPerson the other Person object to compare.
	 */
	@Override
	public int compareTo(Object otherPerson) {
		return this.getName().compareTo(((Person)otherPerson).getName());
	}//end compareTo override

	/**
	 * An override of toString that returns the Person's name.
	 * @return Returns the Person's name.
	 */
	@Override
	public String toString() {
		return "Person [name: " + name + " ]";
	}//end toString override
	
	
}//end Person
