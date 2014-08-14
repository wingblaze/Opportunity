package com.vergara.mp;

import java.util.ArrayList;

import com.vergara.mp.card.InvestmentCard;
import com.vergara.mp.card.property.PropertyCard;

public class Field
{
	private ArrayList<InvestmentCard> investmentSpace;
	private PropertyCard primeInvestment;
	
	public Field()
	{
		investmentSpace = new ArrayList<InvestmentCard>();
	}
	
	public ArrayList<InvestmentCard> getInvestmentSpace() {
		return investmentSpace;
	}
	public PropertyCard getPrimeInvestment() {
		return primeInvestment;
	}
	public void setPrimeInvestment(PropertyCard primeInvestment) {
		this.primeInvestment = primeInvestment;
	}

	public void useInvestment(InvestmentCard card) {
		//check if investment space is full
		investmentSpace.add(card);
	}
	
	public void removeInvestment(InvestmentCard card) {
		investmentSpace.remove(card);
	}
	
}
