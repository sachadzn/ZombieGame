package Actor.Player;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Actor.Player.Fighter;

public class FighterTest {

	/**
     * Test the constructor of the Fighter class with specified lifepoints and actionpoints.
     */
    @Test
    public void testFighter() {
        Fighter fighter = new Fighter("adil", 100, 10);
        assertEquals(100, fighter.getLifepoints());
        assertEquals(10, fighter.getActionpoints());
        assertEquals("adil", fighter.getName());
    }
    
    /**
     * Test the constructor of the Fighter class with default lifepoints and actionpoints.
     */
    @Test
    public void testFighter2() {
        Fighter fighter = new Fighter("adil");
        assertEquals(5, fighter.getLifepoints());
        assertEquals(3, fighter.getActionpoints());
        assertEquals("adil", fighter.getName());
    }
}