package Actor.Player;

/**
 * The Healer class represents a player character who specializes in healing.
 * It extends the Player class.
 */
public class Healer extends Player {

    /**
     * The default healing power of the Healer.
     */
    private static int healingPower = 1;

    /**
     * Constructor for creating a Healer with a specified name.
     *
     * @param name The name of the Healer.
     */
    public Healer(String name) {
        super(name);
    }

    /**
     * Constructor for creating a Healer with specified lifepoints and actionpoints.
     *
     * @param name        The name of the Healer.
     * @param lifepoints  The lifepoints of the Healer.
     * @param actionpoints The actionpoints of the Healer.
     */
    public Healer(String name, int lifepoints, int actionpoints) {
        super(name, lifepoints, actionpoints);
    }

    /**
     * Get the healing power of the Healer.
     *
     * @return The healing power of the Healer.
     */
    public static int getHealingPower() {
        return healingPower;
    }

    /**
     * Set the healing power of the Healer.
     *
     * @param healingPower The new healing power to be set.
     */
    public static void setHealingPower(int healingPower) {
        Healer.healingPower = healingPower;
    }
}
