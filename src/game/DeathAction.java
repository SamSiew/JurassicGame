package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Generic class for death action with any reason that all actor have
 * 
 * death by hunger, player quit, shoot to death and etc
 */
public class DeathAction extends Action {
	
	private String description;
	/**
	 * create a death action for all actor and its reason.
	 * 
	 * @param description description of how actor dies
	 */
	public DeathAction(String description) {
		// TODO Auto-generated constructor stub
		this.description = description;
	}
	/**
	 * when actor died, it will add corpse of actor to map, then removed actor from field.
	 *
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return string which describe the actor
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		map.locationOf(actor).addItem(new Corpse(actor));
		map.removeActor(actor);
		return menuDescription(actor);
	}

	/**
	 * return the menu description for dinosaur dying
	 *
	 * @param actor The actor performing the action.
	 * @return string describing what actor did
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " " + description;
	}

}
