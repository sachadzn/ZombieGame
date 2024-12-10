package Action;

import Actor.Actor;
import Actor.Zombie.Zombie;
import Cell.Cell;
import Cell.Room.Pharmacy;
import City.Cardinal;
import City.City;
import Equipment.Consumable.HealingVial;
import ListChooser.InteractiveListChooser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * The Move class represents an action to move an actor in a city.
 * It implements the Action interface.
 */
public class Move implements Action {
    private City city;

    /**
     * Constructor for the Move class.
     *
     * @param city The city in which the movement action will take place.
     */
    public Move(City city) {
        this.city = city;
    }

    /**
     * Perform the default move action.
     * Currently, this method prints a message indicating that an actor and a cardinal direction must be specified.
     */
    public void Do() {
        System.out.println("To move you must specify an Actor and a cardinal");
    }

    public void Do(Actor actor) {
		List<Cardinal> cardinal = new ArrayList<>(Arrays.asList(Cardinal.NORTH,Cardinal.SOUTH,Cardinal.EAST,Cardinal.WEST));
		InteractiveListChooser<Cardinal> cardinalChooser = new InteractiveListChooser<>();
		Cardinal chosenCardinal = cardinalChooser.choose("Which direction do you choose ?", cardinal);
		if (chosenCardinal!= null) {
			this.Do(actor,chosenCardinal);
		}else {
			System.out.println("Canceled...");
		}
    }
    /**
     * Perform the move action with specified actor and cardinal direction.
     *
     * @param actor The actor to move.
     * @param card  The cardinal direction in which to move the actor.
     */
    public void Do(Actor actor, Cardinal card) {
        int x = actor.getX();
        int y = actor.getY();
        int actionp =  actor.getActionpoints();
        Cell currentCell = city.getCellList().get(y).get(x);
        HashMap<Cardinal, Boolean> currentDoorMap = currentCell.getDoorMap();

        // Check if door map is null
        if (currentDoorMap == null) {
            System.out.println("No door map available in the current cell");
            return;
        }

        // Check if there's a wall in the specified direction
        if (currentCell.getDoorMap().get(card) == null) {
            System.out.println("You are facing a wall");
            return;
        }

        // Perform movement based on the cardinal direction
        switch (card) {
            case NORTH:
                if (currentDoorMap.containsKey(Cardinal.NORTH) && currentDoorMap.get(Cardinal.NORTH)) {
                    city.placeActor(actor, x, y - 1);
                    currentCell.removeActor(actor);
                    Cell newcell = city.getCellList().get(y-1).get(x);
                    if(newcell instanceof Pharmacy ) {
                    	newcell.addEquipment(new HealingVial());
                    }
                    actor.setActionpoints(actionp - 1);
                } else {
                    System.out.println("Door locked in the north direction");
                }
                break;
            case SOUTH:
                if (currentDoorMap.containsKey(Cardinal.SOUTH) && currentDoorMap.get(Cardinal.SOUTH)) {
                    city.placeActor(actor, x, y + 1);
                    currentCell.removeActor(actor);
                    Cell newcell = city.getCellList().get(y+1).get(x);
                    if(newcell instanceof Pharmacy ) {
                    	newcell.addEquipment(new HealingVial());
                    }
                    actor.setActionpoints(actionp - 1);
                } else {
                    System.out.println("Door locked in the south direction");
                }
                break;
            case EAST:
                if (currentDoorMap.containsKey(Cardinal.EAST) && currentDoorMap.get(Cardinal.EAST)) {
                    city.placeActor(actor, x + 1, y);
                    currentCell.removeActor(actor);
                    Cell newcell = city.getCellList().get(y).get(x+1);
                    if(newcell instanceof Pharmacy ) {
                    	newcell.addEquipment(new HealingVial());
                    }
                    actor.setActionpoints(actionp - 1);
                } else {
                    System.out.println("Door locked in the east direction");
                }
                break;
            case WEST:
                if (currentDoorMap.containsKey(Cardinal.WEST) && currentDoorMap.get(Cardinal.WEST)) {
                    city.placeActor(actor, x - 1, y);
                    currentCell.removeActor(actor);
                    Cell newcell = city.getCellList().get(y).get(x-1);
                    if(newcell instanceof Pharmacy ) {
                    	newcell.addEquipment(new HealingVial());
                    }
                    actor.setActionpoints(actionp - 1);
                } else {
                    System.out.println("Door locked in the west direction");
                }
                break;
        }
    }
    
