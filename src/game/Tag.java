package game;
/**
 * tag item for dinosaur tag
 */
public class Tag extends PurchasableItem{
	
	protected String name;
	
	protected char displayChar;

	/**
	 * create a tag with '*' and its name.
	 *
	 */
	public Tag() {
		super("Tag", '*', 0);
		addSkill(TagSkill.TAGGING);
	}
	
	/**
	 * remove skill of this tag, remove its tag ability and its price increment by 100
	 *
	 * @param skill the Skill to remove
	 */
	@Override
	public void removeSkill(Enum<?> skill) {
		super.removeSkill(skill);
		setPrice(100);
	}
}
