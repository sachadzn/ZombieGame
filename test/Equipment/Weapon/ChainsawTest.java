package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Chainsaw;

class ChainsawTest {

	/**
	 * Test case for the Chainsaw class constructor and getter methods.
	 * It checks if the constructor initializes a Chainsaw object with correct attributes
	 * and if the getter methods return the expected values.
	 */
	@Test
    public void testchainsaw() {

		Chainsaw chainsaw = new Chainsaw();
        assertEquals(5, chainsaw.getThreshold());
        assertEquals(0, chainsaw.getRange());
        assertEquals(3, chainsaw.getDamage());
        assertEquals(2, chainsaw.getThrowDice());
        assertEquals("Chainsaw", chainsaw.getName());

    }

}
