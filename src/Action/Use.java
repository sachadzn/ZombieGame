
package Action;
import java.util.List;

import Actor.Actor;
import Actor.Player.Player;
import Cell.Cell;
import City.Cardinal;
import City.City;
import Equipment.Equipment;
import Equipment.Consumable.Consumable;
import Equipment.Consumable.HealingVial;
import Equipment.Consumable.InfraredScop;
import Equipment.Consumable.Map;
import Equipment.Consumable.MasterKey;
import Equipment.Consumable.MedKit;
import ListChooser.InteractiveListChooser;


/**
 * The Use class represents an action to use an item or equipment in the game.
 * It implements the Action interface.
 */
public class Use implements Action {

    private City city;

    /**
     * Constructor for the Use class.
     *
     * @param city The city in which the action will take place.
     */
    public Use(City city) {
        this.city = city;
    }

    /**
     * Perform the use action without specifying any equipment.
     * This method prompts the user to specify what they want to use.
     */
    public void Do() {
        System.out.println("What do you want to Use?");
    }

    /**
     * Perform the use action with a specific player.
     * This method prompts the user to choose a consumable item from the player's backpack.
     *
     * @param player The player who is performing the action.
     */
    public void Do(Player player) {
        List<Equipment> backpack = player.getBackPack();
        InteractiveListChooser<Equipment> equipmentChooser = new InteractiveListChooser<>();
        Equipment chosenEquipment = equipmentChooser.choose("Which consumable do you choose?", backpack);
        if (chosenEquipment != null) {
            Consumable consumable = (Consumable) chosenEquipment;
            this.Do(player, consumable);
        } else {
            System.out.println("There is no equipment in the player's backpack...");
        }
    }

    /**
     * Perform the use action with a specific consumable item.
     *
     * @param player     The player who is performing the action.
     * @param consumable The consumable item to be used.
     */
    public void Do(Player player, Consumable consumable) {
        if (consumable instanceof HealingVial) {
            int life = player.getLifepoints();
            if (life < 5) {
                player.setLifepoints(life + 1);
                System.out.println("Thanks for the healing");
            } else {
                System.out.println("Player is already at full health.");
            }
        } else if (consumable instanceof MedKit) {
            Cell cell = city.getCellList().get(player.getY()).get(player.getX());
            List<Actor> actorList = cell.getAllActors();
            InteractiveListChooser<Actor> actorChooser = new InteractiveListChooser<>();
            Actor actor = actorChooser.choose("Who do you wish to heal?", actorList);
            if (actor != null) {
                int life = actor.getLifepoints();
                if (life < 5) {
                    actor.setLifepoints(life + 1);
                    System.out.println("Thanks for the healing");
                } else {
                    System.out.println("Player is already at full health.");
                }
            } else {
                System.out.println("No actor chosen to heal.");
            }
        } else if (consumable instanceof Map) {
            city.displayCity();
            System.out.println("You used a Map to visualize the entire city and actors.");
            Makenoise makenoise = new Makenoise(city);
            makenoise.Do(player);
            player.removeHand();
        } else if (consumable instanceof InfraredScop) {
            ((InfraredScop) consumable).activateSeeThroughWalls();
            System.out.println("You used Infrared Glasses to see through walls.");
            player.removeHand();
        } else if (consumable instanceof MasterKey) {
            List<Cardinal> cardinalList = Cardinal.getAllCardinals();
            InteractiveListChooser<Cardinal> cardinalChooser = new InteractiveListChooser<>();
            Cardinal cardinal = cardinalChooser.choose("Which Door do you choose?", cardinalList);
            if (cardinal != null) {
                OpenDoor openDoorAction = new OpenDoor(city);
                openDoorAction.Do(player, cardinal);
                System.out.println("You used a Master Key to open a door.");
                player.removeHand();
            } else {
                System.out.println("No cardinal direction chosen to open the door.");
            }
        } else {
            System.out.println("You cannot use this equipment.");
        }
    }

    /**
     * Returns a string representation of the Use action.
     *
     * @return A string representation of the Use action.
     */
    public String toString() {
        return "Use";
    }
}
