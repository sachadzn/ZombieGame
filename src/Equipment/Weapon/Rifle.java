package Equipment.Weapon;

/**
 * The Rifle class represents a type of weapon called "Rifle" in the game.
 * It extends the Weapon class and provides specific attributes for the Rifle weapon.
 */
public class Rifle extends Weapon {
    
    /**
     * Constructor for creating a Rifle with default values.
     * Initializes the Rifle with a name, damage, range, noise level, and action points cost.
     * By default, rifles are noisy.
     */
    public Rifle() {
        super("Rifle", 1, 4, 3, 2);
        setNoisy(true);
    }
}
