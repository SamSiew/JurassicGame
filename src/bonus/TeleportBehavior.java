package bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import game.Behaviour;
import game.GameCharacter;
/**
 *Teleport is a behavior for criminal to telport anywhere.
 */
public class TeleportBehavior implements Behaviour{
	
	private Random random = new Random();
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
	 *Teleport will find all different location it can move to and randomly choose it.
	 *Agent used it to make game more difficult than usual.
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return an Action that actor can perform, or null if actor can't do this.
	 */
	@Override
	public Action getAction(GameCharacter actor, GameMap map) {
		// TODO Auto-generated method stub\
		List<Location> aList = new ArrayList<Location>();
		if (actor.hasSkill(CriminalSkill.TELEPORT) == false) {
			return null;
		}
		
		for (int y : map.getYRange()) 
		{
			for (int x : map.getXRange()) 
			{
				Location location = map.locationOf(actor);
				if ((x != location.x() || y != location.y()) && map.at(x, y).canActorEnter(actor) == true) {
					aList.add(map.at(x, y));
				}
			}
		}
		
		if (aList.size() > 0) {
			return new MoveActorAction( aList.get(random.nextInt(aList.size())), "teleport");
		}
		return null;
	}
}
