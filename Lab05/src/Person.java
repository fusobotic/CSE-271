/*
 * Person.java
 * 
 * Superclass that encompasses Student and Instructor
 * Stores name and yearOfBirth only
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Person {
	
	private String name;
	private int yearOfBirth;
	
	public Person(String name, int yearOfBirth){
		this.name = name;
		//checking that year of birth is positive
		setYearOfBirth(yearOfBirth);
	}//end Person constructor

	public String getName() {
		return name;
	}//end getName

	public void setName(String name) {
		this.name = name;
	}//end setName

	public int getYearOfBirth() {
		return yearOfBirth;
	}//end getYearOfBirth

	public void setYearOfBirth(int yearOfBirth) {
		//if there is negative input set as 0
		if(yearOfBirth > 0){
			this.yearOfBirth = yearOfBirth;
		} else {
			yearOfBirth = 0; 
		}
	}//end setYearOfBirth

	@Override
	public String toString() {
		return "My name is " + name + " and I was born in the year " 
				+ yearOfBirth + ".";
	}//end toString Override

}//end Person
