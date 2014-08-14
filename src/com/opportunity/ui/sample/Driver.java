package com.opportunity.ui.sample;

import com.opportunity.ui.OpportunityUI;

/* This Driver class has a short tutorial on how to use the OpportunityUI classes. Before anything else, you might want to
 * import this project into your Eclipse workspace, then create a new package that will hold all of the class you have already
 * developed for this Machine Project.
 */
public class Driver {
	public static void main(String[] args){
		
		/* This is a sample of how to use OpportunityUI. Note that this need not be in Driver, it could be in any class. */
		
		/* You would want to start by instantiating an OpportunityUI object. This object is the whole UI. Pass your names
		 * as a string parameter to the OpportunityUI constructor...
		 */
		OpportunityUI opportunityUI = new OpportunityUI("Jack Frost");
		
		/* Next, add an instance of all the ClickActions you have created (subclasses of ClickAction). Do not forget to pass
		 * the objects (buttons, cards, etc) that will trigger the ClickAction as a parameter to the constructor of your
		 * ClickAction! You can pass just one trigger, or an ArrayList of triggers to the constructor of your ClickAction, or
		 * you can add each trigger one at a time after by calling the addTrigger method of ClickAction. There is also a method
		 * that adds a list of triggers to the ClickAction if you so prefer. Just note that whenever you instantiate one
		 * ClickAction object you have to pass at least one trigger component to its constructor. Check the ClickAction API for
		 * the other methods provided by the ClickAction abstract class.
		 * 
 		 * In this example, a SampleClickAction instance is created and added by using the addClickAction method of 
 		 * OpportunityUI. The End of Turn Button is used as the trigger object, this was obtained using the getBtnEdTurn()
 		 * helper method of OpportunityUI. Each relevant component in the UI has a corresponding helper method that could
 		 * obtain it. Check the OpportunityUI API for the other helper methods provided by the OpportunityUI class.
 		 * 
 		 *  You may also Ctrl+Click SampleClickAction to read a brief tutorial on how to make a ClickAction subclass.
		 */
		SampleClickAction sampleClickAction = new SampleClickAction(opportunityUI.getBtnEndTurn());
		opportunityUI.addClickAction(sampleClickAction);
		
		/* Next, we add game data to your ClickAction. Ctrl+Click the MyPlayer class to see how to make use of the
		 * OpportunityUICompatible interface to make your classes compatible with the OpportunityUI. Note how the player
		 * object is added to the sampleClickAction as gameData for that ClickAction. You can also do this before adding
		 * the click action itself to the OpportunityUI via the addClickAction() method.
		 */
		MyPlayer player = new MyPlayer();
		sampleClickAction.addGameData(player);
		
		/* Finally, call the start method of OpportunityUI. This will start the game itself, and will display the UI on the
		 * screen. Check the OpportunityUI API for the other methods provided by the OpportunityUI class regarding UI display
		 * and termination.
		 */
		opportunityUI.start();
		
	}
}
