package com.opportunity.ui.sample;

import java.util.ArrayList;

import javax.swing.JComponent;

import com.opportunity.ui.ClickAction;

/* This is a Sample subclass of the ClickAction abstract class. You are to make one of these for each action that is supposed
 * to happen when you click any screen element (to give you an idea, you should at least make one for each Possible Action,
 * although you are not limited to just that). Each ClickAction has a reference to the OpportunityUI itself, which means
 * you can easily manipulate the UI elements from a ClickAction subclass. Just use the getOpportunityUI() method to get the
 * reference, then from there you may call any of the helper methods of the OpportunityUI.
 * 
 * This sample subclass is currently attached to the End the Turn button. You may check out the Driver class in this sample
 * to see how this was done (i.e. attaching a trigger or a set of triggers to a ClickAction). 
 */
public class SampleClickAction extends ClickAction {

	/* Note that when you create a subclass of ClickAction, you must implement these two constructors as seen below. You may
	 * opt not to put anything in them however, except for super(source); and super(sources); for each respectively.
	 */
	public SampleClickAction(JComponent source) {
		super(source);
	}
	
	public SampleClickAction(ArrayList<JComponent> sources) {
		super(sources);
	}

	/* This is the meat and potatoes of a ClickAction class. In this method, you will be placing all the things the ClickAction
	 * would perform. Before you call this, you might want to add game data first to the click action by calling the
	 * addGameData() method (See the sample Driver for a sample on how to do this). You can use this later within the class
	 * to get data from the classes you have created.
	 */
	@Override
	public void mouseClicked() {
		
		/* This is the full method implementation of changing the image in the blowup card to the image for a level 0
		 * Karen Dairy A property
		 */
		//this.getOpportunityUI().getBlowupCard().setIcon(this.getOpportunityUI().getCardImageLoader().getLargeImageIconFor(CardImageLoader.KAREN_DAIRY_A_LVL0));
		
		/* This is the same implementation using a helper method */
		//this.getOpportunityUI().setCardImageOfBlowUpCard(CardImageLoader.KAREN_DAIRY_A_LVL0);
		
		/* This method call adds a new line of text to the Game Log*/
		//this.getOpportunityUI().appendTextToTextLog("An action has occured!");
		
		/* This is a sample set of procedures to showcase what you can do in a ClickAction class. These procedures
		 * "moves" the currently blown up (selected) card from the hand of the player to the first investment slot,
		 * then updates the Game Log. If you keep clicking the trigger of this ClickAction (the "End the Turn" button),
		 * you will see the following effects occur.
		 */
		this.getOpportunityUI().setCardImageOfInvestmentCard(1, 0, this.getOpportunityUI().getCurrentSelectedCard().getCurrentImage());
		this.getOpportunityUI().removeCardFromPlayerHand(1, this.getOpportunityUI().getCurrentSelectedCard());
		this.getOpportunityUI().appendTextToTextLog("A card has been moved from the hand to the investments slot!");
		
		/* This is a sample of how to use the getYourGameData method to link your classes to the OpportunityUI. These procedures
		 * modify the number of cards in the player's deck and hand, reducing the former and increasing the latter. Notice
		 * how the getYourGameData() was used to obtain the ArrayList of all the objects you added to the game data array list,
		 * and how it was type casted first to a MyPlayer class. This allows you to retrieve and manipulate the player data 
		 * stored in the object. If you keep clicking the trigger of this ClickAction (the "End the Turn" button), observe
		 * how the Game Log's text reflect the data stored in the MyPlayer object.
		 */
		if (this.getYourGameData().get(0) instanceof MyPlayer) {
			MyPlayer player = (MyPlayer) this.getYourGameData().get(0);
			
			this.getOpportunityUI().appendTextToTextLog("The player's deck has " + player.getDeckCardCount() + " cards.");
			this.getOpportunityUI().appendTextToTextLog("The player's hand has " + player.getHandCardCount() + " cards.");
			this.getOpportunityUI().appendTextToTextLog("Reducing the deck Count by one, and increasing hand count by one...");
			player.setDeckCardCount(player.getDeckCardCount() - 1);
			player.setHandCardCount(player.getHandCardCount() + 1);
			this.getOpportunityUI().appendTextToTextLog("The player's deck now has " + player.getDeckCardCount() + " cards.");
			this.getOpportunityUI().appendTextToTextLog("The player's hand now has " + player.getHandCardCount() + " cards.");
			
		}
	}

}
