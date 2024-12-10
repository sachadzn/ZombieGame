package Cell.Room;

import Cell.Cell;
//import java.util.ArrayList;

/**
 * The Room class represents a generic room in a city grid.
 * Rooms may have the ability to be attacked and are described by a string description.
 * This class extends the Cell class and provides specific functionality for rooms.
 */
public abstract class Room extends Cell {
//  protected ArrayList<Equipment> equipmentList;

  
    protected boolean canBeAttacked;

    protected String description;

    /**
     * Default constructor for the Room class.
     * Initializes the room with default values for attackability and description.
     */
    public Room() {
        super();
        this.canBeAttacked = false;
        this.description = "Default";
    }

    /**
     * Parameterized constructor for the Room class.
     *
     * @param beAttacked A boolean indicating whether the room can be attacked.
     * @param description The description of the room.
     */
    public Room(boolean beAttacked, String description) {
        super();
        this.canBeAttacked = beAttacked;
        this.description = description;
    }

    /**
     * Check if the room can be attacked.
     *
     * @return True if the room can be attacked, false otherwise.
     */
    public boolean canBeAttacked() {
        return canBeAttacked;
    }

    /**
     * Set whether the room can be attacked.
     *
     * @param beAttacked The new value indicating whether the room can be attacked.
     */
    public void setBeAttacked(boolean beAttacked) {
        this.canBeAttacked = beAttacked;
    }

    /**
     * Get the description of the room.
     *
     * @return The description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the room.
     *
     * @param description The new description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}