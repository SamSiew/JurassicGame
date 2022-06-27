package bonus;

import edu.monash.fit2099.engine.DropItemAction;
import game.PurchasableItem;
/**
 *pill item for neo to become the one
 */
public class RedPill extends PurchasableItem{
	/**
	 * create a pill item for neo to become the one
	 * 
	 * @param name the name of this Item
	 * @param displayChar the character to use to represent this item if it is on the ground
	 * @param price price of item
	 */
	public RedPill(String name, char displayChar, int price) {
		super(name, displayChar, price);
		addSkill(TheOneSkill.NEO);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Create and return an action to drop this Item.
	 * If this Item is not portable, returns null.
	 * @return a new DropItemAction if this Item is portable, null otherwise.
	 */
	@Override
	public DropItemAction getDropAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
