package Cell.Street;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StreetTest {

	/**
	 * Test case for the toString method of the Street class.
	 * It checks if the toString method returns the correct string representation of a Street object.
	 */
	@Test
	void testToString() {
	    Street street = new Street();
	    assertEquals("S", street.toString());
	}
}
