/*
 * PersonTester.java
 * 
 * Tests constructors and improper numbers in Person, Student, and Instructor
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-24-17
 */


public class PersonTester {

	public static void main(String[] args) {
		
		//testing normal constructor behavior
		Person testPerson = new Person("Bob", 1999);
		Student testStudent = new Student("Joe", 1986, "Computer Science");
		Instructor testInstructor = new Instructor("Phil", 1980, 150000f);
		
		//testing whether negative numbers are reset correctly to zero.
		Person errorPerson = new Person("Nah", -500);
		Student errorStudent = new Student("Bruv", -1700, "Coin Collecting");
		Instructor errorInstructor = new Instructor("Nope", -8000, -15f);
		
		//printing results
		System.out.println("Test Results:\n");
		System.out.println(testPerson);
		System.out.println(testStudent);
		System.out.println(testInstructor);
		System.out.println(errorPerson);
		System.out.println(errorStudent);
		System.out.println(errorInstructor);
		
		//comparing to expected results
		System.out.println("\nExpected: \n\n"
				+ "My name is Bob and I was born in the year 1999.\n"
				+ "My name is Joe and I was born in the year 1986. "
				+ "As a student my major is Computer Science.\n"
				+ "My name is Phil and I was born in the year 1980. "
				+ "As a teacher my salary is 150000.0 dollars.\n"
				+ "My name is Nah and I was born in the year 0.\n"
				+ "My name is Bruv and I was born in the year 0. "
				+ "As a student my major is Coin Collecting.\n"
				+ "My name is Nope and I was born in the year 0. "
				+ "As a teacher my salary is 0.0 dollars.");

	}//end main

}//end PersonTester
