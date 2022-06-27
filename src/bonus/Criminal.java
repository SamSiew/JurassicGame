package bonus;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import game.AIBehavior;
import game.AttackAction;
import game.AttackBehavior;
import game.GameCharacter;
import game.MovementType;
/**
 * Criminal is actor who will give troubles to everyone by killing all actor
 */
public class Criminal extends GameCharacter {
	
	private int killScore;
	
	private final int MAX_KILL; 
	
	private AIBehavior criminalBehavior;
	/**
	 * constructor for criminal class which will add gun to inventory, add kill skill and kill score
	 * will start from 0 
	 * 
	 * @param name name of criminal
	 * @param displayChar how will criminal be displayed as
	 * @param hitPoints amount of hitspoints of this criminal.
	 * @param maxkill amount of kill needed to become agent
	 */
	public Criminal(String name, char displayChar, int hitPoints, int maxkill) {
		super(name, displayChar, hitPoints);
		addItemToInventory(new Gun());
		addSkill(MovementType.WALK);
		addSkill(CriminalSkill.KILL);
		// TODO Auto-generated constructor stub
		setKillScore(0);
		this.criminalBehavior = new AIBehavior();
		criminalBehavior.addBehavior(new ShootingBehavior());
		criminalBehavior.addBehavior(new AttackBehavior());
		criminalBehavior.addBehavior(new TeleportBehavior());
		setNumberOfMoves(1);
		MAX_KILL = maxkill;
	} 
	/**
	 * Select and return an action to perform on the current turn. 
	 *
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return the Action to be performed
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// TODO Auto-generated method stub
		if (killScore == MAX_KILL) {
			displayChar = Character.toUpperCase(displayChar);
			name = "Agent";
			heal(maxHitPoints);
			addSkill(MovementType.FLY);
			addSkill(CriminalSkill.TELEPORT);
			setNumberOfMoves(3);
		}
		return this.criminalBehavior.getAction(this, map);
	}
	
	/**
	 * set number of kill score.
	 * 
	 * @param killScore number of kill to set to kill score
	 */
	private void setKillScore(int killScore) {
		this.killScore = killScore;
	}
	
	/**
	 * Returns a collection of the Actions that the otherActor can do to the current Actor.
	 *
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return A collection of Actions.
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		// TODO Auto-generated method stub
		Actions actions = super.getAllowableActions(otherActor, direction, map);
		actions.add(new AttackAction(this));
		return actions;
	}
	/**
	 * Add a skill to this Actor.
	 * for every kill, kill score + 1
	 * 
	 * @param skill the Skill to add
	 */
	@Override
	public void addSkill(Enum<?> skill) {
		// TODO Auto-generated method stub
		super.addSkill(skill);
		if (skill.equals(CriminalSkill.KILL)) {
			killScore++;
		}
	}
}
