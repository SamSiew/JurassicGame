package game;

import edu.monash.fit2099.engine.Location;
/**
 * Reed class is a class that extends water but it is a reed. 
 */
public class Reed extends Water{
	/**
	 * create Reed object that will be a reed. 
	 * 
	 * @param displayChar character to display for this type of terrain
	 */
	public Reed(char displayChar) {
		super(displayChar);
		removeSkill(GroundType.WATER);
		addSkill(GroundType.REED);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * On each turn, a reed square has a 10% chance of generating a fish.
	 * 
	 * @param location The location of the Ground 
	 */
	@Override
	public void tick(Location location) {
		// TODO Auto-generated method stub
		super.tick(location);
		double chance = Math.random(), threshold = 10/100;
		if( location.containsAnActor() == false && chance <= threshold) {
			location.addActor(new Fish("Fish", 'f', 1));
		}
	}
}
