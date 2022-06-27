package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public abstract class Dinosaur extends GameCharacter {
	protected final int MAX_FOOD_LEVEL;
	protected int currentFoodLevel;
	protected int hungryFoodLevel;
	protected DietType diet;
	protected boolean hunger = false;
	protected int age;
	protected boolean isAdult;
	protected AIBehavior behaviour;
	
	/** 
	 * Constructor.
	 * An abstract class for all types of dinosaurs to be created in
	 * 
	 * @param hitPoints - the health of the dinosaur
	 * @param displayChar - the character for the dinosaur on the map
	 * @param name - the name to call the dinosaur
	 * @param maxfoodlevel - max food level of dinosaur
	 */
	public Dinosaur(String name, char displayChar, int hitPoints, int maxfoodlevel) {
		super(name, displayChar, hitPoints);
		behaviour = new AIBehavior();
		addBehavior(new LookForFood(this));
		MAX_FOOD_LEVEL = maxfoodlevel;
	}
	
	/**
	 * return the baby version of the dinosaur
	 * 
	 * @return Baby - return the baby instance the current dinosaur
	 *
	 */
	protected abstract Dinosaur returnBaby();
	
	/**
	 * return the egg version of the dinosaur
	 * 
	 * @return Egg - return the egg subclass of the current dinosaur
	 *
	 */
	protected abstract Egg returnEgg();
	
	protected void breedProcess(char adultDisplay, GameMap map) {
		currentFoodLevel -= 1;
		age += 1;
		if (age == 30) {
			displayChar = adultDisplay;
			isAdult = true;
		}
		
		// determine if the actor is hungry
		determineHunger(map);
		
		if (isAdult == true) {
			// determine if it can lay an egg
			determineLayEgg(map);
		}
	}
	
	/**
	 * Find if the dinosaur can lay an egg this turn
	 * add egg to location of this dinosaur if it lay eggs
	 * 
	 * @param map, gamemap that the dinosaur located in 
	 */
	protected void determineLayEgg(GameMap map) {
		// if the dinosaur has a sufficient food level and hits the random chance, lay an egg
		if (currentFoodLevel > 20) {
			if (Math.random() <= .3) {
				Egg egg = returnEgg();
				egg.addSkill(BreedSkill.CAPTIVE);
				map.locationOf(this).addItem(egg);

			}
		}
	}
	
	/**
	 * determine if the current dinosaur should be hungry or not and if a hunger message should be
	 * printed
	 * 
	 * @param map - the gamemap that the dinosaur is on
	 *
	 */
	protected void determineHunger(GameMap map) {
		// if the dinosaur is below the hunger level print the dinosaur is hungry
		if ((currentFoodLevel <= hungryFoodLevel) && (hunger == false)) {
			System.out.println(this.toString() + " at (" + map.locationOf(this).x() + "," + map.locationOf(this).y()  + ") is getting hungry!");
			hunger = true;
		} else if (currentFoodLevel >= hungryFoodLevel) {
			hunger = false;
		}
	}

	/**
	 * only instance of dinosaur can add its behavior, no one else
	 * allow immersion of dinosaurs
	 *
	 * @param behaviour new behavior that dinosaur exhibit
	 */
	protected void addBehavior(Behaviour behaviour) {
		this.behaviour.addBehavior(behaviour);
	}
	
	/**
	 * return the hunger level of the current dinosaur
	 * 
	 * @return hunger - return the hunger of the current dinosaur
	 *
	 */
	public boolean isHunger() {
		return hunger;
	}
		
	/**
	 * Increase the dinosaurs food level by the amount given
	 * 
	 * @param food - the food that dinosaur eaten
	 * @param map - map of the dinosaur located in 
	 *
	 */
	public void updateFoodLevel(Food food, GameMap map) {
		int increase = food.getFoodLevel();
		if (currentFoodLevel+increase < MAX_FOOD_LEVEL) {
			currentFoodLevel += increase;
		} else {
			currentFoodLevel = MAX_FOOD_LEVEL;
		}
	}
	
	/**
	 * default action allowable by all dinosaurs, can be tagged and attacked
	 *
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return actions list of actions possible for other actor
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		Actions actions = new Actions();
		actions.add(new AttackAction(this));
		if(otherActor.hasSkill(TagSkill.TAGGING)) {
			actions.add(new TagDinosaur(this));
		}
		return actions;
	}

	/**
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return Action an action decided by behavior of this dinosaur
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		if (this.currentFoodLevel <= 0) {
			return new DeathAction("die");
		}
		breedProcess(Character.toUpperCase(getDisplayChar()), map);
		return this.behaviour.getAction(this, map);
	}
}
