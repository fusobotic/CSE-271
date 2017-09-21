
package edu.miamioh.coppolcm.project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ChessFrame.java
 * 
 * An 8x8 Chessboard JFrame for checking queen positions.
 * Can also give tips for next position to be taken.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-28-17
 */
@SuppressWarnings("serial")
public class ChessFrame extends JFrame {
	
	/**
	 * Constructing ChessBoard
	 */
	private ChessBoard b = new ChessBoard(8,8);
	
	/**
	 * Buttons
	 */
	private JButton checkBtn = new JButton("Check Positions");
	private JButton tipBtn = new JButton("Tip");
	private Qbtn[][] boardBtns = new Qbtn[8][8];
	
	/**
	 * Icons for buttons
	 */
	private static ImageIcon queenIcon;
	private static ImageIcon tipIcon;
	private static ImageIcon invalidIcon;
	
	/**
	 * Readout
	 */
	private static JLabel readOut = new JLabel("Number of Queens: 0");
	
	/**
	 * Panels for before and after conversion text fields/combo boxes
	 */
	private JPanel boardPanel = new JPanel(new GridLayout(8,8));
	private JPanel bottomPanel = new JPanel();
	
	/**
	 * Main method creates a new frame with constructor.
	 * @param args Command line arguments not used.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			//make sure these are in the root of the project
			queenIcon = new ImageIcon(ImageIO.read(new File("queen.png")));
			tipIcon = new ImageIcon(ImageIO.read(new File("tip.png")));
			invalidIcon = new ImageIcon(ImageIO.read(new File("invalid.png")));
		} catch (Exception e) {
			readOut.setText("Error: One or more icons not loaded!");
			ChessFrame cf = new ChessFrame();
		}
		ChessFrame cf = new ChessFrame();
		
	}//end main
	
	/**
	 * Constructor for frame with title and packed size
	 */
	public ChessFrame(){	
		buildBoard();
		buildBottom();
		
		add(bottomPanel, BorderLayout.SOUTH);
		add(boardPanel, BorderLayout.CENTER);
		
		setSize(500,500);
		setTitle("YAAAS QUEEN SLAAAY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//end ChessFrame constructor

	/**
	 * Constructs board within two for loops
	 * Alternates blocks with darkGray and White colors
	 */
	private void buildBoard() {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				boardBtns[i][j] = new Qbtn(j,i);
				if((i+j)%2 == 0) 
					boardBtns[i][j].setBackground(Color.darkGray);
				else
					boardBtns[i][j].setBackground(Color.WHITE);
				boardBtns[i][j].setOpaque(true);
				boardBtns[i][j].setBorderPainted(false);
				boardPanel.add(boardBtns[i][j]);
			}
		}
	}//end buildBoard
	
	/**
	 * Builds the bottom panel with Check and Tip Buttons
	 * as well as a readout for Queen count and validation
	 */
	private void buildBottom() {
		bottomPanel.add(checkBtn);
		checkBtn.addActionListener(new CheckTipListener());
		bottomPanel.add(tipBtn);
		tipBtn.addActionListener(new CheckTipListener());
		bottomPanel.add(readOut);
	}//end buildBottom
	
	/**
	 * updates the readout, icons, and switchs on and off tip button
	 * depending on whether the max queen number has been met
	 */
	public void updateInterface(){
		//change the text of the readout
		int count = b.queenCount();
		readOut.setText("Number of Queens: " + count);
		if(b.queenCount() == 8)
			tipBtn.setEnabled(false);
		else
			tipBtn.setEnabled(true);
		resetIcons();
	}//end updateInterface
	
	/**
	 * A custom listener for Tip button and Check button
	 */
	public class CheckTipListener implements ActionListener{
		/**
		 * Override for actionPerformed.
		 * @param e Click event
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(((JButton)e.getSource()).getText() == "Tip"){
				resetIcons();
				int[] tipCords = b.findTip();
				if(tipCords[0] > -1){
					boardBtns[tipCords[0]][tipCords[1]].setIcon(tipIcon);
				} else {
					readOut.setText("No possible Spaces");
				}
			}
			//Check Button
			else {
				if(!b.validateBoard()){
					resetIcons();
					readOut.setText("Invalid Board!");
					for(int i = 0; i < 8; i++)
						for(int j = 0; j < 8; j++){
							if(b.board[i][j] == 1 && !b.checkSpot(j, i)){
								//set invalid Icon
								boardBtns[i][j].setIcon(invalidIcon);
							}
						}
				} else {
					readOut.setText("Board is Valid!");
					resetIcons();
				}
			}
		}//end actionPerformed
	}//end CheckipListener class
	
	/**
	 * Cycles through board and sets Icons to current board state
	 */
	public void resetIcons() {
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				if(b.board[i][j] == 1){
					boardBtns[i][j].setIcon(queenIcon);
				}
				if(b.board[i][j] == 0 || b.board[i][j] == 3){
					boardBtns[i][j].setIcon(null);
				}
			}
	}//end resetIcons

	/**
	 * Custom button class for the board with a local inner class listener
	 */
	public class Qbtn extends JButton{
		/**
		 * location coordinates
		 */
		private int x, y;
		/**
		 * Constructor for QBtn
		 * @param x the x location.
		 * @param y the y location.
		 */
		public Qbtn(int x, int y){
			this.x = x;
			this.y = y;
			
			/**
			 * Local inner class that implements ActionListener calls updateIcon
			 */
			class QListener implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent e) {
					//call functions on ChessBoard with loc values
					updateIcon();
				}
			}//end QListener class
			
			addActionListener(new QListener());
		}
		
		/**
		 * updates the GUI board according to the ChessBoard object
		 */
		public void updateIcon(){
			//change icon according to state
			//just check Chessboard array
			if(b.queenCount() < 8 || b.board[y][x] == 1){
				b.toggleQueen(x,y);
				if(b.board[y][x] == 1){
					//place icon
					setIcon(queenIcon);
				}
				else {
					//remove icon
					setIcon(null);
				}
			}
			updateInterface();
		}//end updateIcon
	}//end QBtn class
	
}//end ChessFrame
