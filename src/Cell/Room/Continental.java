package Cell.Room;

import java.awt.Color;

/**
 * The Continental class represents a continental room in a city grid.
 * Continental rooms cannot be attacked and are described by a string description.
 * This class extends the Room class and provides specific functionality for continental rooms.
 */
public class Continental extends Room {

    /**
     * Default constructor for the Continental class.
     * Initializes the room as a non-attackable continental room with a default description.
     */
    public Continental() {
        super(false, "Default continental room");
    }

    /**
     * Parameterized constructor for the Continental class.
     *
     * @param description The description of the continental room.
     */
    public Continental(String description) {
        super(false, description);
    }

    /**
     * Get a string representation of the continental room.
     *
     * @return A string representation of the continental room.
     */
    public String toString() {
        return "C";
    }
    
    /**
     * Get the color representation of the continental room.
     *
     * @return The color representation of the continental room.
     */
    public Color getColor() {
        return Color.YELLOW;
    }
}
