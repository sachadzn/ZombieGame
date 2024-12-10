package Actor.Zombie;

import Actor.Actor;

/**
 * The Zombie class represents a type of actor known as a zombie.
 * It is an abstract class that extends the Actor class.
 */
public abstract class Zombie extends Actor {
    /**
     * The amount of damage inflicted by the zombie.
     */
    protected int damage;
    
    /**
     * Constructs a new Zombie with the specified name, lifepoints, actionpoints, and damage.
     *
     * @param name        The name of the zombie.
     * @param lifepoints  The initial lifepoints of the zombie.
     * @param actionpoints The initial actionpoints of the zombie.
     * @param damage      The damage inflicted by the zombie's attacks.
     */
    public Zombie(String name, int lifepoints, int actionpoints, int damage) {
        super(name, lifepoints, actionpoints);
        this.damage = damage;
    }


    /**
     * Get the damage inflicted by the zombie.
     *
     * @return The damage inflicted by the zombie.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Set the damage inflicted by the zombie.
     *
     * @param damage The new damage value to be set.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String toString() {
    	return this.name+" { lifepoints: "+this.getLifepoints()+" actionpoints: "+this.getActionpoints()+" damage: "+this.getDamage()+" } ";
    }
}
