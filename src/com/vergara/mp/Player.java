package com.vergara.mp;

import java.util.ArrayList;

import com.vergara.mp.card.Card;
import com.vergara.mp.card.InvestmentCard;
import com.vergara.mp.card.property.PropertyCard;

public class Player 
{
	private String Name;
	private ArrayList<Card> Hand;
	private ArrayList<Card> Deck;
	private int Cash;
	private Field field;
	
	public String getName() 
	{
		return Name;
	}
	public void setName(String name) 
	{
		Name = name;
	}
	public ArrayList<Card> getHand() 
	{
		return Hand;
	}
	public void setHand(ArrayList<Card> hand) 
	{
		Hand = hand;
	}
	public ArrayList<Card> getDeck() 
	{
		return Deck;
	}
	public void setDeck(ArrayList<Card> deck) 
	{
		Deck = deck;
	}
	public int getCash()
	{
		return Cash;
	}
	public void setCash(int cash)
	{
		Cash = cash;
	}
	
	/**
	 * Ends the current players' turn.
	 */
	public void endTurn()
	{
		
	}
	/**
	 * Draw card function.
	 */
	public ArrayList<Card> investOpportunity()
	{
		ArrayList<Card> drawnCards = new ArrayList<Card>();
		
		// draw from the deck.remove()
		
		return drawnCards ;	
	}
	/**
	 * Play Investment Card onto field from the hand.
	 */
	public void purchaseInvestment(InvestmentCard card)
	{
		// subtract from player cash based on price of the card
		// Cash -= c.getPrice()
		Hand.remove(card);
		field.useInvestment(card);
	}
	/**
	 * Invests on property card selected
	 */
	public void investProperty(PropertyCard primeInvestment)
	{
		// checks if primeInvestment
	}
	/**
	 * Makes selected property card on asset/property field into the prime investment.
	 */
	public void setPrimeInvestment(PropertyCard card)
	{
		// check if empty; else switch places
		ArrayList<InvestmentCard> investmentSpace = field.getInvestmentSpace();
		int index = investmentSpace.indexOf(card);
		investmentSpace.remove(card);
		
		PropertyCard insert = field.getPrimeInvestment();
		investmentSpace.add(index, insert);
		
		field.setPrimeInvestment(card);
	}
	/**
	 * Sells the selected Property or Asset Card
	 */
	public void sellInvestment(InvestmentCard card)
	{
		field.removeInvestment(card);
		//get some cash based on card selling price
	}
	/**
	 * Uses the event card selected
	 */
	public void useEvent()
	{
		
	}
}

