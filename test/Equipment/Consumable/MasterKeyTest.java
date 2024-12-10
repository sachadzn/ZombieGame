package Equipment.Consumable;

import org.junit.jupiter.api.Test;

import Equipment.Consumable.MasterKey;

import static org.junit.jupiter.api.Assertions.*;

class MasterKeyTest {

	/**
	 * Test case for the MasterKey class constructor.
	 * It checks if the constructor initializes the MasterKey object correctly.
	 */
	@Test
	void testMasterKeyCreation() {
	    // Creating an instance of MasterKey
	    MasterKey masterKey = new MasterKey();

	    // Asserting that the created instance is not null
	    assertNotNull(masterKey);

	    // Asserting that the name is set correctly
	    assertEquals("MasterKey", masterKey.getName());

	    // Asserting that the effect is set correctly
	    assertEquals("Using a master key allows you to open a door", masterKey.getEffect());
	}

	/**
	 * Test case for the default constructor of the MasterKey class.
	 * It checks if the default constructor initializes the MasterKey object with default values.
	 */
	@Test
	void testMasterKeyDefaultValues() {
	    // Creating an instance of MasterKey using the default constructor
	    MasterKey masterKey = new MasterKey();

	    // Asserting that the created instance is not null
	    assertNotNull(masterKey);

	    // Asserting that the default name is set correctly
	    assertEquals("MasterKey", masterKey.getName());

	    // Asserting that the default effect is set correctly
	    assertEquals("Using a master key allows you to open a door", masterKey.getEffect());
	}
}
