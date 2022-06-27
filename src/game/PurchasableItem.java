package game;

import edu.monash.fit2099.engine.Item;

/**
 * Purchasable Item is an item that is purchsable for all actor.
 */
public abstract class PurchasableItem extends Item{
	private int price;
	/**
	 * create purchasable item which can be sold in store.
	 *
	 * @param name name of this item
	 * @param displayChar display character of this item
	 * @param price price cost of the item
	 */
	public PurchasableItem(String name, char displayChar, int price) {
		super(name, displayChar, true);
		setPrice(price);
	}
	/**
	 * set price for item.
	 * 
	 * @param price cost of the item
	 */
	protected void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * ensure all its subclass have a price tag on it
	 *
	 * @return price price of the item
	 */
	public int getPrice() {
		return this.price;
	}
}
