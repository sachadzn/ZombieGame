package Equipment.Consumable;

import org.junit.jupiter.api.Test;

import Equipment.Consumable.MedKit;

import static org.junit.jupiter.api.Assertions.*;

class MedKitTest {

	/**
	 * Test case for the MedKit class constructor.
	 * It checks if the constructor initializes the MedKit object correctly.
	 */
	@Test
	void testMedKitCreation() {
	    // Creating an instance of MedKit
	    MedKit medKit = new MedKit();

	    // Asserting that the created instance is not null
	    assertNotNull(medKit);

	    // Asserting that the name is set correctly
	    assertEquals("MedKit", medKit.getName());

	    // Asserting that the effect is set correctly
	    assertEquals("using a med kit allows you to heal one of the survivors in your zone (+1 life point)", medKit.getEffect());
	}

	/**
	 * Test case for the default constructor of the MedKit class.
	 * It checks if the default constructor initializes the MedKit object with default values.
	 */
	@Test
	void testMedKitDefaultValues() {
	    // Creating an instance of MedKit using the default constructor
	    MedKit medKit = new MedKit();

	    // Asserting that the created instance is not null
	    assertNotNull(medKit);

	    // Asserting that the default name is set correctly
	    assertEquals("MedKit", medKit.getName());

	    // Asserting that the default effect is set correctly
	    assertEquals("using a med kit allows you to heal one of the survivors in your zone (+1 life point)", medKit.getEffect());
	}
}
