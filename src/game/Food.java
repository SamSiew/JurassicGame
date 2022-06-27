
package game;

import edu.monash.fit2099.engine.Location;

/**
 * Interface for Ground and item which is food for dinosaur
 */
public interface Food {
	/**
     * The food level to update the actor that ate the food
     * 
     * @return foodamount - amount to update food level by
     * 
     */
	int getFoodLevel();
	
	/**
     * If the food is eaten, remove it
     * 
     * @param location location of the food
     */
	void eaten(Location location);
	/**
	 * @author Siew
	 * 
	 * @return String name of the food, when eaten print out eat string
	 */
	String getName();
}