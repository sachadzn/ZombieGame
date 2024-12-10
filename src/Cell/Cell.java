package Cell;

import City.Coordinate;
import City.Cardinal;
import Actor.Actor;
import Equipment.Equipment;
import Actor.Zombie.*;
import Actor.Player.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Color;

/**
 * The Cell class represents a generic cell in a city grid.
 * Cells contain actors and equipment and may have properties such as noise level and catchability.
 * This class provides common functionality for all types of cells.
 */
public abstract class Cell {
    protected int noise;
    protected boolean canCatch;
    protected HashMap<Cardinal, Boolean> doorMap;
    protected List<Actor> actors;
    protected List<Equipment> equipments;

    /**
     * Default constructor for the Cell class.
     * Initializes doorMap with an empty HashMap, noise to 0, and canCatch to false.
     */
    public Cell() {
        this.doorMap = new HashMap<Cardinal, Boolean>();
        this.noise = 0;
        this.canCatch = false;
        this.actors = new ArrayList<Actor>();
        this.equipments = new ArrayList<Equipment>();
    }

    /**
     * Parameterized constructor for the Cell class.
     *
     * @param coordinate The coordinate of the cell.
     * @param door       The number of doors in the cell.
     * @param noise      The initial noise level of the cell.
     * @param canCatch   A boolean indicating whether players can be caught in this cell.
     */
    public Cell(Coordinate coordinate, int door, int noise, boolean canCatch) {
        this.noise = noise;
        this.canCatch = canCatch;
        this.doorMap = new HashMap<Cardinal, Boolean>();
        this.actors = new ArrayList<Actor>();
        this.equipments = new ArrayList<Equipment>();
    }

    /**
     * Get all actors in the cell.
     *
     * @return The list of actors.
     */
    public List<Actor> getAllActors() {
        return actors;
    }

    /**
     * Add an actor to the cell.
     *
     * @param actor The actor to add.
     */
    public void addActor(Actor actor) {
        actors.add(actor);
    }

    /**
     * Remove an actor from the cell.
     *
     * @param actor The actor to remove.
     */
    public void removeActor(Actor actor) {
        actors.remove(actor);
    }

    /**
     * Get all equipments in the cell.
     *
     * @return The list of equipments.
     */
    public List<Equipment> getAllEquipments() {
        return equipments;
    }

    /**
     * Add an equipment to the cell.
     *
     * @param equipment The equipment to add.
     */
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    /**
     * Remove an equipment from the cell.
     *
     * @param equipment The equipment to remove.
     */
    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
    }

    /**
     * Get the noise level of the cell.
     *
     * @return The noise level of the cell.
     */
    public int getNoise() {
        return noise;
    }

    /**
     * Get the mapping of cardinal directions to doors in the cell.
     *
     * @return The door map of the cell.
     */
    public HashMap<Cardinal, Boolean> getDoorMap() {
        return doorMap;
    }

    /**
     * Set the door map of the cell.
     *
     * @param map The new door map to be set.
     */
    public void setDoorMap(HashMap<Cardinal, Boolean> map) {
        this.doorMap = map;
    }

    /**
     * Increase the noise level of the cell by a given value.
     *
     * @param value The value by which the noise level should be increased.
     */
    public void upSound(int value) {
        noise += value;
    }

    /**
     * Decrease the noise level of the cell by a given value.
     *
     * @param value The value by which the noise level should be decreased.
     */
    public void downSound(int value) {
        noise -= value;
    }

    /**
     * Check if players can be caught in this cell.
     *
     * @return True if players can be caught, false otherwise.
     */
    public boolean canCatch() {
        return canCatch;
    }

    /**
     * Set the noise level of the cell.
     *
     * @param noise The new noise level to be set.
     */
    public void setNoise(int noise) {
        this.noise = noise;
    }

    /**
     * Set whether players can be caught in this cell.
     *
     * @param canCatch The new value indicating whether players can be caught.
     */
    public void setCanCatch(boolean canCatch) {
        this.canCatch = canCatch;
    }
    
    /**
     * Counts the number of zombies and survivors in the cell and returns the result as a string.
     *
     * @return A string representation indicating the count of zombies and survivors (e.g., "Z2 S3").
     */
    public String countActors() {
        int zombieCount = 0;
        int survivorCount = 0;

        // Iterate through all actors in the cell
        for (Actor actor : actors) {
            if (actor instanceof Zombie) {
                zombieCount++;
            } else if (actor instanceof Player) {
                survivorCount++;
            }
        }

        // Return the result as a string
        return "Z" + zombieCount + " S" + survivorCount;
    }
    
    /**
     * Counts the number of zombies in the cell and returns the result as a string.
     *
     * @return A string representation indicating the count of zombies.
     */
    public String countZombie() {
        int zombieCount = 0;

        // Iterate through all actors in the cell
        for (Actor actor : actors) {
            if (actor instanceof Zombie) {
                zombieCount++;
            }
        }

        // Return the result as a string
        return "z" + zombieCount;
    }
    
    /**
     * Counts the number of players in the cell and returns the result as a string.
     *
     * @return A string representation indicating the count of players.
     */
    public String countPlayers() {
        int playerCount = 0;

        // Iterate through all actors in the cell
        for (Actor actor : actors) {
            if (actor instanceof Player) {
                playerCount++;
            }
        }

        // Return the result as a string
        return "p" + playerCount;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Provides a string representation of the cell.
     *
     * @return A string representation of the cell.
     */
    public abstract String toString();

    /**
     * Abstract method to be implemented by subclasses.
     * Provides the color of the cell.
     *
     * @return The color of the cell.
     */
    public abstract Color getColor();

}
