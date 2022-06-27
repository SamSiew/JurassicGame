package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.GameMap;

/**
 * AI behavior is a behavior that determine what AI will do.
 * generic class for all AI interaction 
 */
public class AIBehavior implements Behaviour{
	/**
	 * collection of behavior is used to store all possible behavior of dinosaur species
	 */
	private List<Behaviour> behaviours = new ArrayList<Behaviour>();
	
	/**
	 *  contructor to create a new behavior for all AI
	 */
	public AIBehavior() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * contructor to create a new behavior for all AI
	 * 
	 * @param behaviours List of behavior that can be initialised into this class attribute behaviours 
	 */
	public AIBehavior(List<Behaviour> behaviours) {
		// TODO Auto-generated constructor stub
		this.behaviours = behaviours;
	}

	/**
	 * this will iterate all behavior which assumes that priority of first element will act
	 * if all important behavior of actor return null, it will wonder around.
	 *
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return action the action taken for dinosaur 
	 */

	@Override
	public Action getAction(GameCharacter actor, GameMap map) {
		// TODO Auto-generated method stub
		for (Behaviour behaviour : behaviours) {
			if (behaviour.getAction(actor, map) != null) {
				return behaviour.getAction(actor, map);
			}
		}
		Behaviour currentBehaviour = new WanderBehaviour(); 
		return currentBehaviour.getAction(actor, map);
	}
	
	/**
	 * allow new AI behavior to be added to this class which allow immersion later
	 *
	 * @param behaviour, new behavior of AI
	 */
	public void addBehavior(Behaviour behaviour) {
		behaviours.add(behaviour);
	}
}
