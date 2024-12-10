package Actor.Zombie;
import Actor.Zombie.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ZombieTest {

	/**
	 * Test case for the Walker class.
	 * It checks if the Walker's attributes are initialized correctly and if the damage can be set.
	 */
	@Test
	public void testWalker() {
	    Walker walker = new Walker();
	    assertEquals(1, walker.getLifepoints());
	    assertEquals(1, walker.getActionpoints());
	    assertEquals(1, walker.getDamage());
	    walker.setDamage(2);
	    assertEquals(2, walker.getDamage());
	}

	/**
	 * Test case for the Fatty class.
	 * It checks if the Fatty's attributes are initialized correctly and if the damage can be set.
	 */
	@Test
	public void testFatty() {
	    Fatty fatty = new Fatty();
	    assertEquals(4, fatty.getLifepoints());
	    assertEquals(1, fatty.getActionpoints());
	    assertEquals(2, fatty.getDamage());
	    fatty.setDamage(3);
	    assertEquals(3, fatty.getDamage());
	}

	/**
	 * Test case for the Abomination class.
	 * It checks if the Abomination's attributes are initialized correctly and if the damage can be set.
	 */
	@Test
	public void testAbomination() {
	    Abomination abomination = new Abomination();
	    assertEquals(6, abomination.getLifepoints());
	    assertEquals(1, abomination.getActionpoints());
	    assertEquals(3, abomination.getDamage());
	    abomination.setDamage(4);
	    assertEquals(4, abomination.getDamage());
	}

	/**
	 * Test case for the Runner class.
	 * It checks if the Runner's attributes are initialized correctly and if the damage can be set.
	 */
	@Test
	public void testRunner() {
	    Runner runner = new Runner();
	    assertEquals(2, runner.getLifepoints());
	    assertEquals(2, runner.getActionpoints());
	    assertEquals(1, runner.getDamage());
	    runner.setDamage(3);
	    assertEquals(3, runner.getDamage());
	}
    
	/**
	 * Test case for the toString method of the Walker class.
	 * It checks if the toString method returns the correct string representation of a Walker object.
	 */
	@Test
	public void testToStringWalker() {
	    Walker walker = new Walker();
	    String expected = "Walker { lifepoints: 1 actionpoints: 1 damage: 1 } ";
	    String result = walker.toString();
	    assertEquals(expected, result);
	}

	/**
	 * Test case for the toString method of the Runner class.
	 * It checks if the toString method returns the correct string representation of a Runner object.
	 */
	@Test
	public void testToStringRunner() {
	    Runner runner = new Runner();
	    String expected = "Runner { lifepoints: 2 actionpoints: 2 damage: 1 } ";
	    String result = runner.toString();
	    assertEquals(expected, result);
	}

	/**
	 * Test case for the toString method of the Fatty class.
	 * It checks if the toString method returns the correct string representation of a Fatty object.
	 */
	@Test
	public void testToStringFatty() {
	    Fatty fatty = new Fatty();
	    String expected = "Fatty { lifepoints: 4 actionpoints: 1 damage: 2 } ";
	    String result = fatty.toString();
	    assertEquals(expected, result);
	}

	/**
	 * Test case for the toString method of the Abomination class.
	 * It checks if the toString method returns the correct string representation of an Abomination object.
	 */
	@Test
	public void testToStringAbomination() {
	    Abomination abomination = new Abomination();
	    String expected = "Abomination { lifepoints: 6 actionpoints: 1 damage: 3 } ";
	    String result = abomination.toString();
	    assertEquals(expected, result);
	}
}
