package bonus;

import game.Behaviour;
import game.Corpse;
import game.GameCharacter;
import game.TradingSkill;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
/**
 * Shooting behavior is a behavior for actor to shoot anyone.
 */
public class ShootingBehavior extends Action implements Behaviour{
	
	private Actor target;
	
	private Actions actions;
	
	/**
	 * behavior factory that decide actions
	 */
	public ShootingBehavior() {
		// TODO Auto-generated constructor stub
		this.actions = new Actions();
	}
	
	/**
	 * A factory for creating actions. 
	 *
	 * A Behaviour represents a kind of objective that an Actor can have.  For example
	 * it might want to seek out a particular kind of object, or follow another Actor, 
	 * or run away and hide.  Each implementation of Behaviour returns an Action that the 
	 * Actor could take to achieve its objective, or null if no useful options are available.
	 *
	 * An Actor's playTurn() method can use Behaviours to help decide which Action to 
     * perform next.  It can also simply create Actions itself, but using Behaviours allows
	 * us to modularize the code that decides what to do, and that means that it can be 
	 * reused if (e.g.) more than one kind of Actor needs to be able to seek, follow, or hide.
	 *
	 * This behavior will factory all target and make use of getNextAction so that all target can 
	 * be view by player.
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */
	@Override
	public Action getAction(GameCharacter actor, GameMap map) {
		// TODO Auto-generated method stub
		Location actorLocation = map.locationOf(actor);
		
		for (int y : map.getYRange()) {
			for (int x : map.getXRange()) {
				Location currentlocation = map.at(x, y);
				Ground ground = currentlocation.getGround();
				if ((actorLocation.x() == currentlocation.x() ^ actorLocation.y() == currentlocation.y())&& currentlocation.containsAnActor()) {
					Actor currenttarget = currentlocation.getActor();
					if (currenttarget.hasSkill(TradingSkill.CIVILIAN) == false && ground.blocksThrownObjects() == false) {
						ShootingBehavior newShootingBehavior = new ShootingBehavior();
						newShootingBehavior.target = currenttarget;
						newShootingBehavior.actions = actions;
						actions.add(newShootingBehavior);	
					}
				}
			}
		}
		
		return getNextAction();
	}
	/**
	 * This provides a mechanism for Actions to take more than one turn.
	 * For example, an action can change its state and return itself, or return the next Action in a series.
	 * By default, this returns null, indicating that the Action will complete in one turn.
	 * 
	 * @return null
	 */
	@Override
	public Action getNextAction() {
		// TODO Auto-generated method stub
		if (actions.size() > 0) {
			Action action = actions.get(0);
			actions.remove(action);
			return action;
		}
		return null;
	}
	
	/**
	 * Perform the Action when target is kill, they earned criminal skill.
	 * add corpse on target and remove target from map
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a description of what happened that can be displayed to the user.
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		target.hurt(actor.getWeapon().damage());
		if (target.isConscious() == false) {
			actor.addSkill(CriminalSkill.KILL);
			map.locationOf(target).addItem(new Corpse(target));
			map.removeActor(target);
			return menuDescription(actor) + " " + target + " dies" ; 
		}
		return menuDescription(actor);
	}
	
	/**
	 * Returns a descriptive string
	 * @param actor The actor performing the action.
	 * @return the text we put on the menu
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " shoots " + target;
	}

}
