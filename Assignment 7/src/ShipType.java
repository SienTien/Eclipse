/**
 *Enum with all the types of ships
 * @author Hsien Shen
 *
 */
public enum ShipType {
	
	CARGO("Cargo"), CRUISE("Cruise"), WARSHIP("Warship"), CARRIER("Carrier"), CRUISER("Cruiser"), DESTROYER("Destroyer"), MINE_SWEEPER ("Mine Sweeper"), SUBMARINE("Submarine");
	
	private String type;
	
	ShipType(String type) {
		this.type = type;
	}

	/**
	 * get the string description of the ship type
	 * 
	 * @return type
	 */
	public String getDescription() {
		return type;
	}
}
