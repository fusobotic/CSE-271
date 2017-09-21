import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * AppointmentTester.java
 * 
 * Checks to make sure all the appointment classes are working
 * Extends AppointmentBook for easier method access
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-9-17
 */

public class AppointmentTester extends AppointmentBook {

	public static void main(String[] args) {
		
		Appointment[] appointments = {
				new Daily("Brush your teeth", 2000,1,1),
				new Daily("Take a bath", 2020,5,13),
				new Daily("Sleep", 2057,8,25),
				new Monthly("Go to dentist", 2005, 3, 5),
				new Monthly("Performance review", 2008, 2, 7),
				new Monthly("Call Mother", 2017, 5, 10),
				new OneTime("Get wisdom teeth removed", 2007, 8, 18),
				new OneTime("Meet K for coffee", 2015, 4, 18),
				new OneTime("Waxing", 2058, 4, 26)
		};
		
		ArrayList<Appointment> loadList = new ArrayList<Appointment>();
		
		//printing initial entries
		System.out.println("Saved/Expected:");
		for (Appointment a : appointments)
			System.out.println(a);
		System.out.println("\n");
		
		//trying save and load
		try {
			save("AptBook.md", appointments);
		} catch (FileNotFoundException e) {
			System.out.println("Could not write file");
		}
		try{
			load("AptBook.md", loadList);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read file.");
		}
		
		//printing loaded results
		System.out.println("Loaded/Results:");
		for (Appointment a : loadList)
			System.out.println(a);
		System.out.println("\n");
		
		//Testing incorrect appointment input
		Appointment badInput = writeAppointment("Not real", "Blank", -20,-50,-200);
		System.out.println(badInput+"\n");
		
		AppointmentBook testBook = new AppointmentBook(loadList);
		Scanner in = new Scanner(System.in);
		
		//keep prompting for appointment check until application closes
		while(true){
			checkTime(testBook, in);
		}
		
		
	}//end main
	
	//prompts user for checkTime and then lists appointments that match day
	public static void checkTime(AppointmentBook testBook, Scanner in){
		System.out.println("\nEnter a date in 'yyyy mm dd' format to check which appointments overlap.");
		int year = in.nextInt(), 
			month = in.nextInt(), 
			date = in.nextInt();
		
		//checking date across all appointments in book
		for(Appointment a : testBook.getAppointments()){
			if(a.OccursOn(year, month, date))
				System.out.println(a);
		}
	}//end checkTime

}//end AppointmentTester
