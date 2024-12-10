

import org.junit.jupiter.api.Test;

import Action.Move;
import Actor.Actor;
import Actor.Player.Fighter;
import Actor.Player.Healer;
import Actor.Player.Lucky;
import Actor.Player.Nosy;
import Actor.Player.Player;
import Actor.Zombie.Walker;
import Actor.Zombie.Zombie;
import City.Cardinal;
import City.TrainingCity;
import Equipment.Consumable.HealingVial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Livrable2Test {

    @Test
    public void testCityInitialization() {
        TrainingCity trainingCity = new TrainingCity();
        trainingCity.initCity();

        // Add assertions to check that the city is correctly initialized
        // You can check dimensions, presence of streets, rooms, etc.
        // For example:
        assertEquals(5, trainingCity.getLength());
        assertEquals(5, trainingCity.getWidth());
    }

    @Test
    public void testZombiePlacement() {
        TrainingCity trainingCity = new TrainingCity();
        trainingCity.initCity();

        // Place a Zombie in each zone
        for (int y = 0; y < trainingCity.getLength(); y++) {
            for (int x = 0; x < trainingCity.getWidth(); x++) {
                List<Actor> actors = trainingCity.getCellList().get(y).get(x).getAllActors();
                assertNotNull(actors);

                for (Actor actor : actors) {
                    assertTrue(actor instanceof Zombie);
                    assertTrue(actor instanceof Walker);
                }
            }
        }
    }

    @Test
    public void testPlayerInitialization() {
        TrainingCity trainingCity = new TrainingCity();
        trainingCity.initCity();
        int crossroadX = trainingCity.getCrossroadX();
        int crossroadY = trainingCity.getCrossroadY();

        // Verify that each type of player is correctly placed at the main crossroad
        for (Actor actor : trainingCity.getCellList().get(crossroadY).get(crossroadX).getAllActors()) {
            assertTrue(actor instanceof Fighter || actor instanceof Lucky || actor instanceof Nosy || actor instanceof Healer);
        }
    }

 
	@Test
    public void testEquipmentPlacement() {
        TrainingCity trainingCity = new TrainingCity();
        trainingCity.initCity();
        int crossroadX = trainingCity.getCrossroadX();
        int crossroadY = trainingCity.getCrossroadY();

        // Verify that each player at the main crossroad has a map in their backpack and a vial in their hand
        for (Actor actor : trainingCity.getCellList().get(crossroadY).get(crossroadX).getAllActors()) {
            if (actor instanceof Player) {
                Player player = (Player) actor;
                assertTrue(player.getBackPack().contains(Map.class));
                assertNotNull(player.getHand());
                assertTrue(player.getHand() instanceof HealingVial);
            }
        }
    }

    @Test
    public void testPlayerMovement() {
        TrainingCity trainingCity = new TrainingCity();
        trainingCity.initCity();

        // Move north for each player and verify they have been moved correctly
        Move move = new Move(trainingCity);
        for (int y = 0; y < trainingCity.getLength(); y++) {
            for (int x = 0; x < trainingCity.getWidth(); x++) {
                if (trainingCity.getCellList().get(y).get(x).getAllActors() != null) {
                    for (Actor actor : new ArrayList<>(trainingCity.getCellList().get(y).get(x).getAllActors())) {
                        if (actor instanceof Player) {
                            move.Do(actor, Cardinal.NORTH);
                            assertEquals(y - 1, actor.getY());
                        }
                    }
                }
            }
        }
    }
}
