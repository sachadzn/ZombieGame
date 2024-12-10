package Equipment.Consumable;

import Equipment.Equipment;

/**
 * Represents a Consumable item, which is a type of Equipment that can be consumed with an effect.
 */
public abstract class Consumable extends Equipment {
    protected String effect;

    /**
     * Constructs a Consumable object with a given name and effect.
     * @param name   The name of the consumable item.
     * @param effect The effect of using the consumable item.
     */
    public Consumable(String name, String effect) {
        super(name);
        this.effect = effect;
    }
    
    /**
     * Retrieves the effect of using the consumable item.
     * @return The effect of using the consumable item.
     */
    public String getEffect() {
        return effect;
    }
    public String toString() {
    	return this.name+" { effect: "+this.effect+" noisy: "+this.noisy+" }";
    }
}
