
package edu.miamioh.coppolcm.lab10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * ColorChanger.java
 * 
 * JFrame subclass that can change color according to menu items
 * or mouse clicks, which cycle color.
 * 
 * @author coppolcm
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 4-10-17
 */
@SuppressWarnings("serial")
public class ColorChanger extends JFrame {
	
	/**
	 * Dimensions of Frame
	 */
	public static final int WIDTH = 300, HEIGHT = 300;
	
	/**
	 * Menu items and bar for changing colors
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuRoot = new JMenu("Background Color");
	private JMenuItem redBtn = new JMenuItem("Red"),
					greenBtn = new JMenuItem("Green"),
					blueBtn = new JMenuItem("Blue");
	
	/**
	 * Panel that detects mouse input
	 */
	private JPanel wrapperPanel = new JPanel();
	
	/**
	 * Current background color index
	 */
	private int currentCol = 0;
	
	/**
	 * Creates a frame object to display
	 * @param args command line arguments not used.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ColorChanger colorChanger = new ColorChanger();
	}//end main
	
	/**
	 * Constructor for Color Changer JFrame
	 */
	public ColorChanger(){
		buildMenu();
		setJMenuBar(menuBar);
		add(wrapperPanel);
		wrapperPanel.addMouseListener(new PanelListener());
		
		setSize(WIDTH,HEIGHT);
		setTitle("Roy, Geeze Biv");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//end ColorChanger

	/**
	 * Creates menu items and adds them.
	 * Contains local inner listener class.
	 */
	private void buildMenu() {
		/**
		 * Custom listener local inner class for color menu items
		 */
		class ColorListener implements ActionListener {
			private String color;
			/**
			 * Constructor for ColorListener.
			 * @param color Color for button to change background to.
			 */
			public ColorListener(final String color){
				this.color = color;
			}//end ColorListener constructor
			
			/**
			 * Checks buttons color and changes background accordingly
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(color.equals("Red")){
					colorBackground(0);
				} else if(color.equals("Green")){
					colorBackground(1);
				} else {
					colorBackground(2);
				}
			}//end actionPerformed
		}//end ColorListener
		
		redBtn.addActionListener(new ColorListener("Red"));
		greenBtn.addActionListener(new ColorListener("Green"));
		blueBtn.addActionListener(new ColorListener("Blue"));
		
		menuRoot.add(redBtn);
		menuRoot.add(greenBtn);
		menuRoot.add(blueBtn);
		menuBar.add(menuRoot);
	}//end buildMenu
	
	/**
	 * Changes the color of the wrapper and center panel backgrounds.
	 * @param i Index of the color to change to 0 is Red, 1 Green, 2 Blue
	 */
	public void colorBackground (int i){
		// 0 = Red, 1 = Green, 2 = Blue
		if(i == 0){
			wrapperPanel.setBackground(Color.RED);
		} else if(i == 1) {
			wrapperPanel.setBackground(Color.GREEN);
		} else {
			wrapperPanel.setBackground(Color.BLUE);
		}
		//set current color index to match clicked color
		currentCol = i;
	}//end colorBackground
	
	/**
	 * Custom listener for mouse clicks in JFrame
	 */
	public class PanelListener implements MouseListener{

		/**
		 * Cycles color on mouse click
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			cycleColor();
		}//end mouseClicked

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}	
	}//end PanelListener
	
	/**
	 * Rotates through a set of 3 colors via an index
	 * Uses colorBackground to change the actual color
	 */
	public void cycleColor (){
		if(currentCol < 2){
			currentCol++;
		} else {
			currentCol = 0;
		}
		colorBackground(currentCol);
	}//end cycleColor
	
}//end ColorChanger
