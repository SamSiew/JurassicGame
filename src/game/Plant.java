package game;

import edu.monash.fit2099.engine.Location;
/**
 *Plant is a land square that is also a food.
 */
public abstract class Plant extends Land implements Food{
	
	private int foodAmount;
	
	private String name;
	
	/**
	 * constructor to create plant object
	 * all plant in here can be eaten
	 *
	 * @param displayChar display character of plant instance
	 * @param foodlevel amount of food level can be obtained
	 * @param name name of plant
	 */
	public Plant(char displayChar,int foodlevel, String name) {
		super(displayChar);
		addSkill(DietType.HERBIVORE);
		this.foodAmount = foodlevel;
		this.name = name;
	}
	
	/**
	 * allows other class knows food level of this food
	 *
	 * @return food amount of this grass
	 */
	@Override
	public int getFoodLevel() {
		return foodAmount;
	}
	
	/**
	 * eaten will remove this item from the map
	 *
	 * @param location - the location of this item
	 *
	 */
	@Override
	public void eaten(Location location) {
		location.setGround(new Dirt());
	}
	
	/**
	 * get name of the plant.
	 * 
	 * @return name name of this plant
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
