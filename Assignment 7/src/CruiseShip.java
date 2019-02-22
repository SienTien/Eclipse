/**
 * This class will create a new cruise
 * @author Hsien Shen
 *
 */
public class CruiseShip extends Ship{
	
	//declare field
	private int passengers;
	
	/**
	 * Constructor
	 * @param name ship name
	 * @param type ship type
	 * @param year ship year
	 * @param passengers num of passengers
	 */
	public CruiseShip(String name, ShipType type, String year, int passengers)
	{
		super(name, type, year);
		this.passengers = passengers;
	}
	
	
	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	
	public String toString()
	{
		return super.toString() + "carrying " + passengers+ " passengers\n";
	}
	
	public String writeString()
	{
		return super.writeData() + "," + passengers;
	}


}
