package game;

public abstract class AirCarnivoreDinosaur extends CarnivoreDinosaur {

	public AirCarnivoreDinosaur(String name, char displayChar, int hitPoints, int maxfoodlevel) {
		super(name, displayChar, hitPoints, maxfoodlevel);
		this.addSkill(MovementType.FLY);
		numberOfMoves = 2;
	}

}
