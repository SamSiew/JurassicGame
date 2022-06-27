package bonus;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * Gun is a weapon for all actor to hurt another actor 
 */
public class Gun extends WeaponItem{
	/**
	 * create a gun weapon.
	 */
	private int price;
	/**
	 * create a gun weapon.
	 */
	public Gun() {
		super("Gun", '-', 20, "shoot");
		this.price = 500;
		// TODO Auto-generated constructor stub
	}
	/**
	 * create a gun weapon.
	 * 
	 * @param price price of item.
	 */
	public Gun(int price) {
		super("Gun", '-', 20, "shoot");
		this.price = price;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return price price of this weapon
	 */
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
