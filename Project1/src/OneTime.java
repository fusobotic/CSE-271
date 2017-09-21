import java.util.GregorianCalendar;
/*
 * OneTime.java
 * 
 * Appointment subclass for appointments that only occur once
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-8-17
 */

public class OneTime extends Appointment{
	public static final String TYPE = "One Time";
	
	public OneTime(String description, int year, int month, int date){
		super(description, year, month, date);
	}//end OneTime constructor
	
	//sees if objects/calendars are equivalent
	public boolean OccursOn(int year, int month, int date){
		GregorianCalendar other = new GregorianCalendar(year,month,date);
		return getCalendar().compareTo(other) == 0;
	}//end OccursOn
	
	@Override
	public String toString() {
		return TYPE + " " + super.toString();
	}//end toString()
	
	public String fileString(){
		return "~" + TYPE + "~" + super.fileString();
	}//end fileString()
}//end OneTime
