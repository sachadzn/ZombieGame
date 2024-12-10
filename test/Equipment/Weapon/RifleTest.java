package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Rifle;

class RifleTest {

	/**
	 * Test case for the Rifle class constructor and getter methods.
	 * It checks if the constructor initializes a Rifle object with correct attributes
	 * and if the getter methods return the expected values.
	 */
	@Test
    public void testRifle() {
        Rifle rifle = new Rifle();
        assertEquals(4, rifle.getThreshold());
        assertEquals(3, rifle.getRange());
        assertEquals(1, rifle.getDamage());
        assertEquals(2, rifle.getThrowDice());
        assertEquals("Rifle", rifle.getName());

    }

}
