package game;

/**
 * A carnivorous dinosaur.
 *
 */
public class Pteranodon extends AirCarnivoreDinosaur {
	// Will need to change this to a collection if Pteranodon gets additional Behaviours.
	protected int age;

	/** 
	 * Constructor.
	 * All Pteranodon are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Pteranodon
	 */
	public Pteranodon(String name) {
		super(name, 'd', 100, 100);
		this.currentFoodLevel = 30;
		this.hungryFoodLevel = 25;
		this.age = 0;
		this.isAdult = false;
	}
	
	/** 
	 * Return the egg version of pteranodon
	 * 
	 * @return PteranodonEgg - a new egg
	 */
	protected Egg returnEgg() {
		return new Egg("PteranodonEgg", this, 10);
	}
	
	public Dinosaur returnBaby() {
		return new Pteranodon("Pteranodon");
	}
}
