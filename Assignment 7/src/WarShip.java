/**
 * this class will create different kinds of warship included cruiser, submarine, mine sweeper, destroyer and carrier.
 * @author Hsien Shen
 *
 */
public class WarShip extends Ship{

	//declare fields
	private int guns;
	private int torpedoes;
	private int aircraft;
	/**
	 * Constructor
	 * @param name ship name
	 * @param type ship name
	 * @param year ship year
	 * @param guns num of guns
	 * @param torpedoes num of torpedoes
	 * @param aircraft num of aircraft
	 */
	public WarShip(String name, ShipType type, String year, int guns, int torpedoes, int aircraft)
	{
		super(name, type, year);
		this.aircraft = aircraft;
		this.guns = guns;
		this.torpedoes = torpedoes;
		
	}
	/**
	 * getter for guns
	 * @return guns
	 */
	public int getNumGuns() {
		return guns;
	}
	/**
	 * setter for guns
	 * @param guns num of guns
	 */
	public void setNumGuns(int guns) {
		this.guns = guns;
	}
	/**
	 * setter for torpedoes
	 * @return torpedoes
	 */
	public int getNumTorpedos() {
		return torpedoes;
	}
	/**
	 * setter for torpedos
	 * @param torpedoes num of torpedoes
	 */
	public void setNumTorpedos(int torpedoes) {
		this.torpedoes = torpedoes;
	}
	/**
	 * getter for aircraft
	 * @return aircraft
	 */
	public int getNumAircraft() {
		return aircraft;
	}
	/**
	 * setter for aircraft
	 * @param aircraft num of aircraft
	 */
	public void setNumAircraft(int aircraft) {
		this.aircraft = aircraft;
	}
	/**
	 * the data will be displayed in GUI
	 * @return String
	 */
	public String toString()
	{
		
		
		if(super.getType().equals(ShipType.WARSHIP))
		{
			return super.toString() + guns + " Guns, " + torpedoes + " Torpedoes, and" + aircraft + "aircrafts\n";
		}
		else if(super.getType().equals(ShipType.CARRIER))
		{
			return super.toString() + " carrying " + aircraft + " aircraft\n";
		}
		else if(super.getType().equals(ShipType.CRUISER))
		{
			return super.toString()  + guns + " Guns\n";
		}
		else if(super.getType().equals(ShipType.DESTROYER))
		{
			return super.toString() + guns + " Guns\n";
		}
		else if(super.getType().equals(ShipType.MINE_SWEEPER))
		{
			return super.toString() + guns + " Guns\n";
		}
		else if(super.getType().equals(ShipType.SUBMARINE))
		{
			return super.toString() + torpedoes + " torpedoes\n";
		}
		else
			return null;
			
	}
	
	/**
	 * The data will be write in and read from
	 * @return String 
	 */
	@Override
	public String writeString()
	{
		if(super.getType().equals(ShipType.WARSHIP))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else if(super.getType().equals(ShipType.CARRIER))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else if(super.getType().equals(ShipType.CRUISER))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else if(super.getType().equals(ShipType.DESTROYER))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else if(super.getType().equals(ShipType.MINE_SWEEPER))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else if(super.getType().equals(ShipType.SUBMARINE))
		{
			return super.writeData() + "," + guns + "," + torpedoes + "," + aircraft ;
		}
		else
			return null;
	}

}
