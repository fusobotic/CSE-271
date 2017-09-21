/*
 * Student.java
 * 
 * Class to track student grades on quizzes
 * Also averages the scores
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 2-10-17
 */

public class Student {
	
	private String name;
	private double totalScore = 0;
	private int quizNum = 0;
	//we don't need an array since individual quizzes
	//are never referenced.
	
	
	public Student(String name, double totalScore){
		//we were told in lab to always set this to zero
		//even if user enters a totalScore
		totalScore = 0;
		quizNum = 0;
		
		setName(name);
	}//end Student with totalScore
	
	public Student(String name){
		totalScore = 0;
		quizNum = 0;
		setName(name); 
	}//end Student without totalScore
	
	public void addQuiz(int score){
		//checks whether score is valid before adding to score
		if(score < 0 || score > 100) 
			return;
		quizNum++;
		totalScore += score;
	}//end addQuiz
	
	public double getAverageScore(){
		return totalScore/quizNum;
	}//end getAverageScore


	public String getName() {
		return name;
	}//end getName


	public void setName(String name) {
		//if there is no name inputed print an error
		if(name.length() > 0) 
			this.name = name;
		else 
			System.out.println("Error: Please enter a name");
	}//end setName


	public double getTotalScore() {
		return totalScore;
	}//end getTotal


	public void setTotalScore(double totalScore) {
		//makes sure total is over 0
		if(totalScore >= 0)
			this.totalScore = totalScore;
	}//end setTotalScore


	public int getQuizNum() {
		return quizNum;
	}//end getQuizNum


	public void setQuizNum(int quizNum) {
		//makes sure quiz score is valid if starting with one
		if(quizNum >= 0)
			this.quizNum = quizNum;
	}//end setQuizNum
	
	

}//end Student
