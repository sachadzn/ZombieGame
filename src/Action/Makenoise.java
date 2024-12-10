package Action;

import Actor.Player.Player;
import Cell.Cell;
import City.City;

/**
 * The Makenoise class represents an action to make noise.
 * It implements the Action interface.
 */
public class Makenoise implements Action {
	
	public void Do() {
        System.out.println("Who do you want to Search?");
    }
	private City city;

    /**
     * Constructor for the LookAround class.
     *
     * @param city The city in which the action will take place.
     */
    public Makenoise(City city) {
        this.city = city;
    }

    /**
     * Perform the action of making noise.
     * Currently, this method is empty and needs to be implemented.
     */
    public void Do(Player player) {
    	int x = player.getX();
        int y = player.getY();
        Cell currentCell = city.getCellList().get(y).get(x);
        currentCell.setNoise(currentCell.getNoise()+1);
    }
   
}
