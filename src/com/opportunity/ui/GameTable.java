package com.opportunity.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import com.opportunity.ui.clickactions.BlowUpClickAction;

/**
 * Models a game table.
 * 
 * @author Lance Alcabasa and Ryan Dimaunahan
 *
 */
public class GameTable extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4506145738493814977L;
	private int xSize = 1300;
	private int ySize = 730;
	
	private JPanel gameContent;
	
	private JTextArea textLog;
	
	
	/* Card Blowup panel elements */
	private JPanel blowupPanel;
	private Card blowupCard;
	private Card currentSelectedCard;
	private JPanel actionPanel;
	
	private Button btnEndTurn;
	private Button btnInvestOnOpportunity;
	private Button btnPurchaseAssetOrProperty;
	private Button btnInvestOnProperty;
	private Button btnMakePrimeInvestment;
	private Button btnSellPropertyOrAsset;
	private Button btnPlayEvent;
	
	
	/* Player panes */
	private PlayerPane player1Pane;
	private PlayerPane player2Pane;
	
	/* Player money */
	private JLabel player1Money;
	private JLabel player2Money;
	private JLabel player1SpendingLimit;
	private JLabel player2SpendingLimit;
	private JLabel player1Label;
	private JLabel player2Label;
	
	private OpportunityUI opportunityUI;
	
	/* Change reference to imageLoader to just opportunityUI */
	public GameTable(OpportunityUI opportunityUI, String title){
		this.opportunityUI = opportunityUI;
		this.setTitle("Opportunity by " + title);
		
		initBlowupPanel();
		initGameTable();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGameTable(){
		
		this.setSize(xSize,ySize);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(153, 255, 153));
		
		gameContent = new JPanel();
		gameContent.setSize(700,ySize-25);
		gameContent.setAlignmentX(LEFT_ALIGNMENT);
		gameContent.setLayout(new BoxLayout(gameContent,BoxLayout.Y_AXIS));
		gameContent.setOpaque(false);

		player1Pane = new PlayerPane(false, opportunityUI);
		player2Pane = new PlayerPane(true, opportunityUI);
		
		player1Label = new JLabel("Player 1");
		player1Label.setBounds(10, ySize - 225, 250, 25);
		player1Money = new JLabel("PHP 1,000.00");
		player1Money.setBounds(10, ySize - 205, 250, 25);
		player1SpendingLimit = new JLabel("Limit: 10,000.00");
		player1SpendingLimit.setBounds(10, ySize - 185 , 250, 25);
		
		player2Label = new JLabel("Player 2");
		player2Label.setBounds(10, 120, 250, 25);
		player2Money = new JLabel("PHP 1,000.00");
		player2Money.setBounds(10, 140 , 250, 25);
		player2SpendingLimit = new JLabel("Limit: 10,000.00");
		player2SpendingLimit.setBounds(10, 160 , 250, 25);
		
		textLog = new JTextArea();
		textLog.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createLineBorder(Color.WHITE, 5)));
		textLog.setEditable(false);
		
		JLabel textLogLabel = new JLabel ("Game Log: ");
		textLogLabel.setBounds(985, 5, 300, 25);
		
		JScrollPane textLogScrollPane = new JScrollPane(textLog);
		textLogScrollPane.setBounds(983, 30, 300, ySize-70);
		textLogScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textLogScrollPane.setAutoscrolls(true);
		textLogScrollPane.setWheelScrollingEnabled(true);
		
		gameContent.add(player2Pane);
		gameContent.add(player1Pane);
		
		this.add(player1Label);
		this.add(player1Money);
		this.add(player1SpendingLimit);
		this.add(player2Label);
		this.add(player2Money);
		this.add(player2SpendingLimit);
		this.add(blowupPanel);
		this.add(gameContent);
		this.add(textLogScrollPane);
		this.add(textLogLabel);
	}
	
	private void initBlowupPanel(){
		
		blowupPanel = new JPanel();
		blowupPanel.setBounds(580,200,405,300);
		blowupPanel.setOpaque(false);
		
		blowupCard = new Card();
		blowupCard.setPreferredSize(Card.BLOWUP_CARD_DIMENSION);
		blowupCard.setBorder(BorderFactory.createLineBorder(Color.black));
		blowupCard.setBackground(Card.EMPTY_COLOR);
		blowupCard.setOpaque(true);
		
		actionPanel = new JPanel();
		actionPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		actionPanel.setPreferredSize(new Dimension (175, 250));
		actionPanel.setOpaque(false);
		
		JLabel actionsLabel = new JLabel("Possible Actions");
		actionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionsLabel.setPreferredSize(new Dimension(175, 30));
		
		btnEndTurn = new Button("End the Turn");
		btnInvestOnOpportunity = new Button("Invest on Opportunity");
		btnPurchaseAssetOrProperty = new Button("Purchase this Card");
		btnInvestOnProperty = new Button("Invest on this Property");
		btnMakePrimeInvestment = new Button("Make Prime Investment");
		btnSellPropertyOrAsset = new Button("Sell this Card");
		btnPlayEvent = new Button("Play this Event Card");
		
		actionPanel.add(actionsLabel);
		actionPanel.add(btnEndTurn);
		actionPanel.add(btnInvestOnOpportunity);
		actionPanel.add(btnPurchaseAssetOrProperty);
		actionPanel.add(btnInvestOnProperty);
		actionPanel.add(btnMakePrimeInvestment);
		actionPanel.add(btnSellPropertyOrAsset);
		actionPanel.add(btnPlayEvent);
		
		blowupPanel.add(blowupCard);
		blowupPanel.add(actionPanel);
		
	}
	
	/*
	 * DevNotes (Ryan)
	 * 
	 * Sample helper method
	 */
	public void addMouseListenerToElement(MouseListener listener, JComponent element) {
		element.addMouseListener(listener);
	}

	/**
	 * This method gets the PlayerPane of the first player.
	 * @return The PlayerPane of the first player.
	 */
	public PlayerPane getPlayer1Pane() {
		return player1Pane;
	}

	/**
	 * This method gets the PlayerPane of the second player.
	 * @return The PlayerPane of the second player.
	 */
	public PlayerPane getPlayer2Pane() {
		return player2Pane;
	}

	/**
	 * Gets the text log that appears on the side of the screen.
	 * @return The JTextArea object corresponding to the text log on the side of the screen
	 */
	public JTextArea getTextLog() {
		return textLog;
	}

	/**
	 * Gets the "End the Turn" button. Use this to assign a click action to the "End the Turn" button.
	 * 
	 * @return the "End the Turn" button 
	 */
	public Button getBtnEndTurn() {
		return btnEndTurn;
	}

	/**
	 * Gets the "Invest on Opportunity" button. Use this to assign a click action to the "Invest on Opportunity" button.
	 * 
	 * @return the "Invest on Opportunity" button 
	 */
	public Button getBtnInvestOnOpportunity() {
		return btnInvestOnOpportunity;
	}

	/**
	 * Gets the "Purchase this Card" button. Use this to assign a click action to the "Purchase this Card" button.
	 * 
	 * @return the "Purchase this Card" button 
	 */
	public Button getBtnPurchaseAssetOrProperty() {
		return btnPurchaseAssetOrProperty;
	}

	/**
	 * Gets the "Invest on this Property" button. Use this to assign a click action to the "Invest on this Property" button.
	 * 
	 * @return the "Invest on this Property" button 
	 */
	public Button getBtnInvestOnProperty() {
		return btnInvestOnProperty;
	}

	/**
	 * Gets the "Make Prime Investment" button. Use this to assign a click action to the "Make Prime Investment" button.
	 * 
	 * @return the "Make Prime Investment" button 
	 */
	public Button getBtnMakePrimeInvestment() {
		return btnMakePrimeInvestment;
	}

	/**
	 * Gets the "Sell this Card" button. Use this to assign a click action to the "Sell this Card" button.
	 * 
	 * @return the "Sell this Card" button 
	 */
	public Button getBtnSellPropertyOrAsset() {
		return btnSellPropertyOrAsset;
	}

	/**
	 * Gets the "Play this Event Card" button. Use this to assign a click action to the "Play this Event Card" button.
	 * 
	 * @return the "Play this Event Card" button 
	 */
	public Button getBtnPlayEvent() {
		return btnPlayEvent;
	}

	/**
	 * Gets the label that displays the Card Blow Up. Use this method to change the image in the Card Blow Up label.
	 * 
	 * @return the Card Blow Up label
	 */
	public Card getBlowupCard() {
		return blowupCard;
	}

	/**
	 * Gets the label that contains the money of player 1. Use this method to change the money of player 1.
	 * 
	 * @return The label that contains the money of player 1.
	 */
	public JLabel getPlayer1Money() {
		return player1Money;
	}

	/**
	 * Gets the label that contains the money of player 2. Use this method to change the money of player 2.
	 * 
	 * @return The label that contains the money of player 2.
	 */
	public JLabel getPlayer2Money() {
		return player2Money;
	}

	/**
	 * Gets the label that contains the name of player 1. Use this method to change the name of player 1.
	 * 
	 * @return The label that contains the name of player 1.
	 */
	public JLabel getPlayer1Label() {
		return player1Label;
	}

	/**
	 * Gets the label that contains the name of player 2. Use this method to change the name of player 2.
	 * 
	 * @return The label that contains the name of player 2.
	 */
	public JLabel getPlayer2Label() {
		return player2Label;
	}

	/**
	 * Gets the OpportunityUI reference of this GameTable.
	 * 
	 * @return the reference to the OpportunityUI of this GameTable.
	 */
	public OpportunityUI getOpportunityUI() {
		return opportunityUI;
	}

	/**
	 * Gets the currently selected card. This is the card that is currently being blown up in the Blow Up card
	 * label.
	 * 
	 * @return the currently selected card.
	 */
	public Card getCurrentSelectedCard() {
		return currentSelectedCard;
	}

	/**
	 * Sets the currently selected card, which is the card that is currently being blown up. Note that this will
	 * NOT automatically change the image of the blown up card. That is handled by the {@link BlowUpClickAction}.
	 * In fact, the only class that should use this method is the {@link BlowUpClickAction} class. Do not call this 
	 * method unless you are absolutely certain you need to do so.
	 * 
	 * @param currentSelectedCard the new currently selected card. This is the card you set to the Blow Up card.
	 * @see BlowUpClickAction
	 */
	public void setCurrentSelectedCard(Card currentSelectedCard) {
		this.currentSelectedCard = currentSelectedCard;
	}

	/**
	 * Gets the label that contains the spending limit of player 1. Use this method to change the spending limit of player 1.
	 * 
	 * @return The label that contains the spending limit of player 1.
	 */
	public JLabel getPlayer1SpendingLimit() {
		return player1SpendingLimit;
	}

	/**
	 * Gets the label that contains the spending limit of player 2. Use this method to change the spending limit of player 2.
	 * 
	 * @return The label that contains the spending limit of player 2.
	 */
	public JLabel getPlayer2SpendingLimit() {
		return player2SpendingLimit;
	}
	
}
