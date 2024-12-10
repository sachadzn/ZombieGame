package City;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DoorTest {

	
	/**
	 * Test case for the default constructor of the Door class.
	 * It checks if a default door is closed and can be opened.
	 */
	@Test
	void testDefaultConstructor() {
	    Door door = new Door();
	    assertFalse(door.isOpen());
	    assertTrue(door.isCanBeOpened());
	}

	/**
	 * Test case for the parameterized constructor of the Door class.
	 * It checks if a door with specified parameters is created correctly.
	 */
	@Test
	void testParameterizedConstructor() {
	    Door door = new Door(true, false);
	    assertTrue(door.isOpen());
	    assertFalse(door.isCanBeOpened());
	}

	/**
	 * Test case for the getter and setter methods of the Door class.
	 * It checks if the open and canBeOpened properties of the door can be set and retrieved correctly.
	 */
	@Test
	void testGetterSetterMethods() {
	    Door door = new Door();

	    door.setOpen(true);
	    assertTrue(door.isOpen());

	    door.setCanBeOpened(false);
	    assertFalse(door.isCanBeOpened());
	}

}
