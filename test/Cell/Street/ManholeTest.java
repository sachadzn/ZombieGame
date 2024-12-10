package Cell.Street;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ManholeTest {

	/**
	 * Test case for the getSpawnrate method of the Manhole class.
	 * It checks if the spawn rate of the manhole is retrieved correctly.
	 */
	@Test
	void testGetSpawnrate() {
	    Manhole manhole = new Manhole(3);
	    assertEquals(3, manhole.getSpawnrate());
	}

	/**
	 * Test case for the setSpawnrate method of the Manhole class.
	 * It checks if the spawn rate of the manhole can be set and retrieved correctly.
	 */
	@Test
	void testSetSpawnrate() {
	    Manhole manhole = new Manhole();
	    manhole.setSpawnrate(5);
	    assertEquals(5, manhole.getSpawnrate());
	}

	/**
	 * Test case for the toString method of the Manhole class.
	 * It checks if the toString method returns the correct string representation of the manhole.
	 */
	@Test
	void testToString() {
	    Manhole manhole = new Manhole();
	    assertEquals("M", manhole.toString());
	}
}
