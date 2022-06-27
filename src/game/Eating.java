package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Eating is an action for actor to eat a food 
 */
public class Eating extends Action {
	
	private Food food;
	
	private Dinosaur dinosaur;
	
	/** 
	 * Constructor.
	 * The eating action that will allow an actor to eat a food
	 * 
	 * @param newFood - the food to eat
	 * @param dinosaur dinosaur that eat 
	 */
	public Eating(Food newFood, Dinosaur dinosaur) {
		this.food = newFood;
		this.dinosaur = dinosaur;
	}
	
	/**
	 * Perform the eat action of the given Food
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// update the food level of the actor eating by the food level stored in the "Food"
		dinosaur.updateFoodLevel(food,map);
		food.eaten(map.locationOf(actor));
		return menuDescription(actor);
	}

	/**
	 * Returns a descriptive string
	 * @param actor The actor performing the action.
	 * @return the text we put on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " eats " + food.getName();
		
	}

}
