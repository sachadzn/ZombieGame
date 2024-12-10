package Actor.Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Actor.Player.Healer;

class HealerTest {
	/**
     * Test the constructor of the Healer class with specified lifepoints and actionpoints.
     */
    @Test
    public void testConstructor() {
        Healer healer = new Healer("adil", 100, 10);
        assertEquals(100, healer.getLifepoints());
        assertEquals(10, healer.getActionpoints());
        assertEquals("adil", healer.getName());
    }
    
    /**
     * Test the constructor of the Healer class with default lifepoints and actionpoints.
     */
    @Test
    public void testConstructor2() {
        Healer healer = new Healer("adil");
        assertEquals(5, healer.getLifepoints());
        assertEquals(3, healer.getActionpoints());
        assertEquals("adil", healer.getName());
    }

    /**
     * Test getting the default healing power of the healer.
     */
    @Test
    public void testGetHealingPower() {
        assertEquals(2, Healer.getHealingPower());
    }

    /**
     * Test setting the healing power for the healer.
     */
    @Test
    public void testSetHealingPower() {
        Healer.setHealingPower(2);
        assertEquals(2, Healer.getHealingPower());
    }

}
