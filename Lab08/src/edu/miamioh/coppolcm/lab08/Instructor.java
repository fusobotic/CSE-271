package edu.miamioh.coppolcm.lab08;
import java.util.ArrayList;

/**
 * @author Christian Coppoletti
 * 
 * Instructor.java
 * 
 * Person subclass that has a salary and the ability to change a student's GPA.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class Instructor extends Person {
	/**
	 * Salary of the Instructor.
	 */
	private float salary;
	/**
	 * Courses the Instructor teaches.
	 */
	private ArrayList<Course> courses;

	/**
	 * Constructor for Instructor. Generates empty course list.
	 * @param iDNum ID Number passed to super constructor.
	 * @param email Email passed to super constructor.
	 * @param salary Salary for this AdminStaff.
	 */
	public Instructor(int iDNum, String email, float salary) {
		super(iDNum, email);
		this.salary = salary;
		courses = new ArrayList<Course>();
	}//end Instructor constructor
	
	/**
	 * Sets a student's cumulative GPA.
	 * @param student Student whose GPA needs changing.
	 * @param gpa GPA to change to.
	 */
	public void changeGPA(Student student, float gpa){
		student.setgpa(gpa);
	}//end changeGPA

	/**
	 * Gets Instructor's salary.
	 * @return the salary.
	 */
	public float getSalary() {
		return salary;
	}//end getSalary

	/**
	 * Sets Instructor's salary.
	 * @param salary the salary to set.
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}//end setSalary

	/**
	 * Gets ArrayList of courses.
	 * @return the courses.
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}//end getCourses

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Gets a String representing the instructor.
	 * @return Instructor's information plus the names of courses taught.
	 */
	@Override
	public String toString() {
		String res = super.toString() + "Instructor [salary=" + salary + ", courses=";
		for(Course c : courses){
			res += c.getName() + ", ";
		}
		res += "]";
		return res;
	}//end toString
	
}//end Instructor
