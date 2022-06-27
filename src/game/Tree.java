
package game;

import edu.monash.fit2099.engine.Location;
/**
 *Tree is a plant that grows between turn.
 */
public class Tree extends Plant {
	private int age = 0;

	/**
	 * constructor to creates tree
	 * it is herbivore food and it is a tree
	 */
	public Tree() {
		super('+',10,"Tree");
		addSkill(GroundType.TREE);
	}

	/**
	 * Tree can also experience the joy of time.
	 * tree will grows as time past
	 *
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		age++;
		if (age == 10)
			displayChar = 't';
		
		if (age == 20)
			displayChar = 'T';
	}
}