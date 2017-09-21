package edu.miamioh.coppolcm.project2;

import java.util.Arrays;

/**
 * ChessBoard.java
 * 
 * Class for storing chess board data for ChessFrame
 * also has methods for checking board and getting tip positions
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-19-17
 */

public class ChessBoard {
	
	/**
	 * Sample board, written out mostly for testing
	 */
	public int[][] board = {
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0},
		{0,0,0,0,0,0,0,0} 
	};//0 = empty, 1 = queen, 2 = blocked spot, 3 = tip spot
	
	/**
	 * ChessBoard constructor
	 * @param width Width of the board.
	 * @param height Height of the board.
	 */
	public ChessBoard(int width, int height){
		board = new int[width][height];
	}//end ChessBoard
		
	/**
	 * Checks whether spot is valid for Queen
	 * horizontally, vertically, and diagonally.
	 * @param x Column coordinate.
	 * @param y Row coordinate.
	 * @return Returns false if spot is invalid, true if it is.
	 */
	public boolean checkSpot(int x, int y){
		//vertical
		for(int row = 0; row < board.length; row++){
			if(row != y && board[row][x] == 1){
				return false;
			}
		}
		//horizontal
		for(int col = 0; col < board[y].length; col++){
			if(col != x && board[y][col] == 1){
				return false;
			}
		}
		
		//diagonals, depends on board being square
		for(int d = 1; d < board.length; d++){
			if(y+d < board.length && x+d < board.length){
				if(board[y+d][x+d] == 1){
					return false;
				}
			}
			if(y-d > -1 && x-d > -1 ){
				if(board[y-d][x-d] == 1){
					return false;
				}
			}
			if(y+d < board.length && x-d > -1 ){
				if(board[y+d][x-d] == 1){
					return false;
				}
			}
			if(y-d > -1 && x+d < board.length){
				if(board[y-d][x+d] == 1){
					return false;
				}
			}
		}
		
		return true;
	}//end checkSpot
	
	/**
	 * Fills array with 2s where queens cannot be placed.
	 */
	public void markBlocks(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(!checkSpot(j,i) && board[i][j] != 1){
					board[i][j] = 2;
				}
			}
		}
	}//end markBlocks
	
	/**
	 * Either places or removes queen at given coordinate.
	 * @param x Column coordinate.
	 * @param y Row coordinate.
	 */
	public void toggleQueen(int x, int y){
		if(x < 0 || y < 0 || x > board[0].length || y > board.length) 
			return;
		if(board[y][x] == 1)
			board[y][x] = 0;
		else
			board[y][x] = 1;
	}//end toggleQueen
	
	/**
	 * Returns how many queens are currently on the board.
	 * @return current number of queens on board
	 */
	public int queenCount(){
		int count = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == 1){
					count++;
				}
			}
		}
		return count;
	}//end queenCount
	
	/**
	 * Calls checkSpot on each queen placement to validate board
	 * @return boolean of whether the board is valid or not
	 */
	public boolean validateBoard(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == 1 && !checkSpot(j,i)){
					return false;
				}
			}
		}
		return true;
	}//end validateBoard
	
	/**
	 * Scans board for any valid positions for queen placement.
	 * @return an int array with two values, the x and y position of the tip
	 */
	public int[] findTip(){
		resetBoard(false);
		markBlocks();
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == 0){
					board[i][j] = 3; //tip mark
					return new int[] {i,j};
				}
			}
		}
		//handle this return value
		return new int[] {-1,-1};
	}//end findTip
	
	/**
	 * Function for clearing the board or reseting blocked spots.
	 * @param fullReset If false only clear blocked/tip spots and leave queens.
	 */
	public void resetBoard(boolean fullReset){
		if(fullReset){
			for(int[] row : board){
				Arrays.fill(row, 0);
			}
		} 
		else {
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					if(board[i][j] == 2 || board[i][j] == 3)
						board[i][j] = 0;
				}
			}
		}
	}//end resetBoard
	
	/**
	 * Gives back a nicely formatted string of the board.
	 * @return A string representing the current board.
	 */
	@Override
	public String toString() {
		String res = "Current Board:\n";
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				res += " " + board[i][j];
			}
			res += "\n";
		}
		res += "\n";
		return res;
	}//end toString
	
}//end ChessBoard