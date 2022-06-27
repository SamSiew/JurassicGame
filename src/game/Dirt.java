package game;

import edu.monash.fit2099.engine.Location;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Land {

	/**
	 * Constructor.
	 *
	 */
	public Dirt() {
		super('.');
	}
	
	/**
	 * Ground can also experience the joy of time.
	 * Every turn have a 5% chance to set ground to grass
	 * @param location The location of the Ground 
	 */
	@Override
	public void tick(Location location) {
		// 5% chance for this block to turn to grass every tick
		super.tick(location);
		double chance = Math.random(), threshold = 0.5/100;
		if (chance <= threshold) {
			location.setGround(new Grass());
		}
	}	
}
