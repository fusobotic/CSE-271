/*
 * Daily.java
 * 
 * Appointment subclass for appointments that occur every day
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-8-17
 */

public class Daily extends Appointment{
	public static final String TYPE = "Daily";
	
	public Daily(String description, int year, int month, int date){
		super(description, year, month, date);
	}//end Daily constructor
	
	//if it's daily it occurs every day
	public boolean OccursOn(int year, int month, int date){
		return true;
	}//end OccursOn
	
	@Override
	public String toString() {
		return TYPE + " " + super.toString();
	}//end toString()
	
	public String fileString(){
		return "~" + TYPE + "~" + super.fileString();
	}//end fileString()
}//end Daily
