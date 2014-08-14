package com.opportunity.ui.clickactions;

import java.util.ArrayList;

import javax.swing.JComponent;

import com.opportunity.ui.Card;
import com.opportunity.ui.ClickAction;

public class BlowUpClickAction extends ClickAction {

	public BlowUpClickAction(JComponent source) {
		super(source);
	}

	public BlowUpClickAction(ArrayList<JComponent> sources) {
		super(sources);
	}

	@Override
	public void mouseClicked() {
		if (this.getMouseEvent().getSource() instanceof Card) {
			Card card = (Card) this.getMouseEvent().getSource();
			
			if (card.isEmpty() != true) {
				int cardIndex = card.getCurrentImage();
				this.getOpportunityUI().setCardImageOfBlowUpCard(cardIndex);
				this.getOpportunityUI().getGameTable().setCurrentSelectedCard(card);
			}
			else {
				this.getOpportunityUI().getGameTable().setCurrentSelectedCard(null);
				this.getOpportunityUI().removeCardImageOfBlowUpCard();
			}
			
		}
	}

}
