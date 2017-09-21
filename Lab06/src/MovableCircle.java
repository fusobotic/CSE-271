/*
 * MovableCircle.java
 * 
 * Class for a circle that can move
 * Uses MovablePoint for center
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-5-17
 */

public class MovableCircle implements Movable {
	
	private MovablePoint center;
	private double radius;
	
	public MovableCircle(double x, double xSpeed, double y, double ySpeed,
						  double radius){
		//just use point constructor instead of recreating variables
		center = new MovablePoint(x, xSpeed, y, ySpeed); 
		
		//not possible to have negative radius
		if (radius > 0){
			this.radius = radius;
		} else { 
			this.radius = 0;
		}
		
	}//end MovableCircle constructor
	
	public void moveUp(){
		center.moveUp();
	}//end moveUp
	public void moveDown(){
		center.moveDown();
	}//end moveDown
	public void moveLeft(){
		center.moveLeft();
	}//end moveLeft
	public void moveRight(){
		center.moveRight();
	}//end moveRight
	
	public double getxSpeed() {
		return center.getxSpeed();
	}//end getxSpeed

	public void setxSpeed(double xSpeed) {
		center.setxSpeed(xSpeed);
	}//end setxSpeed

	public double getySpeed() {
		return center.getySpeed();
	}//end getySpeed

	public void setySpeed(double ySpeed) {
		center.setySpeed(ySpeed);
	}//end setySpeed

	@Override
	public String toString() {
		return  center + " [ radius=" + radius + " ] ";
	}//end toString override
	
	

}//end MovableCircle
