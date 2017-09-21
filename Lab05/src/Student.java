/*
 * Student.java
 * 
 * Subclass Student that extends with a major
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Student extends Person {
	
	private String major;

	public Student(String name, int yearOfBirth, String major) {
		//extends Person's constructor
		super(name, yearOfBirth);
		this.major = major;
	}//end Student

	public String getMajor() {
		return major;
	}//end getMajor

	public void setMajor(String major) {
		this.major = major;
	}//end setMajor
	
	@Override
	public String toString(){
		return super.toString() +" As a student my major is " + major +".";
	}//end toString override

}
//end Student
