package Equipment.Weapon;

/**
 * The Pistol class represents a type of weapon called "Pistol" in the game.
 * It extends the Weapon class and provides specific attributes for the Pistol weapon.
 */
public class Pistol extends Weapon {
    
    /**
     * Constructor for creating a Pistol with default values.
     * Initializes the Pistol with a name, damage, range, noise level, and action points cost.
     * By default, pistols are noisy.
     */
    public Pistol() {
        super("Pistol", 2, 4, 1, 1);
        setNoisy(true);
    }
}
