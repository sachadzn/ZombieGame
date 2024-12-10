package Equipment.Weapon;

import Equipment.Equipment;

/**
 * The Weapon class represents a generic weapon in the game.
 * It extends the Equipment class and provides specific attributes for weapons.
 */
public abstract class Weapon extends Equipment {
    protected int damage;
    protected int threshold;
    protected int range;
    protected int throwDice;
    
    /**
     * Constructor for creating a Weapon with specified attributes.
     *
     * @param name      The name of the weapon.
     * @param damage    The damage value of the weapon.
     * @param threshold The threshold value of the weapon.
     * @param range     The range of the weapon.
     * @param throwDice The number of dice to throw for the weapon.
     */
    public Weapon(String name, int damage, int threshold, int range, int throwDice) {
        super(name);
        this.damage = damage;
        this.threshold = threshold;
        this.range = range;
        this.throwDice = throwDice;
    }
    
    /**
     * Get the damage value of the weapon.
     *
     * @return The damage value of the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set the damage value of the weapon.
     *
     * @param damage The damage value to set for the weapon.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Get the threshold value of the weapon.
     *
     * @return The threshold value of the weapon.
     */
    public int getThreshold() {
        return threshold;
    }

    /**
     * Set the threshold value of the weapon.
     *
     * @param threshold The threshold value to set for the weapon.
     */
    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    /**
     * Get the range of the weapon.
     *
     * @return The range of the weapon.
     */
    public int getRange() {
        return range;
    }

    /**
     * Set the range of the weapon.
     *
     * @param range The range to set for the weapon.
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Get the number of dice to throw for the weapon.
     *
     * @return The number of dice to throw for the weapon.
     */
    public int getThrowDice() {
        return throwDice;
    }

    /**
     * Set the number of dice to throw for the weapon.
     *
     * @param throwDice The number of dice to throw for the weapon.
     */
    public void setThrowDice(int throwDice) {
        this.throwDice = throwDice;
    }
    
    /**
     * Get a string representation of the weapon.
     *
     * @return A string representation of the weapon.
     */
    public String toString() {
        return this.name + "{ damage: " + this.damage + " threshold: " + this.threshold + " range: " + this.range + " dice: " + this.throwDice + " noisy: " + this.noisy + " }";
    }
}
