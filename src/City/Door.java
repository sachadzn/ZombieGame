package City;

/**
 * The Door class represents a door object that can be opened or closed.
 * It maintains information about whether the door is currently open and whether it can be opened.
 */
public class Door {
    private boolean isOpen;
    private boolean canBeOpened;
    /**
     * Default constructor for the Door class.
     * Initializes a door with the default values for open and canBeOpened.
     */
    public Door() {
    	this.isOpen=false;
    	this.canBeOpened=true;
    }
    /**
     * Parameterized constructor for the Door class.
     *
     * @param isOpen      A boolean indicating whether the door is open.
     * @param canBeOpened A boolean indicating whether the door can be opened.
     */
    public Door(boolean isOpen, boolean canBeOpened) {
        this.isOpen = isOpen;
        this.canBeOpened = canBeOpened;
    }
    /**
     * Check if the door is open.
     *
     * @return True if the door is open, false otherwise.
     */
    public boolean isOpen() {
        return isOpen;
    }
    /**
     * Set the state of the door to open or closed.
     *
     * @param isOpen A boolean indicating whether the door is open.
     */
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    /**
     * Check if the door can be opened.
     *
     * @return True if the door can be opened, false otherwise.
     */
    public boolean isCanBeOpened() {
        return canBeOpened;
    }
    /**
     * Set the state indicating whether the door can be opened.
     *
     * @param canBeOpened A boolean indicating whether the door can be opened.
     */
    public void setCanBeOpened(boolean canBeOpened) {
        this.canBeOpened = canBeOpened;
    }
}
