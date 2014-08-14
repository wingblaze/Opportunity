package com.opportunity.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import com.opportunity.ui.interfaces.OpportunityUICompatible;

/**
 * This class models a Click Action. Whenever you click a clickable component in the interface, if a Click Action
 * had been assigned to it, the Click Action will trigger. For example, if you want that, when the Deck is clicked, 
 * the number of cards in the deck would be reduced by one (among other things, refer to the Machine Problem 
 * Specifications for the other things that happen when you click the deck). You would have to create a Click Action
 * class and then implement the abstract method mouseClicked, which would then modify the elements of the UI (i.e.
 * reduce the number of cards in the deck by one.
 * 
 * When you instantiate a Click Action, you would have to pass to the constructor the clickable UI element or a set
 * of clickable UI elements that would trigger the Click Action. To this end, two constructors were provided, one
 * accepting a JComponent (a button, etc) and one that accepts an ArrayList of JComponents.
 * 
 * To access the elements of the UI, a reference to the OpportunityUI is given. Use the method getOpportunityUI() to
 * get the whole UI, then use the helper methods of OpportunityUI to get the specific elements or modify the properties
 * of elements found in the UI.
 * 
 * For all of this to work, however, do not forget to add your Click Action to the OpportunityUI itself by calling the
 * addClickAction() method of OpportunityUI passing the instance of your Click Action class. 
 * 
 * @author Ryan Dimaunahan and Lance Alcabasa
 *
 */
public abstract class ClickAction implements MouseListener {
	
	private ArrayList<JComponent> triggers;
	private OpportunityUI opportunityUI;
	private MouseEvent mouseEvent;
	private ArrayList<OpportunityUICompatible> yourGameData;
	
	/**
	 * This constructor creates a ClickAction with one associated trigger component (button, card, etc). Use this
	 * if you only have one trigger for your ClickAction, although you can still add triggers later using the
	 * addTrigger() method.
	 * 
	 * @param trigger is an associated trigger component.
	 */
	public ClickAction(JComponent trigger) {
		triggers = new ArrayList<JComponent>();
		this.triggers.add(trigger);
		initListener();
	}
	
	/**
	 * This constructor creates a ClickAction with multiple associated trigger components (buttons, cards, etc).
	 * Use this if you have an ArrayList of triggers for your ClickAction, although you can still add triggers later
	 * using the addTrigger() method.
	 * 
	 * @param triggers is an ArrayList of associated trigger components.
	 */
	public ClickAction(ArrayList<JComponent> triggers) {
		this.triggers = triggers;
		initListener();
	}
	
	private void initListener() {
		this.yourGameData = new ArrayList<OpportunityUICompatible>();
		for (JComponent component:this.triggers) {
			component.addMouseListener(this);
		}
	}
	
	/**
	 * This method gets the OpportunityUI reference, so your ClickAction can modify certain elements of the UI
	 * (cards in the deck, data displayed in the game log, cards in a player's hand, etc.). This is the starting
	 * point of almost all UI related manipulation. See the SampleClickAction class included in this project to
	 * see this in action.
	 * 
	 * This reference is set when you add the ClickAction to the OpportunityUI. The addClickAction() method  of
	 * OpportunityUI does this for you automatically. See the {@link OpportunityUI} class for more details on this. 
	 * 
	 * @return returns the OpportunityUI reference of the ClickAction.
	 * @see OpportunityUI
	 */
	public OpportunityUI getOpportunityUI() {
		return this.opportunityUI;
	}
	
	/**
	 * This method sets the OpportunityUI reference. Do not call this method unless absolutely necessary, as you
	 * could end up losing your OpportunityUI reference (and therefore not be able to edit the UI elements anymore).
	 * 
	 * @param opportunityUI is the associated OpportunityUI object
	 */
	public void setOpportunityUI(OpportunityUI opportunityUI) {
		this.opportunityUI = opportunityUI;
	}
	
	/**
	 * Adds a trigger component to the ClickAction. A trigger component is a button or a label that is supposed to
	 * trigger the ClickAction. When this happens, the mouseClicked(MouseEvent) method of the ClickAction is called, 
	 * which in turn calls the mouseClicked() abstract method of the ClickAction. You are to implement this abstract
	 * method in your ClickAction subclasses; basically put inside the method all the UI manipulation that would
	 * happen when the ClickAction triggers.
	 * 
	 * @param trigger is the trigger component that you wish to add to the ClickAction.
	 */
	public void addTrigger(JComponent trigger) {
		this.triggers.add(trigger);
		trigger.addMouseListener(this);
	}
	
