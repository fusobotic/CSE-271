
package edu.miamioh.coppolcm.lab10;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * CurrencyConverter.java
 * 
 * JFrame UI subclass for converting one currency to another featuring 
 * the US Dollar, Euro, and British Pound.
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
public class CurrencyConverter extends JFrame {
	
	/**
	 * Formats doubles for printing
	 */
	private static NumberFormat usd = 
				   NumberFormat.getCurrencyInstance((new Locale("en", "US")));
	private static NumberFormat gbp = 
			   	   NumberFormat.getCurrencyInstance((new Locale("en", "GB")));
	private static NumberFormat eur = 
			   	   NumberFormat.getCurrencyInstance((new Locale("de", "DE")));
	
	/**
	 * Conversion button
	 */
	private JButton convertBtn = new JButton("Convert");
	
	/**
	 * Text fields for currency values
	 */
	private TextField startValue = new TextField(usd.format(10000)); //ignore non-doubles
	private TextField endValue = new TextField(usd.format(10000));
	
	/**
	 * Combo Boxes for different currencies
	 */
	private String[] currencies = { "USD","EUR", "GBP" };
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox startCurrency = new JComboBox(currencies);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox endCurrency = new JComboBox(currencies);
	
	/**
	 * Panels for before and after conversion text fields/combo boxes
	 */
	private JPanel topRow = new JPanel();
	private JPanel bottomRow = new JPanel();
	
	/**
	 * Main method creates a new frame with constructor.
	 * @param args Command line arguments not used.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		CurrencyConverter converterFrame = new CurrencyConverter();
	}//end main
	
	/**
	 * Constructor for frame with title and packed size
	 */
	public CurrencyConverter(){
		addFields();
		addButton();
		
		add(topRow, BorderLayout.PAGE_START);
		add(bottomRow, BorderLayout.PAGE_END);
		
		pack();
		setTitle("Dolla' Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//end CurrencyConverter constructor

	/**
	 * Adds a button used to convert and listener.
	 */
	public void addButton(){
		
		/**
		 * Inner local class for listener
		 */
		class ConvertListener implements ActionListener {
			/**
			 * Calls the convert function when button is pressed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				convert();
			}//end actionPerformed
		}//end ConvertListener
		
		convertBtn.addActionListener(new ConvertListener());
		add(convertBtn, BorderLayout.CENTER);
	}//end addButton
	
	/**
	 * Adds fields and comboBoxes to panels
	 * and sets the endValue to not be editable
	 */
	private void addFields() {
		topRow.add(startCurrency);
		topRow.add(startValue);
		bottomRow.add(endCurrency);
		bottomRow.add(endValue);
		endValue.setEnabled(false);
	}//end addFields
	
	/**
	 * Gets value in startValue and converts it to new currency
	 * according to selected combo boxes.
	 */
	public void convert(){
		//Getting indexes for comboBoxes
		int startI = startCurrency.getSelectedIndex(),
			endI = endCurrency.getSelectedIndex();
		//0 = USD, 1 = EUR, 2 = GBP
		
		//checks whether commas are being used in decimal place and warns user
		if(startI == 1){
			if(startValue.getText().contains(",")){
				JOptionPane.showMessageDialog(new JFrame(), 
					"Delete thousands decimal and/or comma from Euro.");
				return;
			}
		}
		//ignoring any characters besides doubles
		double startVal = Double.parseDouble(startValue.getText().replaceAll("[^\\d.]", ""));

		//series for determining conversion ratio to use
		if(startI == endI){
			JOptionPane.showMessageDialog(new JFrame(), "Currencies must be different");
		} else if(startI == 0 && endI == 1){
			startValue.setText(usd.format(startVal));
			endValue.setText(eur.format(startVal/1.42));
		} else if(startI == 0 && endI == 2){
			startValue.setText(usd.format(startVal));
			endValue.setText(gbp.format(startVal/1.64));
		} else if(startI == 1 && endI == 0){
			startValue.setText(eur.format(startVal));
			endValue.setText(usd.format(startVal*1.42));
		} else if(startI == 1 && endI == 2){
			startValue.setText(eur.format(startVal));
			endValue.setText(gbp.format(startVal/1.13));
		} else if(startI == 2 && endI == 0){
			startValue.setText(gbp.format(startVal));
			endValue.setText(usd.format(startVal*1.64));
		} else if(startI == 2 && endI == 1){
			startValue.setText(gbp.format(startVal));
			endValue.setText(eur.format(startVal*1.13));
		}
	}//end convert

}//end CurrencyConverter
