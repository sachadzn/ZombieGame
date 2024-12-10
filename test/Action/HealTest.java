package Action;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import Actor.Player.Healer;
import Actor.Player.Player;
import City.TrainingCity;

/**
 * Unit test class for the Heal class.
 */
public class HealTest {
	/**
	 * Tests the heal(Actor actor) method of the Heal class.
	 * Verifies if the heal() method correctly increases the player's health points passed as a parameter,
	 * and decreases the healer's action points.
	 */
    @Test
    public void testHeal() {
      
        Player player = new Player("John");
        player.setLifepoints(3); // Set player's lifepoints to 3

        Healer healer = new Healer("adil");

        Heal heal = new Heal(null);
        heal.Do(healer,player );

        assertEquals(4, player.getLifepoints());

        assertEquals(2, healer.getActionpoints());
    }
    /**
     * Tests the heal(Actor actor) method of the Heal class when the player already has maximum life.
     * Verifies if the heal() method does not change the player's health points when their life is maximum,
     * and still decreases the healer's action points.
     */
    @Test
    public void testHealMaxLife() {
    
        Player player = new Player("Alice");
        player.setLifepoints(5); 

        Healer healer = new Healer("adil");

        Heal heal = new Heal(null);
        heal.Do(healer, player);

        assertEquals(5, player.getLifepoints());

        assertEquals(3, healer.getActionpoints());
    }
    
    /**
     * Tests the Do() method of the Heal class.
     * Verifies if the Do() method correctly displays the message "Who do you want to heal?".
     */
    @Test
    public void testDo() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Heal heal = new Heal(null);
        heal.Do();
        String expectedOutput = "Who do you want to heal?\n";
    }
    /**
     * Tests the toString() method of the Heal class.
     * Verifies if the toString() method correctly returns the class name ("Heal").
     */
    @Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Heal heal = new Heal(Trainingcity);
        String result = heal.toString();
        assertEquals("The toString method should return 'Heal'", "Heal", result);
    }
}
