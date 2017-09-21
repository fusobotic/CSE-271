/*
 * Executive.java
 * 
 * Subclass of Employee that includes a department
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */

public class Executive extends Manager{
	
	private String officeLocation;

	public Executive(String name, float salary, String department, 
					 String officeLocation) {
		//inherits manager and employee's constructors
		super(name, salary, department);
		this.officeLocation = officeLocation;
	}//end Executive constructor

	public String getOfficeLocation() {
		return officeLocation;
	}//end getOfficeLocation

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}//end setOfficeLocation

	@Override
	public String toString() {
		return super.toString() + " | Executive Location: " + officeLocation;
	}//end toString override

}//end Executive
