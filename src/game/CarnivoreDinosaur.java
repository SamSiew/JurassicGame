package game;

public abstract class CarnivoreDinosaur extends Dinosaur{
	/**
	 * an abstract class for all carnivore dinosaurs of dinosaur
	 * don't need to change behavior much
	 *
	 * @param name, name of dinosaurs
	 * @param displayChar, character representation in map
	 * @param hitPoints, health of dinosaurs
	 * @param maxfoodlevel, max food level of dinosaur
	 */
	public CarnivoreDinosaur(String name, char displayChar, int hitPoints, int maxfoodlevel) {
		super(name, displayChar, hitPoints,maxfoodlevel);
		// TODO Auto-generated constructor stub
		addSkill(DietType.CARNIVORE);
		addBehavior(new AttackBehavior());
	}
}
