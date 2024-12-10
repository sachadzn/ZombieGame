package Equipment.Consumable;

import org.junit.jupiter.api.Test;

import Equipment.Consumable.HealingVial;

import static org.junit.jupiter.api.Assertions.*;

class HealingVialTest {

	/**
	 * Test case for the creation of a HealingVial instance.
	 * It checks if an instance of HealingVial is created correctly and if its attributes are set as expected.
	 */
	@Test
	void testHealingVialCreation() {
	    // Creating an instance of HealingVial
	    HealingVial healingVial = new HealingVial("HealingVial", "Healing Effect");

	    // Asserting that the created instance is not null
	    assertNotNull(healingVial);

	    // Asserting that the name is set correctly
	    assertEquals("HealingVial", healingVial.getName());

	    // Asserting that the effect is set correctly
	    assertEquals("Healing Effect", healingVial.getEffect());

	    // Asserting that the healing value is set correctly
	    assertEquals(1, HealingVial.getHealing());
	}

	/**
	 * Test case for the default values of HealingVial.
	 * It checks if the default constructor sets the attributes to their default values.
	 */
	@Test
	void testHealingVialDefaultValues() {
	    // Creating an instance of HealingVial using the default constructor
	    HealingVial healingVial = new HealingVial();

	    // Asserting that the created instance is not null
	    assertNotNull(healingVial);

	    // Asserting that the default name is set correctly
	    assertEquals("HealingVial", healingVial.getName());

	    // Asserting that the default effect is set correctly
	    assertEquals("Using a healing vial allows you to gain a life point", healingVial.getEffect());

	    // Asserting that the default healing value is set correctly
	    assertEquals(1, HealingVial.getHealing());
	}

	/**
	 * Test case for the setHealing method of HealingVial.
	 * It checks if the healing value can be set correctly.
	 */
	@Test
	void testHealingVialSetHealing() {
	    // Setting a new healing value
	    HealingVial.setHealing(2);

	    // Asserting that the new healing value is set correctly
	    assertEquals(2, HealingVial.getHealing());
	}}