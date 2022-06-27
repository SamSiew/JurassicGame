
package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends TraderActor{

	private Menu menu = new Menu();
	
	/**
	 * Constructor that create player into game
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 * @param cashamount amount of cash player had initially
	 */
	
	public Player(String name, char displayChar, int hitPoints, int cashamount) {
		super(name, displayChar, hitPoints,cashamount);
		addSkill(MovementType.WALK);
		numberOfMoves = 1;
	}
	
	
	/**
	 *  let player choose actions and Handle multi-turn Actions if the games allow it
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return Action that has been decided by player
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		actions.add(new DeathAction("quit"));
        return menu.showMenu(this, actions, display);
	}
	
	/** Remove a skill from this Actor.
	 * 
	 * @param skill the Skill to remove
	 */
	public void removeSkill(Enum<?> skill) {
		for (Item item : getInventory()) {
			if(item.hasSkill(skill)) 
			{
				item.removeSkill(skill);
				if (skill == TagSkill.TAGGING) {
					receivePayment(item.getPrice());
					removeItemFromInventory(item);
				}
				return;
			}
		}
		super.removeSkill(skill);
	}
}