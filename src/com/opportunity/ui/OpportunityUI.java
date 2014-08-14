package com.opportunity.ui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.opportunity.ui.clickactions.BlowUpClickAction;

/**
 * A class that models one Opportunity Game UI. Students would be making use of this to generate the UI
 * and control the Opportunity Game itself.
 * 
 * @author Ryan Dimaunahan and Lance Alcabasa
 *
 */
public class OpportunityUI {
	
	private GameTable gameTable;
	private CardImageLoader cardImageLoader;
	private BlowUpClickAction bca;
	
	/**
	 * Constructor that instantiates the Opportunity Game. This constructor also sets the look and feel of
	 * the interface to the CrossPlatformLookAndFeel look and feel of Java.
	 * 
	 */
	public OpportunityUI(String title) {
		try {
	        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		/* TODO: UNCOMMENT THIS LINE. COMMENTING OUT TO IMPROVE LOAD SPEED TEMPORARILY */
		this.cardImageLoader = new CardImageLoader();
		
		this.gameTable = new GameTable(this, title);
		this.addPreBuiltClickActions();
		
		this.gameTable.getPlayer1Pane().getPrimeInvesment().setImage(this.getCardImageLoader().getMediumImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0));
	}
	
	private void addPreBuiltClickActions() {
		ArrayList<JComponent> sources = new ArrayList<JComponent>();
		
		for(JComponent source:this.gameTable.getPlayer1Pane().getInvestments()) {
			sources.add(source);
		}
		
		for(JComponent source:this.gameTable.getPlayer2Pane().getInvestments()) {
			sources.add(source);
		}
		
		sources.add(this.gameTable.getPlayer1Pane().getPrimeInvesment());
		sources.add(this.gameTable.getPlayer2Pane().getPrimeInvesment());
		
		bca = new BlowUpClickAction(sources);
		this.addClickAction(bca);
	}
	
	/**
	 * Starts the game by displaying the UI.
	 */
	public void start() {
		gameTable.setVisible(true);
		//for (int i = 0; i < 21; i++)
		//	gameTable.getPlayer1Pane().addCardToHand(i);
	}
	
	public BlowUpClickAction getBca() {
		return bca;
	}

	/**
	 * Sets the card count displayed on the deck button on the screen, however, this does not actually
	 * change the number of cards in the deck, it merely alters the display. Call this method whenever
	 * you change the card count of the actual Deck in your implementation so that the value displayed
	 * on the deck button on the screen would match the actual card count.
	 * 
	 * @param deckCardCount is the new cardCount.
	 * @param playerNumber is the player number of the player whose deck count you want to change (1 or 2).
	 */
	public void setDeckCardCountOfPlayer (int deckCardCount, int playerNumber) {
		if (playerNumber == 1) {
			gameTable.getPlayer1Pane().getDeck().setText("Deck: " + deckCardCount);
		} else {
			gameTable.getPlayer2Pane().getDeck().setText("Deck: " + deckCardCount);
		}
	}
	
	/**
	 * Gets the deck button on the game screen of a player. Use this method if you want to assign Click Actions
	 * to the deck of a particular player. See {@link ClickAction} to know more about this.
	 * 
	 * @param playerNumber is the player number of the player whose deck you want to get (1 or 2).
	 * @return the deck button of the player
	 * @see ClickAction
	 */
	public JButton getDeckOfPlayer (int playerNumber) {
		if (playerNumber == 1) {
			return gameTable.getPlayer1Pane().getDeck();
		}
		else {
			return gameTable.getPlayer2Pane().getDeck();
		}
	}
	
	/**
	 * <p>This method appends text to the Game Log. The Game Log serves as an action history; every time a
	 * player makes an action it must be logged in the Game Log. You may follow the sample shown below:</p>
	 * 
	 * <code>
	 *   GAME START<br>
	 *   <br>
	 *   IT'S PLAYER 1'S TURN!<br>
	 *   Player 1 invests in opportunity!<br>
	 *   Player 1 draws a card from the deck.<br>
	 *   Player 1 invests in opportunity! Double Opportunity!<br>
	 *   Player 2 draws a card from the deck.<br>
	 *   Player 1 ends the turn!<br>
	 *   <br>
	 *   IT'S PLAYER 1'S TURN!<br>
	 *   ...<br>
	 *   
	 * </code>
	 * 
	 * <p>Remember that you may use <code>\n</code> to display a new line in the Game Log.</p>
	 * 
	 * @param newText additional text to append to the end of the Game Log.
	 */
	public void appendTextToTextLog (String newText) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(gameTable.getTextLog().getText());
		if (!sb.toString().equals("")) sb.append("\n");
		sb.append(newText);
		
