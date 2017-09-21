package edu.miamioh.coppolcm.lab08;

/**
 * @author Christian Coppoletti
 * 
 * Person.java
 * 
 * Superclass of Student, Admin Staff and Instructor.
 * Keeps track of ID and email and is collected by University.
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-27-17
 */

public abstract class Person {
	
	/**
	 * ID Number for each Person.
	 */
	private int iDNum;
	
	/**
	 * School email associated with each Person.
	 */
	private String email;
	
	public Person(int iDNum, String email){
		this.iDNum = iDNum;
		this.email = email;
	}//end Person

	/**
	 * Returns ID Number.
	 * @return the ID Number returned.
	 */
	public int getiDNum() {
		return iDNum;
	}//end getiDNum

	/**
	 * @param iDNum the ID Number to set.
	 */
	public void setiDNum(int iDNum) {
		this.iDNum = iDNum;
	}//end setiDNum

	/**
	 * Returns school email.
	 * @return the email.
	 */
	public String getEmail() {
		return email;
	}//end getEmail

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}//end setEmail

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * Returns base of Person string, usually expanded with subclass
	 * @return the Person's ID Number and Email
	 */
	@Override
	public String toString() {
		return "Person [ID Number=" + iDNum + ", Email=" + email + "] ";
	}
	
	

}//end Person
