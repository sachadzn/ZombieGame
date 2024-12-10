package Cell.Room;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContinentalTest {
	
	/**
	 * Test case for the canBeAttacked method of the Continental class.
	 * It checks if the room cannot be attacked by default.
	 */
	@Test
	void testCannotBeAttacked() {
	    Continental continental = new Continental("Default continental room");
	    assertFalse(continental.canBeAttacked());
	}

	/**
	 * Test case for the getDescription method of the Continental class.
	 * It checks if the description of the room is retrieved correctly.
	 */
	@Test
	void testGetDescription() {
	    Continental continental = new Continental("Default continental room");
	    assertEquals("Default continental room", continental.getDescription());
	}

	/**
	 * Test case for the setDescription method of the Continental class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetDescription() {
	    Continental continental = new Continental("Default continental room");
	    continental.setDescription("New Description");
	    assertEquals("New Description", continental.getDescription());
	}

	/**
	 * Test case for the toString method of the Continental class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString2() {
	    Continental continental = new Continental("Default continental room");
	    assertEquals("C", continental.toString());
	}

	/**
	 * Test case for the canBeAttacked method of the Continental class.
	 * It checks if the room cannot be attacked by default.
	 */
	@Test
	void testCanBeAttacked() {
	    Continental room = new Continental();
	    assertFalse(room.canBeAttacked());
	}

	/**
	 * Test case for the setDescription and getDescription methods of the Continental class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetAndGetDescription() {
	    Continental room = new Continental();
	    room.setDescription("Test Description");
	    assertEquals("Test Description", room.getDescription());
	}

	/**
	 * Test case for the setBeAttacked and canBeAttacked methods of the Continental class.
	 * It checks if the room's attack status can be set and retrieved correctly.
	 */
	@Test
	void testSetCanBeAttacked() {
	    Continental room = new Continental();
	    room.setBeAttacked(true);
	    assertTrue(room.canBeAttacked());
	}

	/**
	 * Test case for the toString method of the Continental class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString() {
	    Continental continental = new Continental();
	    assertEquals("C", continental.toString());
	}
}
