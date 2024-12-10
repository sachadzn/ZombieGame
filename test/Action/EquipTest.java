package Action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import Actor.Player.Player;
import City.TrainingCity;
import Equipment.Equipment;
import Equipment.Weapon.Axe;

/**
 * Unit test class for the Equip class.
 */
public class EquipTest {
	/**
	 * Tests the toString() method of the Equip class.
	 * Verifies if the toString() method correctly returns the class name ("Equip").
	 */
	@Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Equip equip = new Equip();
        String result = equip.toString();
        assertEquals("The toString method should return 'Equip'", "Equip", result);
    }
	/**
	 * Tests the Equip(Actor actor, Equipment equipment) method of the Equip class.
	 * Verifies if the Equip() method correctly equips the player with the specified equipment
	 * and empties the player's backpack.
	 */
    @Test
    public void testEquip() {
        Player player = new Player("John");
        Equipment equipment = new Axe();
        player.addEquipment(equipment);
        Equip equip = new Equip();
        equip.Do(player, equipment);
        assertEquals(equipment, player.getHand());
        assertTrue(player.getBackPack().isEmpty());
    }
    /**
     * Tests the Equip(Actor actor, Equipment equipment) method of the Equip class when the specified equipment is not in the player's backpack.
     * Verifies if an appropriate message is displayed when the equipment is not found in the player's backpack.
     */
    @Test
    public void testEquipFail() {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Player player = new Player("John");
        Equipment equipment = new Axe();
        Equip equip = new Equip();
        equip.Do(player, equipment);
        assertEquals("There is not this equipment in the player's backpack!", outputStream.toString().trim());
    }
    /**
     * Tests the Do() method of the Equip class when the necessary parameters are not provided.
     * Verifies if an appropriate message is displayed when the method is called without the necessary parameters.
     */
    @Test
    public void testMethodFail() {
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Equip equip = new Equip();
        equip.Do();
        assertEquals("Need a Player and an equipment", outputStream.toString().trim());
    }
}
