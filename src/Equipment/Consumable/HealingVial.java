package Equipment.Consumable;

/**
 * Represents a HealingVial, a type of Consumable item that allows gaining a life point.
 */
public class HealingVial extends Consumable {
    private static int healing = 1;

    /**
     * Constructor for creating a HealingVial with default values.
     */
    public HealingVial() {
        super("HealingVial", "Using a healing vial allows you to gain a life point");
    }

    /**
     * Constructor for creating a HealingVial with custom name and effect.
     * @param name   The name of the HealingVial.
     * @param effect The effect of using the HealingVial.
     */
    public HealingVial(String name, String effect) {
        super(name, effect);
    }

    /**
     * Gets the amount of healing provided by the HealingVial.
     * @return The amount of healing.
     */
    public static int getHealing() {
        return healing;
    }

    /**
     * Sets the amount of healing provided by the HealingVial.
     * @param healingValue The amount of healing to set.
     */
    public static void setHealing(int healingValue) {
        healing = healingValue;
    }
}
