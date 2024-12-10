package Actor;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Actor.Actor;
import Actor.Player.Healer;

public class ActorTest {

	 /**
     * Test the constructor of the Actor class.
     * Verifies if an actor is created with the specified lifepoints and actionpoints.
     */
    @Test
    public void testConstructor() {
        Healer actor = new Healer("adil");
        
        assertEquals(5, actor.getLifepoints());
        assertEquals(3, actor.getActionpoints());
    }

    /**
     * Test the setLifepoints() method of the Actor class.
     * Verifies if lifepoints for an actor are set correctly.
     */
    @Test
    public void testSetLifepoints() {
        Healer actor = new Healer("adil");
        actor.setLifepoints(4);
        assertEquals(4, actor.getLifepoints());
    }

    /**
     * Test the setActionpoints() method of the Actor class.
     * Verifies if actionpoints for an actor are set correctly.
     */
    @Test
    public void testSetActionpoints() {
        Healer actor = new Healer("adil");
        actor.setActionpoints(2);
        assertEquals(2, actor.getActionpoints());
    }

    
    

}
