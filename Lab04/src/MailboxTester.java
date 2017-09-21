/*
 * MailboxTester.java
 * 
 * Tester for Mailbox class
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-17-17
 */

public class MailboxTester {

	public static void main(String[] args) {
		//testing whether all of the methods and checks in Mailbox work
		
		//testing addMessage, getMesage and toString methods
		System.out.println("Testing addMessage, getMessage, and toString:\nResults:\n");
		Mailbox tstMail = new Mailbox("\nSincerely,\nBob");
		Message msg1 = new Message("Bob", "Jack");
		msg1.append("This is the first Message!");
		tstMail.addMessage(msg1);
		System.out.println(tstMail.getMessage(0).toString());
		System.out.println("Expected:\n");
		System.out.println("From: Bob\nTo:Jack\nThis is the first Message!\n\nSincerely,\nBob\n");
		
		//testing removeMessage and Errors
		System.out.println("Testing removeMessage and Error catching:\nResults:\n");
		Message msg2 = new Message("Bob", "Jill");
		msg2.append("This is the second Message!");
		tstMail.addMessage(msg2);
		tstMail.removeMessage(1); //if this triggers it's working fine
		
		//trying invalid indexes
		tstMail.removeMessage(5); 
		tstMail.removeMessage(-1);
		tstMail.getMessage(1);
		tstMail.getMessage(-1);
		
		System.out.println("\nExpected:\n");
		System.out.println("removeMessage error: Message index (5) out of range.");
		System.out.println("removeMessage error: Message index (-1) out of range.");
		System.out.println("getMessage error: Message index (1) out of range.");
		System.out.println("getMessage error: Message index (-1) out of range.");
		
	}//end main

}//end MailboxTester
