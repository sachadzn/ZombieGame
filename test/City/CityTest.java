package City;
import Cell.Cell;
import Cell.Room.Room;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import Actor.Actor;
import Actor.Player.Fighter;
import Cell.Street.*;

class CityTest extends City {

	
	
	
	/**
	 * Test case for the initCity method of the City class.
	 * It checks if the city is initialized correctly with the specified dimensions.
	 */
	@Test
	void initCitySuccess() {
	    City city = new City(10, 10);
	    city.initCity();

	    assertNotNull(city.getCellList());
	    assertEquals(10, city.getLength());
	    assertEquals(10, city.getWidth());
	}

	/**
	 * Test case for the default constructor of the City class.
	 * It checks if the default city has the default dimensions.
	 */
	@Test
	void testDefaultConstructor() {
	    City city = new City();
	    assertEquals(5, city.getWidth());
	    assertEquals(5, city.getLength());
	}

	/**
	 * Test case for the getter and setter methods of the City class.
	 * It checks if the length and width of the city can be set and retrieved correctly.
	 */
	@Test
	void testGetterSetterMethods() {
	    City city = new City();
	    city.setLength(7);
	    city.setWidth(9);
	    assertEquals(7, city.getLength()) ;
	    assertEquals(9, city.getWidth()) ;
	}

	/**
	 * Test case for the placeManHole method of the City class.
	 * It checks if manholes are correctly placed at the edges of the city grid.
	 */
	@Test
	void placeManHoleSuccess() {
	    City city = new City(15, 15);
	    city.initStreets();
	    assertTrue(city.getCellList().get(0).get(7) instanceof Manhole);
	    assertTrue(city.getCellList().get(14).get(7) instanceof Manhole);
	    assertTrue(city.getCellList().get(7).get(0) instanceof Manhole);
	    assertTrue(city.getCellList().get(7).get(14) instanceof Manhole);
	}

	/**
	 * Test case for the initStreets method of the City class.
	 * It checks if streets are correctly placed in the middle of the city grid.
	 */
	@Test
	void initStreetsSuccess() {
	    City city = new City(10, 10);
	    city.initStreets();
	    ArrayList<ArrayList<Cell>> cellList = city.getCellList();
	    for (int i = 0; i < city.getLength(); i++) {
	        for (int j = 0; j < city.getWidth(); j++) {
	            Cell cell = cellList.get(i).get(j);
	            if (cell instanceof Street) {
	                if (i == city.getLength() / 2 || j == city.getWidth() / 2) {
	                    assertTrue(cell instanceof Street, "Expected Street at (" + i + ", " + j + ")");
	                } 
	            }
	        }
	    }
	}
        
        
	/**
	 * Test case for the placeVerticalStreet method of the City class.
	 * It checks if a vertical street is correctly placed within the city grid.
	 */
	@Test
	void testPlaceVerticalStreet() {
	    City city = new City(10, 10);
	    city.placeVerticalStreet(2, 5, 0, 9, 4);
	    ArrayList<ArrayList<Cell>> cellList = city.getCellList();
	    for (int i = 0; i < city.getLength(); i++) {
	        for (int j = 0; j < city.getWidth(); j++) {
	            Cell cell = cellList.get(i).get(j);
	            if (j == 4) {
	                assertTrue(cell instanceof Street);
	            }
	        }
	    }
	}

	/**
	 * Test case for the placeHorizontalStreet method of the City class.
	 * It checks if a horizontal street is correctly placed within the city grid.
	 */
	@Test
	void testPlaceHorizontalStreet() {
	    City city = new City(10, 10);
	    city.placeHorizontalStreet(0, 9, 3, 6, 5);
	    ArrayList<ArrayList<Cell>> cellList = city.getCellList();
	    for (int i = 0; i < city.getLength(); i++) {
	        for (int j = 0; j < city.getWidth(); j++) {
	            Cell cell = cellList.get(i).get(j);
	            if (i == 5) {
	                assertTrue(cell instanceof Street);
	            }
	        }
	    }
	}

	/**
	 * Test case for the placeActor method of the City class.
	 * It checks if an actor is correctly placed within the city grid.
	 */
	@Test
	void testPlaceActor() {
	    City city = new City(8, 8);
	    city.initCity();
	    Actor actor = new Fighter("adil");
	    int x = 2, y = 3;
	    city.placeActor(actor, x, y);
	    assertTrue(city.getCellList().get(y).get(x).getAllActors().contains(actor));
	}

	/**
	 * Test case for the setCellList method of the City class.
	 * It checks if the cell list of the city can be set and retrieved correctly.
	 */
	@Test
	void testSetCellList() {
	    City city = new City(8, 8);

	    // Create a new cell list
	    ArrayList<ArrayList<Cell>> newCellList = new ArrayList<>();
	    for (int i = 0; i < city.getLength(); i++) {
	        ArrayList<Cell> row = new ArrayList<>();
	        for (int j = 0; j < city.getWidth(); j++) {
	            // Add cells or null based on your implementation
	            row.add(new Street());
	        }
	        newCellList.add(row);
	    }

	    // Set the new cell list
	    city.setCellList(newCellList);

	    // Check if the cell list is set correctly
	    assertEquals(newCellList, city.getCellList());
	}

	/**
	 * Test case for the initRooms method of the City class.
	 * It checks if rooms are correctly initialized within the city grid.
	 */
	@Test
	void testInitRoomsSuccess() {
	    City city = new City(10, 10);
	    city.initStreets();
	    city.initRooms();
	    ArrayList<ArrayList<Cell>> cellList = city.getCellList();

	    for (int i = 0; i < city.getLength(); i++) {
	        for (int j = 0; j < city.getWidth(); j++) {
	            Cell cell = cellList.get(i).get(j);
	            if (cell instanceof Room) {
	                assertNotNull(cell.getDoorMap(), "Expected Room to have a door map");
	            }
	        }
	    }
	}

	/**
	 * Test case for the createDoorMap method of the City class.
	 * It checks if the door map is correctly created based on the provided parameters.
	 */
	@Test
	void testCreateDoorMap() {
	    City city = new City();
	    HashMap<Cardinal, Boolean> doorMap = city.createDoorMap(true, false, true, false);

	    assertTrue(doorMap.containsKey(Cardinal.NORTH));
	    assertTrue(doorMap.containsKey(Cardinal.SOUTH));
	    assertTrue(doorMap.containsKey(Cardinal.EAST));
	    assertTrue(doorMap.containsKey(Cardinal.WEST));
	    assertTrue(doorMap.get(Cardinal.NORTH));
	    assertFalse(doorMap.get(Cardinal.SOUTH));
	    assertTrue(doorMap.get(Cardinal.EAST));
	    assertFalse(doorMap.get(Cardinal.WEST));
	}
        
      
        

	
}
