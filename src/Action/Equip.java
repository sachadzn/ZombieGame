package Action;
import java.util.List;
import Actor.Player.*;
import Equipment.Equipment;
import ListChooser.InteractiveListChooser;

/**
 * This class represents an action allowing the player to equip an item from their backpack.
 */
public class Equip implements Action {
    
    /**
     * Executes the action of equipping an item.
     * 
     * @param player the player performing the action
     */
	public void Do(Player player) {
		List<Equipment> backpack = player.getBackPack();
		InteractiveListChooser<Equipment> equipmentChooser = new InteractiveListChooser<>();
		Equipment chosenEquipment = equipmentChooser.choose("Which equipment do you choose ?", backpack);
		if (chosenEquipment != null) {
			player.setHand(chosenEquipment);
			player.removeBackpackEquipment(chosenEquipment);
			player.setActionpoints(player.getActionpoints() - 1);
		}else {
			System.out.println("There is no equipment in the player's backpack...");
		}
	}
    public void Do(Player player, Equipment equipment) {
        List<Equipment> backpack = player.getBackPack();
        if (backpack.contains(equipment)) {
            player.setHand(equipment);
            player.setActionpoints(player.getActionpoints() - 1);
            player.removeBackpackEquipment(equipment);
        } else {
            System.out.println("There is not this equipment in the player's backpack!");
        }
    }
    /**
     * Displays a message indicating that a player and an equipment are needed.
     */
    public void Do() {
        System.out.println("Need a Player and an equipment");
    }

    /**
     * Returns a string representation of this object.
     *
     * @return the string "Equip".
     */
    public String toString() {
        return "Equip";
    }

}
