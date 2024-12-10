package Actor.Player;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Actor.Player.Player;
import Equipment.Equipment;

import Equipment.Consumable.HealingVial;
import Equipment.Consumable.Map;
import Equipment.Consumable.MedKit;

public class PlayerTest {

	/**
	 * Test cases for the Player class constructors and methods.
	 */
	@Test
	public void testPlayerConstructorWithName() {
	    // Creating a player with only name
	    Player player = new Player("adil");

	    // Asserting player attributes
	    assertEquals("adil", player.getName());
	    assertEquals(5, player.getLifepoints());
	    assertEquals(3, player.getActionpoints());
	    assertEquals(1, player.getLevel());
	    assertNull(player.getHand());
	    assertTrue(player.getBackPack().isEmpty());
	    assertTrue(player.getRoles().isEmpty());
	}

	/**
	 * Test cases for the Player class constructors and methods.
	 * Testing constructor with name and custom lifepoints and actionpoints.
	 */
	@Test
	public void testPlayerConstructorWithNameAndStats() {
	    int lifepoints = 10;
	    int actionpoints = 5;
	    Player player = new Player("adil", lifepoints, actionpoints);

	    // Asserting player attributes
	    assertEquals("adil", player.getName());
	    assertEquals(lifepoints, player.getLifepoints());
	    assertEquals(actionpoints, player.getActionpoints());
	    assertEquals(1, player.getLevel());
	    assertNull(player.getHand());
	    assertTrue(player.getBackPack().isEmpty());
	    assertTrue(player.getRoles().isEmpty());
	}

	/**
	 * Test cases for the Player class constructors and methods.
	 * Testing the addition of equipment to the player's backpack.
	 */
	@Test
	public void testAddEquipmentToBackpack() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Creating a medkit
	    MedKit equipment = new MedKit();

	    // Adding equipment to backpack
	    player.addEquipment(equipment);

	    // Asserting equipment addition
	    assertEquals(1, player.getBackPack().size());
	    assertEquals(equipment, player.getBackPack().get(0));
	}
	/**
	 * Test cases for removing equipment from the player's backpack, rolling a dice, checking player roles, and the toString method.
	 */
	@Test
	public void testRemoveEquipmentFromBackpack() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Creating a medkit
	    MedKit equipment = new MedKit();
	    // Adding equipment to backpack
	    player.addEquipment(equipment);

	    // Removing equipment from backpack
	    player.removeBackpackEquipment(equipment);

	    // Asserting equipment removal
	    assertTrue(player.getBackPack().isEmpty());
	}

	/**
	 * Test cases for removing equipment from the player's backpack, rolling a dice, checking player roles, and the toString method.
	 * Testing the roll of a dice.
	 */
	@Test
	public void testDiceRoll() {
	    // Creating a player
	    Player player = new Player("TestPlayer");

	    // Rolling a dice
	    int roll = player.diceRoll();

	    // Asserting dice roll result
	    assertTrue(roll >= 1 && roll <= 6);
	}

	/**
	 * Test cases for removing equipment from the player's backpack, rolling a dice, checking player roles, and the toString method.
	 * Testing whether the player has a specific role.
	 * When the player has the role.
	 */
	@Test
	public void testHasRoleWhenPlayerHasRole() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Adding a role to the player
	    player.getRoles().add("Warrior");

	    // Asserting that player has the role
	    assertTrue(player.hasRole("Warrior"));
	}

	/**
	 * Test cases for removing equipment from the player's backpack, rolling a dice, checking player roles, and the toString method.
	 * Testing whether the player has a specific role.
	 * When the player does not have the role.
	 */
	@Test
	public void testHasRoleWhenPlayerDoesNotHaveRole() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Adding a different role to the player
	    player.getRoles().add("Warrior");

	    // Asserting that player does not have the role
	    assertFalse(player.hasRole("Mage"));
	}

	/**
	 * Test cases for removing equipment from the player's backpack, rolling a dice, checking player roles, and the toString method.
	 * Testing the toString method.
	 */
	@Test
	public void testToString() {
	    // Setting up lifepoints, actionpoints, and level
	    int lifepoints = 10;
	    int actionpoints = 5;
	    int level = 2;
	    // Creating a player with custom attributes
	    Player player = new Player("adil", lifepoints, actionpoints);
	    player.setLevel(level);

	    // Expected string representation of the player
	    String expected = "adil { lifepoints: 10 actionpoints: 5 level: 2 hand: null } ";

	    // Asserting the string representation of the player
	    assertEquals(expected, player.toString());
	}
    
	/**
	 * Test cases for setting and removing the player's hand, and checking the backpack status.
	 */
	@Test
	public void testSetHand() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Creating a medkit
	    MedKit equipment = new MedKit();

	    // Setting the player's hand
	    player.setHand(equipment);

	    // Asserting the hand equipment
	    assertEquals(equipment, player.getHand());
	}

	/**
	 * Test cases for setting and removing the player's hand, and checking the backpack status.
	 */
	@Test
	public void testRemoveHand() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Creating a medkit
	    MedKit equipment = new MedKit();
	    // Setting the player's hand
	    player.setHand(equipment);

	    // Removing the player's hand
	    player.removeHand();

	    // Asserting the removal of the hand
	    assertNull(player.getHand());
	}

	/**
	 * Test cases for setting and removing the player's hand, and checking the backpack status.
	 * Testing when the backpack is empty.
	 */
	@Test
	public void testCheckBackpackEmpty() {
	    // Creating a player
	    Player player = new Player("TestPlayer");

	    // Redirecting System.out to capture printed output
	    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStreamCaptor));

	    // Checking the backpack status
	    player.checkBackpack();

	    // No need to assert printed output in this case
	}

	/**
	 * Test cases for setting and removing the player's hand, and checking the backpack status.
	 * Testing when the backpack is not empty.
	 */
	@Test
	public void testCheckBackpackNotEmpty() {
	    // Creating a player
	    Player player = new Player("TestPlayer");
	    // Creating a medkit
	    MedKit med = new MedKit();
	    // Adding equipment to the backpack
	    player.addEquipment(med);

	    // Redirecting System.out to capture printed output
	    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outputStreamCaptor));

	    // Checking the backpack status
	    player.checkBackpack();
	}
}
