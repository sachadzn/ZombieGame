package Equipment.Consumable;

import org.junit.jupiter.api.Test;

import Equipment.Consumable.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

	/**
	 * Test case for the Map class constructor.
	 * It checks if the constructor initializes the Map object correctly.
	 */
	@Test
	void testMapCreation() {
	    // Creating an instance of Map
	    Map map = new Map();

	    // Asserting that the created instance is not null
	    assertNotNull(map);

	    // Asserting that the name is set correctly
	    assertEquals("Map", map.getName());

	    // Asserting that the effect is set correctly
	    assertEquals("Using a map allows you to visualize the entire city and the actors", map.getEffect());
	}

	/**
	 * Test case for the default constructor of the Map class.
	 * It checks if the default constructor initializes the Map object with default values.
	 */
	@Test
	void testMapDefaultValues() {
	    // Creating an instance of Map using the default constructor
	    Map map = new Map();

	    // Asserting that the created instance is not null
	    assertNotNull(map);

	    // Asserting that the default name is set correctly
	    assertEquals("Map", map.getName());

	    // Asserting that the default effect is set correctly
	    assertEquals("Using a map allows you to visualize the entire city and the actors", map.getEffect());
	}
}
