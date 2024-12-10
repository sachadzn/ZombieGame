package City;

import java.util.HashMap;

import Cell.Street.Manhole;

/**
 * The TrainingCity class represents a specialized type of city used for training purposes.
 * It inherits functionality from the City class and provides additional methods specific to training scenarios.
 */
public class TrainingCity  extends City {
	/**
     * Default constructor for the TrainingCity class.
     * Initializes a training city with the default width and length.
     */
	public TrainingCity() {
		super();
	}
	
	/**
     * Places a manhole in the center of the training city.
     * The manhole is added to the cell at the center coordinates (2, 2).
     */
	protected void placeManHole() {
        Manhole m = new Manhole();
        HashMap<Cardinal, Boolean> centerDoor = createDoorMap(true, true, true, true);
        m.setDoorMap(centerDoor);
        this.cellList.get(2).set(2, m); // milieu 
	}
	
}