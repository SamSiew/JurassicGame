package game;

/**
 * A carnivorous dinosaur.
 *
 */
public class Plesiosaur extends WaterCarnivoreDinosaur {
	// Will need to change this to a collection if Plesiosaur gets additional Behaviours.
	protected int age;

	/** 
	 * Constructor.
	 * All Plesiosaur are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Plesiosaur
	 */
	public Plesiosaur(String name) {
		super(name, 's', 100,100);
		this.currentFoodLevel = 30;
		this.hungryFoodLevel = 25;
		this.age = 0;
		this.isAdult = false;
	}
	
	/** 
	 * Return the egg version of Plesiosaur
	 * 
	 * @return Egg - a new egg
	 */
	protected Egg returnEgg() {
		return new Egg("PlesiosaurEgg", this, 10);
	}
	
	public Dinosaur returnBaby() {
		return new Plesiosaur("Plesiosaur");
	}
}
