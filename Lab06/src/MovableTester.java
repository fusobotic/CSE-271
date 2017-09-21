/*
 * MovableTester.java
 * 
 * Tests new movable classes and interface
 * Also does dance moves for funzies
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-5-17
 */

public class MovableTester {

	public static void main(String[] args) {
		tester();
		
		Movable[] movables = { 
				  	  new MovablePoint(5, 6, 10, 12),
					  new MovableCircle(2, 1, 2, 20, 50),
					  new MovableCircle(4, 6, 10, 30, 70),
					  new MovablePoint(56, 20, 39, 80) };
		
		//testing before and after dance moves
		for(Movable mov : movables)
			System.out.println(mov);
		
		System.out.println();
		chaChaSlide(movables);
		
		for(Movable mov : movables)
			System.out.println(mov);
		
	}//end main

	public static void tester() {
		//tests various smart setters and constructors
		//test cases given by Lab Notes
		Movable m1 = new MovablePoint(5, 6, 10, 12);
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		Movable m2 = new MovableCircle(2, 1, 2, 20, 50);
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2 + "\n");

		// Trying negative numbers for speed
		MovablePoint mp1 = new MovablePoint(6, -1, 8, -20);
		// expects 0 as both speeds
		System.out.println(mp1);
		mp1.setxSpeed(20);
		// expects 20 as xSpeed
		System.out.println(mp1 + "\n");

		// Trying negative number for radius
		MovableCircle mc1 = new MovableCircle(5, 4, 8, 30, -500);
		// expects 0 as radius
		System.out.println(mc1 + "\n");
	}//end tester
	
	public static void chaChaSlide(Movable[] movables){
		//makes movables perform a specific set of dance moves
		for(Movable mov : movables){
			mov.moveLeft();
			mov.moveRight();
			mov.moveDown();
			mov.moveUp();
			mov.moveLeft();
			mov.moveDown();
			mov.moveUp();
			mov.moveRight();
			mov.moveLeft();
			mov.moveDown();
			mov.moveUp();
			mov.moveUp();
			//"cha cha real smooth..."
		}
	}//end chaChaSlide
	
}// end MovableTester
