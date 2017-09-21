/*
 * OlympicRings.java
 * 
 * Class and frame for drawing Olympic Rings
 * 
 * Christian Coppoletti
 * 
 * CSE 271 Section A
 * 
 * Java 1.8
 * 
 * 3-31-17
 */
package edu.miamioh.coppolcm.lab09;
/**
 * @author coppolcm
 *
 */
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class OlympicRings extends JFrame {
	
	/**
	 * Width and Height of the frame
	 */
	private static final int WIDTH = 400;
	private static final int HEIGHT = 250;

	/**
	 * Runs at the start of the program to make the frame
	 * @param args Command line args; doesn't do anything.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args){
		OlympicRings olympicRings = new OlympicRings();
	}//end main
	
	/**
	 * Constructs Frame and adds title
	 */
	public OlympicRings(){
		setSize(WIDTH,HEIGHT);
		setTitle("GOTTA GO FAST!"); //"YOU'RE TOO SLOW!"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//end OlympicRings
	
	/**
	 * calls drawRing to construct rings
	 * @param g Graphics object to draw rings to.
	 */
	public void paint(Graphics g){
		drawRing(g, 50, 50, Color.BLUE);
		drawRing(g, 155, 50, Color.BLACK);
		drawRing(g, 260, 50, Color.RED);
		drawRing(g, 102, 97, Color.YELLOW);
		drawRing(g, 206, 97, Color.GREEN);
	}//end paint
	
	/**
	 * Draws a ring stroke with a pixel width of 5 and a diameter of 100.
	 * @param g Graphics component to pass.
	 * @param x x position integer.
	 * @param y y position integer.
	 * @param c Color component.
	 */
	public void drawRing(Graphics g, int x, int y, Color c){
		((Graphics2D) g).setStroke(new BasicStroke(5));
		((Graphics2D) g).setPaint(c);
		g.drawOval(x, y, 100, 100);
	}//end drawRings

}//end OlympicRings