		gameTable.getTextLog().setText(sb.toString());
	}
	
	/**
	 * Sets the card count displayed on the discard pile on the screen, however, this does not actually
	 * change the number of cards in the discard pile, it merely alters the display. Call this method whenever
	 * you change the card count of the actual Discard Pile in your implementation so that the value displayed
	 * on the discard pile on the screen would match the actual card count.
	 * 
	 * @param discardCardCount is the new cardCount.
	 * @param playerNumber is the player number of the player whose deck count you want to change (1 or 2).
	 */
	public void setDiscardCardCountOfPlayer (int discardCardCount, int playerNumber) {
		if (playerNumber == 1) {
			gameTable.getPlayer1Pane().getDiscardPile().setText("Discard: " + discardCardCount);
		} else {
			gameTable.getPlayer2Pane().getDiscardPile().setText("Discard: " + discardCardCount);
		}
	}
	
	/**
	 * Gets the discard pile on the game screen of a player. Use this method if you want to assign Click Actions
	 * to the discard pile of a particular player. See {@link ClickAction} to know more about this.
	 * 
	 * @param playerNumber is the player number of the player whose discard pile you want to get (1 or 2).
	 * @return the deck button of the player
	 * @see ClickAction
	 */
	public Card getDiscardPileOfPlayer (int playerNumber) {
		if (playerNumber == 1) {
			return gameTable.getPlayer1Pane().getDiscardPile();
		}
		else {
			return gameTable.getPlayer2Pane().getDiscardPile();
		}
	}
	
	/**
	 * Adds a Click Action to the Opportunity UI.
	 * 
	 * @param clickAction the click action you want to add to the Opportunity UI.
	 * @see ClickAction
	 */
	public void addClickAction(ClickAction clickAction) {
		clickAction.setOpportunityUI(this);
	}

	/**
	 * <p>Gets the Card Image Loader helper defined in the OpportunityUI. Use this in combination with the other helper methods
	 * of the OpportunityUI to modify the cards being shown in the card labels of the UI.</p>
	 * 
	 * <p>For example, in an OpportunityClickAction subclass, you may use the following code to alter the card image
	 * currently loaded in the Blow Up Card label:</p>
	 * 
	 * <code>this.getOpportunityUI().getBlowupCard().setImage(this.getOpportunityUI().getCardImageLoader().getLargeImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0));</code>
	 * 
	 * <p>Note that the getLargeImageIconFor() method was used because the blow up card label requires a large sized image. For the
	 * investments and prime investments labels, use getMediumImageIconFor() instead.
	 *  
	 * @return the CardImageLoader that is automatically created along with the OpportunityUI
	 * @see ClickAction
	 * @see CardImageLoader
	 * @see Card
	 */
	public CardImageLoader getCardImageLoader() {
		return cardImageLoader;
	}
	
	/**
	 * Gets the "End the Turn" button. Use this to assign a click action to the "End the Turn" button.
	 * 
	 * @return the "End the Turn" button
	 * @see ClickAction
	 */
	public Button getBtnEndTurn() {
		return this.gameTable.getBtnEndTurn();
	}
	
	/**
	 * Sets the visibility of the "End the Turn" button. Use this to hide or show the "End the Turn" button.
	 * 
	 * @param visible The visibility of the "End the Turn" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnEndTurn(boolean visible) {
		this.gameTable.getBtnEndTurn().setVisible(visible);
	}

	/**
	 * Gets the "Invest on Opportunity" button. Use this to assign a click action to the "Invest on Opportunity" button.
	 * 
	 * @return the "Invest on Opportunity" button 
	 * @see ClickAction
	 */
	public Button getBtnInvestOnOpportunity() {
		return this.gameTable.getBtnInvestOnOpportunity();
	}
	
	/**
	 * Sets the visibility of the "Invest on Opportunity" button. Use this to hide or show the "Invest on Opportunity" button.
	 * 
	 * @param visible The visibility of the "Invest on Opportunity" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnInvestOnOpportunity(boolean visible) {
		this.gameTable.getBtnInvestOnOpportunity().setVisible(visible);
	}

	/**
	 * Gets the "Purchase this Card" button. Use this to assign a click action to the "Purchase this Card" button.
	 * 
	 * @return the "Purchase this Card" button 
	 * @see ClickAction
	 */
	public Button getBtnPurchaseAssetOrProperty() {
		return this.gameTable.getBtnPurchaseAssetOrProperty();
	}
	
	/**
	 * Sets the visibility of the "Purchase this Card" button. Use this to hide or show the "Purchase this Card" button.
	 * 
	 * @param visible The visibility of the "Purchase this Card" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnPurchaseAssetOrProperty(boolean visible) {
		this.gameTable.getBtnPurchaseAssetOrProperty().setVisible(visible);
	}

	/**
	 * Gets the "Invest on this Property" button. Use this to assign a click action to the "Invest on this Property" button.
	 * 
	 * @return the "Invest on this Property" button 
	 * @see ClickAction
	 */
	public Button getBtnInvestOnProperty() {
		return this.gameTable.getBtnInvestOnProperty();
	}
	
	/**
	 * Sets the visibility of the "Invest on this Property" button. Use this to hide or show the "Invest on this Property" button.
	 * 
	 * @param visible The visibility of the "Invest on this Property" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnInvestOnProperty(boolean visible) {
		this.gameTable.getBtnInvestOnProperty().setVisible(visible);
	}

	/**
	 * Gets the "Make Prime Investment" button. Use this to assign a click action to the "Make Prime Investment" button.
	 * 
	 * @return the "Make Prime Investment" button 
	 * @see ClickAction
	 */
	public Button getBtnMakePrimeInvestment() {
		return this.gameTable.getBtnMakePrimeInvestment();
	}
	
	/**
	 * Sets the visibility of the "Make Prime Investment" button. Use this to hide or show the "Make Prime Investment" button.
	 * 
	 * @param visible The visibility of the "Make Prime Investment" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnMakePrimeInvestment(boolean visible) {
		this.gameTable.getBtnMakePrimeInvestment().setVisible(visible);
	}

	/**
	 * Gets the "Sell this Card" button. Use this to assign a click action to the "Sell this Card" button.
	 * 
	 * @return the "Sell this Card" button 
	 * @see ClickAction
	 */
	public Button getBtnSellPropertyOrAsset() {
		return this.gameTable.getBtnSellPropertyOrAsset();
	}
	
	/**
	 * Sets the visibility of the "Sell this Card" button. Use this to hide or show the "Sell this Card" button.
	 * 
	 * @param visible The visibility of the "Sell this Card" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnSellPropertyOrAsset(boolean visible) {
		this.gameTable.getBtnSellPropertyOrAsset().setVisible(visible);
	}

	/**
	 * Gets the "Play this Event Card" button. Use this to assign a click action to the "Play this Event Card" button.
	 * 
	 * @return the "Play this Event Card" button 
	 * @see ClickAction
	 */
	public Button getBtnPlayEvent() {
		return this.gameTable.getBtnPlayEvent();
	}
	
	/**
	 * Sets the visibility of the "Play this Event Card" button. Use this to hide or show the "Play this Event Card" button.
	 * 
	 * @param visible The visibility of the "Play this Event Card" button. 
	 * @see ClickAction
	 */
	public void setVisibleBtnPlayEvent(boolean visible) {
		this.gameTable.getBtnPlayEvent().setVisible(visible);
	}

	/**
	 * Gets the label that displays the Card Blow Up. Use this method to change the image in the Card Blow Up label, or
	 * if you want to assign Click Actions to the Card Blow Up.  See the {@link CardImageLoader} class for more
	 * information on how to load card image and the {@link ClickAction} class for more information on how
	 * to create Click Actions.
	 * 
	 * @return the Card Blow Up label
	 * @see ClickAction
	 * @see CardImageLoader
	 */
	public Card getBlowupCard() {
		return this.gameTable.getBlowupCard();
	}
	
	/**
	 * Gets all five investment cards of a player, given the player number, as an array of cards. You may use array
	 * indexing to get the specific investment card that you need. Remember that array indexing starts at 0.
	 * Use this method to change the image in that particular investment card or to assign Click Actions to a specific
	 * investment card. See the {@link CardImageLoader} class for more information on how to load card images and the 
	 * {@link ClickAction} class for more information on how to create Click Actions.
	 * 
	 * @param player is the player number of the player whose investment cards you want to get (1 or 2).
	 * @return an array of cards corresponding to the investment cards of the selected player.
	 * @see ClickAction
	 * @see CardImageLoader
	 */
	public Card[] getInvestmentsOfPlayer (int player) {
		if (player == 1) {
			return this.gameTable.getPlayer1Pane().getInvestments();
		}
		else {
			return this.gameTable.getPlayer2Pane().getInvestments();
		}
	}
	
	/**
	 * Gets a specific investment card on the board, given the player number and an investment card number. The investment
	 * card number must be a value from 0 to 4, if another value is given, this method would throw {@link IndexOutOfBoundsException}.
	 * Use this method to change the image in that particular investment card or to assign Click Actions to a specific
	 * investment card. See the {@link CardImageLoader} class for more information on how to load card images and the 
	 * {@link ClickAction} class for more information on how to create Click Actions.
	 * 
	 * @param player is the player number of the player whose investment card you want to get (1 or 2).
	 * @param investmentCardNumber is the card number of the investment card you want to get.
	 * @return the card label that corresponds to one investment card in the game board.
	 * 
	 * @see ClickAction
	 * @see CardImageLoader
	 */
	public Card getInvestmentCardOfPlayer (int player, int investmentCardNumber) {
		if (player == 1) {
			return this.gameTable.getPlayer1Pane().getInvestments()[investmentCardNumber];
		}
		else {
			return this.gameTable.getPlayer2Pane().getInvestments()[investmentCardNumber];
		}
	}
	
	/**
	 * Gets the prime investment card of a player, given the player number. Use this method if you want to change the card
	 * image on that particular prime investment card or to assign Click Actions to a prime investment card. See the 
	 * {@link CardImageLoader} class for more information on how to load card images and the {@link ClickAction} 
	 * class for more information on how to create Click Actions.
	 * 
	 * @param player is the player number of the player whose prime investment card you want to get (1 or 2).
	 * @return the prime investment card of that player.
	 * 
	 * @see ClickAction
	 * @see CardImageLoader
	 */
	public Card getPrimeInvestmentCardOfPlayer (int player) {
		if (player == 1) {
			return this.gameTable.getPlayer1Pane().getPrimeInvesment();
		}
		else {
			return this.gameTable.getPlayer2Pane().getPrimeInvesment();
		}
	}
	
	/**
	 * This is a helper method that sets the image on a particular investment card. Use the constants defined in the 
	 * CardImageLoader to select which image to load. This method does the same thing as getting the Investment Card first
	 * using the getInvestmentCardOfPlayer() method then setting its image by calling the setImage() method passing a relevant
	 * method call of the CardImageLoader of the OpporunityUI. 
	 * 
	 * Basically, this method is here to make your job easier. 
	 * 
	 * @param playernumber is the player number of the player whose investment card you want to get (1 or 2).
	 * @param investmentCardNumber is the number of the card that specifies which card to get from the player
	 * @param image is the image you want to load. Use the constants defined in CardImageLoader to select which image to load.
	 * 
	 * @see CardImageLoader
	 */
	public void setCardImageOfInvestmentCard (int playernumber, int investmentCardNumber, int image) {
		this.getInvestmentCardOfPlayer(playernumber, investmentCardNumber).setImage(this.getCardImageLoader().getMediumImageIconFor(image));
	}
	
	/**
	 * This helper method removes the image on a particular investment card. This method also automatically empties the
	 * investment card.
	 * 
	 * @param playernumber is the player number of the player whose investment card you want to get (1 or 2).
	 * @param investmentCardNumber is the card number of the investment card you want to empty.
	 */
	public void removeCardImageOfInvestmentCard(int playernumber, int investmentCardNumber) {
		this.getInvestmentCardOfPlayer(playernumber, investmentCardNumber).removeImage();
	}
	
	/**
	 * This is a helper method that gets the card image of a particular investment card of a player. This method will return
	 * one of the constant values defined in the CardImageLoader class; to use this method, you might want to check if the
	 * value returned by this card is equal to one of those constants, then react from there. For example:
	 * 
	 * <code>
	 * if (this.getOpportunityUI().getCardImageOfInvestmentCard(1, 0) == CardImageLoader.KAREN_DAIRY_A_LVL0) {
	 *   this.getOpportunityUI().setCardImageOfInvestmentCard(1, 0, CardImageLoader.KAREN_DAIRY_A_LVL1);
	 * }</code>
	 * 
	 * @param playernumber is the player number of the player whose investment card you want to get (1 or 2).
	 * @param investmentCardNumber is the card number of the investment card you want to get the image of.
	 * @return the card image as a constant defined in the CardImageLoader class.
	 */
	public int getCardImageOfInvestmentCard(int playernumber, int investmentCardNumber) {
		return this.getInvestmentCardOfPlayer(playernumber, investmentCardNumber).getCurrentImage();
	}
	
	/**
	 * This is a helper method that sets the image on a prime investment card. Use the constants defined in the 
	 * CardImageLoader to select which image to load. This method does the same thing as getting the Prime Investment Card first
	 * using the getPrimeInvestmentCardOfPlayer() method then setting its image by calling the setImage() method passing a relevant
	 * method call of the CardImageLoader of the OpporunityUI. 
	 * 
	 * Basically, this method is here to make your job easier. 
	 * 
	 * @param playernumber is the player number of the player whose prime investment card you want to set the image of (1 or 2).
	 * @param image is the image you want to load. Use the constants defined in CardImageLoader to select which image to load.
	 *
	 * @see CardImageLoader
	 */
	public void setCardImageOfPrimeInvestmentCard (int playernumber, int image) {
		this.getPrimeInvestmentCardOfPlayer(playernumber).setImage(this.getCardImageLoader().getMediumImageIconFor(image));
	}
	
	/**
	 * This helper method removes the image on a prime investment card. This method also automatically empties the
	 * prime investment card.
	 * 
	 * @param playernumber is the player number of the player whose prime investment card you want to empty (1 or 2).
	 */
	public void removeCardImageOfPrimeInvestmentCard(int playernumber) {
		this.getPrimeInvestmentCardOfPlayer(playernumber).removeImage();
	}
	
	/**
	 * This is a helper method that gets the card image of a prime investment card of a player. This method will return
	 * one of the constant values defined in the CardImageLoader class; to use this method, you might want to check if the
	 * value returned by this card is equal to one of those constants, then react from there. For example:
	 * 
	 * <code>
	 * if (this.getOpportunityUI().getCardImageOfPrimeInvestmentCard(1) == CardImageLoader.KAREN_DAIRY_A_LVL0) {
	 *   this.getOpportunityUI().setCardImageOfPrimeInvestmentCard(1, CardImageLoader.KAREN_DAIRY_A_LVL1);
	 * }</code>
	 * 
	 * @param playernumber is the player number of the player whose investment card you want to get the image of (1 or 2).
	 * @return the card image as a constant defined in the CardImageLoader class.
	 */
	public int getCardImageOfPrimeInvestmentCard(int playernumber) {
		return this.getPrimeInvestmentCardOfPlayer(playernumber).getCurrentImage();
	}
	
	/**
	 * This is a helper method that sets the image of the blow up card. This is the same as getting the Blow Up Card first of the
	 * UI by calling the getBlowUpCard() method, then settings its image via the setImage() method passing a relevant method call
	 * of the CardImageLoader of the OpportunityUI.
	 * 
	 * Basically, this method is here to make your job easier.
	 * 
	 * @param image is the image you want to load. Use the constants defined in CardImageLoader to select which image to load.
	 */
	public void setCardImageOfBlowUpCard(int image) {
		this.getBlowupCard().setImage(this.getCardImageLoader().getLargeImageIconFor(image));
	}
	
	/**
	 * This helper method removes the image of the blow up card. This method also automatically empties the blow up card.
	 */
	public void removeCardImageOfBlowUpCard() {
		this.getBlowupCard().removeImage();
	}
	
	/**
	 * This is a helper method that gets the card image of the blow up card. This method will return
	 * one of the constant values defined in the CardImageLoader class; to use this method, you might want to check if the
	 * value returned by this card is equal to one of those constants, then react from there. For example:
	 * 
	 * <code>
	 * if (this.getOpportunityUI().getCardImageOfBlowUpCard() == CardImageLoader.NO_IMAGE) {
	 *   this.getOpportunityUI().setCardImageOfBlowUpCard(CardImageLoader.KAREN_DAIRY_A_LVL1);
	 * }</code>
	 * 
	 * @return the card image as a constant defined in the CardImageLoader class.
	 */
	public int getCardImageOfBlowUpCard() {
		return this.getBlowupCard().getCurrentImage();
	}
	
	/**
	 * This helper method sets the money of the player, given the player number and the money as String.
	 * 
	 * @param playerNum is the player number of the player whose money you want to change (1 or 2).
	 * @param moneyAsString the amount of money of the player as a String.
	 */
	public void setMoneyOfPlayer(int playerNum, String moneyAsString) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Money().setText("PHP " + moneyAsString);
		} 
		else {
			this.gameTable.getPlayer2Money().setText("PHP " + moneyAsString);
		}
	}
	
	/**
	 * This helper method sets the money of the player, given the player number and the money as a double. Note that this
	 * method will NOT convert the double into money format (but will prepend the String "PHP" to it).
	 * 
	 * @param playerNum is the player number of the player whose money you want to change (1 or 2).
	 * @param money the amount of money of the player. This method will NOT convert the value of the money into money format.
	 */
	public void setMoneyOfPlayer(int playerNum, double money) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Money().setText("PHP " + money);
		} 
		else {
			this.gameTable.getPlayer2Money().setText("PHP " + money);
		}
	}
	
	/**
	 * This helper method sets the spending limit of the player, given the player number and the money as String.
	 * 
	 * @param playerNum is the player number of the player whose money you want to change (1 or 2).
	 * @param moneyAsString the amount of the spending limit of the player as a String.
	 */
	public void setSpendingLimitOfPlayer(int playerNum, String moneyAsString) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1SpendingLimit().setText("Limit: " + moneyAsString);
		} 
		else {
			this.gameTable.getPlayer2SpendingLimit().setText("Limit: " + moneyAsString);
		}
	}
	
	/**
	 * This helper method sets the spending limit of the player, given the player number and the money as a double. Note that this
	 * method will NOT convert the double into money format (but will prepend the String "Limit: " to it).
	 * 
	 * @param playerNum is the player number of the player whose money you want to change (1 or 2).
	 * @param money the amount of the spending limit of the player. This method will NOT convert the value of the money into money format.
	 */
	public void setSpendingLimitOfPlayer(int playerNum, double money) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1SpendingLimit().setText("Limit: " + money);
		} 
		else {
			this.gameTable.getPlayer2SpendingLimit().setText("Limit: " + money);
		}
	}
	
	/**
	 * This helper method sets the name of the player, given the player number and the new name. Note that this
	 * method will replace ALL the text contained within the label. If you wish to retain the "Player 1" or "Player 2"
	 * String, either prepend or append it to the name parameter you are passing to this method.
	 * 
	 * @param playerNum is the player number of the player whose name you want to change (1 or 2).
	 * @param name is the new name of the player.
	 */
	public void setNameOfPlayer(int playerNum, String name) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Label().setText(name);
		} 
		else {
			this.gameTable.getPlayer2Label().setText(name);
		}
	}
	
	/**
	 * This helper method will get the name of the player that is currently being displayed on-screen. Note that this
	 * method will return ALL the contents of the player name label.
	 * 
	 * @param playerNum is the player number of the player whose name you want to get (1 or 2).
	 * @return the name of the player, given the playerNum
	 */
	public String getNameOfPlayer(int playerNum) {
		if (playerNum == 1) {
			return this.gameTable.getPlayer1Label().getText();
		} else {
			return this.gameTable.getPlayer2Label().getText();
		}
	}
	
	/**
	 * This method will add an instance of a card to the hand of the player.
	 * @param playerNum is the player number of the player who will get the card (1 or 2). 
	 * @param card is the card that would be added to the selected player's hand.
	 */
	public void addCardToPlayerHand (int playerNum, Card card) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Pane().addCardToHand(card);
		}
		else {
			this.gameTable.getPlayer2Pane().addCardToHand(card);
		}
	}
	
	/**
	 * This method will create a new card instance and add it to the hand of the player. The image used for the card
	 * is based on the image parameter and the player whose hand the card will go to is based on the playerNum. Use
	 * the constants defined in the {@link CardImageLoader} as the image parameter to this method.
	 *   
	 * @param playerNum is the player number of the player who will get the card (1 or 2).
	 * @param image the image of the newly generated card. Use the constants defined in the {@link CardImageLoader} class for this parameter.
	 * @see CardImageLoader 
	 */
	public void addCardToPlayerHandWithImage (int playerNum, int image) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Pane().addCardToHand(image);
		}
		else {
			this.gameTable.getPlayer2Pane().addCardToHand(image);
		}
	}
	
	/**
	 * This method will remove the instance of the card passed as the second parameter to this method from the hand of the 
	 * player whose player number matches the first parameter of this method.
	 * 
	 * @param playerNum is the player number of the player whose hand you want to remove a card from (1 or 2).
	 * @param card is the card to be removed from the hand of the player.
	 */
	public void removeCardFromPlayerHand (int playerNum, Card card) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Pane().removeFromHand(card);
		}
		else {
			this.gameTable.getPlayer2Pane().removeFromHand(card);
		}
	}
	
	/**
	 * This method will remove a card from a player's hand, given the player number of the player and the index of the card
	 * from the player's hand. Note that the first card in the hand of the player is index 0.
	 * 
	 * @param playerNum is the player number of the player whose hand you want to remove a card from (1 or 2).
	 * @param index the index of the card you want to remove from the hand of the player.
	 */
	public void removeCardFromPlayerHand (int playerNum, int index) {
		if (playerNum == 1) {
			this.gameTable.getPlayer1Pane().removeFromHand(index);
		}
		else {
			this.gameTable.getPlayer2Pane().removeFromHand(index);
		}
	}
	
	/**
	 * Gets the card that is currently being blown up. This is useful if you want to transfer the card to another location on
	 * the board (for example, from the hand to the investments, or from the investment to the prime investment. This method
	 * would most likely be called in the {@link ClickAction} subclass that will be assigned to the buttons on the right side
	 * of the BlowUp Card.
	 * 
	 * @return the card that is currently being blown up.
	 */
	public Card getCurrentSelectedCard() {
		return this.getGameTable().getCurrentSelectedCard();
	}
	
	/**
	 * This helper method declares a game winner through a confirmation dialog box, based on the specified integer parameter 
	 * (which denotes the player number). This method returns true if the user clicked on "Yes" and false otherwise. 
	 * 
	 * @param playerNum is the number of the player that will be announced the winner (e.g. Player 1 wins so playerNum = 1)
	 * @return true if the user selected Yes, otherwise returns false
	 */
	public boolean declareWinnerAndPlayAgain(int playerNum) {
		Object[] options = {"Yes","No"};
		int n = JOptionPane.showOptionDialog(gameTable, getNameOfPlayer(playerNum) + " wins! Would you like to play again?", "Game Over!",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[1]);
		
		if (n == 0) //User chooses "Yes"
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This helper method declares the game a draw, then asks the players if they want to play again.
	 * This method returns true if the user clicked on "Yes" and false otherwise. 
	 * 
	 * @return true if the user selected Yes, otherwise returns false
	 */
	public boolean declareDrawAndPlayAgain() {
		Object[] options = {"Yes","No"};
		int n = JOptionPane.showOptionDialog(gameTable, "The game is draw! Would you like to play again?", "Game Over!",
											JOptionPane.YES_NO_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											options,
											options[1]);
		
		if (n == 0) //User chooses "Yes"
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method will forcibly terminate the game.
	 */
	public void quitGame() {
		System.exit(0);
	}
	
	/**
	 * Gets the GameTable of OpportunityUI. Do not use this method unless absolutely necessary.
	 * 
	 * @return the GameTable of OpportunityUI.
	 */
	public GameTable getGameTable() {
		return gameTable;
	}

	/**
	 * Sets the GameTable of OpportunityUI. Do not use this method unless absolutely necessary.
	 * 
	 * @param gameTable is the new GameTable that will replace the old GameTable of OpportunityUI.
	 */
	public void setGameTable(GameTable gameTable) {
		this.gameTable = gameTable;
	}

}
