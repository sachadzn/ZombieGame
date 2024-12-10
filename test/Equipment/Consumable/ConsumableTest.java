package Equipment.Consumable;


import org.junit.jupiter.api.Test;

import Equipment.Consumable.Consumable;

import static org.junit.jupiter.api.Assertions.*;

public class ConsumableTest {

    // Creating a concrete subclass of Consumable for testing purposes
    private static class TestConsumable extends Consumable {
        public TestConsumable(String name, String effect) {
            super(name, effect);
        }
    }

    /**
     * Test case for the creation of a Consumable subclass for testing purposes.
     * It checks if an instance of the subclass is created correctly and if its name and effect are set as expected.
     */
    @Test
    public void testConsumableCreation() {
        TestConsumable testConsumable = new TestConsumable("TestConsumable", "Test Effect");
        assertNotNull(testConsumable);
        assertEquals("TestConsumable", testConsumable.getName());
        assertEquals("Test Effect", testConsumable.getEffect());
    }
}
