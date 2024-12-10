package Equipment.Consumable;
import Equipment.Equipment;
import Equipment.Consumable.InfraredScop;
import Actor.Actor;
import City.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InfraredScopTest {
	/**
	 * Test case for the getAdjacentEquipments method of InfraredScop.
	 * It checks if the method correctly retrieves adjacent equipments.
	 */
	@Test
	public void testGetAdjacentEquipments2() {
	    // Creating a test city
	    City testCity = new City(5, 5);
	    testCity.initCity();

	    // Creating an instance of InfraredScop
	    InfraredScop infraredScop = new InfraredScop();

	    // Activating the ability to see through walls
	    infraredScop.activateSeeThroughWalls();

	    // Getting equipment from adjacent cells at a specific position
	    int centerX = 2;
	    int centerY = 2;
	    List<Equipment> adjacentEquipments = infraredScop.getAdjacentEquipments(testCity, centerX, centerY);

	    // Asserting that the list of adjacent equipments is not null
	    assertNotNull(adjacentEquipments);
	}

	/**
	 * Test case for the getAdjacentEquipments method of InfraredScop with parameters.
	 * It checks if the method correctly retrieves adjacent equipments with specified name and effect.
	 */
	@Test
	public void testGetAdjacentEquipments() {
	    // Creating a test city
	    City testCity = new City(5, 5);
	    testCity.initCity();

	    // Creating an instance of InfraredScop with parameters
	    InfraredScop infraredScop = new InfraredScop("InfraredScop", "See through walls");

	    // Activating the ability to see through walls
	    infraredScop.activateSeeThroughWalls();

	    // Getting equipment from adjacent cells at a specific position
	    int centerX = 2;
	    int centerY = 2;
	    List<Equipment> adjacentEquipments = infraredScop.getAdjacentEquipments(testCity, centerX, centerY);

	    // Asserting that the list of adjacent equipments is not null
	    assertNotNull(adjacentEquipments);
	}

	/**
	 * Test case for the getAdjacentActors method of InfraredScop.
	 * It checks if the method correctly retrieves adjacent actors.
	 */
	@Test
	public void testGetAdjacentActors() {
	    // Creating a test city
	    City testCity = new City(5, 5);
	    testCity.initCity();

	    // Creating an instance of InfraredScop
	    InfraredScop infraredScop = new InfraredScop("InfraredScop", "See through walls");

	    // Activating the ability to see through walls
	    infraredScop.activateSeeThroughWalls();

	    // Getting actors from adjacent cells at a specific position
	    int centerX = 2;
	    int centerY = 2;
	    List<Actor> adjacentActors = infraredScop.getAdjacentActors(testCity, centerX, centerY);

	    // Asserting that the list of adjacent actors is not null
	    assertNotNull(adjacentActors);
	}

	/**
	 * Test case for the isSeeThroughWallsActivated method of InfraredScop.
	 * It checks if the method correctly indicates if the ability to see through walls is activated.
	 */
	@Test
	void testIsSeeThroughWallsActivated() {
	    // Creating an instance of InfraredScop
	    InfraredScop infraredScop = new InfraredScop();

	    // Initially, seeThroughWalls should be false
	    assertFalse(infraredScop.isSeeThroughWallsActivated());

	    // Activating seeThroughWalls
	    infraredScop.activateSeeThroughWalls();

	    // After activation, seeThroughWalls should be true
	    assertTrue(infraredScop.isSeeThroughWallsActivated());
	}
}
