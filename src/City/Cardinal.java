package City;

import java.util.ArrayList;
import java.util.List;

/**
 * The Cardinal enum represents cardinal directions.
 * It includes the directions NORTH, SOUTH, EAST, and WEST.
 * These directions are commonly used to indicate orientation or movement.
 */
public enum Cardinal {
    NORTH, SOUTH, EAST, WEST;

    /**
     * Get a list containing all cardinal directions.
     *
     * @return A list containing all cardinal directions.
     */
    public static List<Cardinal> getAllCardinals() {
        List<Cardinal> cardinalList = new ArrayList<>();
        cardinalList.add(NORTH);
        cardinalList.add(SOUTH);
        cardinalList.add(EAST);
        cardinalList.add(WEST);
        return cardinalList;
    }
}
