package game;

import edu.monash.fit2099.engine.Location;

/**
 * Base class for any item that can be picked up and dropped.
 */
public abstract class EdibleItem extends PurchasableItem implements Food{
	
	private int foodamount;

	/**
	 * create super object for instance object
	 *
	 * @param name name of edible item
	 * @param displayChar display character of edible item
	 * @param foodamount amount of food level inhebit
	 * @param price price of edible item.
	 */
	public EdibleItem(String name, char displayChar, int foodamount, int price) {
		super(name, displayChar,price);
		this.foodamount = foodamount;
	};
	
	/** 
	 * eaten will remove this item from the map
	 * 
	 * @param location - the location of this item
	 * 
	 */
	public void eaten(Location location) {
		location.removeItem(this);
	}
	
	/** 
	 * this will return the food level increase for the current item
	 * 
	 * @return foodAmount the level by which to increase the actors food level
	 * 
	 */
	@Override
	public int getFoodLevel() {
		// TODO Auto-generated method stub
		return this.foodamount;
	}
	/**
	 * getter for food name.
	 * 
	 * @return name name of food
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
