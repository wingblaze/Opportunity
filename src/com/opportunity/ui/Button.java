package com.opportunity.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

/**
 * This class models one button on the screen.
 * 
 * @author Ryan Dimaunahan and Lance Alcabasa
 *
 */
public class Button extends JButton {
	
	public static final Color DEFAULT_COLOR = new Color(153, 204, 255);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1090838074468472556L;

	/**
	 * Constructor that creates one button with the String as the text.
	 * 
	 * @param string is the text of the button.
	 */
	public Button(String string) {
		super(string);
		initializeComponent();
	}
	
	private void initializeComponent() {
		this.setBackground(DEFAULT_COLOR);
		this.setPreferredSize(new Dimension(175, 26));
	}


	
	

}
