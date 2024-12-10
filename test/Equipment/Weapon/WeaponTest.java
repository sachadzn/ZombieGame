package Equipment.Weapon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Axe;

class WeaponTest {

	/**
	 * Test case for the Weapon class and its subclasses.
	 * It verifies the initialization of a weapon object and checks the setter and getter methods.
	 */
	@Test
    void testWeaponInitialization() {
      

        // Act
        Axe weapon = new Axe();

        // Assert
        assertEquals("Axe", weapon.getName());
        assertEquals(2, weapon.getDamage());
        assertEquals(4, weapon.getThreshold());
        assertEquals(0, weapon.getRange());
        assertEquals(1, weapon.getThrowDice());
    }

	/**
	 * Test case for the setter and getter methods of the Weapon class and its subclasses.
	 * It checks if the setter methods correctly set the attributes and if the getter methods return the expected values.
	 */
	@Test
    void testSettersAndGetters() {
        // Arrange
    	Axe weapon = new Axe();

        // Act
        weapon.setDamage(12);
        weapon.setThreshold(6);
        weapon.setRange(4);
        weapon.setThrowDice(4);

        // Assert
        assertEquals(12, weapon.getDamage());
        assertEquals(6, weapon.getThreshold());
        assertEquals(4, weapon.getRange());
        assertEquals(4, weapon.getThrowDice());
    }

}
