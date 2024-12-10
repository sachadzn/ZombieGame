package City;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Cell.Cell;
import Cell.Room.Room;
import Cell.Street.Manhole;

class TrainingCityTest {

	/**
	 * Test case for the initTrainingCity method of the TrainingCity class.
	 * It checks if the training city is initialized correctly.
	 */
	@Test
	void testInitTrainingCity() {
	    TrainingCity trainingCity = new TrainingCity();
	    trainingCity.initCity(); // Initialiser la ville
	    trainingCity.displayCity(); // Afficher la ville pour vérification manuelle

	    ArrayList<ArrayList<Cell>> cellList = trainingCity.getCellList();

	    assertTrue(cellList.get(2).get(2) instanceof Manhole);
	    assertTrue(cellList.get(0).get(0) instanceof Room);
	}
}
