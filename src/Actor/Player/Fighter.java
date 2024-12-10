package Actor.Player;

/**
 * The Fighter class represents a player character who specializes in combat.
 * It extends the Player class.
 */
public class Fighter extends Player {

    /**
     * Constructor for creating a Fighter with a specified name.
     *
     * @param name The name of the Fighter.
     */
    public Fighter(String name) {
        super(name);
    }

    /**
     * Constructor for creating a Fighter with specified lifepoints and actionpoints.
     *
     * @param name        The name of the Fighter.
     * @param lifepoints  The lifepoints of the Fighter.
     * @param actionpoints The actionpoints of the Fighter.
     */
    public Fighter(String name, int lifepoints, int actionpoints) {
        super(name, lifepoints, actionpoints);
    }
}
