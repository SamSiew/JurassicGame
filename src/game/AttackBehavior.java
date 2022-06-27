package game;

import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
/**
 * Attack behavior is a behavior that attack all search for all target and attack any random target
 */
public class AttackBehavior implements Behaviour{
	/**
	 * getActions method will get a random chance of which target that it will choose to attack
	 * null is return to allow other behavior knows that it can't do anything.
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return Action, a decision making of which the action to be returned
	 */
	@Override
	public Action getAction(GameCharacter actor, GameMap map) {
		// TODO Auto-generated method stub
		Random random = new Random();
		TropicalLocation location = (TropicalLocation)map.locationOf(actor);
		Actions actions = searchAttackTarget(location);
		if (actions.size() > 0 ) {
			return actions.get(random.nextInt(actions.size()));
		}
		return null;
	}

	/**
	 * as long as this is a Tropical Location, Attack Behavior can get all possible target
	 * it will return list of actions which consist of Attack Action of target
	 * 0 target is possible.
	 *
	 * @param currentlLocation, Tropical location of actor
	 * @return actions, list of target can be attack
	 */
	private Actions searchAttackTarget(TropicalLocation currentlLocation) {
		// TODO Auto-generated method stub
		Actions actions = new Actions();
		for (Actor actor : currentlLocation.neighbourActor()) {
			if (actor.hasSkill(TradingSkill.CIVILIAN) == false) {
				actions.add(new AttackAction(actor));
			} 
		}
		return actions;
	}

}
