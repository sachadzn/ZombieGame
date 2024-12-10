package Cell.Street;

import Cell.Cell;
import java.awt.Color;

/**
 * The Street class represents a street cell in a city grid.
 * Street cells are part of the city and may have various properties.
 * This class extends the Cell class and provides specific functionality for streets.
 */
public class Street extends Cell {

    /**
     * Default constructor for the Street class.
     * Initializes the street with default values.
     */
    public Street() {
        super();
    }

    /**
     * Get a string representation of the street cell.
     *
     * @return A string representation of the street cell.
     */
    public String toString() {
        return "S";
    }
    
    /**
     * Get the color associated with the street cell.
     *
     * @return The color associated with the street cell.
     */
    public Color getColor() {
        return Color.GRAY;
    }
}
