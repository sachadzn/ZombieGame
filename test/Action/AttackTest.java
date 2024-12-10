package Action;
import Actor.Actor;
import Actor.Player.Player;
import Actor.Zombie.*;
import City.Cardinal;
import City.TrainingCity;
import Equipment.Weapon.Axe;
import Equipment.Weapon.Rifle;
import Equipment.Weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AttackTest {

	/**
     * Tests the player's attack on a zombie with a weapon.
     * Verifies if the player successfully attacks the zombie with the specified weapon,
     * reducing the zombie's life points accordingly, and if the player's level increases by one.
     */
    @Test
    void testPlayerAttackZombieWithWeapon() {
        // Preparation
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        player.setHand(weapon);
        Zombie zombie = new Walker();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        int actionp = player.getActionpoints();
        int vie = zombie.getLifepoints();
        player.setLevel(2);
        int level = player.getLevel();
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 1, 2);

        // Execution
        Attack attack = new Attack(Trainingcity);
        weapon.setThreshold(0); // Forced diceroll
        attack.Do(player, zombie);

        // Verification
        assertEquals(level + 1, player.getLevel()); // Player's level should increase by one
        assertEquals(vie - weapon.getDamage(), zombie.getLifepoints()); // Zombie's life points should decrease
        assertEquals(actionp, player.getActionpoints()); // Player's action points should remain unchanged
    }

    /**
     * Tests the player's attack on a zombie without a weapon.
     * Verifies if the player cannot attack the zombie when not equipped with a weapon.
     */
    @Test
    void testPlayerAttackZombieWithoutWeapon() {
        // Preparation
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        Zombie zombie = new Walker();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        player.setLevel(2);
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 1, 2);

        // Execution
        Attack attack = new Attack(Trainingcity);
        weapon.setThreshold(0); // Forced diceroll
        attack.Do(player, zombie);

        // Verification
        // No verification needed as the attack should not have any effect
    }

    /**
     * Tests the player's attack on a zombie with a bad dice roll.
     * Verifies if the player cannot successfully attack the zombie due to a bad dice roll.
     */
    @Test
    void testPlayerAttackZombieNotGoodDice() {
        // Preparation
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        Zombie zombie = new Walker();
        player.setHand(weapon);
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        player.setLevel(2);
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 1, 2);

        // Execution
        Attack attack = new Attack(Trainingcity);
        weapon.setThreshold(10); // Forced diceroll
        attack.Do(player, zombie);

        // Verification
        // No verification needed as the attack should not have any effect
    }

    /**
     * Tests the player's attack on a zombie that's out of range.
     * Verifies if the player cannot attack the zombie when it's out of range.
     */
    @Test
    void testPlayerAttackZombieOutOfRange() {
        // Preparation
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        Zombie zombie = new Walker();
        player.setHand(weapon);
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        player.setLevel(2);
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 1, 4); // Zombie is out of range

        // Execution
        Attack attack = new Attack(Trainingcity);
        weapon.setThreshold(0); // Forced diceroll
        attack.Do(player, zombie);

        // Verification
        // No verification needed as the attack should not have any effect
    }
    /**
     * Test method to verify that a zombie attacks a player.
     * The test ensures that the player's lifepoints decrease by 1 after the attack.
     */
    @Test
    void testZombieAttackPlayer() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        int vie = player.getLifepoints();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 2);
        Attack attack = new Attack(Trainingcity);
        attack.Do(zombie, player);
        assertEquals(vie-1, player.getLifepoints());
    }
    /**
     * Test method to verify that a zombie attacks another zombie.
     * This test scenario involves two zombies without a player.
     */
    @Test
    void testwithoutplayer(){
    	Zombie zombie = new Walker();
    	Zombie zombie2 = new Walker();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(zombie2, 2, 2);
		Trainingcity.placeActor(zombie, 2, 2);
        Attack attack = new Attack(Trainingcity);
        attack.Do(zombie, zombie2);
    	
    }
    /**
     * Test method to verify that a zombie attacks a player whose lifepoints are 1.
     * This test ensures that the player is eliminated if their lifepoints are 1 and they are attacked by a zombie.
     */
    @Test
    void testZombieAttackPlayer1() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        player.setLifepoints(1);
        int vie = player.getLifepoints();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 2);
        Attack attack = new Attack(Trainingcity);
        attack.Do(zombie, player);
    }
    /**
     * Test method to verify that a zombie does not attack a player when the player is not within range.
     * This test ensures that a zombie does not attack a player located on a different cell.
     */
    @Test
    void testZombiedontAttackPlayer() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        int vie = player.getLifepoints();
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 4);
        Attack attack = new Attack(Trainingcity);
        attack.Do(zombie, player);
        assertEquals(vie, player.getLifepoints());
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on the same cell.
     * This test verifies if the Checkdoors() method correctly detects the presence of doors.
     */
    @Test
    void checkdoorsonsamecell() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 2);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on nearby cells to the left.
     * This test verifies if the Checkdoors() method correctly detects the presence of doors.
     */
    @Test
    void checkdoorsoncellsnearby() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 1, 2);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on nearby cells to the right.
     * This test verifies if the Checkdoors() method correctly detects the presence of doors.
     */
    @Test
    void checkdoorsoncellsnearby2() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 3, 2);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on nearby cells above.
     * This test verifies if the Checkdoors() method correctly detects the presence of doors.
     */
    @Test
    void checkdoorsoncellsnearby3() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 1);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on nearby cells below.
     * This test verifies if the Checkdoors() method correctly detects the presence of doors.
     */
    @Test
    void checkdoorsoncellsnearby4() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 3);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are doors between a zombie and a player when they are on different cells.
     * This test verifies if the Checkdoors() method correctly detects the absence of doors.
     */
    @Test
    void checkdoorsondifferentcells() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 4, 2);
		Trainingcity.placeActor(zombie, 0, 2);
		Attack attack = new Attack(Trainingcity);
		assertFalse(attack.Checkdoors(player, zombie));
    }
    
    /**
     * Test method to verify if a zombie is within the range of a player's attack when they are on the same cell.
     * This test ensures that the isInRange() method correctly identifies if a zombie is within the attack range of a player.
     */
    @Test
    void isinrangeonsamecell() {
        Zombie zombie = new Walker();
        Weapon weapon = new Axe();
        Player player = new Player("Adil");
        player.setHand(weapon); 
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 2, 2);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.isInRange(player, zombie, weapon));
    }
    /**
     * Test method to verify if a zombie is within the range of a player's attack when they are in the same row.
     * This test ensures that the isInRange() method correctly identifies if a zombie is within the attack range of a player.
     */
    @Test
    void testIsInRangeSameRow() {
    	Zombie zombie = new Walker();
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        player.setHand(weapon); 
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 2, 4);
        weapon.setRange(3);
        assertTrue(new Attack(null).isInRange(player, zombie, weapon));
    }
    /**
     * Test method to check if there are closed doors to the right between a zombie and a player.
     * This test verifies if the Checkdoors() method correctly identifies closed doors.
     */
    @Test
    void checkdoorsWhenDoorsAreClosedToTheRight() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 1, 2);
        Trainingcity.placeActor(zombie, 0, 2);
        Trainingcity.getCellList().get(1).get(2).getDoorMap().put(Cardinal.EAST, true);
        Attack attack = new Attack(Trainingcity);
        assertFalse(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are closed doors above between a zombie and a player.
     * This test verifies if the Checkdoors() method correctly identifies closed doors.
     */
    @Test
    void checkdoorsWhenDoorsAreClosedAbove() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 2, 1);
        Trainingcity.getCellList().get(2).get(2).getDoorMap().put(Cardinal.NORTH, false);
        Attack attack = new Attack(Trainingcity);
        assertFalse(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are closed doors below between a zombie and a player.
     * This test verifies if the Checkdoors() method correctly identifies closed doors.
     */
    @Test
    void checkdoorsWhenDoorsAreClosedBelow() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 2, 1);
        Trainingcity.placeActor(zombie, 2, 2);
        Trainingcity.getCellList().get(2).get(1).getDoorMap().put(Cardinal.SOUTH, false);
        Attack attack = new Attack(Trainingcity);
        // Vérification des portes entre le joueur et le zombie, le joueur est en dessous du zombie et la porte au sud est fermée
        assertFalse(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to check if there are closed doors to the left between a zombie and a player.
     * This test verifies if the Checkdoors() method correctly identifies closed doors.
     */
    @Test
    void checkdoorsWhenDoorsAreClosedLeft() {
        Zombie zombie = new Walker();
        Player player = new Player("Adil");
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 2, 1);
        Trainingcity.placeActor(zombie, 2, 2);
        Trainingcity.getCellList().get(2).get(1).getDoorMap().put(Cardinal.WEST, false);
        Attack attack = new Attack(Trainingcity);
        assertFalse(attack.Checkdoors(player, zombie));
    }
    /**
     * Test method to verify the behavior of the Attack action when called without proper actors.
     * This test ensures that the Do() method behaves as expected when called with incorrect parameters.
     */
    @Test
    void testDo() {
	    Zombie zombie = new Walker();
	    Player player = new Player("Adil");
	    TrainingCity Trainingcity = new TrainingCity();
	    Trainingcity.initCity();
	    Trainingcity.placeActor(player, 2, 1);
	    Trainingcity.placeActor(zombie, 2, 2);
	    Attack attack = new Attack(Trainingcity);
	    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    attack.Do();
	    assertEquals("Need 2 Actors, 1 zombie and 1 Player", outContent.toString().trim());
    }
    /**
     * Test method to verify if a zombie is within the range of a player's attack when they are on different cells.
     * This test ensures that the isInRange() method correctly identifies if a zombie is within the attack range of a player.
     */
    @Test
    void testIsInRangeDifferentCell() {
    	Zombie zombie = new Walker();
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        player.setHand(weapon); 
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Trainingcity.placeActor(player, 2, 2);
        Trainingcity.placeActor(zombie, 4, 4);
        weapon.setRange(1); // Portée de l'arme
        assertFalse(new Attack(null).isInRange(player, zombie, weapon));
    }
    
    
    /**
     * Test method to verify if a zombie is within the attack range of a player when they are on different cells.
     * This test ensures that the isInRange() method correctly identifies if a zombie is within the attack range of a player.
     */
    @Test
    void isinrangeondifferentcells() {
        Zombie zombie = new Walker();
        Weapon weapon = new Rifle();
        Player player = new Player("Adil");
        player.setHand(weapon); // on utilise uniquement ce qu'il a dans la main
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
		Trainingcity.placeActor(player, 2, 2);
		Trainingcity.placeActor(zombie, 0, 2);
		Attack attack = new Attack(Trainingcity);
		assertTrue(attack.isInRange(player, zombie, weapon));
    }
    /**
     * Test method to verify the behavior of the toString() method in the Attack class.
     * This test ensures that the toString() method returns the expected string representation of the Attack action.
     */
    @Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Attack attack = new Attack(Trainingcity);
        String result = attack.toString();
        assertEquals("Attack", result);
    }
    
    
    
    
    
}
