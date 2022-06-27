package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * Fish is actor which swim and is there to feed dinosaur only.
 */
public class Fish extends GameCharacter{
	
	private int age;
	
	private static final int AGE_LIMIT = 20;
	
	public Fish(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		addSkill(DietType.CARNIVORE);
		addSkill(MovementType.SWIM);
		age = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// TODO Auto-generated method stub
		age++;
		if (age > AGE_LIMIT) {
			return new DeathAction("die");
		}
		return new WanderBehaviour().getAction(this, map);
	}
}
