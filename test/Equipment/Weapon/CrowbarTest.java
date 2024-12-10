package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Crowbar;

class CrowbarTest {

	/**
	 * Test case for the Crowbar class constructor and getter methods.
	 * It checks if the constructor initializes a Crowbar object with correct attributes
	 * and if the getter methods return the expected values.
	 */
	@Test
    public void testcrowbar() {

        Crowbar crowbar = new Crowbar();
        assertEquals(4, crowbar.getThreshold());
        assertEquals(0, crowbar.getRange());
        assertEquals(1, crowbar.getDamage());
        assertEquals(1, crowbar.getThrowDice());
        assertEquals("Crowbar", crowbar.getName());

    }

}
