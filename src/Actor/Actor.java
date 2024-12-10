package Actor;

/**
 * This abstract class represents an actor in the game.
 */
public abstract class Actor {
    /**
     * The x-coordinate of the actor's position.
     */
    protected int x;

    /**
     * The y-coordinate of the actor's position.
     */
    protected int y;

    /**
     * The lifepoints of the actor.
     */
    protected int lifepoints;

    /**
     * The action points of the actor.
     */
    protected int actionpoints;
    
    protected String name;

    /**
     * Constructor for creating an actor with specified lifepoints and actionpoints.
     *
     * @param lifepoints   The lifepoints of the actor.
     * @param actionpoints The actionpoints of the actor.
     */
    public Actor(String name,int lifepoints, int actionpoints) {
    	this.name=name;
        this.lifepoints = lifepoints;
        this.actionpoints = actionpoints;
    }

    /**
     * Get the x-coordinate of the actor's position.
     *
     * @return The x-coordinate of the actor.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Set the x-coordinate of the actor's position.
     *
     * @param x The new x-coordinate to be set.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get the y-coordinate of the actor's position.
     *
     * @return The y-coordinate of the actor.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Set the y-coordinate of the actor's position.
     *
     * @param y The new y-coordinate to be set.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the lifepoints of the actor.
     *
     * @return The lifepoints of the actor.
     */
    public int getLifepoints() {
        return lifepoints;
    }

    /**
     * Get the actionpoints of the actor.
     *
     * @return The actionpoints of the actor.
     */
    public int getActionpoints() {
        return actionpoints;
    }

    /**
     * Set the lifepoints of the actor.
     *
     * @param lifepoints The new lifepoints to be set.
     */
    public void setLifepoints(int lifepoints) {
        this.lifepoints = lifepoints;
    }

    /**
     * Set the actionpoints of the actor.
     *
     * @param actionpoints The new actionpoints to be set.
     */
    public void setActionpoints(int actionpoints) {
        this.actionpoints = actionpoints;
    }
    public String getName() {
    	return this.name;
    }
    
}
