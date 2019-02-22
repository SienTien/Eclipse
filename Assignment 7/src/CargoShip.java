/**
 * this class create a cargo ship
 * 
 * @author Hsien Shen
 *
 */
public class CargoShip extends Ship {

	// declare field
	private int ton;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            ship name
	 * @param type
	 *            ship type
	 * @param year
	 *            ship year
	 * @param ton
	 *            tonnage
	 */
	public CargoShip(String name, ShipType type, String year, int ton) {
		super(name, type, year);
		this.ton = ton;
	}

	/**
	 * getter for ton
	 * 
	 * @return ton
	 */

	public int getTon() {
		return ton;
	}

	/**
	 * setter for ton
	 * @param ton tonnage
	 */
	public void setTon(int ton) {
		this.ton = ton;
	}
	/**
	 * String with cargo info in file
	 * @return String
	 */
	@Override
	public String writeString() {

		return super.writeData() + "," + ton;
	}
	/**
	 * String with cargo info display on GUI
	 * @return String 
	 */
	public String toString() {

		return super.toString() + ton + " tons\n";
	}

}
