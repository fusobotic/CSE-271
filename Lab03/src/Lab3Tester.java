

public class Lab3Tester {

	public static void main(String[] args) {
		VotingMachine myVote = new VotingMachine();
		myVote.voteDem();
		myVote.voteDem();
		myVote.voteDem();
		myVote.voteRep();
		System.out.println(myVote.getTallies());
	}

}
