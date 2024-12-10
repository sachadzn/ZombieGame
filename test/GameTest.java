import static org.junit.Assert.*;
import org.junit.Test;

import Actor.*;
import Actor.Player.Fighter;
import Actor.Player.Healer;
import Actor.Player.Lucky;
import Actor.Player.Nosy;
import Actor.Zombie.*;
import Cell.Street.Manhole;
import City.City;
import City.TrainingCity;

import org.junit.Before;

public class GameTest {
    private City city;
    /**
     * Tests if the game is over.
     * The game should be over under different conditions:
     * 1. When there are no zombies or players in the city.
     * 2. When there are players but no zombies.
     * 3. When there are zombies and players.
     * 4. When there are no more zombies but players are still present.
     * 5. When a player reaches a level of 30.
     */
    @Test
    public void testIsGameOver() {
    	Fighter Ilyes = new Fighter("Ilyes");
    	Walker walker = new Walker();
    	TrainingCity Trainingcity = new TrainingCity();
		Trainingcity.initCity();
        Game game = new Game(Trainingcity); 
        assertTrue(game.isGameOver()); // Le jeu devrait être terminé car il n'y a pas de zombies ni de joueurs
        Trainingcity.placeActor(new Fighter("Ilyes"), 2, 2); 
        assertTrue(game.isGameOver()); // Le jeu devrait être terminé car il n'y a pas de zombies
        Trainingcity.placeActor(new Walker(), 2, 2);
        assertFalse(game.isGameOver()); // Le jeu ne devrait pas être terminé car il y a des joueurs et des zombies
        Trainingcity.getCellList().get(Ilyes.getY()).get(Ilyes.getX()).removeActor(Ilyes);
        assertFalse(game.isGameOver()); // Le jeu ne devrait pas être terminé car il y a encore des joueurs
        Trainingcity.placeActor(new Fighter("Ilyes"), 2, 2); 
        Trainingcity.getCellList().get(Ilyes.getY()).get(Ilyes.getX()).removeActor(Ilyes);
        assertFalse(game.isGameOver()); // Le jeu ne devrait pas être terminé car il n'y a plus de zombies
        Ilyes.setLevel(30); 
        Trainingcity.getCellList().get(Ilyes.getY()).get(Ilyes.getX()).removeActor(Ilyes); 
        Trainingcity.placeActor(Ilyes, 2, 2); 
        assertTrue(game.isGameOver()); // Le jeu devrait être terminé car le niveau du joueur est de 30
    }
    /**
     * Tests the resetting of action points for actors.
     * Action points for each actor are reset based on their level.
     */
    @Test
    public void testResetActionPoints() {
    	TrainingCity Trainingcity = new TrainingCity();
		Trainingcity.initCity();
        Game game = new Game(Trainingcity);
        Fighter ilyes = new Fighter("Ilyes");
        Lucky sacha = new Lucky("Sacha");
        Nosy adil = new Nosy("Adil");
        Healer samuel = new Healer("Samuel");

        Trainingcity.placeActor(ilyes, 2, 2);
        Trainingcity.placeActor(sacha, 2, 2);
        Trainingcity.placeActor(adil, 2, 2);
        Trainingcity.placeActor(samuel, 2, 2);
        ilyes.setLevel(0);
        sacha.setLevel(5);
        adil.setLevel(10);
        samuel.setLevel(15);

        game.resetActionPoints();
        assertEquals(3, ilyes.getActionpoints()); 
        assertEquals(4, sacha.getActionpoints()); 
        assertEquals(5, adil.getActionpoints()); 
        assertEquals(6, samuel.getActionpoints()); 
        
        Walker zombieWalker = new Walker();
        Runner runner = new Runner();
        Trainingcity.placeActor(zombieWalker, 2, 2);
        Trainingcity.placeActor(runner, 2, 2);
        
        game.resetActionPoints();
        
        assertEquals(1, zombieWalker.getActionpoints()); 
        assertEquals(2, runner.getActionpoints()); 
    }
    /**
     * Tests the resetting of noise level for each cell in the city.
     * Noise levels of cells are reset to zero after calling the resetNoise() method.
     */
    @Test
    public void testResetNoise() {
        City city = new City(5, 5);
        city.initCity();
        Game game = new Game(city);
        for (int y = 0; y < city.getLength(); y++) {
            for (int x = 0; x < city.getWidth(); x++) {
                int noise = (int) (Math.random() * 10) + 1;
                city.getCellList().get(y).get(x).setNoise(noise);
            }
        }
        game.resetNoise();
        for (int y = 0; y < city.getLength(); y++) {
            for (int x = 0; x < city.getWidth(); x++) {
                assertEquals(0, city.getCellList().get(y).get(x).getNoise());
            }
        }
    }
    /**
     * Tests the zombieSpawn() method to verify the number of zombies spawned in the city.
     * Zombies should appear from the manholes, and the number of spawned zombies
     * should match the expected count based on the game conditions.
     */
    @Test
    public void testZombieSpawn() {
    	TrainingCity Trainingcity = new TrainingCity();
		Trainingcity.initCity();
		Game game = new Game(Trainingcity);
		int cX = Trainingcity.getCrossroadX();
		int cY = Trainingcity.getCrossroadY();
		Fighter Ilyes = new Fighter("Ilyes");
		Lucky Sacha = new Lucky("Sacha");
		Nosy Adil = new Nosy("Adil");
		Trainingcity.placeActor(Ilyes, cX, cY);
		Trainingcity.placeActor(Sacha, cX, cY);
		Trainingcity.placeActor(Adil, cX, cY);
		game.zombieSpawn();
        int zombieCount = 0;
        for (int y = 0; y < Trainingcity.getLength(); y++) {
            for (int x = 0; x < Trainingcity.getWidth(); x++) {
                if (Trainingcity.getCellList().get(y).get(x) instanceof Manhole) {
                    zombieCount += Trainingcity.getCellList().get(y).get(x).getAllActors().stream()
                            .filter(actor -> actor instanceof Zombie).count();
                }
            }
        }
        assertEquals("Number of zombies spawned matches the expected count", 1, zombieCount);
    }
    
