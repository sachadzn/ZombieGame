package Cell.Room;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClassicalRoomTest {
	
	/**
	 * Test case for the canBeAttacked and setDescription methods of the ClassicalRoom class.
	 * It checks if the room can be attacked and if its description can be set and retrieved correctly.
	 */
	@Test
	void testCanBeAttacked2() {
	    ClassicalRoom classicalRoom = new ClassicalRoom(true, "Classical Room");
	    assertTrue(classicalRoom.canBeAttacked());
	}

	/**
	 * Test case for the canBeAttacked method of the ClassicalRoom class when the room cannot be attacked.
	 * It checks if the room cannot be attacked.
	 */
	@Test
	void testCannotBeAttacked() {
	    ClassicalRoom classicalRoom = new ClassicalRoom(false, "Classical Room");
	    assertFalse(classicalRoom.canBeAttacked());
	}

	/**
	 * Test case for the getDescription method of the ClassicalRoom class.
	 * It checks if the description of the room is retrieved correctly.
	 */
	@Test
	void testGetDescription() {
	    ClassicalRoom classicalRoom = new ClassicalRoom(true, "Classical Room");
	    assertEquals("Classical Room", classicalRoom.getDescription());
	}

	/**
	 * Test case for the setDescription method of the ClassicalRoom class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetDescription() {
	    ClassicalRoom classicalRoom = new ClassicalRoom(true, "Classical Room");
	    classicalRoom.setDescription("New Description");
	    assertEquals("New Description", classicalRoom.getDescription());
	}

	/**
	 * Test case for the toString method of the ClassicalRoom class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString2() {
	    ClassicalRoom classicalRoom = new ClassicalRoom(true, "Classical Room");
	    assertEquals("R", classicalRoom.toString());
	}	
	/**
	 * Test case for the canBeAttacked method of the ClassicalRoom class.
	 * It checks if the room can be attacked by default.
	 */
	@Test
	void testCanBeAttacked() {
	    ClassicalRoom room = new ClassicalRoom();
	    assertTrue(room.canBeAttacked());
	}

	/**
	 * Test case for the setDescription and getDescription methods of the ClassicalRoom class.
	 * It checks if the description of the room can be set and retrieved correctly.
	 */
	@Test
	void testSetAndGetDescription() {
	    ClassicalRoom room = new ClassicalRoom();
	    room.setDescription("Test Description");
	    assertEquals("Test Description", room.getDescription());
	}

	/**
	 * Test case for the setBeAttacked and canBeAttacked methods of the ClassicalRoom class.
	 * It checks if the room's attack status can be set and retrieved correctly.
	 */
	@Test
	void testSetCanBeAttacked() {
	    ClassicalRoom room = new ClassicalRoom();
	    room.setBeAttacked(true);
	    assertTrue(room.canBeAttacked());
	}

	/**
	 * Test case for the toString method of the ClassicalRoom class.
	 * It checks if the toString method returns the correct string representation of the room.
	 */
	@Test
	void testToString() {
	    ClassicalRoom classicalRoom = new ClassicalRoom();
	    assertEquals("R", classicalRoom.toString());
	}

	/**
	 * Test case for the default constructor of the ClassicalRoom class.
	 * It checks if the default constructor initializes the room correctly.
	 */
	@Test
	void testConstructor() {
	    ClassicalRoom classicalRoom = new ClassicalRoom();
	    assertEquals("R", classicalRoom.toString());
	}

}
