package com.vergara.mp;

import java.util.ArrayList;

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
}
