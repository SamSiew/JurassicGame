package game;

/**
 * A carnivorous dinosaur.
 *
 */
public class Velociraptor extends LandCarnivoreDinosaur {
	// Will need to change this to a collection if Velociraptor gets additional Behaviours.
	protected int age;

	/** 
	 * Constructor.
	 * All Velociraptor are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Velociraptor
	 */
	public Velociraptor(String name) {
		super(name, 'v', 100,100);
		this.currentFoodLevel = 30;
		this.hungryFoodLevel = 25;
		this.age = 0;
		this.isAdult = false;
	}
	
	/** 
	 * Return the egg version of velociraptor
	 * 
	 * @return VelociraptorEgg - a new egg
	 */
	protected Egg returnEgg() {
		return new Egg("VelociraptorEgg", this, 10);
	}
	
	public Dinosaur returnBaby() {
		return new Velociraptor("Velociraptor");
	}
}
