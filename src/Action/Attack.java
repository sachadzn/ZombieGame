package Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Actor.*;
import Actor.Player.*;
import Actor.Zombie.*;
import Cell.Cell;
import Cell.Room.Continental;
import City.Cardinal;
import City.City;
import Equipment.Equipment;
import Equipment.Weapon.Pistol;
import Equipment.Weapon.Rifle;
import Equipment.Weapon.Weapon;
import ListChooser.InteractiveListChooser;
import ListChooser.RandomListChooser;

/**
 * The Attack class represents an action to perform an attack.
 * It implements the Action interface.
 */
public class Attack implements Action {

    private City city;
    
    /**
     * Constructor for Attack class.
     *
     * @param city The city where the attack is taking place.
     */
    public Attack(City city) {
        this.city = city;
    }
    
    /**
     * Executes the attack action based on the type of the attacker.
     *
     * If the attacker is a Zombie, it randomly selects a Player to attack from the same cell.
     * If the attacker is a Player, it prompts the user to choose an Actor from the same cell to attack.
     *
     * @param attacker The actor performing the attack.
     */
    public void Do(Actor attacker) {
        if(attacker instanceof Zombie) {
            // If attacker is a Zombie, randomly select a Player to attack
            List<Player> players = new ArrayList<>();
            List<Actor> actors = city.getCellList().get(attacker.getY()).get(attacker.getX()).getAllActors();
            for (Actor actor : actors) {
                if (actor instanceof Player) {
                    players.add((Player) actor);
                }
            }
            RandomListChooser<Actor> actorChooser = new RandomListChooser<>();
            Actor choose = actorChooser.choose(null, players);
            if (choose != null) {
                this.Do(attacker, choose);
            } else {
                System.out.println("No player found in the same cell...");
            }
            
        } else if (attacker instanceof Player) {

            int attackerX=attacker.getX();
            int attackerY=attacker.getY();

            if (((Player) attacker).getHand() instanceof Pistol || ((Player) attacker).getHand() instanceof Rifle) {
            List<Cardinal> cardinal = new ArrayList<>(Arrays.asList(Cardinal.NORTH,Cardinal.SOUTH,Cardinal.EAST,Cardinal.WEST));
            InteractiveListChooser<Cardinal> Cardinalc = new InteractiveListChooser<>();
            Cardinal chosenCard = Cardinalc.choose("Which cardinal do you choose ?\n", cardinal);
            List<String> range23 = new ArrayList<>(Arrays.asList("0","1","2","3"));
            InteractiveListChooser<String> ranges = new InteractiveListChooser<>();
            String range1 = ranges.choose("Which range do you choose ?\n", range23);
            attackerX = attacker.getX();
            attackerY = attacker.getY();
            if(chosenCard!=null && ((Integer.parseInt(range1) >= 0) && (Integer.parseInt(range1) <= 3))) {
            switch(chosenCard) {
            	case NORTH:
            		attackerX = attacker.getX();
            		attackerY = attacker.getY()- Integer.parseInt(range1);
            		break;
            	case SOUTH:
            		attackerX = attacker.getX();
            		attackerY = attacker.getY()+ Integer.parseInt(range1);
            		break;
            	case EAST:
            		attackerX = attacker.getX()+ Integer.parseInt(range1);
            		attackerY = attacker.getY();
            		break;
            	case WEST:
            		attackerX = attacker.getX()- Integer.parseInt(range1);
            		attackerY = attacker.getY();
            		break;	
            }
            }else {
            	System.out.println("None is not a range or a cardinal, so it's the same as attacking on your position. ");
            	attackerX = attacker.getX();
        		attackerY = attacker.getY();
            }
            	
            }
            List<Actor> actors = city.getCellList().get(attackerY).get(attackerX).getAllActors();
            
            InteractiveListChooser<Actor> actorChooser = new InteractiveListChooser<>();
            Actor chosenActor = actorChooser.choose("Which actor do you choose ?\n", actors);
            if (chosenActor != null) {
                this.Do(attacker, chosenActor);
            } else {
            	
                System.out.println("Canceled...");
            }
        }
    }