	/**
	 * Adds an ArrayList of trigger components to the ClickAction. A trigger component is a button or a label that is supposed to
	 * trigger the ClickAction. When this happens, the mouseClicked(MouseEvent) method of the ClickAction is called, 
	 * which in turn calls the mouseClicked() abstract method of the ClickAction. You are to implement this abstract
	 * method in your ClickAction subclasses; basically put inside the method all the UI manipulation that would
	 * happen when the ClickAction triggers.
	 * 
	 * @param triggers is an ArrayList of trigger components you wish to add to the ClickAction.
	 */
	public void addTriggers(ArrayList<JComponent> triggers) {
		for (JComponent trigger:triggers) {
			this.addTrigger(trigger);
		}
	}
	
	/**
	 * Removes a trigger component from the ClickAction. You normally would not have a reason to call this method, but if you
	 * wish to remove a trigger component from this ClickAction (i.e. you do not want this ClickAction to occur when you click
	 * the trigger component), then you may call this method.
	 * 
	 * @param trigger is the trigger component you wish to remove from the ClickAction.
	 */
	public void removeTrigger(JComponent trigger) {
		this.triggers.remove(trigger);
		trigger.removeMouseListener(this);
	}
	
	/**
	 * Removes an ArrayList of trigger components from the ClickAction. You normally would not have a reason to call this method, but if you
	 * wish to remove a trigger component from this ClickAction (i.e. you do not want this ClickAction to occur when you click
	 * the trigger component), then you may call this method.
	 * 
	 * @param triggers is an ArrayList of trigger components you wish to remove from the ClickAction.
	 */
	public void removeTriggers(ArrayList<JComponent> triggers) {
		for (JComponent trigger:triggers) {
			this.removeTrigger(trigger);
		}
	}

	/**
	 * Sets the list of OpportunityUICompatible objects added to this ClickAction. This method is not normally called if you
	 * wish to add the game data one at a time. Note that this will replace ALL the game data objects added to this ClickAction.
	 * See the Driver class included in this project for a sample of how this method is used.
	 * 
	 * @param yourGameData is an ArrayList of OpportunityUICompatible objects that contains your game data.
	 */
	public void setYourGameData(ArrayList<OpportunityUICompatible> yourGameData) {
		this.yourGameData = yourGameData;
	}
	
	/**
	 * Adds a OpportunityUICompatible object to the list of OpportunityUICompatible objects stored within this ClickAction.
	 * Use this method to add your classes to the ClickAction, after having your class implement the OpportunityUICompatible
	 * interface. See the MyPlayer class included in this project for a sample of how to accomplish this, and the Driver
	 * class for a sample of this method is used.
	 * 
	 * @param yourClass is a OpportunityUICompatible class that you wish to add to this ClickAction.
	 */
	public void addGameData(OpportunityUICompatible yourClass) {
		this.yourGameData.add(yourClass);
	}	
	
	/**
	 * Gets the list of OpportunityUICompatible objects added to this ClickAction. Use this to retrieve all your game data
	 * classes. To see how this is done, see the MyPlayer class and the SampleClickAction class included in this project.
	 * 
	 * @return the ArrayList of OpportunityUICompatible classes added to this ClickAction.
	 * @see OpportunityUICompatible
	 */
	public ArrayList<OpportunityUICompatible> getYourGameData() {
		return this.yourGameData;
	}

	/**
	 * You have to override this method. Override it with all the UI manipulation that must happen when the ClickAction is
	 * triggered (by clicking any of its trigger components). See the SampleClickAction class included in this project to
	 * see how this is done.
	 */
	public abstract void mouseClicked();
	
	/**
	 * Returns the current MouseEvent. Only use this if you understand Swing.
	 * 
	 * @return the last MouseEvent that triggered.
	 */
	public MouseEvent getMouseEvent() {
		return mouseEvent;
	}

	/**
	 * Override of the mouseClicked method of a MouseListener of swing. Do not call this method. This method calls
	 * the abstract method mouseClicked() which you would have to implement when you extend ClickAction.
	 * 
	 * @param e is the MouseEvent that occured which notified this Listener.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		this.mouseEvent = e;
		this.mouseClicked();
		this.getOpportunityUI().getGameTable().repaint();
	}

	/**
	 * Override of the mousePressed method of a MouseListener of swing. Do not call this method. 
	 * 
	 * @param e is the MouseEvent that occured which notified this Listener.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	/**
	 * Override of the mouseReleased method of a MouseListener of swing. Do not call this method. 
	 * 
	 * @param e is the MouseEvent that occured which notified this Listener.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	/**
	 * Override of the mouseEntered method of a MouseListener of swing. Do not call this method. 
	 * 
	 * @param e is the MouseEvent that occured which notified this Listener.
	 */
	@Override
	public void mouseEntered(MouseEvent e) {


	}

	/**
	 * Override of the mouseExited method of a MouseListener of swing. Do not call this method. 
	 * 
	 * @param e is the MouseEvent that occured which notified this Listener.
	 */
	@Override
	public void mouseExited(MouseEvent e) {


	}

}
