package com.vergara.mp;

import java.util.ArrayList;

import com.vergara.mp.card.Card;

public class Player 
{
	private String Name;
	private ArrayList<Card> Hand;
	private ArrayList<Card> Deck;
	private int Cash;
	
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
	public void investOpportunity()
	{
		
	}
	/**
	 * Purchase card drawn.
	 */
	public void purchaseCard()
	{
		
	}
	/**
	 * Invests on property card selected
	 */
	public void investProperty()
	{
		
	}
	/**
	 * Makes selected property card on asset/property field into the prime investment.
	 */
	public void primeInvestment()
	{
		
	}
	/**
	 * Sells the selected Property or Asset Card
	 */
	public void sellCard()
	{
		
	}
	/**
	 * Uses the event card selected
	 */
	public void useEvent()
	{
		
	}
}

