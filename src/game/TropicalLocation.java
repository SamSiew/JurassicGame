package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
/**
 * TropicalLocation is a square location for each map in TropicalGameMap
 */
public class TropicalLocation extends Location{
	/**
	 * Constructor that create location of maps
	 *
	 * Locations know which map they are part of, and where.
	 *
	 * @param map the map that contains this location
	 * @param x x coordinate of this location within the map
	 * @param y y coordinate of this location within the map
	 */
	public TropicalLocation(GameMap map, int x, int y) {
		super(map, x, y);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Called once per turn, so that Locations can experience the passage time. If that's important to them.
	 * all non-tree that is adjacent to tree can grow to tree
	 */
	@Override
	public void tick() {
		super.tick();
		double chance = Math.random(), threshold = 0.5/100;
		if (getGround().hasSkill(GroundType.TREE) == false && getGround().hasSkill(GroundType.WATER) == false &&frequencySkillNeighbour(GroundType.TREE) > 0 && chance <= threshold) {
			setGround(new Tree());
		}
		if(getGround().hasSkill(GroundType.WATER)==true) {
			chance = Math.random();threshold = 10/100;
			boolean canGrowReed = false;
			if (frequencySkillNeighbour(GroundType.LAND) > 0 && chance <= threshold) {
				canGrowReed = true;
			}
			else if (frequencySkillNeighbour(GroundType.REED) > 0  && frequencySkillNeighbour(GroundType.LAND) == 0 && chance <= threshold/2) {
				canGrowReed = true;
			}
			if(canGrowReed) {
				setGround(new Reed('~'));
			}
		}
		if(getGround().hasSkill(GroundType.REED)==true && frequencySkillNeighbour(GroundType.REED) > 6) {
			setGround(new Water());
		}
	}

	/**
	 * count number of tree of its neighbour
	 *
	 * @param skill a skill that all ground have
	 * @return numOfNonTreeNeighbour number of tree of its neighbour
	 */
	private int frequencySkillNeighbour(Enum<?> skill) {
		int numOfNonTreeNeighbour = 0;
		for (Ground ground : neighbourGround()) {
			if (ground.hasSkill(skill)) {
				numOfNonTreeNeighbour++;
			}
		}
		return numOfNonTreeNeighbour;
	}
	/**
	 * get all neighbour of this location 
	 * 
	 * @author Siew
	 * @return list of location that neighbour  
	 */
	private List<Location> neighbourSearch() {
		return getExits().stream().map(exit -> exit.getDestination()).collect(Collectors.toList());
	}
	/**
	 * check if the element is null or not.
	 * 
	 * @author Siew
	 * @param <T> generic type that allows any search interest 
	 * @param elem item that it interesy with
	 * @param elemList list of any type
	 */
	private <T> void emptyQueryValidation(T elem, List<T> elemList) {
		if(elem != null) {
			elemList.add(elem);
		}
	}
	/**
	 * get list of Actor near to this location 
	 * 
	 * @author Siew
	 * @return List of its neighbour Actor
	 */
	public List<Actor> neighbourActor() {
		// TODO Auto-generated method stub
		List<Actor> returnList = new ArrayList<Actor>() ;
		for (Location destination : neighbourSearch()) {
			Actor currentActor = destination.getActor();
			emptyQueryValidation(currentActor, returnList);
		}
		return returnList;
	}
	/**
	 * get list of Ground near to this location 
	 * 
	 * @author Siew 
	 * @return List of its neighbour Ground
	 */
	public List<Ground> neighbourGround() {
		// TODO Auto-generated method stub	
		List<Ground> returnList = new ArrayList<Ground>() ;
		for (Location destination : neighbourSearch()) {
			Ground currentGround = destination.getGround();
			emptyQueryValidation(currentGround, returnList);
		}
		return returnList;
	}
}
