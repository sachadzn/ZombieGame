package Actor.Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Actor.Player.Lucky;

class LuckyTest {

	/**
     * Test the constructor of the Lucky class with specified lifepoints and actionpoints.
     */
    @Test
    public void testConstructor() {
        Lucky lucky = new Lucky("adil", 100, 10);
        assertEquals(100, lucky.getLifepoints());
        assertEquals(10, lucky.getActionpoints());
        assertEquals("adil", lucky.getName());
    }
    
    /**
     * Test the constructor of the Lucky class with default lifepoints and actionpoints.
     */
    @Test
    public void testConstructor2() {
        Lucky lucky = new Lucky("adil");
        assertEquals("adil", lucky.getName());
        assertEquals(3, lucky.getActionpoints());
        assertEquals(5, lucky.getLifepoints());
    }

}
