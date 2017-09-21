/*
 * EmployeeTester.java
 * 
 * Tests constructors in Person, Student, and Instructor
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */


public class EmployeeTester {

	public static void main(String[] args) {
		
		//testing normal constructors
		Employee testEmployee = new Employee("Roy", 75000f);
		Manager testManager = new Manager("Alex", 110000f, "Marketing");
		Executive testExecutive = new Executive("Constantine", 200000f, 
								  "Finance", "Los Angeles, CA");
		
		//testing negative numbers
		Employee errorEmployee = new Employee("Bob", -1f);
		Manager errorManager = new Manager("Richard", -2000000f, 
							   "Venture Capital");
		Executive errorExecutive = new Executive("Charles II", -4000f, 
								   "Royal Investments", "London, UK");
		
		//printing results
		System.out.println("Test Results:\n");
		System.out.println(testEmployee);
		System.out.println(testManager);
		System.out.println(testExecutive);
		System.out.println(errorEmployee);
		System.out.println(errorManager);
		System.out.println(errorExecutive);
		
		//printing expected
		System.out.println("\nExpected: \n\n"
				+ "Employee Name: Roy | Salary: 75000.0\n"
				+ "Employee Name: Alex | Salary: 110000.0 | "
				+ "Manager Department: Marketing\n"
				+ "Employee Name: Constantine | Salary: 200000.0 | "
				+ "Manager Department: Finance | Executive Location: Los Angeles, CA\n"
				+ "Employee Name: Bob | Salary: 0.0\n"
				+ "Employee Name: Richard | Salary: 0.0 | "
				+ "Manager Department: Venture Capital\n"
				+ "Employee Name: Charles II | Salary: 0.0 | Manager Department: "
				+ "Royal Investments | Executive Location: London, UK");

	}//end main

}//end EmployeeTester
