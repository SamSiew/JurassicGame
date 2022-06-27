package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 *  Item transaction is an action for player to interact with shop either 
 *  selling or buying.
 */
public class ItemTransaction extends Action{
	/**
	 * Instance object of  Purchasable Item
	 */
	private Item item;
	/**
	 * Instance object of Shop
	 */
	private Shop shop;
	/**
	 * Boolean value of whether this is a purchase transaction
	 */
	private final TransactionType TRANSACTION_TYPE; 

	/**
	 * create item transaction between shop and actor
	 *
 	 * @param item, Item which are purchasable
	 * @param shop, instance of Shop class
	 * @param transactionType the type of transaction that merchant have with player
	 */
	public ItemTransaction(Item item, Shop shop, TransactionType transactionType) {
		// TODO Auto-generated constructor stub
		this.item = item;
		this.shop = shop;
		TRANSACTION_TYPE = transactionType;
	}

	/**
	 * this method will perform transaction based on what all its subclass has implemented
	 * and it will not need to worry what its child class is doing and will instead adhere to dependency inversion principles.
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return String, describing what item transaction had happened.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stubs
		
		TraderActor traderActor = (TraderActor)actor;
		
		if(TRANSACTION_TYPE.equals(TransactionType.PURCHASE)) {
			performTransaction(traderActor, shop);
		}
		else {
			performTransaction(shop,traderActor);
		}
		return menuDescription(actor);
	}
	
	/**
	 * if buyer is a Trader, it will buyer will make payment.
	 *
	 * @param buyer, an actor who is going to buy an item
	 * @param merchant, an actor who is going to sell an item
	 */
	private void performTransaction(TraderActor buyer, TraderActor merchant) {
		// TODO Auto-generated method stub
		itemExchange(buyer,merchant);
		cashExchange(buyer, merchant);
	}
	
	/**
	 * add item to buyer inventory and removed from merchant.
	 * role can be switch since there are only two possible way of implementing.
	 *
	 * @param buyer, the person who buy item
	 * @param merchant, person who sell item
	 */
	private void itemExchange(TraderActor buyer, TraderActor merchant) {
		buyer.addItemToInventory(this.item);
		merchant.removeItemFromInventory(this.item);
	}
	
	/**
	 * buyer make payment and memrchant will receive payment
	 * role can be switch since there are only two possible way of implementing.
	 *
	 * @param buyer, the person who buy item
	 * @param merchant, person who sell item
	 */
	private void cashExchange(TraderActor buyer, TraderActor merchant) {
		buyer.makePayment(this.item.getPrice());
		merchant.receivePayment(this.item.getPrice());
	}

	/**
	 * describing the item transaction for action display
	 *
	 * @param actor The actor performing the action.
	 * @return string describing the item transaction
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " " + TRANSACTION_TYPE.name() + " "+ this.item  + " for " + this.item.getPrice(); 
	}
}
