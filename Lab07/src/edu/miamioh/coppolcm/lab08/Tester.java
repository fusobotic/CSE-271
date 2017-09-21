package edu.miamioh.coppolcm.lab08;
import java.util.ArrayList;

/**
 * @author Christian Coppoletti
 * 
 * Tester.java
 * 
 * Tests the classes and methods in lab08
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class Tester {
	
	public static void main(String args[]){
		//creating ArrayList and assigning it to University
		ArrayList<Person> testPeople = new ArrayList<Person>();
		University testUni = new University(testPeople);
		//creating People
		testPeople.add(new Student(111,"derp@uni.edu",2.6f,"Family Studies"));
		testPeople.add(new Instructor(112,"lerp@uni.edu",30000));
		testPeople.add(new AdminStaff(113,"slerp@uni.edu",40000));
		
		
		//testing admin functions and lectureHall
		AdminStaff testAdmin = (AdminStaff)testPeople.get(2);
		testAdmin.assignInstructor(
				(Instructor) testPeople.get(1),
					new Course(new LectureHall(10,"derp"), 
				(Instructor) testPeople.get(1), 
					"Kitchens"));
		System.out.println("Expected: One of each Person subclass with"
						 + " assigned instance variables.\nResults:");
		System.out.println(testUni);

		testAdmin.assignCourse(
				((Student) testPeople.get(0)),
				((Instructor) testPeople.get(1)).getCourses().get(0));
		System.out.println("Expected: list of course participants "
						 + "(Instructor and Student).\nResults:");
		System.out.println(((Student) testPeople.get(0)).getCourses().get(0)+"\n");
		
		LectureHall testHall = new LectureHall(50, "Kreger 121");
		testAdmin.assignLectureHall(testHall, 
				((Instructor) testPeople.get(1)).getCourses().get(0));
		System.out.println("Expected:\nLectureHall [capacity=50, name=Kreger 121]"
						 + "\nResults:");
		System.out.println(testHall + "\n");
		
		
		//testing instructor changeGPA
		Instructor testInst = (Instructor) testPeople.get(1);
		testInst.changeGPA(((Student) testPeople.get(0)),
				3.9f);
		System.out.println("Expected: GPA of 3.9\nResults:");
		System.out.println((Student) testPeople.get(0));
		
	}//end main
	
}//end Tester
