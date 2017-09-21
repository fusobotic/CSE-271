package edu.miamioh.coppolcm.lab08;

import java.util.ArrayList;

/**
 * @author Christian Coppoletti
 * 
 * Course.java
 * 
 * Class that stores a name, hall, instructor and an ArrayList of students for
 * a course.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class Course {
	/**
	 * Hall for the Course.
	 */
	private LectureHall hall;
	
	/**
	 * Instructor of the Course.
	 */
	private Instructor instructor;
	
	/**
	 * Name of the Course.
	 */
	private String name;
	
	/**
	 * Students enrolled in the Course.
	 */
	private ArrayList<Student> students;
	
	/**
	 * Constructor for a Course.
	 * @param hall Hall for the Course.
	 * @param instructor Instructor of the Course.
	 * @param name Name of the Course.
	 */
	public Course(LectureHall hall, Instructor instructor, String name) {
		this.hall = hall;
		this.instructor = instructor;
		this.name = name;
		students = new ArrayList<Student>();
	}//end Course constructor

	/**
	 * Gets the course's hall.
	 * @return the hall.
	 */
	public LectureHall getHall() {
		return hall;
	}//end getHall

	/**
	 * Sets the courses hall.
	 * @param hall the hall to set.
	 */
	public void setHall(LectureHall hall) {
		this.hall = hall;
	}//end setHall

	/**
	 * Gets the course's instructor.
	 * @return the instructor.
	 */
	public Instructor getInstructor() {
		return instructor;
	}//end getInstructor

	/**
	 * Sets the course's instructor.
	 * @param instructor the instructor to set.
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}//end setInstructor

	/**
	 * Gets the course's name.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}//end getName

	/**
	 * Sets the course's name.
	 * @param name the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}//end setName

	/**
	 * Gets the ArrayList of current Students in Course.
	 * @return the students in the Course.
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}//end getStudents

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Returns information for the course.
	 * @return Multiline String with course name, hall, instructor and students.
	 */
	@Override
	public String toString() {
		return "Course [name=" + name + ", hall=" + hall + "\nInstructor=" + 
				instructor +"\nStudents=" + students + "]";
	}//end toString

}//end Course
