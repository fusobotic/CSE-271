/*
 * Instructor.java
 * 
 * Subclass Instructor that includes a salary
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Instructor extends Person {
	
	private float salary;

	public Instructor(String name, int yearOfBirth, float salary) {
		//extends Person's constructor
		super(name, yearOfBirth);
		setSalary(salary);
	}//end Instructor constructor

	public float getSalary() {
		return salary;
	}//end getSalary

	public void setSalary(float salary) {
		//makes sure salary isn't negative
		if (salary > 0) {
			this.salary = salary;
		} else {
			salary = 0;
		}
	}//end setSalary

	@Override
	public String toString() {
		return super.toString() + " As a teacher my salary is " + salary 
								+ " dollars.";
	}//end toString override

}//end Instructor
