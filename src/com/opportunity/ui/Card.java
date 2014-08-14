package com.opportunity.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This class models one Card Label on the screen. All the labels that display cards (except perhaps the Discard and the Deck,
 * which do not directly display a card image anyway) are instances of this Card class.
 * 
 * @author Ryan Dimaunahan and Lance Alcabasa
 *
 */
public class Card extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6990146253295690365L;
	public static final int SMALL_CARD_WIDTH = 64;
	public static final int SMALL_CARD_HEIGHT = 82;
	public static final Dimension SMALL_CARD_DIMENSION = new Dimension(SMALL_CARD_WIDTH,SMALL_CARD_HEIGHT);
	
	public static final int MEDIUM_CARD_WIDTH = 72;
	public static final int MEDIUM_CARD_HEIGHT = 92;
	public static final Dimension MEDIUM_CARD_DIMENSION = new Dimension(MEDIUM_CARD_WIDTH,MEDIUM_CARD_HEIGHT);
	
	public static final int BLOWUP_CARD_WIDTH = 212;
	public static final int BLOWUP_CARD_HEIGHT = 272;
	public static final Dimension BLOWUP_CARD_DIMENSION = new Dimension(BLOWUP_CARD_WIDTH,BLOWUP_CARD_HEIGHT);
	
	public static final Color EMPTY_COLOR = new Color(230, 230, 230);
	public static final Color DEFAULT_FILLED_COLOR = new Color(255, 153, 51);
	
	private boolean empty;
	private int currentImage;
	
	/**
	 * Creates one card, sets the text of the card to the value of count (this will show on the screen) and initializes 
	 * its default properties (medium sized, blue border).
	 * 
	 * @param count is the number that will be displayed on the card.
	 */
	public Card(int count) {
		super(count + "");
		initCard();
		this.setEmpty(false);
	}
	
	/**
	 * Creates one card, sets its name to the String parameter passed (this will show on the screen) and initializes 
	 * its default properties (medium sized, blue border).
	 * 
	 * @param name is the text that will be displayed on the card.
	 */
	public Card(String name) {
		super(name);
		initCard();
		this.setEmpty(false);
	}
	
	/**
	 * Creates one card and initializes its default properties (medium sized, blue border).
	 */
	public Card() {
		initCard();
	}

	private void initCard() {
		this.setPreferredSize(MEDIUM_CARD_DIMENSION);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
		this.setEmpty(true);
		this.setOpaque(true);
	}
	
	/**
	 * This method changes the size of the card. Use the constants defined in the {@link CardImageLoader} class to select
	 * which card size to change this card into.
	 * 
	 * @param dimension is the new size of the card. Use the constants defined in the CardImageLoader class.
	 * @see CardImageLoader
	 */
	public void changeSize(int dimension){
		switch(dimension){
		case CardImageLoader.SMALL: this.setPreferredSize(SMALL_CARD_DIMENSION); break;
		case CardImageLoader.MEDIUM: this.setPreferredSize(MEDIUM_CARD_DIMENSION); break;
		case CardImageLoader.LARGE: this.setPreferredSize(BLOWUP_CARD_DIMENSION); break;
		}
		
	}
	
	/**
	 * Set the emtpy property of this card. Also removes the current image of the card in case the value was set to false.
	 * Setting this to true without changing the card image would result in a color-filled card without a card image, so
	 * use this method with care.
	 * 
	 * @param isEmpty a boolean value that tells whether the card should be emtpy or not.
	 */
	public void setEmpty(boolean isEmpty) {
		this.empty = isEmpty;
		if (this.empty == true) {
			this.setBackground(EMPTY_COLOR);
			this.currentImage = CardImageLoader.NO_IMAGE;
			this.setIcon(null);
		} else {
			this.setBackground(DEFAULT_FILLED_COLOR);
		}
	}
	
	/**
	 * This method checks if the card is currently empty.
	 * 
	 * @return true if the card is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.empty;
	}
	
	/**
	 * This method sets the ImageIcon of the card. To use this method, please use the corresponding methods from
	 * the CardImageLoader class. For example, to set the card image of an investment card label, you may use
	 * the following method call from within your ClickAction subclass:
	 *
	 * <code>this.getOpportunityUI().getInvestmentCardOfPlayer(1, 0).setImage(this.getOpportunityUI().getCardImageLoader().getLargeImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0))</code>
	 * 
	 * Or you may use the various helper methods from getOpportunityUI:
	 * 
	 * <code>this.getOpportunityUI().setCardImageOfInvestmentCard(1, 0, CardImageLoader.KAREN_DAIRY_A_LVL0)</code>
	 * 
	 * The two codes perform the same task.
	 * 
	 * @param icon the image you want to set as the image of the card. Use the CardImageLoader to load the specific card image.
	 * @see <a href="CardImageLoader.html">CardImageLoader</a>
	 */
	public void setImage(ImageIcon icon) {
		this.setIcon(icon);
		String fileName = icon.getDescription();
		this.currentImage = CardImageLoader.FILE_NAMES.indexOf(fileName);
		this.setEmpty(false);;
	}
	
	/**
	 * This method removes the current image of the card and makes the card empty. This method automatically calls
	 * the setEmpty() method of the card to empty the card.
	 */
	public void removeImage() {
		this.setIcon(null);
		this.setEmpty(true);
	}

	/**
	 * This method returns an integer value corresponding to the current image currently being displayed by the card. If
	 * the card is empty, this method will return the value of the constant CardImageLoader.NO_IMAGE.
	 * 
	 * @return integer current Image of this card corresponding to the constants in the CardImageLoader class
	 * @see <a href="CardImageLoader.html">CardImageLoader</a>
	 */
	public int getCurrentImage() {
		return currentImage;
	}

}
