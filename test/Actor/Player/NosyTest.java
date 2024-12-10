package Actor.Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Actor.Player.Nosy;

class NosyTest {
	/**
     * Test the constructor of the Nosy class with specified lifepoints and actionpoints.
     */
    @Test
    public void testConstructor() {
        Nosy noisy = new Nosy("adil", 100, 10);
        assertEquals(100, noisy.getLifepoints());
        assertEquals(10, noisy.getActionpoints());
        assertEquals("adil", noisy.getName());
    }
    
    /**
     * Test the constructor of the Nosy class with default lifepoints and actionpoints.
     */
    @Test
    public void testConstructor2() {
        Nosy noisy = new Nosy("adil");
        assertEquals(5, noisy.getLifepoints());
        assertEquals(3, noisy.getActionpoints());
        assertEquals("adil", noisy.getName());
    }

}
