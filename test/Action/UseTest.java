package Action;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import Input.Input;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import Actor.Actor;
import Actor.Player.Fighter;
import Actor.Player.Player;
import Cell.Cell;
import City.Cardinal;
import City.City;
import City.TrainingCity;
import Equipment.Consumable.Consumable;
import Equipment.Consumable.HealingVial;
import Equipment.Consumable.InfraredScop;
import Equipment.Consumable.MedKit;
import Equipment.Weapon.Axe;
import ListChooser.RandomListChooser;
import Equipment.Consumable.Map;
import Equipment.Consumable.MasterKey;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;



public class UseTest {
	/**
     * Teste l'utilisation d'une HealingVial par un joueur lorsque ses points de vie ne sont pas pleins.
     */
    @Test
    public void testUseHealingVial() {
        Player player = new Player("John");
        player.setLifepoints(4); // Les points de vie du joueur ne sont pas pleins
        Consumable consumable = new HealingVial();
        Use use = new Use(null);

        use.Do(player, consumable);

        assertEquals(5, player.getLifepoints()); // Les points de vie du joueur devraient être incrémentés de 1
    }

    /**
     * Teste l'utilisation d'une HealingVial par un joueur lorsque ses points de vie sont pleins.
     */
    @Test
    public void testUseHealingVialAtFullHealth() {
        Player player = new Player("John");
        player.setLifepoints(5); // Les points de vie du joueur sont déjà pleins
        Consumable consumable = new HealingVial();
        Use use = new Use(null);

        use.Do(player, consumable);

        assertEquals(5, player.getLifepoints()); // Les points de vie du joueur devraient rester inchangés
    }

    /**
     * Teste l'utilisation d'un MedKit par un joueur pour soigner un autre joueur.
     *
     * @throws AWTException si une exception AWT survient
     */
    @Test
    public void testUseMedKit() throws AWTException {
        // Création de la ville et initialisation
        City city = new City(5, 5);
        city.initCity();
        
        // Création des joueurs
        Player player = new Player("John");
        player.setLifepoints(3); 
        Player otherPlayer = new Player("Jane");
        city.placeActor(player, 2, 2);
        otherPlayer.setLifepoints(3);
        city.placeActor(otherPlayer, 2, 2);
        Consumable consumable = new MedKit();
        
        // Création de l'instance Use avec la ville
        Use use = new Use(city);
        
        // Capturer la sortie de la console
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        use.Do(player, consumable);
       
        assertEquals(4, otherPlayer.getLifepoints()); // Les points de vie de l'autre joueur devraient être incrémentés de 1
    }

    /**
     * Teste l'utilisation d'une carte par un joueur.
     */
    @Test
    public void testUseMap() {
        Player player = new Player("John");
        City city = new City(5, 5);
        city.initCity();
        Consumable consumable = new Map();
        Use use = new Use(city);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        use.Do(player, consumable);
    }

    /**
     * Teste l'utilisation d'un InfraredScop par un joueur.
     */
    @Test
    public void testUseInfraredScop() {
        Player player = new Player("John");
        Consumable consumable = new InfraredScop();
        Use use = new Use(null);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        use.Do(player, consumable);

        assertTrue(outContent.toString().contains("You used Infrared Glasses"));
    }
    
    /**
     * Teste la méthode toString de la classe Use.
     */
    @Test
    public void testToString() {
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Use use = new Use(Trainingcity);
        String result = use.toString();
        assertEquals("The toString method should return 'Use'", "Use", result);
    }
    
    /**
     * Teste l'affichage de la console lorsque la méthode Do() de Use est appelée sans paramètres.
     */
    @Test
    public void douse() {
        TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Use use = new Use(Trainingcity); 
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        use.Do();
        assertTrue(outContent.toString().contains("What do you want to Use?"));
    }

    

    
}
