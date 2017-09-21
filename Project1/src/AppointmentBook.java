import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
/*
 * AppointmentBook.java
 * 
 * Class for managing appointments
 * Is able to read and write to its ArrayList to a file
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-8-17
 */

public class AppointmentBook {
	
	private ArrayList<Appointment> appointments;
	
	public AppointmentBook (){
		appointments = new ArrayList<Appointment>();
	}//end AppointmentBook blank constructor
	
	public AppointmentBook (ArrayList<Appointment> appointments){
		this.appointments = appointments;
	}//end AppointmentBook ArrayList constructor
	
	public AppointmentBook (Appointment[] appointments){
		this.appointments = new ArrayList<Appointment>(Arrays.asList(appointments));
	}//end AppointmentBook array conversion constructor
	
	//checks for proper dates and returns an new appointment object
	public static Appointment writeAppointment(String type, String descript, 
											   int year, int month, int date){
		//preventing improper dates from creating crashing
		if (year < 0) {
			System.out.println("Year is negative.");
			year = 1;
		}
		if (month < 0 || month > 11) {
			System.out.println("Month exceeds limit or is negative. Enter 0-11.");
			month = 0;
		}
		OneTime testDay = new OneTime("null",year,month,1);
		if(date < 1 || date > 
		   testDay.getCalendar().getActualMaximum(Calendar.DAY_OF_MONTH)){
			System.out.println("Day does not exist in given month.");
			date = 1;
		}
		
		//detecting type of appointment
		switch(type){
			case "OneTime": return new OneTime(descript,year,month,date);
			case "One Time": return new OneTime(descript,year,month,date);
			case "Daily": return new Daily(descript,year,month,date);
			case "Monthly": return new Monthly(descript,year,month,date);
			default: return new OneTime(descript,year,month,date);
		}
	}//end writeAppointment
	
	//saves an array of appointments
	public static void save(String filename, Appointment[] apts) 
							throws FileNotFoundException{
		PrintWriter out = new PrintWriter(new File(filename));
		for(Appointment a : apts){
			out.print(a.fileString());
		}
		out.close();
	}//end save with basic array
	
	//saves an ArrayList of appointments
	public static void save(String filename, ArrayList<Appointment> apts) 
							throws FileNotFoundException{
		PrintWriter out = new PrintWriter(new File(filename));
		for(Appointment a : apts){
			out.print(a.fileString());
		}
		out.close();
	}//end save overload ArrayList
	
	//saves just a single appointment per project requirements
	public static void saveSingle(String filename, Appointment apt) 
							throws FileNotFoundException{
		PrintWriter out = new PrintWriter(new File(filename));
		out.print(apt.fileString());
		out.close();
	}//end saveSingle
	
	//Loops straight through file and creates/writes objects directly to an ArrayList
	public static ArrayList<Appointment> load(String filename, 
				  ArrayList<Appointment> apts) throws FileNotFoundException{
		Scanner in = new Scanner(new File(filename));
		//I set this separator up earlier with fileString() functions
		in.useDelimiter("~"); 
		
		while(in.hasNext()){
			String type="", descript="";
			int year=0, month=0, date=1;
			
			type = in.next();
			descript = in.next();
			year = in.nextInt();
			month = in.nextInt();
			date = in.nextInt();
			
			apts.add(writeAppointment(type,descript,year,month,date));
		}
		
		in.close();
		return apts;
	}//end load
	
	//overloading the method so that it can be called on an instance
	public ArrayList<Appointment> load(String filename) throws FileNotFoundException{
		return load(filename, this.appointments);
	}//end load instance version

	//Getters and setters for appointments array
	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}//end getAppointments

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}//end setAppointments

	@Override
	public String toString() {
		String appointList = "";
		for (Appointment a : appointments)
			appointList += a + "\n";
		return appointList;
	}//end toString override

}//end ApppointmentBook