    /**
     * Tests the zombieSpawn() method when multiple players are present and have different levels.
     * Verifies that the number of spawned zombies matches the expected count based on the game conditions,
     * taking into account the levels of the players present in the city.
     */
    @Test
    public void testZombieSpawn2() {
    	TrainingCity Trainingcity = new TrainingCity();
		Trainingcity.initCity();
		Game game = new Game(Trainingcity);
		int cX = Trainingcity.getCrossroadX();
		int cY = Trainingcity.getCrossroadY();
		Fighter Ilyes = new Fighter("Ilyes");
		Lucky Sacha = new Lucky("Sacha");
		Nosy Adil = new Nosy("Adil");
		Adil.setLevel(5);
		Sacha.setLevel(5);
		Ilyes.setLevel(4);
		Trainingcity.placeActor(Ilyes, cX, cY);
		Trainingcity.placeActor(Sacha, cX, cY);
		Trainingcity.placeActor(Adil, cX, cY);
		game.zombieSpawn();
        int zombieCount = 0;
        for (int y = 0; y < Trainingcity.getLength(); y++) {
            for (int x = 0; x < Trainingcity.getWidth(); x++) {
                if (Trainingcity.getCellList().get(y).get(x) instanceof Manhole) {
                    zombieCount += Trainingcity.getCellList().get(y).get(x).getAllActors().stream()
                            .filter(actor -> actor instanceof Zombie).count();
                }
            }
        }
        assertEquals("Number of zombies spawned matches the expected count", 2, zombieCount);
    }
    /**
     * Tests the Play() method to verify its execution without errors.
     * Simulates starting the game by placing a player in the city and executing the Play() method.
     */
    @Test
    public void testPlay() {
        City city = new City(5, 5);
        city.initCity();
        Game game = new Game(city);
        Runner ilyes = new Runner();
        city.placeActor(ilyes, 2, 2);
        game.Play();
    }
    
    /**
     * Tests the MessageGameOver() method when all survivors are dead.
     * Verifies that the returned message indicates that all survivors are dead.
     */
    @Test
    public void testMessageGameOver_AllSurvivorsDead() {
        City city = new City(5, 5);
        city.initCity();
        Game game = new Game(city);
        Runner ilyes = new Runner();
        city.placeActor(ilyes, 2, 2);
        String message = game.MessageGameOver();
        assertEquals("All survivors are dead. You have lost...", message);
    }
    /**
     * Tests the MessageGameOver() method when all players have reached level 30 or higher.
     * Verifies that the returned message indicates that all players have won by reaching the maximum level.
     */
    @Test
    public void testMessageGameOver_AllPlayersLevel30OrHigher() {
        City city = new City(5, 5);
        city.initCity();
        Fighter Ilyes = new Fighter("Ilyes");
        city.placeActor(Ilyes, 2, 2);
        Ilyes.setLevel(30);
        Game game = new Game(city);
        String message = game.MessageGameOver();
        assertEquals("All players are level 30 or higher. You have won!", message);
    }
    /**
     * Tests the MessageGameOver() method when all zombies are dead.
     * Verifies that the returned message indicates that all zombies have been defeated.
     */
    @Test
    public void testMessageGameOver_AllZombiesDead() {
        City city = new City(5, 5);
        city.initCity();
        Fighter Ilyes = new Fighter("Ilyes");
        city.placeActor(Ilyes, 2, 2);
        Game game = new Game(city);
        String message = game.MessageGameOver();
        assertEquals("All zombies are dead. You have won!", message);
    }
    
}
