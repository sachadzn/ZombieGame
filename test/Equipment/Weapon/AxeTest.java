package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Axe;



class AxeTest {

	/**
	 * Test case for the Axe class constructor and getter methods.
	 * It checks if the constructor initializes an Axe object with correct attributes
	 * and if the getter methods return the expected values.
	 */
	@Test
	public void testAxe() {
	    Axe axe = new Axe();
	    assertEquals(4, axe.getThreshold());
	    assertEquals(0, axe.getRange());
	    assertEquals(2, axe.getDamage());
	    assertEquals(1, axe.getThrowDice());
	    assertEquals("Axe", axe.getName());
	}

}
