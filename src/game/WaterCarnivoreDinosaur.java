package game;

public abstract class WaterCarnivoreDinosaur extends CarnivoreDinosaur {

	public WaterCarnivoreDinosaur(String name, char displayChar, int hitPoints, int maxfoodlevel) {
		super(name, displayChar, hitPoints, maxfoodlevel);
		this.addSkill(MovementType.SWIM);
		numberOfMoves = 1;
	}

}
