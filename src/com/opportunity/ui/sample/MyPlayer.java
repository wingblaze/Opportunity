package com.opportunity.ui.sample;

import com.opportunity.ui.interfaces.OpportunityUICompatible;

/* A sample implementation of the OpportunityUICompatible interface. Assume MyPlayer is one of your classes, in this example
 * this class is a VERY crude model of a Player (hopefully yours is better). You only need to implement the empty interface,
 * the point of the interface is to make your classes compatible with the OpportunityUI, and so that you can add it to the
 * gameData of a ClickAction.
 */
public class MyPlayer implements OpportunityUICompatible {

	private int deckCardCount;
	private int handCardCount;
	
	public MyPlayer() {
		this.deckCardCount = 40;
		this.handCardCount = 0;
	}

	public int getDeckCardCount() {
		return deckCardCount;
	}

	public void setDeckCardCount(int deckCardCount) {
		this.deckCardCount = deckCardCount;
	}

	public int getHandCardCount() {
		return handCardCount;
	}

	public void setHandCardCount(int handCardCount) {
		this.handCardCount = handCardCount;
	}

}
