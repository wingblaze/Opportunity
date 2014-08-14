package com.opportunity.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * This class represents the common elements of each player's display. These common elements include the player's deck,
 * hand, investments, prime investments and event card slots. 
 * 
 * @author Lance Alcabasa and Ryan Dimaunahan
 *
 */
public class PlayerPane extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7635836658600782334L;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	
	/* Top panel elements */
	//private JLabel eventCard;
	private Card primeInvesment;
	
	/* Middle panel elements */
	private Card[] investments = new Card[5]; 
	
	/* Bottom panel elements */
	private JButton deck;
	private JScrollPane handScrollPane;
	private JPanel handPanel;
	private Card discardPile;
	
	private OpportunityUI opportunityUI;
	
	/* Misc Elements */
	
	public PlayerPane(boolean reverse, OpportunityUI opportunityUI){
		
		this.opportunityUI = opportunityUI;
		
		this.setPreferredSize(new Dimension(900,400));
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setVisible(true);
		
		topPanel = new JPanel(); 
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER,110,0));
		topPanel.setOpaque(false);
		
		middlePanel = new JPanel();
		
		middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
		middlePanel.setOpaque(false);
		
		bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		
//		eventCard = new JLabel();
//		eventCard.setPreferredSize(Card.MEDIUM_CARD_DIMENSION);
//		eventCard.setBorder(BorderFactory.createLineBorder(Color.blue));

		primeInvesment = new Card();
		primeInvesment.setBorder(BorderFactory.createLineBorder(Color.green));
		primeInvesment.setPreferredSize(Card.MEDIUM_CARD_DIMENSION);
		
		for(int i = 0; i < investments.length; i++){
			investments[i] = new Card();
			investments[i].setPreferredSize(Card.MEDIUM_CARD_DIMENSION);
			investments[i].setBorder(BorderFactory.createLineBorder(Color.black));
		}
		
		deck = new JButton("Deck: 40");
		deck.setPreferredSize(new Dimension(90,110));
		deck.setBackground(Button.DEFAULT_COLOR);
		
		handPanel = new JPanel();
		handScrollPane = new JScrollPane(handPanel);
		handScrollPane.setPreferredSize(new Dimension(500,120));

		discardPile = new Card("Discard: 0");
		discardPile.setBorder(BorderFactory.createLineBorder(Color.RED));
		discardPile.setPreferredSize(new Dimension(80,110));
		discardPile.setHorizontalAlignment(SwingConstants.CENTER);

		
		topPanel.add(Box.createRigidArea(Card.MEDIUM_CARD_DIMENSION));
		//topPanel.add(eventCard);
		topPanel.add(primeInvesment);
		topPanel.add(Box.createRigidArea(Card.MEDIUM_CARD_DIMENSION));
		
		
		for(int i = 0; i < investments.length; i++){
			middlePanel.add(investments[i]);
		}
		
		bottomPanel.add(deck);
		bottomPanel.add(handScrollPane);
		bottomPanel.add(discardPile);
		
		if (reverse)
		{
			this.add(bottomPanel);
			this.add(middlePanel);
			this.add(topPanel);
		}
		else
		{
			this.add(topPanel);
			this.add(middlePanel);
			this.add(bottomPanel);
		}
		
		this.setOpaque(false);
	}

	public JButton getDeck() {
		return deck;
	}

	public void setDeck(JButton deck) {
		this.deck = deck;
	}
	
	public Card getDiscardPile() {
		return this.discardPile;
	}

	public Card[] getInvestments() {
		return investments;
	}

	public Card getPrimeInvesment() {
		return primeInvesment;
	}
	
	/**
	 * Gets the collection of cards inside the handPanel component, which represents the cards in hand of the player
	 * 
	 * @return cardsInHand is the collection of cards stored inside handPanel
	 */
	public ArrayList<Card> getHand(){
		ArrayList<Card> cardsInHand = new ArrayList<>();
		
		for(Component cardObj:handPanel.getComponents())
			cardsInHand.add((Card)cardObj);
		
		return cardsInHand;
	}
	
	/**
	 * Method for drawing a card for the player. This method should draw 1 card from the top of the deck.
	 * Drawing a card should result in the following:
	 * 	- Resources are subtracted from the player drawing the card
	 * 	- The card is removed from the deck
	 * 	- The card is added to the player's hand
	 */
	public void drawCard(){
		
		/* PLACE YOUR CODE TO DRAW A CARD FROM YOUR DECK (CARD LIST) HERE. 
		 * THIS INCLUDES DECREMENTING FROM THE LIST OF CARDS AND SUBTRACTING
		 * FROM THE PLAYER RESOURCES */
		
		/* CODE BELOW ARE FOR THE UI */

		Card dummy = new Card(); //Dummy Card ... replace this with the drawn card from your implementation above
		dummy.setImage(this.opportunityUI.getCardImageLoader().getMediumImageIconFor(CardImageLoader.BIR_HUNTING_BEGINS));
		dummy.setSize(Card.MEDIUM_CARD_DIMENSION);
		this.opportunityUI.getBca().addTrigger(dummy);
		
		handPanel.add(dummy);
		handPanel.revalidate();
		handPanel.repaint();
		
		deck.setText("Deck: X"); //replace X with the remaining card number
	}
	
	/**
	 * Adds a card to the hand of the player, given an integer that represents the image that will be used in the card.
	 * This method instantiates the card and sets its image to the image passed, then adds that instantiated card to the
	 * hand of the player. Use a constant in the CardImageLoader to select which image the generated card will have.
	 * 
	 * @param image the image of the card that will be added to the hand of the player. Use a costant of the CardImageLoader class to accomplish this.
	 * @see CardImageLoader
	 */
	public void addCardToHand(int image) {
		Card card = new Card();
		card.setImage(this.opportunityUI.getCardImageLoader().getMediumImageIconFor(image));
		
		this.addCardToHand(card);
	}
	
	/**
	 * Adds an instance of a card to the hand of the player. Call this method if you have an instance of a card already,
	 * otherwise, you may call the overloaded method addCardToHand(int) passing a constant of the CardImageLoader.
	 * 
	 * @param card the card instance you want to add to the hand of the player.
	 */
	public void addCardToHand(Card card) {
		this.opportunityUI.getBca().addTrigger(card);
		
		handPanel.add(card);
		handPanel.revalidate();
		handPanel.repaint();
	}
	
	/**
	 * Method for removing a card from hand. Note that this method will only remove the card from the player's hand,
	 * but will not perform any other events that needs to be performed such as: placing the card into Investment space
	 * or playing an Event card. Create your own logic or method for performing these events.
	 * 
	 * @param index is an integer parameter that specifies the index of the component to remove from the hand.
	 */
	public void removeFromHand(int index){
		handPanel.remove(index);
		handPanel.revalidate();
		handPanel.repaint();
	}
	
	/**
	 * Method for removing a card from hand. Note that this method will only remove the card from the player's hand,
	 * but will not perform any other events that needs to be performed such as: placing the card into Investment space
	 * or playing an Event card. Create your own logic or method for performing these events.
	 * 
	 * @param c is a Card parameter that specifies the Card object to remove from the hand.
	 */
	public void removeFromHand(Card c){
		handPanel.remove(c);
		handPanel.revalidate();
		handPanel.repaint();
	}
	
}