    /**
    * Perform the attack action.
    *
    * @param attacker The actor performing the attack.
    * @param target The actor being targeted by the attack.
    */
    public void Do(Actor attacker, Actor target) {
        // Check if the attacker is a Zombie
    	if ((city.getCellList().get(target.getY()).get(target.getX()) instanceof Continental) || (city.getCellList().get(attacker.getY()).get(attacker.getX()) instanceof Continental)) {
    	    System.out.println("You cannot attack someone in Continental!");
    	    return;
    	}
        if (attacker instanceof Zombie && target instanceof Player) {
            if (attacker.getX() == target.getX() && attacker.getY() == target.getY()) {
                int damage = ((Zombie) attacker).getDamage();
                target.setLifepoints(target.getLifepoints() - damage); 
                attacker.setActionpoints(attacker.getActionpoints()-1);
                System.out.println(attacker.getName()+" attacks! " +target.getName()+ " loses " + damage + " lifepoints.");
                if (target.getLifepoints()<=0) {
                	city.getCellList().get(target.getY()).get(target.getX()).removeActor(target);
                	System.out.println("The Player "+target.getName() +" is dead !!!");
                }
            } else {
                System.out.println(attacker.getName()+" cannot attack! "+attacker.getName()+" and"+ target.getName()+" are not on the same cell.");
            }
        } else if (attacker instanceof Player && target instanceof Zombie) {
            // If attacker is a Player
            int damage = 0;
            Equipment weapon = ((Player) attacker).getHand();
            if (weapon instanceof Weapon) {
                if (isInRange(attacker, target, (Weapon) weapon) && Checkdoors(attacker, target)) { 
                    damage = (((Weapon) weapon).getDamage());
                    if ((damage == 1 && target instanceof Fatty) || (damage == 1 && target instanceof Abomination)) {
                    	System.out.println("You cannot make damage with your weapon on a Fatty or Abomination");
                    	return;
                    }
                    int rollResult = ((Player) attacker).diceRoll(); 
                    int attackThreshold = ((Weapon) weapon).getThreshold();
                    if ( attacker instanceof Fighter) {
                    	rollResult+=1;
                    } else if (attacker instanceof Lucky && rollResult < attackThreshold) {
                    	rollResult =((Player)attacker).diceRoll(); // on refait une fois
                    }
                    if (rollResult >= attackThreshold) {
                        // Attack is successful, inflict damage to the zombie
                        target.setLifepoints(target.getLifepoints() - damage);
                        attacker.setActionpoints(attacker.getActionpoints()-1);
                        System.out.println(attacker.getName()+" attacks! " +target.getName()+ " loses " + damage + " lifepoints.");
                        if (target.getLifepoints() <= 0) {
                            ((Player) attacker).setLevel(((Player) attacker).getLevel() + 1);
                            city.getCellList().get(target.getY()).get(target.getX()).removeActor(target);
                            System.out.println("The "+target.getName() +" is dead !!!");
                            if (((Player) attacker).getLevel() == 3 || ((Player) attacker).getLevel() == 7 || ((Player) attacker).getLevel() == 11) {
                                attacker.setActionpoints(attacker.getActionpoints() + 1); // increase actionpoints if level at 3 7 or 11
                                System.out.println("Congratulations, you have earned an action point ");
                            }
                        }
                    } else  {
                    	System.out.println("Unfortunately, your dice roll didn't meet the required threshold. No damage was dealt this time.");
                    }
                } else {
                    System.out.println(attacker.getName()+" cannot attack! "+attacker.getName()+" and "+target.getName()+" are not in range or there is at least one closed door or a wall between them.");
                }
            } else {
                System.out.println(attacker.getName()+" needs to have a weapon to attack!!");
            }
        } else {
            System.out.println("You need 1 zombie and 1 Player!");
        }
    }


