package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
/**
 * Game character is an abstract class of all actor with mpvement. 
 * 
 * @author Harry
 */
public abstract class GameCharacter extends Actor {

	protected int numberOfMoves;
	/**
	 * constructor for all game character.
	 * 
	 * @author Harry
	 * @param name  name of character
	 * @param displayChar Display character of actor
	 * @param hitPoints number of hitpoints that an actor will have
	 */
	public GameCharacter(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		//default value for all number of moves.
		setNumberOfMoves(1);
	}
	
	/**
	 * set number of step an actor can moves.
	 * 
	 * @param numberOfMoves number of moves that actor will move
	 */
	protected void setNumberOfMoves(int numberOfMoves) {
		this.numberOfMoves = numberOfMoves;
	}
	
	/**
	 * returnExits is a method that return list of possible exits for an actor.
	 * These are possible square that actor can moves.
	 * 
	 * @author Harry 
	 * @param map map of actor in 
	 * @return list of possible exits 
	 */
	public List<Exit> returnExits(GameMap map) {
		List<Exit> exits = new ArrayList<>();
		
		for (Exit newExit : map.locationOf(this).getExits())  {
			exits.add(newExit);
		}
		
		for (int i=1; i <= numberOfMoves - 1; i++) {
			List<Exit> copy = new ArrayList<Exit>(exits);
			for (Exit exit : copy) {
				for (Exit newExit : exit.getDestination().getExits()) {
					if (!exits.contains(newExit)) {
						exits.add(newExit);
					}
				}
			}
		}
		return exits;
	}
	
	@Override
	public String attack(Actor target) {
		// TODO Auto-generated method stub
		int damage = getWeapon().damage();
		String result = this + " " + getWeapon().verb() + " " + target + " for " + damage + " damage.";
		target.hurt(damage);
		return result;
	}
}
