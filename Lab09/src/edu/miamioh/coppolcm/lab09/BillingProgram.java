/*
 * BillingProgram.java
 * 
 * Interface for constructing orders and calculating
 * cost with tax+tip. Also allows for adding custom items
 * to the receipt for calculations.
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;

@SuppressWarnings("serial")
public class BillingProgram extends JFrame {
	/**
	 * Width and Height of the frame
	 */
	private static final int WIDTH = 800;
	private static final int HEIGHT = 300;
	
	/**
	 * Constant tip and tax values
	 */
	public static final float TIP = .2f;
	public static final float TAX = .07f;
	
	/**
	 * formats cost values to USD
	 */
	private static NumberFormat nf = 
				   NumberFormat.getCurrencyInstance((new Locale("en", "US")));
	
	/**
	 * Values for keeping track of receipt and total cost
	 */
	private String receiptText = "";
	private float total = 0;
	
	/**
	 * array of menuItems to add
	 */
	private ItemButton[] presetButtons = {
			new ItemButton("'spaget", 5),
			new ItemButton("'za", 10),
			new ItemButton("Colorized 1942", 42),
			new ItemButton("Fettucinni Freddo", 24),
			new ItemButton("Lasaaaaagna", 1),
			new ItemButton("One Breadstick", 100),
			new ItemButton("Meatah-ball", 50),
			new ItemButton("Noooodles", 69),
			new ItemButton("Palmajohn Chicken", 24),
			new ItemButton("Take the Canoli", 420),
	};
	
	/**
	 * Buttons for adding custom item and calculating total
	 */
	private CustomItemButton customBtn = new CustomItemButton("Add Item");
	private CalculateButton calculateBtn = new CalculateButton("Calculate");
	
	/**
	 * Text fields and area
	 */
	private TextArea readOut = new TextArea();
	private TextField customItem = new TextField("Item Name");
	private TextField customPrice = new TextField("[price]");

	/**
	 * Runs at the start of the program
	 * @param args Command line args; doesn't do anything.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args){
		BillingProgram billingProgram = new BillingProgram();
	}//end main
	
	/**
	 * constructor for JFrame triggers createUI
	 * and sets title
	 */
	public BillingProgram(){
		createUI();
		setSize(WIDTH,HEIGHT);
		setTitle("'Better Ingredients, Better Pizza' -PAPA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//end BillingProgram
	
	/**
	 * adds all the buttons and fields to the panel
	 * then adds panel to frame
	 */
	private void createUI() {
		JPanel panel = new JPanel();
		for(ItemButton b : presetButtons)
			panel.add(b);
		
		panel.add(customItem);
		panel.add(customPrice);
		panel.add(customBtn);
		panel.add(readOut);
		panel.add(calculateBtn);
		
		add(panel);
	}//end createUI

	/**
	 * new button subclass for preset menu items
	 */
	class ItemButton extends JButton{
		private float price = 0f;
		
		/**
		 * constructs button with price and listener
		 * @param text string for the button label
		 * @param price price for menu item
		 */
		public ItemButton(String text, float price){
			super(text);
			this.price = price;
			
			ActionListener listener = new ButtonListener(this);
			addActionListener(listener);
		}//end ItemButton

		public float getPrice() {
			return price;
		}//end getPrice

		public void setPrice(float price) {
			this.price = price;
		}//end setPrice
	}//end ItemButton
	
	/**
	 * Button subclass for button that submits custom item
	 */
	class CustomItemButton extends JButton{
		/**
		 * Constructor that adds an event listener to button
		 * @param text label for button
		 */
		public CustomItemButton(String text){
			super(text);
			ActionListener listener = new ButtonListener(this);
			addActionListener(listener);
		}//end CustomItemButton constructor
	}//end CustomItemButton
	
	/**
	 * Button subclass for button that calculates total
	 */
	class CalculateButton extends JButton{
		/**
		 * Constructor that adds an event listener to button
		 * @param text label for button
		 */
		public CalculateButton(String text){
			super(text);
			ActionListener listener = new ButtonListener(this);
			addActionListener(listener);
		}//end CalculateButton constructor
	}//end CalculateButton
	
	/**
	 * General ButtonListener used for each button in frame
	 */
	class ButtonListener implements ActionListener{

		private JButton b;
		
		/**
		 * Constructs listener with button reference.
		 * @param b button that listener is tracking.
		 */
		public ButtonListener(JButton b){
			this.b = b;
		}//end ButtonListener constructor
		
		/**
		 * Function called when button is pressed
		 * Checks what type of button it is
		 * then calls the proper function accordingly
		 * @param e event parameter
		 */
		public void actionPerformed(ActionEvent e) {
			if(b instanceof ItemButton){
				//ItemButton trigger
				updateReciept(b.getText(), ((ItemButton) b).getPrice());
			}
			else if (b instanceof CustomItemButton){
				//for custom item fields
				//only submits if there's an actual number in customPrice
				if(customPrice.getText().matches("[-+]?\\d*\\.?\\d+")){
					updateReciept(customItem.getText(), 
								  Float.parseFloat(customPrice.getText()));
				}
			}
			else {
				//the last remaining button is calculate
				readOut.setText(receiptText 
						+ "\nSubTotal: " + nf.format(total)
						+ "\nTip: " + (int)(TIP*100) + "%"
						+ "\nTax: " + (int)(TAX*100) + "%"
						+ "\nBalance Due: " + nf.format((1+TAX+TIP)*total));
			}
		}//end actionPerformed
		
	}//end ButtonListener
	
	/**
	 * Adds item to receipt and updates textArea.
	 * @param name name of item for textArea.
	 * @param price price of the item for the textArea.
	 */
	private void updateReciept (String name, float price){
		total += price;
		String newItem = nf.format(price)
					   + " " + name + "\n";
		receiptText += newItem;
		readOut.setText(receiptText);
	}//end updateReciept

}//end BillingProgram

