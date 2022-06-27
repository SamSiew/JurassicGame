package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
/**
 * abtract class for all land square
 */
public abstract class Land extends Ground {
	/**
	 * create a land square ground 
	 * 
	 * @param displayChar character to display for this type of terrain
	 */
	public Land(char displayChar) {
		super(displayChar);
		addSkill(GroundType.LAND);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * ensure  only actor who has walk or fly cross this only.
	 *
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if (actor.hasSkill(MovementType.WALK) || actor.hasSkill(MovementType.FLY)) {
			return true;
		}
		return false;
	}
}
