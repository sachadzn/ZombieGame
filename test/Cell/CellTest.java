package Cell;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Actor.Player.Player;
import Actor.Zombie.Walker;

import Cell.Room.ClassicalRoom;

import Cell.Street.Street;

import Equipment.Consumable.Map;

class CellTest  {
	
	

	/**
	 * Test case for the upSound method of the Cell class.
	 * It checks if the noise level increases correctly when a sound is made.
	 */
	@Test
	void testUpSound() {
	    Cell cell = new ClassicalRoom();
	    cell.upSound(5);
	    assertEquals(5, cell.getNoise());
	}

	/**
	 * Test case for the downSound method of the Cell class.
	 * It checks if the noise level decreases correctly when a sound is suppressed.
	 */
	@Test
	void testDownSound() {
	    Cell cell = new ClassicalRoom();
	    cell.downSound(3);
	    assertEquals(-3, cell.getNoise());
	}

	/**
	 * Test case for the canCatch method of the Cell class.
	 * It checks if the cell can catch something.
	 */
	@Test
	void testCanCatch() {
	    Cell cell = new ClassicalRoom();
	    cell.setCanCatch(true);
	    assertEquals(true, cell.canCatch());
	}

	/**
	 * Test case for the toString method of the Cell class.
	 * It checks if the toString method returns the correct string representation of the cell.
	 */
	@Test
	void testToString() {
	    Cell cell = new ClassicalRoom();
	    assertEquals("R", cell.toString());
	}
    
	/**
	 * Test case for the addEquipment and removeEquipment methods of the Street class.
	 * It checks if equipment can be added to and removed from the street.
	 */
	@Test
	void testAddRemoveEquipment() {
	    Street street = new Street();
	    Map equipment = new Map();

	    street.addEquipment(equipment);

	    assertTrue(street.getAllEquipments().contains(equipment));

	    street.removeEquipment(equipment);
	    assertFalse(street.getAllEquipments().contains(equipment));
	}

	/**
	 * Test case for the getAllEquipments method of the Street class.
	 * It checks if the method returns all the equipments in the street.
	 */
	@Test
	void testGetAllEquipments() {
	    Street street = new Street();
	    Map equipment = new Map();

	    street.addEquipment(equipment);

	    assertTrue(street.getAllEquipments().contains(equipment));
	}

	/**
	 * Test case for the setNoise method of the Street class.
	 * It checks if the noise level can be set to a specific value.
	 */
	@Test
	void testSetNoise() {
	    Street street = new Street();
	    // Set the noise level to a specific value
	    street.setNoise(10);
	    // Check if the noise level was set correctly
	    assertEquals(10, street.getNoise());
	}

	/**
	 * Test case for the countActors method of the Street class.
	 * It checks if the method returns the correct count of actors in the street.
	 */
	@Test
	void testCountActors() {
	    // Create a Street
	    Street cell = new Street();

	    // Add some actors to the cell
	    cell.addActor(new Walker());
	    cell.addActor(new Walker());
	    cell.addActor(new Player("John"));

	    // Check if countActors returns the correct string
	    assertEquals("Z2 S1", cell.countActors());
	}
}


 