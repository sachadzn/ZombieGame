package Action;
import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Actor;
import Actor.Player.Fighter;
import Actor.Player.Player;
import Actor.Zombie.Fatty;
import City.Cardinal;
import City.City;
import City.TrainingCity;
import Equipment.Equipment;
import Equipment.Consumable.HealingVial;
import Equipment.Consumable.MedKit;
import Equipment.Weapon.Pistol;
import Cell.Cell;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Unit test class for the LookAround class.
 */
public class LookAroundTest {
	/**
	 * Tests the Do() method of the LookAround class.
	 * Verifies if the Do() method correctly displays the message "Who do you want to look around?".
	 */
	@Test
    public void testDo() {
        // Capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create a city
        City city = new City(5, 5);

        // Call the method you want to test
        LookAround lookAround = new LookAround(city);
        lookAround.Do();

        // Verify the output
        String expectedOutput = "Who do you want to look around?";
        assertEquals(expectedOutput, outputStream.toString().trim());

        // Restore original System.out
        System.setOut(System.out);
    }
	/**
	 * Tests the Do(Player player) method of the LookAround class.
	 * Verifies if the Do(Player player) method correctly displays information about actors,
	 * doors, and equipment present in the cell where the player is located.
	 */
    @Test
    public void testDoPlayer() {
    	// Create a city
        City city = new City(5, 5);
        city.initCity();

        // Create a player
        Player player = new Player("John");
        city.placeActor(player, 2, 2);
        Cell currentCell = city.getCellList().get(2).get(2);
        Fighter actor1 = new Fighter("Actor1");
        Fighter actor2 = new Fighter("Actor2");
        currentCell.addActor(actor1);
        currentCell.addActor(actor2);
        currentCell.getDoorMap().put(Cardinal.NORTH, true);
        currentCell.getDoorMap().put(Cardinal.SOUTH, false);
        currentCell.getDoorMap().put(Cardinal.EAST, true);
        currentCell.getDoorMap().put(Cardinal.WEST, false);
        Equipment equipment1 = new MedKit();
        Equipment equipment2 = new HealingVial();
        currentCell.addEquipment(equipment1);
        currentCell.addEquipment(equipment2);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Call the method you want to test
        LookAround lookAround = new LookAround(city);
        lookAround.Do(player);

        // Restore System.out
        System.setOut(originalOut);

        // Verify the output
        String expectedOutput = "Actors in the current cell: [John { lifepoints: 5 actionpoints: 3 level: 1 hand: null } , Actor1 { lifepoints: 5 actionpoints: 3 level: 1 hand: null } , Actor2 { lifepoints: 5 actionpoints: 3 level: 1 hand: null } ]\r\n"
        		+ "Doors in the current cell: {EAST=true, WEST=false, NORTH=true, SOUTH=false}\r\n"
        		+ "Equipment in the current cell: [MedKit { effect: using a med kit allows you to heal one of the survivors in your zone (+1 life point) noisy: false }, HealingVial { effect: Using a healing vial allows you to gain a life point noisy: false }]";
        
    }
    /**
     * Tests the toString() method of the LookAround class.
     * Verifies if the toString() method correctly returns the class name ("LookAround").
     */
    @Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        LookAround lookAround = new LookAround(Trainingcity);
        String result = lookAround.toString();
        assertEquals("The toString method should return 'LookAround'", "LookAround", result);
    }
}
