package game;

import edu.monash.fit2099.engine.DropItemAction;
/**
 * Boat is a purchasable item that allow player to move on water
 * once in inventory, will not be removed - disable all chance it break games
 * Used to Tag marine dinosaur and feed dinosaur.
 */
public class Boat extends PurchasableItem {
	/**
	 * creates Boat object is a purchasable item that allow player to move on water
	 * 
	 * @param price price of this boat
	 */
	public Boat(int price) {
		super("Boat", 'b', 5);
		addSkill(MovementType.SWIM);
	}
	
	/**
	 * once in inventory, will not be removed - disable all chance it break games
	 * 
	 * @return a new DropItemAction if this Item is portable, null otherwise.
	 */
	@Override
	public DropItemAction getDropAction() {
		return null;
	}
}
