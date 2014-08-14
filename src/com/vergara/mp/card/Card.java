package com.vergara.mp.card;


public abstract class Card
{
	protected String Name;
	protected int Cost;
	
	public String getName() 
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public int getCost()
	{
		return Cost;
	}
	public void setCost(int cost)
	{
		Cost = cost;
	}
	
	public abstract void use();
}
