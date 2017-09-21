/*
 * Manager.java
 * 
 * Subclass of Employee that includes a department string
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Manager extends Employee{
	
	private String department;

	public Manager(String name, float salary, String department) {
		//inherits same constructor as Employee but adds department
		super(name, salary);
		setDepartment(department);
	}//end Manager constructor

	public String getDepartment() {
		return department;
	}//end getDepartment

	public void setDepartment(String department) {
		this.department = department;
	}//end setDepartment

	@Override
	public String toString() {
		return super.toString() + " | Manager Department: " + department;
	}//end toString override

}//end Manager
