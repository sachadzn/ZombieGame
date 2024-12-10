package Cell.Room;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PharmacyTest {
	/**
	 * Test case for the canBeAttacked method of the Pharmacy class.
	 * It checks if the room can be attacked when explicitly specified.
	 */
	@Test
	void testCanBeAttacked2() {
	    Pharmacy pharmacy = new Pharmacy(true, "Default pharmacy room");
	    assertTrue(pharmacy.canBeAttacked());
	}

	/**
	 * Test case for the getDescription method of the Pharmacy class.
	 * It checks if the description of the room is retrieved correctly.
	 */
	@Test
	void testGetDescription() {
	    Pharmacy pharmacy = new Pharmacy(false, "Default pharmacy room");
	    assertEquals("Default pharmacy room", pharmacy.getDescription());
	}

	/**
	 * Test case for the setDescription method of the Pharmacy class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetDescription() {
	    Pharmacy pharmacy = new Pharmacy(false, "Default pharmacy room");
	    pharmacy.setDescription("New Description");
	    assertEquals("New Description", pharmacy.getDescription());
	}

	/**
	 * Test case for the toString method of the Pharmacy class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString2() {
	    Pharmacy pharmacy = new Pharmacy(false, "Default pharmacy room");
	    assertEquals("P", pharmacy.toString());
	}

	/**
	 * Test case for the canBeAttacked method of the Pharmacy class.
	 * It checks if the room can be attacked by default.
	 */
	@Test
	void testCanBeAttacked() {
	    Pharmacy room = new Pharmacy();
	    assertTrue(room.canBeAttacked());
	}

	/**
	 * Test case for the setDescription and getDescription methods of the Pharmacy class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetAndGetDescription() {
	    Pharmacy room = new Pharmacy();
	    room.setDescription("Test Description");
	    assertEquals("Test Description", room.getDescription());
	}

	/**
	 * Test case for the setBeAttacked and canBeAttacked methods of the Pharmacy class.
	 * It checks if the room's attack status can be set and retrieved correctly.
	 */
	@Test
	void testSetCanBeAttacked() {
	    Pharmacy room = new Pharmacy();
	    room.setBeAttacked(true);
	    assertTrue(room.canBeAttacked());
	}

	/**
	 * Test case for the toString method of the Pharmacy class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString() {
	    Pharmacy pharmacy = new Pharmacy();
	    assertEquals("P", pharmacy.toString());
	}
}
