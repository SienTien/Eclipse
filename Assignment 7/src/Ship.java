/**
 * this abtract class provide the basic methods of a ship
 * @author Hsien Shen
 *
 */
public abstract class Ship implements Comparable<Ship> {

	// declare all the variables
	private String name;
	private String year;
	private ShipType type;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            String
	 * @param type
	 *            ShipType
	 * @param year
	 *            String
	 */
	public Ship(String name, ShipType type, String year) {

		this.name = name;
		this.type = type;
		this.year = year;

	}

	/**
	 * wrtie String method for different ships
	 * 
	 * @return String
	 */
	public abstract String writeString();

	/**
	 * getter for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 * 
	 * @param name
	 *            ship name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter for year
	 * 
	 * @return year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * setter for year
	 * 
	 * @param year
	 *            of the ship
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * getter for type
	 * 
	 * @return type
	 */
	public ShipType getType() {
		return type;
	}

	/**
	 * setter for type
	 * 
	 * @param type
	 *            of ship
	 */
	public void setType(ShipType type) {
		this.type = type;
	}

	/**
	 * compare the names in alphabetic order
	 */
	public int compareTo(Ship s) {
		return getName().compareTo(s.getName());
	}

	/**
	 * the String will be write in file
	 * 
	 * @return String
	 */
	public String writeData() {
		return getName() + "," + getType().getDescription() + "," + getYear();
	}

	/**
	 * the data will display in GUI
	 */
	public String toString() {

		return name + " built in " + year + ", " + getType().getDescription() + " class with";
	}

}
