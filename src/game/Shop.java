package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 * Shop is an actor that allow player to buy and sells.
 */
public class Shop extends TraderActor{
	
	/**
	 * Constructor which is used to create Shop
	 * shop is represented with s and it has 100 hitpoint
	 * though shop can't be killed and will not be a target for all actor.
	 *
	 * @param name name of shop
	 * @param displayChar display character of shop
	 * @param hitPoints hitpoint of shop
	 * @param cashamount cash it started
	 */
	public Shop(String name, char displayChar, int hitPoints, int cashamount) {
		super(name, displayChar, hitPoints,cashamount);
		addSkill(TradingSkill.CIVILIAN);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * it does nothing but wait for actor to interact with it
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return action, shop does nothing
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// TODO Auto-generated method stub
		return new DoNothingAction();
	}
	

	/**
	 * Returns a collection of the Actions that the otherActor can do to the current Actor.
	 *it will create selling transaction and purchase transaction between shop and other actor nearby with it
	 *
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		if(otherActor.hasSkill(TradingSkill.TRADER)) {
			List<Item> actorinventory = otherActor.getInventory(), shopinventory = getInventory();
			createTransaction(actions, shopinventory,TransactionType.PURCHASE,(TraderActor) otherActor);
			createTransaction(actions, actorinventory,TransactionType.SELLING,this);
		}
		return actions;
	}

	/**
	 * create transaction between buyer and merchant
	 * can be done for selling and purchasing
	 *
	 * @param actions list of actions it have currently
	 * @param inventory inventory of query interest
	 * @param transactionType type of transaction performed in item transaction
	 * @param traderActor the trader that involved in purchase
	 */
	private void createTransaction(Actions actions, List<Item> inventory, TransactionType transactionType, TraderActor traderActor) {
		// TODO Auto-generated method stub
		for (Item item : inventory) {
			if(traderActor.isenoughcash(item.getPrice())) {
				ItemTransaction newTransaction = new ItemTransaction(item, this, transactionType);
				actions.add(newTransaction);
			}
		}
	}
	
	/**
	 * empty implementation to ensure shop is not killed
	 *
	 * @param points number of hitpoints to deduct.
	 */
	@Override
	public void hurt(int points) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * empty implementation to ensure shop is not killed
	 *
	 * @param item Item that is being removed from inventory.
	 */
	@Override
	public void removeItemFromInventory(Item item) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Returns true if and only if the current Actor has the required skill.
	 *
	 * @param skill the skill required
	 * @return true if and only if the current Actor has the required skill
	 */
	public boolean hasSkill(Enum<?> skill) {
		return skill == TradingSkill.CIVILIAN;
	}
}
