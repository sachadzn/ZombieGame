package Equipment.Consumable;

/**
 * Represents a MedKit, a type of Consumable item.
 */
public class MedKit extends Consumable {
    
    /** The amount of healing provided by the MedKit. */
    private static int healing = 1;

    /**
     * Constructor for creating a MedKit with default values.
     */
    public MedKit() {
        super("MedKit", "using a med kit allows you to heal one of the survivors in your zone (+1 life point)");
    }
}
