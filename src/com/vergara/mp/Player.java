package com.vergara.mp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import com.vergara.mp.card.Card;
import com.vergara.mp.card.InvestmentCard;
import com.vergara.mp.card.property.PropertyCard;

public class Player {
	private String Name;
	private ArrayList<Card> Hand;
	private Stack<Card> Deck;
	private int Cash;
	private Field field;
	private int maxSpend;
	private int currentSpend;

	public Player(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public ArrayList<Card> getHand() {
		return Hand;
	}

	public Stack<Card> getDeck() {
		return Deck;
	}

	public int getCash() {
		return Cash;
	}

	/**
	 * Ends the current players' turn.
	 */
	public void endTurn() {

	}

	/**
	 * Draw card function.
	 */
	public ArrayList<Card> investOpportunity() {

		try {
			double chance = Math.random();

			if (Cash < 1000)
				throw new Exception("You don't have enough money.");

			if (Deck.size() == 0)
				throw new Exception("You don't have enough cards in your deck.");

			if (currentSpend > maxSpend)
				throw new Exception("You are spending too much.");

			// Checks if Player has enough money.
			// Checks for 10% chance
			if (chance > 0.9) {
				System.out
						.println("Investing in Opportunities cost 1000PHP. You draw 2 cards! Double Opportunity!");

				// Get 2 cards
				Card Card1 = Deck.pop();
				Card Card2 = Deck.pop();

				// Pay for draw
				Cash -= 1000;

				Hand.add(Card1);
				Hand.add(Card2);

			} else {
				System.out
						.println("Investing in Opportunities cost 1000PHP. You draw 1 card");

				// Get 1 card
				Card Card1 = Deck.pop();

				// Pay for draw
				Cash -= 1000;

				Hand.add(Card1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ArrayList<Card> drawnCards = new ArrayList<Card>();

		// draw from the deck.remove()

		return drawnCards;
	}

	/**
	 * Play Investment Card onto field from the hand.
	 */
	public void purchaseInvestment(InvestmentCard card) {
		// subtract from player cash based on price of the card
		// Cash -= c.getPrice()
		Hand.remove(card);
		field.useInvestment(card);
	}

	/**
	 * Invests on property card selected
	 */
	public void investProperty(PropertyCard primeInvestment) {
		// checks if primeInvestment
	}

	/**
	 * Makes selected property card on asset/property field into the prime
	 * investment.
	 */
	public void setPrimeInvestment(PropertyCard card) {
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
	public void sellInvestment(InvestmentCard card) {
		field.removeInvestment(card);
		// get some cash based on card selling price
	}

	/**
	 * Uses the event card selected
	 */
	public void useEvent() {

	}
}
