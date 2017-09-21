import java.util.GregorianCalendar;
/*
 * Monthly.java
 * 
 * Appointment subclass for appointments that occur on a monthly basis
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-8-17
 */

public class Monthly extends Appointment{
	public static final String TYPE = "Monthly";
	
	public Monthly(String description, int year, int month, int date){
		super(description, year, month, date);
	}//end Monthly constructor
	
	//check whether day in the month is the same
	public boolean OccursOn(int year, int month, int date){
		//only comparing day of the month here
		return getCalendar().get(GregorianCalendar.DAY_OF_MONTH) == date;
	}//end OccursOn
	
	@Override
	public String toString() {
		return TYPE + " " + super.toString();
	}//end toString()
	
	public String fileString(){
		return "~"+ TYPE + "~" + super.fileString();
	}//end fileString()
}//end Daily
