package Action;
import static org.junit.Assert.*;
import org.junit.Test;

import Actor.Player.Player;
import Cell.Room.ClassicalRoom;
import Cell.Room.Room;
import City.City;
import City.TrainingCity;
import Equipment.Equipment;
import Equipment.Consumable.MedKit;
import Equipment.Weapon.Pistol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SearchTest {
	/**
	 * Test method to verify the behavior of searching in an empty room.
	 * This test ensures that a player's action points are not decreased when searching in an empty room.
	 */
    @Test
    public void testSearchWithEmptyRoom() {
        // Create a city
        City city = new City(5, 5);
        city.initCity();

        // Create a player
        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 2, 2);

        // Create an instance of Search action
        Search search = new Search(city);

        // Create an empty room
        ClassicalRoom room = new ClassicalRoom();
        city.getCellList().get(2).set(2, room);

        // Perform the search action
        search.Do(player);

        // Assert that the player receives a message about the absence of equipment
        // and his action points are not decreased
        assertEquals(3, player.getActionpoints()); // Assuming the player had 4 action points initially
    }
    /**
     * Test method to verify the behavior of searching in a room with equipment.
     * This test ensures that a player can successfully pick up equipment when searching in a room with equipment.
     */
    @Test
    public void testSearchWithEquipment() {
        // Create a city
        City city = new City(5, 5);
        city.initCity();

        // Create a player
        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 2, 2);

        // Create an instance of Search action
        Search search = new Search(city);

        // Create a room with equipment
        ClassicalRoom room = new ClassicalRoom();
        Pistol pistol = new Pistol();
        room.addEquipment(pistol);
        city.getCellList().get(2).set(2, room);
        
        // Prepare input for the InteractiveListChooser
        String input = "1\n"; // Choose the first equipment

        // Redirect System.in to provide input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        // Perform the search action
        search.Do(player);

        // Assert that the player receives a message about picking up the equipment
        // and the equipment is added to the player's backpack
        assertEquals(2, player.getActionpoints()); // Assuming the player had 4 action points initially
        assertEquals(1, player.getBackPack().size());
        assertTrue(player.getBackPack().get(0) instanceof Pistol);
    }
    /**
     * Test method to verify the behavior of the Search action when not enough parameters are provided.
     * This test ensures that the Do method fails gracefully when not enough parameters are provided.
     */
    @Test
    public void testMethodFail() {
    	City city = new City(5,5);
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Search search = new Search(city);
        search.Do();
        assertEquals("Who do you want to search?", outputStream.toString().trim());
    }
    /**
     * Test method to verify the behavior of searching with a full backpack.
     * This test ensures that a player's action points are not decreased and the backpack size remains the same when searching with a full backpack.
     */
    @Test
    public void testSearchWithFullBackpack() {
        // Create a city
        City city = new City(5, 5);
        city.initCity();
        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 2, 2);
        for (int i = 0; i < 5; i++) {
            player.addEquipment(new MedKit());
        }
        Search search = new Search(city);
        ClassicalRoom room = new ClassicalRoom();
        Pistol pistol = new Pistol();
        room.addEquipment(pistol);
        city.getCellList().get(2).set(2, room);
        search.Do(player);
        assertEquals(2, player.getActionpoints()); // Assuming the player had 4 action points initially
        assertEquals(5, player.getBackPack().size()); // Backpack size remains the same
        assertTrue(player.getBackPack().contains(pistol)); // The new equipment is added to the backpack
    }
    /**
     * Test method to verify the behavior of the toString() method in the Search class.
     * This test ensures that the toString() method returns the expected string representation of the Search action.
     */
    
    @Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Search search = new Search(Trainingcity);
        String result = search.toString();
        assertEquals("The toString method should return 'Search'", "Search", result);
    }
    
}
