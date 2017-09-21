/*
 * Message.java
 * 
 * Model class for email message
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-17-17
 */

public class Message {

	private String recipient, 
				   sender, 
				   body;

	//header formatting, doesn't need to be modified
	public static final String FROM_TXT = "From: ", 
							   TO_TXT = "\nTo: ";

	public Message(String sender, String recipient) {
		// basic message constructor that has checks for blank strings
		
		if (recipient.length() > 0)
			this.recipient = recipient;
		if (sender.length() > 0)
			this.sender = sender;
		
		this.body = ""; //prevents strange null at beginning of string
	}// end Message constructor

	public void append(String line) {
		//adds line to the end of body and creates a new line
		if (line.length() > 0)
			this.body += line + "\n";
	}// end append

	@Override
	public String toString() {
		//returns string with all of message info combined
		return FROM_TXT + this.sender + TO_TXT + this.recipient + "\n" + this.body + "\n";
	}// end toString Override

}// end Message
