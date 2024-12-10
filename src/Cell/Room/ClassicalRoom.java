package Cell.Room;

import java.awt.Color;

/**
 * The ClassicalRoom class represents a classical room in a city grid.
 * Classical rooms may have the ability to be attacked and are described by a string description.
 * This class extends the Room class and provides specific functionality for classical rooms.
 */
public class ClassicalRoom extends Room {

    /**
     * Default constructor for the ClassicalRoom class.
     * Initializes the room with the ability to be attacked and a default description.
     */
    public ClassicalRoom() {
        super(true, "Classical Room");
    }

    /**
     * Parameterized constructor for the ClassicalRoom class.
     *
     * @param beAttacked A boolean indicating whether the room can be attacked.
     * @param description The description of the classical room.
     */
    public ClassicalRoom(boolean beAttacked, String description) {
        super(beAttacked, description);
    }

    /**
     * Get a string representation of the classical room.
     *
     * @return A string representation of the classical room.
     */
    public String toString() {
        return "R";
    }
    
    /**
     * Get the color representation of the classical room.
     *
     * @return The color representation of the classical room.
     */
    public Color getColor() {
        return Color.DARK_GRAY;
    }
}
