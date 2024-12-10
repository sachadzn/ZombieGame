package Action;
import ListChooser.InteractiveListChooser;
import java.util.List;
import Actor.Player.Player;
import Cell.Cell;
import Cell.Room.Room;
import City.City;
import Equipment.Equipment;

/**
 * The Search class represents an action to search for items or clues in the game.
 * It implements the Action interface.
 */
public class Search implements Action {

    /**
     * Perform the search action.
     * This method prompts the user to specify who they want to search.
     */
    public void Do() {
        System.out.println("Who do you want to search?");
    }

    private City city;

    /**
     * Constructor for the Search class.
     *
     * @param city The city in which the action will take place.
     */
    public Search(City city) {
        this.city = city;
    }

    /**
     * Perform the search action.
     *
     * @param player The player performing the action.
     */
    public void Do(Player player) {
        int x = player.getX();
        int y = player.getY();
        Cell currentCell = city.getCellList().get(y).get(x);
        if (currentCell instanceof Room) {
            List<Equipment> equipmentsInRoom = currentCell.getAllEquipments();
            if (equipmentsInRoom.isEmpty()) {
                System.out.println("There are no equipments in this room.");
            } else {
                InteractiveListChooser<Equipment> equipmentChooser = new InteractiveListChooser<>();
                Equipment chosenEquipment = equipmentChooser.choose("Which equipment do you choose?", equipmentsInRoom);
                if (chosenEquipment != null) {
                    if (player.getBackPack().size() < 5) {
                        player.addEquipment(chosenEquipment);
                        System.out.println("You picked up " + chosenEquipment + " and added it to your backpack.");
                        player.setActionpoints(player.getActionpoints() - 1);
                        currentCell.removeEquipment(chosenEquipment);
                    } else {
                        System.out.println("Your backpack is full. You can choose to replace an equipment.");
                        System.out.println("Current equipments in your backpack:");
                        InteractiveListChooser<Equipment> equipmentChoosers = new InteractiveListChooser<>();
                        List<Equipment> equipmentsplayer = player.getBackPack();
                        Equipment chosenEquipments = equipmentChoosers.choose("Which equipment do you choose?", equipmentsplayer);
                        player.removeBackpackEquipment(chosenEquipments);
                        currentCell.addEquipment(chosenEquipments);
                        player.addEquipment(chosenEquipment);
                        currentCell.removeEquipment(chosenEquipment);
                        System.out.println("You picked up " + chosenEquipment + " and added it to your backpack.");
                        player.setActionpoints(player.getActionpoints() - 1);
                    }
                }
            }
        } else {
            System.out.println("You are not in a Room!");
        }
    }

    /**
     * Returns a string representation of the Search action.
     *
     * @return A string representation of the Search action.
     */
    public String toString() {
        return "Search";
    }
}

