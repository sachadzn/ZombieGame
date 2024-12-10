package Cell.Street;

import Cell.Cell;
import java.awt.Color;

/**
 * The Manhole class represents a manhole cell in a city grid.
 * Manhole cells are part of the street and may have various properties.
 * This class extends the Cell class and provides specific functionality for manholes.
 */
public class Manhole extends Cell {

  
    private int spawnrate;

    private Street street;

    /**
     * Default constructor for the Manhole class.
     * Initializes the manhole with a default street and spawn rate of 0.
     */
    public Manhole() {
        this.street = new Street();
        this.spawnrate = 0;
    }

    /**
     * Parameterized constructor for the Manhole class.
     *
     * @param spawnrate The spawn rate for players at the manhole.
     */
    public Manhole(int spawnrate) {
        this.spawnrate = spawnrate;
    }

    /**
     * Get the spawn rate for players at the manhole.
     *
     * @return The spawn rate for players.
     */
    public int getSpawnrate() {
        return spawnrate;
    }

    /**
     * Set the spawn rate for players at the manhole.
     *
     * @param spawnrate The new spawn rate to be set.
     */
    public void setSpawnrate(int spawnrate) {
        this.spawnrate = spawnrate;
    }

    /**
     * Get a string representation of the manhole cell.
     *
     * @return A string representation of the manhole cell.
     */
    public String toString() {
        return "M";
    }
    public Color getColor() {
    	return Color.GRAY;
    }
}