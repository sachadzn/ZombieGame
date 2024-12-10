package Cell.Room;
//import java.util.ArrayList;
import java.awt.Color;

/**
 * The Pharmacy class represents a pharmacy room in a city grid.
 * Pharmacy rooms may have the ability to be attacked and are described by a string description.
 * This class extends the Room class and provides specific functionality for pharmacy rooms.
 */
public class Pharmacy extends Room {

    /**
     * Default constructor for the Pharmacy class.
     * Initializes the room with the ability to be attacked and a default description.
     */
    public Pharmacy() {
        super(true, "Default pharmacy room");
    }

    /**
     * Parameterized constructor for the Pharmacy class.
     *
     * @param beAttacked A boolean indicating whether the room can be attacked.
     * @param description The description of the pharmacy room.
     */
    public Pharmacy(boolean beAttacked, String description) {
        super(beAttacked, description);
    }

    /**
     * Get a string representation of the pharmacy room.
     *
     * @return A string representation of the pharmacy room.
     */
    public String toString() {
        return "P";
    }
    
    /**
     * Get the color representation of the pharmacy room.
     *
     * @return The color representation of the pharmacy room.
     */
    public Color getColor() {
        return Color.GREEN;
    }
}

