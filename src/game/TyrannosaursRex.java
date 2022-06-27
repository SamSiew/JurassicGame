package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * A carnivorous dinosaur.
 *
 */
public class TyrannosaursRex extends LandCarnivoreDinosaur {
	// Will need to change this to a collection if Velociraptor gets additional Behaviours.
	protected int age;

	/** 
	 * Constructor.
	 * All TyrannosaursRex are represented by a 't' and have 100 hit points.
	 * 
	 * @param name the name of this TyrannosaursRex
	 */
	public TyrannosaursRex(String name) {
		super(name, 'r', 100,100);
		this.currentFoodLevel = 30;
		this.hungryFoodLevel = 25;
		this.age = 0;
		this.isAdult = false;
	}
	
	/**
	 * Select and return an action to perform on the current turn. 
	 * AdultProtoceratops determines if its hungry or not, if it can lay an egg, if it can wander
	 * and if none of those are available it stands still
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		if(hasSkill(BreedSkill.CAPTIVE) && isAdult) {
			addSkill(BreedSkill.TYRANNOSAURS_CAPTIVEBREED);
		}
		return super.playTurn(actions, lastAction, map, display);
	}
	
	/** 
	 * Return the egg version of velociraptor
	 * 
	 * @return VelociraptorEgg - a new egg
	 */
	protected Egg returnEgg() {
		return new Egg("TyrannosaursRexEgg", this, 10);
	}
	
	public Dinosaur returnBaby() {
		return new TyrannosaursRex("TyrannosaursRex");
	}
}