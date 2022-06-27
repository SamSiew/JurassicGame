package game;

import edu.monash.fit2099.engine.Actor;

/**
 * Corpse is an item for all actor that died.
 */
public class Corpse extends EdibleItem{

	/***
	 * Constructor.
	 * 
	 * Create Corpse item based on the type of dinosaur that it came from
	 * Add the skill carnivore to this item so it can only be eaten by carnivores
	 * 
	 * @param name the name of the actor this corpse came from
	 */
	public Corpse(Actor name) {
		super(name + " Corpse", '%', 50, 15);
		this.addSkill(DietType.CARNIVORE);
	}
}
