package game;
/**
 * Marine food 
 */
public class MarineAnimalFood extends EdibleItem{
	
	/** 
	 * Constructor.
	 * All MarineAnimalFood is represented by a 'c'
	 * Add the skill carnivore so it can only be eaten by carnivores
	 * 
	 */
	public MarineAnimalFood() {
		super("MarineAnimalFood",'m',20,100);
		this.addSkill(DietType.CARNIVORE);
	}
}