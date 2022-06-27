package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * abtract class for all water square
 */
public class Water extends Ground {
	/**
	 *constructor to create water block
	 * w is a character that represent water
	 */
	public Water() {
		super('w');
		addSkill(GroundType.WATER);
	}
	
	/**
	 * constructor to create water block
	 * allow dynamic display character of water.
	 *
	 * @param displayChar a character that represent water
	 */
	public Water(char displayChar) {
		super(displayChar);
		addSkill(GroundType.WATER);
	}

	/**
	 * ensure only actor who has water cross this only.
	 *
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasSkill(MovementType.SWIM) || actor.hasSkill(MovementType.FLY)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ensure blown thrown item is false
	 *
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return false;
	}
}
