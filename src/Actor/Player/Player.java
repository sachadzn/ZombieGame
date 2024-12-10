package Actor.Player;

import Actor.Actor;
import Equipment.Equipment;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Player class represents a player character in the game.
 * It extends the Actor class.
 */
public class Player extends Actor {
    protected List<Equipment> backPack; // The list of equipment in the player's backpack
    protected Equipment hand; // The equipment currently held in the player's hand
    protected List<String> roles; // The roles the player has
    protected int level; // The level of the player

    /**
     * Constructor for creating a Player with a specified name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        super(name, 5, 3);
        this.backPack = new ArrayList<>();
        this.roles = new ArrayList<>();
        this.level = 1;
    }

    /**
     * Constructor for creating a Player with specified name, lifepoints, and actionpoints.
     *
     * @param name        The name of the player.
     * @param lifepoints  The lifepoints of the Player.
     * @param actionpoints The actionpoints of the Player.
     */
    public Player(String name, int lifepoints, int actionpoints) {
        super(name, lifepoints, actionpoints);
        backPack = new ArrayList<>();
        roles = new ArrayList<>();
        this.level = 1;
    }

    /**
     * Get the level of the Player.
     *
     * @return The level of the Player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Get the list of equipment in the Player's backpack.
     *
     * @return The list of equipment.
     */
    public List<Equipment> getBackPack() {
        return backPack;
    }


    /**
     * Get the equipment currently held in the Player's hand.
     *
     * @return The equipment in hand.
     */
    public Equipment getHand() {
        return hand;
    }

    /**
     * Get the roles of the Player.
     *
     * @return The roles of the Player.
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Set the level of the Player.
     *
     * @param level The new level to be set.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Set the equipment held in the Player's hand.
     *
     * @param hand The equipment to be set in hand.
     */
    public void setHand(Equipment hand) {
        this.hand = hand;
    }

    /**
     * Remove the equipment held in the Player's hand.
     */
    public void removeHand() {
        this.hand = null;
    }

    /**
     * Add an equipment to the Player's backpack.
     *
     * @param equipment The equipment to add.
     */
    public void addEquipment(Equipment equipment) {
        backPack.add(equipment);
    }

    /**
     * Remove an equipment from the Player's backpack.
     *
     * @param equipment The equipment to remove.
     */
    public void removeBackpackEquipment(Equipment equipment) {
        backPack.remove(equipment);
    }

    /**
     * Check if the Player has a specific role.
     *
     * @param role The role to check.
     * @return True if the Player has the role, false otherwise.
     */
    public boolean hasRole(String role) {
        return roles.contains(role);
    }

    /**
     * Get a random number between 1 and 6.
     *
     * @return The value rolled on the die.
     */
    public int diceRoll() {
        Random randomNumber = new Random();
        int value = randomNumber.nextInt(6) + 1;
        System.out.println("Rolling the dice... " + value);
        return value;
    }

    /**
     * Check the contents of the Player's backpack and print them.
     */
    public void checkBackpack() {
        List<Equipment> backpack = this.getBackPack();
        String res = "Backpack :";
        if (backpack.isEmpty()) {
            System.out.println("The backpack is empty.");
        } else {
            Iterator<Equipment> it = backpack.iterator();
            int i = 0;
            while (it.hasNext()) {
                Equipment e = it.next();
                res += i + "- " + e.toString();
            }
            System.out.println(res);
        }
    }

    /**
     * Returns a string representation of the Player.
     *
     * @return A string representation of the Player.
     */
    public String toString() {
        return this.getName() + " { lifepoints: " + this.lifepoints + " actionpoints: " + this.actionpoints + " level: " + this.level + " hand: " + this.hand + " } ";
    }
}
