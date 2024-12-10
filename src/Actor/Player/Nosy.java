package Actor.Player;

/**
 * The Nosy class represents a player character who has a noisy trait.
 * It extends the Player class.
 */
public class Nosy extends Player {

    /**
     * Constructor for creating a Nosy player with a specified name.
     *
     * @param name The name of the Nosy player.
     */
    public Nosy(String name) {
        super(name);
    }

    /**
     * Constructor for creating a Nosy player with specified lifepoints and actionpoints.
     *
     * @param name        The name of the Nosy player.
     * @param lifepoints  The lifepoints of the Nosy player.
     * @param actionpoints The actionpoints of the Nosy player.
     */
    public Nosy(String name, int lifepoints, int actionpoints) {
        super(name, lifepoints, actionpoints);
    }
}
