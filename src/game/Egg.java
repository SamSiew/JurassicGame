package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;
/**
 * Dinosaur Egg class for all egg
 */
public class Egg extends EdibleItem{

	protected int price;
	private Dinosaur parent;
	private Location currLocation;

	/***
	 * Constructor will create egg object for all subclass.
	 * 
	 * Create egg item
	 * 
	 * @param name the name of this Item
	 * @param dino dinosaur that this egg will grow 
	 * @param price price of this egg.
	 */
	public Egg(String name, Dinosaur dino,int price) {
		super(name, 'e', 10, price);
		addSkill(DietType.CARNIVORE);
		this.price = price;
		this.parent = dino;
	}
	
	/**
     * Inform a carried Item of the passage of time.
     * 
     * This method is called once per turn, if the Item is on the ground
     * @param currentLocation The location of the actor carrying this Item.
     */
	@Override
	public void tick(Location currentLocation) {
		// every tick that the egg experiences while on the ground, it has a chance to hatch
		if(Math.random() < .3) {
			if (currentLocation.containsAnActor() == false) {
				hatchBaby(currentLocation);
			}
		}
	}
	
	/**
     * Hatch the egg, create an actor and remove the egg at the same location
     *
	 * @param currentLocation ideal location for hatching baby
     */
	public void hatchBaby(Location currentLocation) {
		currLocation = currentLocation;
		// add the relevant actor stored in each eggs returnBaby method and remove the egg
		if (parent.hasSkill(MovementType.SWIM)) {
			for (Exit exit : currLocation.getExits()) {
				if ((exit.getDestination().getGround().hasSkill(GroundType.WATER) == true) && (exit.getDestination().containsAnActor() == false)) {
					addActorRemoveItem(exit.getDestination());
					break;
				}
			}
		} else if ((parent.hasSkill(MovementType.WALK)) || (parent.hasSkill(MovementType.FLY))) {
			addActorRemoveItem(currentLocation);
		}
	}
	/**
	 * remove item and add actor on location and indicates baby dinosaur is captive.
	 * 
	 * @param location location of actor remove item and add actor on location 
	 */
	private void addActorRemoveItem(Location location) {
		Dinosaur babyDinosaur = parent.returnBaby();
		if (hasSkill(BreedSkill.CAPTIVE)) {
			babyDinosaur.addSkill(BreedSkill.CAPTIVE);
		}
		location.addActor(babyDinosaur);
		currLocation.removeItem(this);
	}
}
