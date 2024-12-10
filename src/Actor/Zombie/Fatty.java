package Actor.Zombie;

/**
 * The Fatty class represents a type of zombie known as Fatty.
 * It extends the Zombie class.
 */
public class Fatty extends Zombie {
	private static final String name = "Fatty";
    /**
     * The default lifepoints of the Fatty.
     */
    private static final int LIFEPOINTS = 4;

    /**
     * The default actionpoints of the Fatty.
     */
    private static final int ACTIONPOINTS = 1;

    /**
     * The default damage inflicted by the Fatty.
     */
    private static final int DAMAGE = 2;

    /**
     * Constructor for creating a Fatty with default lifepoints, actionpoints, and damage.
     */
    public Fatty() {
        super(name,LIFEPOINTS, ACTIONPOINTS, DAMAGE);
    }
}
