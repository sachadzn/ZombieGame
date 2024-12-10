package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Pistol;

class PistolTest {

	/**
	 * Test case for the Pistol class constructor and getter methods.
	 * It checks if the constructor initializes a Pistol object with correct attributes
	 * and if the getter methods return the expected values.
	 */
	@Test
	public void testPistol() {
	    // Create an instance of Pistol
	    Pistol pistol = new Pistol();
	    assertEquals(4, pistol.getThreshold());
	    assertEquals(1, pistol.getRange());
	    assertEquals(2, pistol.getDamage());
	    assertEquals(1, pistol.getThrowDice());
	    assertEquals("Pistol", pistol.getName());
	}

}
