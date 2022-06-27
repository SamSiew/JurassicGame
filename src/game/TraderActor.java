package game;

/**
 * Trader Actor is an actor that trade item and cash between actor.
 */
public abstract class TraderActor extends GameCharacter {
	/**
	 * cash is attribute all trader have to pay and sell
	 */
	private int cash;

	/**
	 * constructor for creating all trader object
	 *
	 * @param name name of Trader Actor
	 * @param displayChar display character of trader
	 * @param hitPoints hitpoint of actor
	 * @param cashamount cash amount of actor have initally
	 */
	public TraderActor(String name, char displayChar, int hitPoints, int cashamount) {
		super(name, displayChar, hitPoints);
		setCash(cashamount);
		addSkill(TradingSkill.TRADER);
		// TODO Auto-generated constructor stub
	}

	/**
	 * change amount of cash to new one
	 *
	 * @param cash amount of cash to be modify
	 */
	private void setCash(int cash) {
		this.cash = cash;
	}

	/**
	 * make payment for amount
	 * decrement in cash
	 *
	 * @param amount amount of cash to pay 
	 */
	public void makePayment(int amount) {
		// TODO Auto-generated method stub
		setCash(cash - amount);
	}

	/**
	 *amount of receive payment
	 *increment in cash
	 *
	 * @param amount amount of cash to receive
	 */
	public void receivePayment(int amount) {
		// TODO Auto-generated method stub
		setCash(cash + amount);
	}

	/**
	 *check if enough cash or not for amount
	 *check if trader can buy stock
	 *
	 * @param amount the purchasable item that trader interested in 
	 * @return boolean this actor can pay or not 
	 */
	public boolean isenoughcash(int amount) {
		// TODO Auto-generated method stub
		if (amount > cash) {
			return false;
		}
		return true;
	}
}
