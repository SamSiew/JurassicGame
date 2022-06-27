package game;

/**
 * Herbivore food item for protoceratops
 */
public class HerbivoreFood extends EdibleItem {
	
	/** 
	 * Constructor.
	 * All Herbivorefood is represented by a h
	 * add the skill herbivore so it can only be eaten by herbivores
	 * 
	 */
	public HerbivoreFood() {
		super("HerbivoreFood", 'h',20,20);
		this.addSkill(DietType.HERBIVORE);
	}
}
