package edu.miamioh.coppolcm.lab08;

/**
 * @author Christian Coppoletti
 * 
 * AdminStaff.java
 * 
 * Subclass of Person that keeps track of salary and has functionality for
 * adding assigning Courses, Instructors, and LectureHalls.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class AdminStaff extends Person {
	
	private float salary;

	/**
	 * AdminStaff constructor.
	 * @param iDNum ID Number passed to super constructor.
	 * @param email Email passed to super constructor.
	 * @param salary Salary for this AdminStaff.
	 */
	public AdminStaff(int iDNum, String email, float salary) {
		super(iDNum, email);
		this.salary = salary;
	}//end AdminStaff constructor
	
	/**
	 * Assigns a Student to a Course and adds the same Student to the Course's roster.
	 * @param student
	 * @param course
	 */
	public void assignCourse(Student student, Course course){
		student.getCourses().add(course);
		course.getStudents().add(student);
	}//end assignCourse
	
	/**
	 * Adds a course to an instructor and assigns an instructor to a course.
	 * @param instructor an Instructor.
	 * @param course a Course.
	 */
	public void assignInstructor(Instructor instructor, Course course){
		instructor.getCourses().add(course);
		course.setInstructor(instructor);
	}//end assignInstructor
	
	/**
	 * Assigns a course a LectureHall.
	 * @param lectureHall LectureHall to assign.
	 * @param course Course that takes the LectureHall.
	 */
	public void assignLectureHall(LectureHall lectureHall, Course course){
		course.setHall(lectureHall);
	}//end assignLectureHall

	/**
	 * Gets AdminStaff salary.
	 * @return the salary.
	 */
	public float getSalary() {
		return salary;
	}//end getSalary

	/**
	 * Sets AdminStaff salary.
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}//end setSalary

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "AdminStaff [salary=" + salary + "]";
	}//end toString
	
	

}//end AdminStaff