    /**
     * Déplace le zombie vers la cellule adjacente avec le plus de bruit.
     *
     * @param zombie Le zombie à déplacer.
     */
    public void moveToLoudestCell(Zombie zombie) {
    	int currentX = zombie.getX();
        int currentY = zombie.getY();
        int actionp =  zombie.getActionpoints();
        Cell currentCell = city.getCellList().get(currentY).get(currentX);
        int loudestX = currentX;
        int loudestY = currentY;
        int loudestNoise = currentCell.getNoise();
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                int adjacentX = currentX + xOffset;
                int adjacentY = currentY + yOffset;
                if (isValidCoordinate(adjacentX, adjacentY)) {
                    Cell adjacentCell = city.getCellList().get(adjacentY).get(adjacentX);
                    if (adjacentCell.getNoise() > loudestNoise) {
                        loudestX = adjacentX;
                        loudestY = adjacentY;
                        loudestNoise = adjacentCell.getNoise();
                        zombieMove(zombie,getCloser(currentX,currentY,loudestX,loudestY));
                    } else {
                    	zombieRandomMove(zombie);
                    }
                }
            }
        }
        
    }
    
    private void zombieMove(Zombie zombie,Cardinal card) {
        int x = zombie.getX();
        int y = zombie.getY();
        int actionp =  zombie.getActionpoints();
        Cell currentCell = city.getCellList().get(y).get(x);
        HashMap<Cardinal, Boolean> currentDoorMap = currentCell.getDoorMap();

        if (currentDoorMap == null) {
            return;
        }

        if (currentCell.getDoorMap().get(card) == null) {
            return;
        }
        switch (card) {
            case NORTH:
                if (currentDoorMap.containsKey(Cardinal.NORTH) && currentDoorMap.get(Cardinal.NORTH)) {
                    city.placeActor(zombie, x, y - 1);
                    currentCell.removeActor(zombie);
                } 
                zombie.setActionpoints(actionp - 1);
                break;
            case SOUTH:
                if (currentDoorMap.containsKey(Cardinal.SOUTH) && currentDoorMap.get(Cardinal.SOUTH)) {
                    city.placeActor(zombie , x, y + 1);
                    currentCell.removeActor(zombie);
                }                 
                zombie.setActionpoints(actionp - 1);
                break;
            case EAST:
                if (currentDoorMap.containsKey(Cardinal.EAST) && currentDoorMap.get(Cardinal.EAST)) {
                    city.placeActor(zombie, x + 1, y);
                    currentCell.removeActor(zombie);
                } 
                zombie.setActionpoints(actionp - 1);
                break;
            case WEST:
                if (currentDoorMap.containsKey(Cardinal.WEST) && currentDoorMap.get(Cardinal.WEST)) {
                    city.placeActor(zombie, x - 1, y);
                    currentCell.removeActor(zombie);
                } 
                zombie.setActionpoints(actionp - 1);
                break;
        }
    }
    
    /**
     * Déplace le zombie de manière aléatoire vers une cellule adjacente.
     *
     * @param zombie Le zombie à déplacer.
     */
    public void zombieRandomMove(Zombie zombie) {
        Random random = new Random();
        int randomDirection = random.nextInt(4) + 1;

        Cardinal card = null;
        switch (randomDirection) {
            case 1:
                card = Cardinal.NORTH;
                break;
            case 2:
                card = Cardinal.WEST;
                break;
            case 3:
                card = Cardinal.EAST;
                break;
            case 4:
                card = Cardinal.SOUTH;
                break;
        }
        zombieMove(zombie, card);
    }

    	
    private Cardinal getCloser(int currentX, int currentY, int targetX, int targetY) {
        int dx = targetX - currentX;
        int dy = targetY - currentY;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                return Cardinal.EAST;
            } else if (dx < 0) { 
                return Cardinal.WEST;
            } else { 
                if (dy > 0) {
                    return Cardinal.SOUTH;
                } else if (dy < 0) {
                    return Cardinal.NORTH;
                } else {
                    return null; 
                }
            }
        } else { 
            if (dy > 0) {
                return Cardinal.SOUTH;
            } else if (dy < 0) { 
                return Cardinal.NORTH;
            } else { 
                if (dx > 0) {
                    return Cardinal.EAST;
                } else if (dx < 0) {
                    return Cardinal.WEST;
                } else {
                    return null; 
                }
            }
        }
    }
    
    

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < city.getWidth() && y >= 0 && y < city.getLength();
    }
    
	public String toString() {
		return "Move";
	}
}
