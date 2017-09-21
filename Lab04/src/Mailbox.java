import java.util.ArrayList;
/*
 * Mailbox.java
 * 
 * Model class for email mailbox
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-17-17
 */

public class Mailbox {
	
	private ArrayList<Message> messages;
	
	private final String SIGNATURE; //doesn't change after constructor
	
	public Mailbox(String signature){
		//basic constructor that takes a signature (can be blank)
		this.messages = new ArrayList<Message>();
		if(signature != null && signature.length() > 0){
			SIGNATURE = signature;
		} else {
			SIGNATURE = "";
		}
	}//end Mailbox Constructor
	
	public void addMessage(Message m){
		//adds signature to message and adds it to the mailbox
		if(SIGNATURE != null && SIGNATURE != ""){
			m.append(SIGNATURE);
		}
		messages.add(m);
	}//end addMessage
	
	public Message getMessage(int i){
		//checks index before returning message
		if(i < messages.size() && i >= 0){
			return messages.get(i);
		} else {
			//is it OK to directly print errors from methods?
			//or should there be a separate void or String method for errors?
			System.out.println("getMessage error: Message index ("+ i
							  +") out of range.");
			return null;
		}
	}//end getMessage
	
	public void removeMessage(int i){
		//checks index before removing message
		if(i < messages.size() && i >= 0){
			messages.remove(i);
		} else {
			System.out.println("removeMessage error: Message index ("+ i
							  +") out of range.");
		}
	}//end removeMessage

}//end Mailbox
