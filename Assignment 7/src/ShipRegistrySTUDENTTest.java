/**
 * Add your test methods here.  Follow the examples in ShipRegistryTest.java
 * @author Hsien Shen
 *
 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ShipRegistrySTUDENTTest {

	private ShipRegistry shipsSTUDENT;
/**
 * set up all the data set 	
 * @throws Exception if there is nothing
 */

	@Before
	public void setUpSTUDENT() throws Exception {
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT.addShip("Ice Bear (O 195)", "Cargo", "1954", 25000, 0, 0, 0, 0);
		shipsSTUDENT.addShip( "Grizzly",  "Cruise", "1954", 0, 1300, 0, 0, 0);
		shipsSTUDENT.addShip( "Pan Pan",  "Warship", "1813", 0, 0, 15, 0, 0);
		shipsSTUDENT.addShip( "Fin (CV-63)", "Carrier",  "1961", 0, 0, 0, 0, 100);
		shipsSTUDENT.addShip( "Jake the Magic Dog (DDG-51)", "Destroyer", "1989", 0, 0, 900, 0, 0);

	}
/**
 * teardown methods
 * @throws Exception throw exception
 */
	@After
	public void tearDown() throws Exception {
		shipsSTUDENT=null;
	}
/**
 * test addship methods
 */
	@Test
	public void testAddShipSTUDENT() {
		shipsSTUDENT.addShip( "Davie AA (CG-52)",  "Cruise",  "1988", 0, 1400, 0, 0, 0);
		shipsSTUDENT.addShip( "Caden Han (LPH-12)",  "Mine Sweeper", "1970", 0, 0, 15, 0, 0);
		shipsSTUDENT.addShip( "Kian Han (SSBN-620)",  "Submarine", "1964", 0, 0, 0, 50, 0);
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		assertEquals("Ice Bear",shipList.get(0).toString().substring(0,8));
		assertEquals(15,((WarShip) shipList.get(2)).getNumGuns());
		assertEquals("Kian Han",shipList.get(7).toString().substring(0,8));
		assertEquals(900,((WarShip) shipList.get(4)).getNumGuns());
	}
/**
 * test readfile method
 */
	@Test
	public void testReadFileSTUDENT() {
		try {
			//this statement just rewrites an empty file over any existing ones
			new PrintWriter("testShips.csv"); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		shipsSTUDENT.writeFile(new File("testShips.csv"));
		shipsSTUDENT = new ShipRegistry();
		shipsSTUDENT.readFile(new File("testShips.csv"));
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		Ship s = shipList.get(2);
		assertEquals("Pan Pan",s.writeData().substring(0,7));	
		s = shipList.get(1);
		assertEquals("Grizzly",s.writeData().substring(0,7));		
	}
/**
 * test write file method	
 */
	
	@Test
	public void testWriteFileSTUDENT() {
		ArrayList<Ship> shipList = shipsSTUDENT.getShips();
		Ship s = shipList.get(3);
		assertEquals("Fin",s.writeData().substring(0,3));	
	}

}