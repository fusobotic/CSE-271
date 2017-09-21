/*
 * MessageTester.java
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

public class MessageTester {

	public static void main(String[] args) {
		//testing constructor, append and toString override
		Message tstMsg = new Message("Bob", "Jack");
		tstMsg.append("This is a message!");
		tstMsg.append("This is a second line!");
		System.out.print("Testing append and toString:\nResult:\n" 
						+ tstMsg.toString());
		System.out.println("Expected:\nFrom: Bob\nTo: Jack\nThis is a message!\n"
						 + "This is a second line!\n");
	}//end main

}//end MessageTester
