package Action;

import java.util.ArrayList;
import java.util.List;

import Actor.Actor;
import Actor.Player.Healer;
import Actor.Player.Player;
import City.City;
import ListChooser.InteractiveListChooser;

/**
 * The Heal class represents an action to heal a character.
 * It implements the Action interface.
 */
public class Heal implements Action {

    private City city;
    
    /**
     * Constructor for Heal class.
     *
     * @param city The city where the healing is taking place.
     */
    public Heal(City city) {
        this.city = city;
    }

    /**
     * Prompt the user to select a player to heal.
     */
    public void Do() {
        System.out.println("Who do you want to heal?");
    }
    
    /**
     * Perform the action of healing a character.
     *
     * @param healer The healer performing the healing action.
     */
    public void Do(Healer healer) {
        List<Player> players= new ArrayList<>();
        List<Actor> actors = city.getCellList().get(healer.getY()).get(healer.getX()).getAllActors();
        for (Actor actor : actors) {
            if (actor instanceof Player) {
                players.add((Player)actor);
            }
        }
        InteractiveListChooser<Player> playerChooser = new InteractiveListChooser<>();
        Player chosenPlayer = playerChooser.choose("Which player do you choose ?", players);
        if (chosenPlayer!= null) {
            this.Do(healer,chosenPlayer);
        } else {
            System.out.println("Canceled...");
        }
    }
    
    /**
     * Perform the action of healing a character.
     *
     * @param player The player to be healed.
     * @param healer The healer performing the healing action.
     */
    public void Do(Healer healer, Player player) {
        int life = player.getLifepoints();
        if (life < 5) {
            player.setLifepoints(life + 1);
            healer.setActionpoints(healer.getActionpoints() - 1);
            System.out.println(player.getName() + " says: thank you for healing me!");
        } else {
            System.out.println(player.getName() + " has already 5 lifepoints!");
        }
    }
    
    /**
     * Returns a string representation of the Heal action.
     * 
     * @return A string representation of the Heal action.
     */
    public String toString() {
        return "Heal";
    }
}
