package City;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CoordinateTest {

	/**
	 * Test case for the getX method of the Coordinate class.
	 * It checks if the x-coordinate is retrieved correctly.
	 */
	@Test
	void testGetX() {
	    Coordinate coordinate = new Coordinate(3, 4);
	    assertEquals(3, coordinate.getX());
	}

	/**
	 * Test case for the setX method of the Coordinate class.
	 * It checks if the x-coordinate is set and retrieved correctly.
	 */
	@Test
	void testSetX() {
	    Coordinate coordinate = new Coordinate(3, 4);
	    coordinate.setX(5);
	    assertEquals(5, coordinate.getX());
	}

	/**
	 * Test case for the getY method of the Coordinate class.
	 * It checks if the y-coordinate is retrieved correctly.
	 */
	@Test
	void testGetY() {
	    Coordinate coordinate = new Coordinate(3, 4);
	    assertEquals(4, coordinate.getY());
	}

	/**
	 * Test case for the setY method of the Coordinate class.
	 * It checks if the y-coordinate is set and retrieved correctly.
	 */
	@Test
	void testSetY() {
	    Coordinate coordinate = new Coordinate(3, 4);
	    coordinate.setY(6);
	    assertEquals(6, coordinate.getY());
	}
}
