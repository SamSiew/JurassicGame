package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.World;
/**
 * Jurrasic World is a world that oversees player to win by breeding a TREX to adult.
 */
public class JurrasicWorld extends World{
	/**
	 * Jurrasic world contructor to create world 
	 * 
	 * @param display a console of this world for output purpose
	 */
	public JurrasicWorld(Display display) {
		super(display);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Run the game.
	 *
	 * On each iteration the gameloop does the following: - displays the player's
	 * map - processes the actions of every Actor in the game, regardless of map
	 *
	 * We could either only process the actors on the current map, which would make
	 * time stop on the other maps, or we could process all the actors. We chose to
	 * process all the actors.
	 * 
	 * wins: captive TRex grows adult
	 * lose: player HP is 0
	 *
	 * @throws IllegalStateException if the player doesn't exist
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		if (player.isConscious() == false) {
			display.println("You Lose!");
		}
		if (hasTRexCaptiveBreed()) {
			display.println("You Win!");
		}
	}
	
	/**
	 * Returns true if the game is still running.
	 *
	 * if captive TRex grows adult, stop running
	 * else, runs super method to determine to run or not.
	 * 
	 * The game is considered to still be running if the player is still around.
	 *
	 * @return true if the player is still on the map.
	 */
	@Override
	protected boolean stillRunning() {
		// TODO Auto-generated method stub
		if (hasTRexCaptiveBreed()) {
			return false;
		}
		return super.stillRunning();
	}
	/**
	 * method to check captive TRex grows adult, stop running if true.
	 * 
	 * @return boolean
	 */
	private boolean hasTRexCaptiveBreed() {
		for (Actor actor : actorLocations) {
			if(actor.hasSkill(BreedSkill.TYRANNOSAURS_CAPTIVEBREED)){
				return true;
			}
		}
		return false;
	}
}
