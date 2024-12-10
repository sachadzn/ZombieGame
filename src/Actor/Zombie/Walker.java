package Actor.Zombie;

/**
 * The Walker class represents a type of zombie known as Walker.
 * It extends the Zombie class.
 */
public class Walker extends Zombie {
	private static final String NAME = "Walker";
    /**
     * The default lifepoints of the Walker.
     */
    private static final int LIFEPOINTS = 1;

    /**
     * The default actionpoints of the Walker.
     */
    private static final int ACTIONPOINTS = 1;

    /**
     * The default damage inflicted by the Walker.
     */
    private static final int DAMAGE = 1;

    /**
     * Constructor for creating a Walker with default lifepoints, actionpoints, and damage.
     */
    public Walker() {
        super(NAME,LIFEPOINTS, ACTIONPOINTS, DAMAGE);
    }
    
}
