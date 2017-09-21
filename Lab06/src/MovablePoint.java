/*
 * MovablePoint.java
 * 
 * Class for a point that can move
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-5-17
 */

public class MovablePoint implements Movable {
	
	//variables for the point
	private double x, xSpeed, y, ySpeed;
	
	public MovablePoint(double x, double xSpeed, double y, double ySpeed){
		this.x = x;
		setxSpeed(xSpeed);
		this.y = y;
		setySpeed(ySpeed);
	}//end MovablePoint constructor
	
	public void moveUp(){
		y += ySpeed;
	}//end moveUp
	public void moveDown(){
		y -= ySpeed;
	}//end moveDown
	public void moveLeft(){
		x -= xSpeed;
	}//end moveLeft
	public void moveRight(){
		x += xSpeed;
	}//end moveRight
	
	public double getxSpeed() {
		return xSpeed;
	}//end getxSpeed

	public void setxSpeed(double xSpeed) {
		//can't have negative speed
		if (xSpeed > 0){
			this.xSpeed = xSpeed;
		} else {
			this.xSpeed = 0;
		}
	}//end setxSpeed

	public double getySpeed() {
		return ySpeed;
	}//end getySpeed

	public void setySpeed(double ySpeed) {
		//can't have negative speed
		if (ySpeed > 0){
			this.ySpeed = ySpeed;
		} else {
			this.ySpeed = 0;
		}
	}//end setySpeed

	@Override
	public String toString() {
		return " [ (" + x + ", " + y + ") " +
				"xSpeed=" + xSpeed + " ySpeed=" + ySpeed + " ] ";
	}//end toString override
	

}//end MovablePoint
