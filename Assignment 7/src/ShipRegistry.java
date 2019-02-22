/**
0 * ShipRegistry that implements all the methods from interface.
 * ShipRegistry is a Data Manager that keeps a list of ships.  
 * @author Hsien Shen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShipRegistry implements ShipRegistryInterface {

	/**
	 * shipList is an ArrayList holding Ship references
	 */
	ArrayList<Ship> shipList;

	public ShipRegistry() {
		shipList = new ArrayList<Ship>();
	}
	
	/**
	 * The getShips method returns the current shipList
	 * @return shipList the list contains all the ships
	 */
	@Override
	public ArrayList<Ship> getShips() {
		
		return shipList;
	}
	
	/**
	 * The addShip method adds ships to the ShipRegistry's ArrayList, distinguishing by type, 
	 * creating a ship instance of the correct type, and specifying the correct parameters according to its type. 
	 * This method does not add in any sorted order - the ships are held in the order they are added
	 * @param name A string representing the name of the ship
	 * @param type A string representing one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine"
	 * @param year A string representing the year launched
	 * @param tons A string representing the number of tons of cargo (net register tonnage (NRT)) the ship can carry
	 * @param pax A string representing the number of passengers a cruise ship can carry
	 * @param guns A string representing the number of guns a warship can carry.  "Guns" is loosely defined, not according to naval jargon
	 * @param torpedoes A string representing the number of torpedoes a warship can carry.
	 * @param aircraft A string representing the number of aircraft a warship can nominally carry.
	 */
	@Override
	public void addShip(String name, String type, String year, int tons, int pax, int guns, int torpedoes,
			int aircraft) {
		switch (type) {
		case "Cargo":
			shipList.add(new CargoShip(name, ShipType.CARGO, year, tons));
			break;
		case "Warship":
			shipList.add(new WarShip(name, ShipType.WARSHIP, year, guns, torpedoes, aircraft));
			break;
		case "Cruise":
			shipList.add(new CruiseShip(name, ShipType.CRUISE, year, pax));
			break;
		case "Carrier":
			shipList.add(new WarShip(name, ShipType.CARRIER, year, guns, torpedoes, aircraft));
			break;
		case "Destroyer":
			shipList.add(new WarShip(name, ShipType.DESTROYER, year, guns, torpedoes, aircraft));
			break;
		case "Mine Sweeper":
			shipList.add(new WarShip(name, ShipType.MINE_SWEEPER, year, guns, torpedoes, aircraft));
			break;
		case "Submarine":
			shipList.add(new WarShip(name, ShipType.SUBMARINE, year, guns, torpedoes, aircraft));
			break;
		case "Cruiser":
			shipList.add(new WarShip(name, ShipType.CRUISER, year, guns, torpedoes, aircraft));
			System.out.println(shipList);
			break;
		
		}

	
	}
	
	/**
	 * The readFile method reads from the input file, one line at a time, assuming each line represents data for one ship.
	 * It assumes that the second field is a string representing the ship type, 
	 * one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine".
	 * It further assumes specific formats for each type of ship, as follows:
	 *    Cargo: name,"Cargo",year,tons
	 *    Cruise: name,"Cruise",year,passengers
	 *    Warship: name,"Warship",year,guns,aircraft,torpedoes
	 *    Carrier: name,"Carrier",year,aircraft
	 *    Cruiser, Destroyer, and Mine Sweeper: name,type,year,guns
	 *    Submarine: name,"Submarine",year,torpedoes
	 * It then calls addShip to instantiate it and add it to the ShipRegistry's ArrayList
	 * @param file the file of type File to read from, assumed to be a csv file (comma-delimited) in the above order.
	 */
	@Override
	public void readFile(File file) {
		try {
			Scanner input = new Scanner(file);
			String[] read;
			String name = "", year = "", line, type = "";
			int guns = 0, aircraft = 0, torpedoes = 0, pax = 0, tons;
			
			//When there is more data it will keep reading
			while(input.hasNextLine()) 
			{
				
				line = input.nextLine();
				read = line.split(",");
				name = read[0];
				type = read[1];
				year = read[2];
				
				//determine the type of ship and add them in the list
				switch(type) 
				{
				
				case "Cargo":
					tons = Integer.parseInt(read[3]);
					addShip(name, "Cargo",  year, tons, 0, 0, 0, 0);
					break;
				case "Warship":
					guns = Integer.parseInt(read[3]);
					torpedoes = Integer.parseInt(read[4]);
					aircraft =  Integer.parseInt(read[5]);
					addShip(name, "Warship",  year,0, 0, guns, torpedoes, aircraft);
					break;
				case "Cruise":
					pax = Integer.parseInt(read[3]);
					addShip(name, "Cruise",year, 0, pax, 0, 0, 0);
					break;
				case "Carrier":
					aircraft =  Integer.parseInt(read[3]);
					addShip(name, "Carrier", year, 0, 0, 0, 0, aircraft);
					break;
				case "Destroyer":
					guns = Integer.parseInt(read[3]);
					addShip(name, "Destroyer",year, 0, 0, guns, 0, 0);
					break;
				case "Mine Sweeper":
					guns = Integer.parseInt(read[3]);
					addShip(name, "Mine Sweeper", year, 0, 0, guns, 0, 0);
					break;
				case "Submarine":
					torpedoes = Integer.parseInt(read[3]);
					addShip(name, "Submarine", year, 0, 0, 0, torpedoes, 0);
					break;
				case "Cruiser":
					guns = Integer.parseInt(read[3]);
					addShip(name, "Cruiser", year, 0, 0, guns, 0, 0);
					break;

				}

			}
			
			} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		

		

	}
	
	/**
	 * The writeFile method writes to a specified file, either creating a new file or appending to the end of an existing file.
	 * It iterates through ShipRegistry's ArrayList-ship, writes one line at a time representing data for each ship.
	 * It writes the second field as a string representing the ship type, 
	 * one of "Cargo", "Cruise", "Warship", "Carrier", "Cruiser","Destroyer","Mine Sweeper",or "Submarine".
	 * It further writes specific formats for each type of ship, as follows:
	 *    Cargo: name,"Cargo",year,tons
	 *    Cruise: name,"Cruise",year,passengers
	 *    Warship: name,"Warship",year,guns,aircraft,torpedoes
	 *    Carrier: name,"Carrier",year,aircraft
	 *    Cruiser, Destroyer, and Mine Sweeper: name,type,year,guns
	 *    Submarine: name,"Submarine",year,torpedoes
	 * @param file the file of type File to write to
	 */
	@Override
	public void writeFile(File file) {
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try 
		{
			fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);
			
			for(Ship s: shipList)			
			{
					pw.println(s.writeString());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} finally {
			pw.close();
		}


	}
	/**
	 * The getShipDescriptions method is used in the GUI to set the radio button labels for basic ship types
	 * @return the string array {ShipType.CARGO.toString(), ShipType.CRUISE.toString(), ShipType.WARSHIP.toString()};
	 */
	public String[] getShipDescriptions() {
		String a[] = { ShipType.CARGO.getDescription(), ShipType.CRUISE.getDescription(), ShipType.WARSHIP.getDescription() };
		return a;
	}
	/**
	 * The getWarshipDescriptions method is used in the GUI to set the radio button labels for the five warship types
	 * @return the string array {ShipType.CARRIER.toString(), ShipType.CRUISER.toString(), ShipType.DESTROYER.toString(), ShipType.MINE_SWEEPER.toString(), ShipType.SUBMARINE.toString()};
	 */

	@Override
	public String[] getWarshipDescriptions() {
		String a[] = { ShipType.CARRIER.getDescription(), ShipType.CRUISER.getDescription(), ShipType.DESTROYER.getDescription(),
				ShipType.MINE_SWEEPER.getDescription(), ShipType.SUBMARINE.getDescription() };
		return a;
	}
	/**
	 * String will display in the GUI
	 */
	
	public String toString() {
		
		String formattedString = shipList.toString().replace(",", "").replace("[", "").replace("]", "").trim();    
		return formattedString;
		
	}

}
