package game;
/**
 *Carnivore food for dinosaur
 */
public class CarnivoreFood extends EdibleItem {
	
	/** 
	 * Constructor.
	 * All Carnivorefood is represented by a 'c'
	 * Add the skill carnivore so it can only be eaten by carnivores
	 * 
	 */
	public CarnivoreFood() {
		super("CarnivoreFood",'c',20,100);
		this.addSkill(DietType.CARNIVORE);
	}
}
