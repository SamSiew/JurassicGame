package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.NumberRange;
/**
 * Look for food is a behavior of dinosaur to hunt a food.
 */
public class LookForFood implements Behaviour {

	private Dinosaur dinosaur;
	/**
	 * Constructor.
	 * 
	 * @param dinosaur dinosaurs that this lookforfood behavior going to implement for.
	 */
	public LookForFood(Dinosaur dinosaur) {
		this.dinosaur = dinosaur;
		// TODO Auto-generated constructor stub
	}

	/**
	 * getAction will find closest food around it, with complicated algorithm
	 * it will try to eat anything in its location but will then move closest food
	 * if location of dinosaur does not have food
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return actions, what this actor should od 
	 */
	@Override
	public Action getAction(GameCharacter actor, GameMap map) {
		List<Item> items = new ArrayList<>();
		NumberRange heights, widths;
		Food targetFood = null;
		final int MIN_VALUE = 0;
		int minX = MIN_VALUE, minY = MIN_VALUE;
		// if the dinosaur not hungry return null
		if (dinosaur.isHunger() == false) {
			return null;
		}
		// get the map ranges
		heights = map.getYRange();
		widths = map.getXRange();
		
		DietType diet;
		
		if (dinosaur.hasSkill(DietType.CARNIVORE)) {
			diet = DietType.CARNIVORE;
		}
		else {
			diet = DietType.HERBIVORE;
		}
		
		Location currentLocation = map.locationOf(dinosaur);

		// for every location on the map
		for (int y : heights) {
			for (int x : widths) {
				Ground currGround = map.at(x, y).getGround();
				if (currGround.canActorEnter(dinosaur) ==  true) {
					// get the list of items and ground at the location
					List<Food> food = new ArrayList<>();
					items = map.at(x, y).getItems();
							
					// if the items and ground are of the relevant food type (diet)
					// add them to the new list
					for (Item item : items) {
						// if the item is of the same food group to the dinosaur
						if (item.hasSkill(diet)) {
							food.add((Food) item);
						}
					}
					// 
					if (currGround.hasSkill(diet)) {
						food.add((Food) currGround);
					}
					
					// for everything in the list of potential foods, if its closer to the target
					// than the previously stored food, update the closest food to the target
					// as well as the closest values (MinX, MinY)
					for (Food current : food) {
						// if no value is stored, set it to the first relevant Food object
						int distance_xy = distance(map.at(x, y), currentLocation);
						int distance_minxy = distance(map.at(minX, minY), currentLocation);
						if (minX == MIN_VALUE ||(minX != MIN_VALUE && distance_xy < distance_minxy)) {
							targetFood = (Food) current;
							minX = x;
							minY = y;
						}
					}
				}

			}
		}
		
		// if no target foods are found return null
		if (targetFood == null) {
			return null;
		}
		
		// find the locations of the actor and the target Food
		Location there = map.at(minX, minY);

		int currentDistance = distance(currentLocation, there);
		// if the distance between them is 0, eat the food
		if (currentDistance == 0) {
			return new Eating(targetFood, dinosaur);
		// look through all possible squares that the dinosaur can move into
		// if they are closer to the target location than the current square
		// return the move action to that new square
		} 
		else {
			List<Exit> movement = actor.returnExits(map);
			for (Exit exit : movement) {
				Location destination = exit.getDestination();
				if (destination.canActorEnter(actor)) {
					int newDistance = distance(destination, there);
					if (newDistance < currentDistance) {
						return new MoveActorAction(destination, exit.getName());
					}
				}
			}
		}
		return null;
	}

	/**
	 * Compute the Manhattan distance between two locations.
	 * 
	 * @param a the first location
	 * @param b the first location
	 * @return the number of steps between a and b if you only move in the four cardinal directions.
	 */
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}
