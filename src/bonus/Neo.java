package bonus;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import game.MovementType;
import game.Player;
/**
 * playable character that has gun and can be The One.
 */
public class Neo extends Player{
	/**
	 * create a neo playable character
	 * 
	 * @param name name of this player
	 * @param displayChar the character that will represent the Actor in the display
	 * @param hitPoints hitPoints the Actor's starting hit points
	 * @param cashamount starting cash of neo.
	 */
	public Neo(String name, char displayChar, int hitPoints, int cashamount) {
		super(name, displayChar, hitPoints, cashamount);
		addItemToInventory(new Gun());
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * if neo becomes the one, he will not die at all.
	 * 
	 * @param points amount of point neo takes.
	 */
	@Override
	public void hurt(int points) {
		// TODO Auto-generated method stub
		if (hasSkill(TheOneSkill.THE_ONE) == false) {
			super.hurt(points);
			if (isConscious() == false && hasSkill(TheOneSkill.NEO)) {
				removeSkill(TheOneSkill.NEO);
			}
		}
	}
	
	/**
	 * Select and return an action to perform on the current turn.
	 * find all different shooting target and add to actions so that player can choose any target to shoot 
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// TODO Auto-generated method stub
		Action shootingAction = new ShootingBehavior().getAction(this, map);
		while (shootingAction != null) {
			actions.add(shootingAction);
			shootingAction = shootingAction.getNextAction();
		}
		return super.playTurn(actions, lastAction, map, display);
	}
	/** 
	 * Remove a skill from this Actor.
	 * When Neo skill is removed, it is assume he is THE ONE.
	 * he can fly and heal all the way to max. 
	 * 
	 * @param skill the Skill to remove
	 */
	@Override
	public void removeSkill(Enum<?> skill) {
		// TODO Auto-generated method stub
		super.removeSkill(skill);
		if (skill.equals(TheOneSkill.NEO)) {
			addSkill(TheOneSkill.THE_ONE);
			addSkill(MovementType.FLY);
			heal(maxHitPoints);
		}
	}
}
