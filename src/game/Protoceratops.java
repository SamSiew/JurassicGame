package game;

/**
 * A herbivorous dinosaur.
 *
 */
public class Protoceratops extends HerbivoreDinosaur {
	// Will need to change this to a collection if Protoceratops gets additional Behaviours.
	
	/** 
	 * Constructor.
	 * All Protoceratops are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Protoceratops
	 */
	public Protoceratops(String name) {
		super(name, 'p', 100, 50);
		this.currentFoodLevel = 50;
		this.hungryFoodLevel = 15;
		this.age = 0;
		this.isAdult = false;
		this.addSkill(MovementType.WALK);
	}
	
	/**
	 * return egg version of protoceratops
	 *
	 * @return Egg ProtoceratopsEgg
	 */
	@Override
	protected Egg returnEgg() {
		return new Egg("ProtoceratopsEgg", this, 10);
	}
	
	public Dinosaur returnBaby() {
		return new Protoceratops("Protoceratops");
	}
}
