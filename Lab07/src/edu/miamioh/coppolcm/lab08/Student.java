package edu.miamioh.coppolcm.lab08;

import java.util.ArrayList;

/**
 * @author Christian Coppoletti
 * 
 * Student.java
 * 
 * Student subclass of Person that keeps track of GPA and Major.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class Student extends Person {
	
	/**
	 * GPA of the Student.
	 */
	private float gpa;
	
	/**
	 * Major of the Student.
	 */
	private String major;
	
	/**
	 * ArrayList of courses student is enrolled in.
	 */
	private ArrayList<Course> courses;

	public Student(int iDNum, String email, float gpa, String major) {
		super(iDNum, email);
		setgpa(gpa);
		this.major = major;
		courses = new ArrayList<Course>();
	}//end Student

	/**
	 * Gets a Student's GPA. 
	 * @return the gpa
	 */
	public float getgpa() {
		return gpa;
	}//end getgpa

	/**
	 * Sets GPA on Student. If below zero, it sets to 0.
	 * @param gpa the Grade Point Average to set.
	 */
	public void setgpa(float gpa) {
		if(gpa > 0){
			this.gpa = gpa;
		} else {
			this.gpa = 0;
		}
		
	}//end setgpa

	/**
	 * Get's Students major.
	 * @return the major.
	 */
	public String getMajor() {
		return major;
	}//end getMajor

	/**
	 * Sets a students major.
	 * @param major the major to set.
	 */
	public void setMajor(String major) {
		this.major = major;
	}//end setMajor

	/**
	 * Returns a list of courses the student is enrolled in.
	 * Doesn't need a setter since the list can be manipulated with getter.
	 * @return the courses.
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}//end getCourses
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Returns an expanded string from superclass Person including Student's GPA and Major.
	 * @return the super toString plus GPA and Major.
	 */
	@Override
	public String toString() {
		return super.toString() + "Student [gpa=" + gpa + ", major=" + major + "]";
	}//end toString
	
	
	
}//end Student
