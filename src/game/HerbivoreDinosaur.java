package game;

public abstract class HerbivoreDinosaur extends Dinosaur {
	/**
	 * an abstract class for all herbivore dinosaurs of dinosaur
	 * don't need to change behavior much
	 *
	 * @param name, name of dinosaurs
	 * @param displayChar, character representation in map
	 * @param hitPoints, health of dinosaurs
	 * @param maxfoodlevel maximum foodlevel of this dinosaur
	 */
	public HerbivoreDinosaur(String name, char displayChar, int hitPoints,int maxfoodlevel) {
		super(name, displayChar, hitPoints, maxfoodlevel);
		addSkill(DietType.HERBIVORE);
	}
}
