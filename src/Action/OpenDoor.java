package Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import Actor.Player.Player;
import Actor.Zombie.Abomination;
import Actor.Zombie.Fatty;
import Actor.Zombie.Walker;
import Cell.Cell;
import Cell.Street.Manhole;
import City.Cardinal;
import City.City;
import Equipment.Consumable.MasterKey;
import Equipment.Weapon.Chainsaw;
import Equipment.Weapon.Crowbar;
import Equipment.Weapon.Pistol;
import Equipment.Weapon.Rifle;
import ListChooser.InteractiveListChooser;


/**
 * The OpenDoor class represents an action to open a door in the game.
 * It implements the Action interface.
 */
public class OpenDoor implements Action {

    private City city;

    /**
     * Constructor for the OpenDoor class.
     *
     * @param city The city where the action takes place.
     */
    public OpenDoor(City city) {
        this.city = city;
    }

    /**
     * Perform the action of opening a door.
     * This method prompts the user to specify a player and a cardinal direction.
     */
    public void Do() {
        System.out.println("To open a door, you must specify a player and a cardinal direction.");
    }

    /**
     * Perform the action of opening a door in a specified cardinal direction.
     *
     * @param player The player performing the action.
     */
    public void Do(Player player) {
        List<Cardinal> cardinal = new ArrayList<>(Arrays.asList(Cardinal.NORTH, Cardinal.SOUTH, Cardinal.EAST, Cardinal.WEST));
        InteractiveListChooser<Cardinal> cardinalChooser = new InteractiveListChooser<>();
        Cardinal chosenCardinal = cardinalChooser.choose("Which direction do you choose?", cardinal);
        if (chosenCardinal != null) {
            this.Do(player, chosenCardinal);
        } else {
            System.out.println("Canceled...");
        }
    }

    /**
     * Perform the action of opening a door in a specified cardinal direction.
     *
     * @param player  The player performing the action.
     * @param card    The cardinal direction in which to open the door.
     */
    public void Do(Player player, Cardinal card) {
        Cell cell = city.getCellList().get(player.getY()).get(player.getX());
        if (cell.getDoorMap().get(card) == null) {
            System.out.println("You are facing a wall.");
        } else if (cell.getDoorMap().get(card)) {
            System.out.println("The door is already open.");
        } else {
            if (player.getHand() instanceof MasterKey) {
                cell.getDoorMap().put(card, true);
                System.out.println("You opened the door.");
                player.removeHand();
                Makenoise makenoise = new Makenoise(city);
                makenoise.Do(player);
            }
            if (player.getHand() instanceof Chainsaw || player.getHand() instanceof Crowbar || player.getHand() instanceof Pistol || player.getHand() instanceof Rifle) {
                cell.getDoorMap().put(card, true);
                System.out.println("You opened the door.");
                Makenoise makenoise = new Makenoise(city);
                makenoise.Do(player);
                Random random = new Random();
                int number = random.nextInt(3) + 1;
                zombieSpawnAfterDoorOpened(number);
            }
        }
    }

    /**
     * Spawns zombies after a door is opened.
     * Opening a door systematically spawns between 1 and 3 zombies, and at most one Abomination or Fatty.
     *
     * @param number The number of zombies to spawn.
     */
    public void zombieSpawnAfterDoorOpened(int number) {
        Random random = new Random();
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                if (this.city.getCellList().get(y).get(x) instanceof Manhole) {
                    if (number == 1) {
                        int numberZombies = random.nextInt(3) + 1; // Random number between 1 and 3
                        for (int i = 0; i < numberZombies; i++) {
                            this.city.getCellList().get(y).get(x).addActor(new Walker());
                        }
                    } else if (number == 2) {
                        this.city.getCellList().get(y).get(x).addActor(new Abomination());
                    } else { // 3
                        this.city.getCellList().get(y).get(x).addActor(new Fatty());
                    }
                    return;
                }
            }
        }
    }

    /**
     * Returns a string representation of the OpenDoor action.
     *
     * @return A string representation of the OpenDoor action.
     */
    public String toString() {
        return "OpenDoor";
    }
}
