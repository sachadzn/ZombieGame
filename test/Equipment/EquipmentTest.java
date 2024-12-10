package Equipment;

import org.junit.jupiter.api.Test;

import Equipment.Weapon.Rifle;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentTest {

	/**
	 * Test case for the constructor of the Equipment class.
	 * It checks if an equipment instance with a specific name is created correctly.
	 */
	@Test
	void testEquipmentConstructor() {
	    // Create an equipment instance with a specific name
	    Equipment equipment = new TestEquipment("Test Equipment");

	    // Check if the equipment name is correct
	    assertEquals("Test Equipment", equipment.getName());
	}

	/**
	 * Test case for the setName method of the Equipment class.
	 * It checks if the name of the equipment is set correctly.
	 */
	@Test
	void testEquipmentSetName() {
	    // Create an equipment instance
	    Equipment equipment = new TestEquipment("Test Equipment");

	    // Modify the equipment name
	    equipment.setName("New Name");

	    // Check if the new name is correct
	    assertEquals("New Name", equipment.getName());
	}

	/**
	 * Test case for the noisy method of the Rifle class.
	 * It checks if the noisy property of the rifle is set correctly.
	 */
	@Test
	void noisy() {
	    Rifle equipment = new Rifle();
	    assertTrue(equipment.getNoisy());
	}

	// Create an inner class to test Equipment
	private static class TestEquipment extends Equipment {
	    public TestEquipment(String name) {
	        super(name);
	    }
	}
}
