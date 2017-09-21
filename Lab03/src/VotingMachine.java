/*
 * VotingMachine.java
 * 
 * Simple voting machine with only counting and printing
 * can also wipe the machine of votes
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-10-17
 */

public class VotingMachine {
	
	private int demVotes,
				repVotes;
	
	public VotingMachine(){
		//just set values to zero to initialize
		clearMachine();
	}//end VotingMachine constructor
	
	public void clearMachine(){
		demVotes = 0;
		repVotes = 0;
	}//end clearMachine
	
	public void voteDem(){
		demVotes++;
	}//end voteDem
	
	public void voteRep(){
		repVotes++;
	}//end voteRep
	
	public String getTallies(){
		//only need one method for this:
		//"get the tallies for both parties."
		//returning one string with new lines instead of printing directly
		return "Democrat Votes: " + demVotes + "\n" +
			   "Republican Votes: " + repVotes + "\n" +
			   "Total votes: " + (repVotes+demVotes) + "\n";
	}//end getTallies
	
}//end VotingMachine
