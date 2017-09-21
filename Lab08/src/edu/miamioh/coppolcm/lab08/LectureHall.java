package edu.miamioh.coppolcm.lab08;

/**
 * @author Christian Coppoletti
 * 
 * LectureHall.java
 * 
 * Lecture Hall class that tracks a capacity and name.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public class LectureHall {
	
	private int capacity;
	private String name;
	/**
	 * @param capacity
	 * @param name
	 */
	public LectureHall(int capacity, String name) {
		this.capacity = capacity;
		this.name = name;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LectureHall [capacity=" + capacity + ", name=" + name + "]";
	}
	
	

}//end LectureHall
