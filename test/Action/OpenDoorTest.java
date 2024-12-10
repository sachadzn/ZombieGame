package Action;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;

import Actor.Actor;
import Actor.Player.Player;
import Actor.Zombie.Abomination;
import Actor.Zombie.Fatty;
import Actor.Zombie.Walker;
import City.Cardinal;
import City.City;
import City.TrainingCity;
import Equipment.Consumable.MasterKey;
import Equipment.Weapon.Axe;
import Equipment.Weapon.Chainsaw;
import Cell.Cell;
import Cell.Street.Manhole;

public class OpenDoorTest {
	/**
	 * Test method to verify opening a door with a Master Key.
	 * This test ensures that a player can successfully open a door using a Master Key.
	 */
    @Test
    public void testOpenDoorWithMasterKey() {
    	City city = new City(5, 5);
        city.initCity();

        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 1, 2);
        player.setHand(new MasterKey());

        OpenDoor openDoor = new OpenDoor(city);

        openDoor.Do(player, Cardinal.NORTH);
        

        assertTrue(city.getCellList().get(2).get(1).getDoorMap().get(Cardinal.NORTH));
        assertNull(player.getHand());
        assertEquals(1,player.getX());
        assertEquals(2,player.getY());
    }
    /**
     * Test method to verify opening a door with an Axe.
     * This test ensures that a player cannot open a door with an Axe.
     */
    @Test
    public void testOpenDoorWithAxe() {
        City city = new City(5, 5);
        city.initCity();

        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 1, 2);
        player.setHand(new Chainsaw());

        OpenDoor openDoor = new OpenDoor(city);

        openDoor.Do(player, Cardinal.NORTH);

        assertTrue(city.getCellList().get(1).get(2).getDoorMap().get(Cardinal.NORTH));
        assertNotNull(player.getHand());
        assertEquals(1,player.getX());
        assertEquals(2,player.getY());
    }
    /**
     * Test method to verify opening a door when the player is against a wall.
     * This test ensures that attempting to open a door when the player is against a wall does not cause any issues.
     */
    @Test
    public void testOpenDoorWall() {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        City city = new City(5, 5);
        city.initCity();

        Player player = new Player("John");
        player.setX(2);
        player.setY(2);
        city.placeActor(player, 0, 0);

        OpenDoor openDoor = new OpenDoor(city);

        openDoor.Do(player, Cardinal.NORTH);
    }
    /**
     * Test method to verify the behavior when attempting to open a door that is already open.
     * This test ensures that attempting to open a door that is already open does not affect the player's state.
     */
   @Test
   public void testDoorAlreadyOpen() {
    	City city = new City(5, 5);
        city.initCity();

        Player player = new Player("John");
        city.placeActor(player, 2, 2);
        player.setHand(new MasterKey());

        OpenDoor openDoor = new OpenDoor(city);
        openDoor.Do(player, Cardinal.NORTH);

        assertNotNull(player.getHand());
        assertEquals(2,player.getX());
        assertEquals(2,player.getY());
   }
   /**
    * Test method to verify the behavior of the OpenDoor action when not enough parameters are provided.
    * This test ensures that the Do method fails gracefully when not enough parameters are provided.
    */
   @Test
   public void testMethodFail() {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        City city = new City();
        OpenDoor openDoor = new OpenDoor(city);
        openDoor.Do();
        assertEquals("To open a door, you must specify a player and a cardinal direction.", outputStream.toString().trim());
   }
   /**
    * Test method to verify the spawning of zombies after a door is opened.
    * This test ensures that the correct number of zombies spawn after a door is opened.
    */
   @Test
   public void testZombieSpawnAfterDoorOpened() {
       City city = new City(5, 5);
       city.initCity();
       OpenDoor openDoor = new OpenDoor(city);
       openDoor.zombieSpawnAfterDoorOpened(1);
       int walkerCount = 0;
       int abominationCount = 0;
       int fattyCount = 0;

       for (int y = 0; y < city.getLength(); y++) {
           for (int x = 0; x < city.getWidth(); x++) {
               if (city.getCellList().get(y).get(x) instanceof Manhole) {
                   for (Actor actor : city.getCellList().get(y).get(x).getAllActors()) {
                       if (actor instanceof Walker) {
                           walkerCount++;
                       }
                   }
               }
           }
       }
    	   assertTrue("Number of Walkers spawned is within the expected range", walkerCount >= 1 && walkerCount <= 3);
           assertTrue("Number of Abominations spawned is within the expected range", abominationCount== 0);
           assertTrue("Number of Fatties spawned is within the expected range", fattyCount == 0);
       
       
   }
   /**
    * Test method to verify the spawning of zombies after a door is opened with different parameters.
    * This test ensures that the correct types and numbers of zombies spawn after a door is opened with different parameters.
    */
   @Test
   public void testZombieSpawnAfterDoorOpened2() {
       City city = new City(5, 5);
       city.initCity();
       OpenDoor openDoor = new OpenDoor(city);
       openDoor.zombieSpawnAfterDoorOpened(2);
       int walkerCount = 0;
       int abominationCount = 0;
       int fattyCount = 0;

       for (int y = 0; y < city.getLength(); y++) {
           for (int x = 0; x < city.getWidth(); x++) {
               if (city.getCellList().get(y).get(x) instanceof Manhole) {
                   for (Actor actor : city.getCellList().get(y).get(x).getAllActors()) {
                       if (actor instanceof Abomination) {
                           abominationCount++;
                       } 
                       }
                   }
               }
           }
       
    	assertTrue("Number of Walkers spawned is within the expected range", walkerCount == 0);
        assertTrue("Number of Abominations spawned is within the expected range", abominationCount== 1);
        assertTrue("Number of Fatties spawned is within the expected range", fattyCount == 0);
    	   
       
   }
   /**
    * Test method to verify the spawning of zombies after a door is opened with different parameters.
    * This test ensures that the correct types and numbers of zombies spawn after a door is opened with different parameters.
    */
   @Test
   public void testZombieSpawnAfterDoorOpened3() {
       City city = new City(5, 5);
       city.initCity();
       OpenDoor openDoor = new OpenDoor(city);
       openDoor.zombieSpawnAfterDoorOpened(3);
       int walkerCount = 0;
       int abominationCount = 0;
       int fattyCount = 0;

       for (int y = 0; y < city.getLength(); y++) {
           for (int x = 0; x < city.getWidth(); x++) {
               if (city.getCellList().get(y).get(x) instanceof Manhole) {
                   for (Actor actor : city.getCellList().get(y).get(x).getAllActors()) {
                      if (actor instanceof Fatty) {
                           fattyCount++;
                       }
                   }
               }
           }
       }
    	assertTrue("Number of Walkers spawned is within the expected range", walkerCount == 0);
        assertTrue("Number of Abominations spawned is within the expected range", abominationCount== 0);
        assertTrue("Number of Fatties spawned is within the expected range", fattyCount == 1);
   }
   /**
    * Test method to verify the behavior of the toString() method in the OpenDoor class.
    * This test ensures that the toString() method returns the expected string representation of the OpenDoor action.
    */
   @Test
   public void testToString() {
   	TrainingCity Trainingcity = new TrainingCity();
       Trainingcity.initCity();
       OpenDoor openDoor = new OpenDoor(Trainingcity);
       String result = openDoor.toString();
       assertEquals("The toString method should return 'OpenDoor'", "OpenDoor", result);
   }
}



