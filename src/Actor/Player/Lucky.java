package Actor.Player;

/**
 * The Lucky class represents a player character who has a lucky trait.
 * It extends the Player class.
 */
public class Lucky extends Player {

    /**
     * Constructor for creating a Lucky player with a specified name.
     *
     * @param name The name of the Lucky player.
     */
    public Lucky(String name) {
        super(name);
    }

    /**
     * Constructor for creating a Lucky player with specified lifepoints and actionpoints.
     *
     * @param name        The name of the Lucky player.
     * @param lifepoints  The lifepoints of the Lucky player.
     * @param actionpoints The actionpoints of the Lucky player.
     */
    public Lucky(String name, int lifepoints, int actionpoints) {
        super(name, lifepoints, actionpoints);
    }
}
