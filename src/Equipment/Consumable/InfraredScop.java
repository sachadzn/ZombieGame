package Equipment.Consumable;

import Cell.Cell;
import City.City;
import Equipment.Equipment;
import Actor.Actor;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an InfraredScop, a type of Consumable item that allows seeing through walls.
 */
public class InfraredScop extends Consumable {
    private boolean seeThroughWalls;

    /**
     * Constructor for creating an InfraredScop with default values.
     */
    public InfraredScop() {
        super("InfraredScop", "Using infrared glasses allows you to see through walls (i.e. see areas adjacent to " +
                "areas in which we are, even if the doors are closed)");
    }

    /**
     * Constructor for creating an InfraredScop with custom name and effect.
     * @param name   The name of the InfraredScop.
     * @param effect The effect of using the InfraredScop.
     */
    public InfraredScop(String name, String effect) {
        super(name, effect);
        this.seeThroughWalls = false;
    }

    /**
     * Activates the ability to see through walls.
     */
    public void activateSeeThroughWalls() {
        this.seeThroughWalls = true;
    }

    /**
     * Checks if the ability to see through walls is activated.
     * @return True if the ability is activated, false otherwise.
     */
    public boolean isSeeThroughWallsActivated() {
        return seeThroughWalls;
    }

    /**
     * Gets a list of adjacent equipments from the specified center coordinates in the city.
     * @param city     The city.
     * @param centerX  The x-coordinate of the center.
     * @param centerY  The y-coordinate of the center.
     * @return A list of adjacent equipments.
     */
    public List<Equipment> getAdjacentEquipments(City city, int centerX, int centerY) {
        List<Equipment> adjacentEquipments = new ArrayList<>();

        if (seeThroughWalls) {
            adjacentEquipments.addAll(getEquipmentsFromCell(city, centerX - 1, centerY));
            adjacentEquipments.addAll(getEquipmentsFromCell(city, centerX + 1, centerY));
            adjacentEquipments.addAll(getEquipmentsFromCell(city, centerX, centerY - 1));
            adjacentEquipments.addAll(getEquipmentsFromCell(city, centerX, centerY + 1));
        }

        return adjacentEquipments;
    }

    /**
     * Gets a list of adjacent actors from the specified center coordinates in the city.
     * @param city     The city.
     * @param centerX  The x-coordinate of the center.
     * @param centerY  The y-coordinate of the center.
     * @return A list of adjacent actors.
     */
    public List<Actor> getAdjacentActors(City city, int centerX, int centerY) {
        List<Actor> adjacentActors = new ArrayList<>();

        if (seeThroughWalls) {
            adjacentActors.addAll(getActorsFromCell(city, centerX - 1, centerY));
            adjacentActors.addAll(getActorsFromCell(city, centerX + 1, centerY));
            adjacentActors.addAll(getActorsFromCell(city, centerX, centerY - 1));
            adjacentActors.addAll(getActorsFromCell(city, centerX, centerY + 1));
        }

        return adjacentActors;
    }

    // Utility method to get equipments from a cell
    private List<Equipment> getEquipmentsFromCell(City city, int x, int y) {
        if (x >= 0 && x < city.getWidth() && y >= 0 && y < city.getLength()) {
            Cell cell = city.getCellList().get(y).get(x);
            if (cell != null) {
                return cell.getAllEquipments();
            }
        }
        return new ArrayList<>();
    }

    // Utility method to get actors from a cell
    private List<Actor> getActorsFromCell(City city, int x, int y) {
        if (x >= 0 && x < city.getWidth() && y >= 0 && y < city.getLength()) {
            Cell cell = city.getCellList().get(y).get(x);
            if (cell != null) {
                return cell.getAllActors();
            }
        }
        return new ArrayList<>();
    }
}
