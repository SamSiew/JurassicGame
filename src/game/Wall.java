package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
/**
 * Wall is a concrete of building which should not allow actor to stand here at all.
 */
public class Wall extends Ground {
	/**
	 *constructor to create wall block
	 */
	public Wall() {
		super('#');
	}

	/**
	 * ensure actor do not cross this
	 *
	 * @param actor the Actor to check
	 * @return false
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * ensure blown thrown item is true
	 *
	 * @return true
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
