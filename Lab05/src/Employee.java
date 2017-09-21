/*
 * Employee.java
 * 
 * Superclass that extends to Manager and Executive
 * Stores name and salary only
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Employee {
	
	private String name;
	private float salary;
	
	public Employee(String name, float salary){
		//using setSalary to check number
		this.name = name;
		setSalary(salary);
	}//end Employee Constructor

	public String getName() {
		return name;
	}//end getName

	public void setName(String name) {
		this.name = name;
	}//end setName

	public float getSalary() {
		return salary;
	}//end getSalary

	public void setSalary(float salary) {
		//can't have negative salary so set it to zero
		if (salary > 0){
			this.salary = salary;
		} else {
			this.salary = 0;
		}
	}//end setSalary

	@Override
	public String toString() {
		return "Employee Name: " + name + " | Salary: " + salary;
	}//end toString override

}//end Employee
