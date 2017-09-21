import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/*
 * Appointment.java
 * 
 * Base abstract class for all Appointments
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-8-17
 */

public abstract class Appointment{
	private String description;
	private GregorianCalendar calendar;
	
	public Appointment(String description, int year, int month, int date){
		//make sure to extend this in subclasses
		setDescription(description);
		setCalendar(year, month, date);
	}//end Appointment constructor

	public String getDescription() {
		return description;
	}//end getDescription

	public void setDescription(String description) {
		if(description.length() > 0 ){
			this.description = description;
		} else {
			this.description = "";
		}
	}//end setDescription

	public GregorianCalendar getCalendar() {
		return calendar;
	}//end getCalendar

	public void setCalendar(int year, int month, int date) {
		//not a smart setter since AppointBook's writeAppointment() checks
		//for those sorts of errors
		calendar = new GregorianCalendar(2000, 0, 1);
		calendar.clear();
		calendar.setLenient(true);
		calendar.set(year, month, date);
	}//end setCalendar
	
	//overloading methods to compare either type of data
	abstract boolean OccursOn(int year, int month, int date);

	@Override
	//formats the date to something more readable
	public String toString() {
		SimpleDateFormat d = new SimpleDateFormat("MMMM dd, yyyy");
		d.setCalendar(calendar);
		return "Appointment: " + description + ". " +
				d.format(calendar.getTime()); 
	}//end toString
	
	//formats appointment for easier saving, loading and file scanning
	public String fileString(){
		return description + "~" + calendar.get(GregorianCalendar.YEAR) + "~"
			   + calendar.get(GregorianCalendar.MONTH) + "~"
			   + calendar.get(GregorianCalendar.DAY_OF_MONTH);
	}//end fileString
	
}//end Appointment
