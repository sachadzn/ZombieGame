package Equipment;

/**
 * The Equipment class represents an equipment item in the game.
 */
public abstract class Equipment {
    protected boolean noisy = false; // Indicates whether the equipment is noisy
    protected String name; // The name of the equipment

    /**
     * Constructor for creating an Equipment with a specified name.
     *
     * @param name The name of the equipment.
     */
    public Equipment(String name) {
        this.name = name;
    }

    /**
     * Check if the Equipment is noisy.
     *
     * @return True if the Equipment is noisy, false otherwise.
     */
    public boolean getNoisy() {
        return noisy;
    }

    /**
     * Set whether the Equipment is noisy or not.
     *
     * @param noisy True if the Equipment is noisy, false otherwise.
     */
    public void setNoisy(boolean noisy) {
        this.noisy = noisy;
    }

    /**
     * Get the name of the Equipment.
     *
     * @return The name of the Equipment.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Equipment.
     *
     * @param name The name of the Equipment.
     */
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
    	return this.name+" { noisy: "+this.noisy+" }";
    }
}
