package Actor.Zombie;

/**
 * The Runner class represents a type of zombie known as Runner.
 * It extends the Zombie class.
 */
public class Runner extends Zombie {
	private static final String NAME = "Runner";
    /**
     * The default lifepoints of the Runner.
     */
    private static final int LIFEPOINTS = 2;

    /**
     * The default actionpoints of the Runner.
     */
    private static final int ACTIONPOINTS = 2;

    /**
     * The default damage inflicted by the Runner.
     */
    private static final int DAMAGE = 1;

    /**
     * Constructor for creating a Runner with default lifepoints, actionpoints, and damage.
     */
    public Runner() {
        super(NAME,LIFEPOINTS, ACTIONPOINTS, DAMAGE);
    }
    
}
