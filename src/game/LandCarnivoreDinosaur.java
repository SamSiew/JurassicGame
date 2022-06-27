package game;

public abstract class LandCarnivoreDinosaur extends CarnivoreDinosaur {

	public LandCarnivoreDinosaur(String name, char displayChar, int hitPoints, int maxfoodlevel) {
		super(name, displayChar, hitPoints, maxfoodlevel);
		this.addSkill(MovementType.WALK);
		numberOfMoves = 1;
	}

}
