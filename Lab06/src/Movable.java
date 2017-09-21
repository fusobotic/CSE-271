/*
 * Moveable.java
 * 
 * Interface for generally moving objects
 * Assumed typical x/y grid for moveLeft and moveRight values
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-5-17
 */

public interface Movable {
	//only happens in single steps, not an acceleration or speed
	void moveUp();
	void moveDown();
	void moveLeft(); //moves negatively
	void moveRight(); //moves positively
}//end Movable
