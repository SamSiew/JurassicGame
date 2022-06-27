package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
/**
 * dinosaur action that can be tagged on
 */
public class TagDinosaur extends Action{
	/**
	 * dinosaur that can be tagged on
	 */
	protected Dinosaur target;

	/**
	 * tag dinosaur action created with target on hold
	 *
	 * @param dinosaur dinosaur that needs to be tag
	 */
	public TagDinosaur(Dinosaur dinosaur) {
		// TODO Auto-generated constructor stub
		this.target = dinosaur;
	}

	/**
	 * remove skill from actor and remove dinosaur of mop
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return string which describe the actor has tag this dinosaur
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		actor.removeSkill(TagSkill.TAGGING);
		map.removeActor(this.target);
		return menuDescription(actor);
	}

	/**
	 * actor just tag a dinosaur.
	 *
	 * @param actor The actor performing the action.
	 * @return string describing what actor did
	 */
	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return actor + " tag " + target + " and gain $100";
	}

}