    /**
     * Checks if the target is within the range of the attacker's weapon.
     *
     * @param attacker The actor performing the attack.
     * @param target The actor being targeted by the attack.
     * @param weapon The weapon being used for the attack.
     * @return True if the target is within the range of the weapon, false otherwise.
     */
    public boolean isInRange(Actor attacker, Actor target, Weapon weapon) {
        int attackerX = attacker.getX();
        int attackerY = attacker.getY();
        int targetX = target.getX();
        int targetY = target.getY();
    
        int range = weapon.getRange();
    
        if (attackerX == targetX && attackerY == targetY) {
            // Same cell, so it's always true
            return true;
        } else if (attackerX == targetX) {
            // Same column, so they are vertically aligned
            int distance = Math.abs(targetY - attackerY);
            return distance <= range;
        } else if (attackerY == targetY) {
            // Same row, so it's horizontal
            int distance = Math.abs(targetX - attackerX);
            return distance <= range;
        } else {
            // Coordinates are different, so it's out of range
            return false;
        }
    }

    /**
     * Performs the attack action without specific target.
     */
    public void Do() {
        System.out.println("Need 2 Actors, 1 zombie and 1 Player");
    }

    /**
    * Check if the attacker can shoot the target through the verification of the doors 
    *
    * @param attacker The actor performing the attack.
    * @param target The actor being targeted by the attack.
    * @return true if the attacker can shoot the target, false otherwise.
    */
	public boolean Checkdoors(Actor attacker, Actor target) {
	    int attackerX = attacker.getX();
	    int attackerY = attacker.getY();
	    int targetX = target.getX();
	    int targetY = target.getY();

	    List<ArrayList<Cell>> cells = city.getCellList();

	    // Même cellule, donc le personnage peut toujours tirer
	    if (attackerX == targetX && attackerY == targetY) {
	        return true;
	    } else if (attackerY == targetY) {
	        int ahead = Math.max(attackerX, targetX); // celui qui est devant
	        if (ahead == attackerX) {
	            for (int x = attackerX; x > targetX; x--) {
	                Cell currentCell = cells.get(x).get(attackerY);
	                HashMap<Cardinal, Boolean> doorMap = currentCell.getDoorMap(); // la map de la cellule 
	                if (!doorMap.get(Cardinal.WEST) || doorMap.get(Cardinal.WEST) == null) { // on reg la direction qui faut 
	                    return false;
	                }
	            }
	            return true; // Toutes les portes sont ouvertes
	        } else { // si target devant
	            for (int x = attackerX; x < targetX; x++) {
	                Cell currentCell = cells.get(x).get(attackerY);
	                HashMap<Cardinal, Boolean> doorMap = currentCell.getDoorMap();
	                if (!doorMap.get(Cardinal.EAST) || doorMap.get(Cardinal.EAST) == null) {
	                    return false;
	                }
	            }
	            return true; // Toutes les portes sont ouvertes
	        }
	    } else if (attackerX == targetX) {
	        int above = Math.min(attackerY, targetY); // car de 0 à n de haut en bas
	        if (above == attackerY) { // attacker au dessus
	            for (int y = attackerY; y < targetY; y++) {
	                Cell currentCell = cells.get(attackerX).get(y);
	                HashMap<Cardinal, Boolean> doorMap = currentCell.getDoorMap();
	                if (!doorMap.get(Cardinal.SOUTH) || doorMap.get(Cardinal.SOUTH) == null) {
	                    return false;
	                }
	            }
	            return true; // Toutes les portes sont ouvertes
	        } else { // attacker en dessous
	            for (int y = attackerY; y > targetY; y--) {
	                Cell currentCell = cells.get(attackerX).get(y);
	                HashMap<Cardinal, Boolean> doorMap = currentCell.getDoorMap();
	                if (!doorMap.get(Cardinal.NORTH) || doorMap.get(Cardinal.NORTH) == null) {
	                    return false;
	                }
	            }
	            return true; // Toutes les portes sont ouvertes
	        }
	    }
	    return false; // si x et y différent alors False
	}

	/**
	 * Returns a string representation of the Attack action.
	 * 
	 * @return A string representation of the Attack action.
	 */
	public String toString() {
	    return "Attack";
	}



}
