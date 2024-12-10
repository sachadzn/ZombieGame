package Actor.Zombie;

/**
 * The Abomination class represents a type of zombie known as Abomination.
 * It extends the Zombie class.
 */
public class Abomination extends Zombie {
	private static final String name = "Abomination";
    /**
     * The default lifepoints of the Abomination.
     */
    private static final int LIFEPOINTS = 6;

    /**
     * The default actionpoints of the Abomination.
     */
    private static final int ACTIONPOINTS = 1;

    /**
     * The default damage inflicted by the Abomination.
     */
    private static final int DAMAGE = 3;

    /**
     * Constructor for creating an Abomination with default lifepoints, actionpoints, and damage.
     */
    public Abomination() {
        super(name,LIFEPOINTS, ACTIONPOINTS, DAMAGE);
    }
}
