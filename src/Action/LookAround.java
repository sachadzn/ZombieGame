package Action;
import Actor.Player.*;
import Cell.Cell;
import City.City;

/**
 * The LookAround class represents an action to look around the surroundings.
 * It implements the Action interface.
 */
public class LookAround implements Action {

    private City city;

    /**
     * Constructor for the LookAround class.
     *
     * @param city The city in which the action will take place.
     */
    public LookAround(City city) {
        this.city = city;
    }
    
    /**
     * Perform the default look around action.
     * Currently, this method prints a message indicating that a player must be specified.
     */
    public void Do() {
        System.out.println("Who do you want to look around?");
    }
    
    /**
     * Perform the action of looking around the surroundings.
     * 
     * @param player The player performing the action.
     */
    public void Do(Player player) {
        int x = player.getX();
        int y = player.getY();
        Cell currentCell = city.getCellList().get(y).get(x);
        System.out.println("Actors in the current cell: " + currentCell.getAllActors().toString());
        System.out.println("Doors in the current cell: " + currentCell.getDoorMap());
        System.out.println("Equipment in the current cell: " + currentCell.getAllEquipments().toString());
    }
    
    /**
     * Returns a string representation of the LookAround action.
     * 
     * @return A string representation of the LookAround action.
     */
    public String toString() {
        return "LookAround";
    }

}
