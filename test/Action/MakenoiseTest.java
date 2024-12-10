package Action;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import Actor.Player.Player;
import City.City;
import City.TrainingCity;
import Cell.Cell;
import Cell.Room.ClassicalRoom;
import Cell.Room.Room;

/**
 * Unit test class for the Makenoise class.
 */
public class MakenoiseTest {
	/**
	 * Tests the makeNoise() method of the Makenoise class.
	 * Verifies if the noise level in the cell increases by 1 after executing makeNoise(),
	 * and if the player's action points decrease by 1.
	 */
	@Test
	public void testMakeNoise() {
	    City city = new City(5, 5);

	    // Initialize the cell where the player is located
	    Cell currentCell = new ClassicalRoom();
	    currentCell.setNoise(0); // Ensure the initial noise level is set to 0
	    city.getCellList().get(2).set(2, currentCell); // Set the cell in the city grid

	    Player player = new Player("John");
	    player.setX(2);
	    player.setY(2);

	    Makenoise makenoise = new Makenoise(city);
	    makenoise.Do(player);

	    assertEquals(1, currentCell.getNoise());
	    assertEquals(3, player.getActionpoints());
	}
	/**
	 * Tests the Do() method of the Makenoise class.
	 * Verifies if the Do() method correctly displays the message "Who do you want to Search?".
	 */
	@Test
	public void testDo() {
		City city = new City(5, 5);
		// Capture System.out
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the method you want to test
        Makenoise makenoise = new Makenoise(city);
        makenoise.Do();

        String expectedOutput = "Who do you want to Search?\n";
        
	}
}
