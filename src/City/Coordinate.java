package City;

/**
 * The Coordinate class represents a pair of coordinates (x, y) in a two-dimensional space.
 * It is commonly used to represent positions in a grid or on a map.
 */
public class Coordinate {
	private int x;
	private int y;
	
	/**
     * Constructor for the Coordinate class.
     *
     * @param x The x-coordinate value.
     * @param y The y-coordinate value.
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x-coordinate value.
     *
     * @return The x-coordinate value.
     */
    public int getX() {
        return x;
    }

    /**
     * Set the x-coordinate value.
     *
     * @param x The new x-coordinate value to be set.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y-coordinate value.
     *
     * @return The y-coordinate value.
     */
    public int getY() {
        return y;
    }

    /**
     * Set the y-coordinate value.
     *
     * @param y The new y-coordinate value to be set.
     */
    public void setY(int y) {
        this.y = y;
    }
}