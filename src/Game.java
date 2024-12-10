import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Action.*;
import Actor.Zombie.*;
import Actor.Actor;
import Actor.Player.*;
import ListChooser.InteractiveListChooser;
import ListChooser.RandomListChooser;
import City.City;
import Cell.Cell;
import Cell.Street.Manhole;

/**
 * The main class representing the game.
 */
public class Game {
    
    protected City city;
    
    /**
     * Constructor for the Game class.
     *
     * @param city The city where the game takes place.
     */
    public Game(City city) {
        this.city = city;
    }
    
    /**
     * Method to start playing the game.
     */
    public void Play() {
        do {
            this.city.displayCity();
            this.makeActorsPlay();
            this.resetNoise();
            this.resetActionPoints();
            this.zombieSpawn();
        } while (!this.isGameOver());
        MessageGameOver();
    }

    
    /**
     * Method to spawn zombies in the city.
     */
    public void zombieSpawn() {
        int countLevel = 0;
        int countPlayer = 0;
        int countManhole = 0;
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                if (this.city.getCellList().get(y).get(x) instanceof Manhole) {
                    countManhole += 1;
                }
                List<Actor> Actors = this.city.getCellList().get(y).get(x).getAllActors();
                for (Actor actor : Actors) {
                    if (actor instanceof Player) {
                        countLevel += ((Player) actor).getLevel();
                        countPlayer += 1;
                    }
                }
            }
        }
        if (countPlayer != 0){
        int averageXp = countLevel / countPlayer;
        int spawn = (int) Math.ceil((double) averageXp / 3);
        int zombiePerManhole = spawn / countManhole;
        int reste = spawn % countManhole;
        
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                if (this.city.getCellList().get(y).get(x) instanceof Manhole) {
                    for (int i = 0; i < zombiePerManhole; i++) {
                        this.city.placeActor(randomZombie(), x, y);
                    }
                    if (reste > 0) {
                        this.city.placeActor(randomZombie(),x,y);
                    }
                }
            }
        }
        }
    }
    
    /**
     * Method to generate a random zombie.
     *
     * @return A randomly selected zombie.
     */
    public static Zombie randomZombie() {
        Random random = new Random();
        double randomNumber = random.nextDouble(); // Random number between 0 and 1
        
        // Definition of appearance rates for each type of zombie
        double abominationRate = 0.05;  // 5%
        double fattyRate = 0.1;         // 10%
        double runnerRate = 0.3;        // 30%
        double walkerRate = 0.55;       // 55%
        
        // Calculation of cumulative probability
        double probCumulAbomination = abominationRate;
        double probCumulFatty = probCumulAbomination + fattyRate;
        double probCumulRunner = probCumulFatty + runnerRate;
        
        // Choice of zombie type based on the generated random number
        if (randomNumber < probCumulAbomination) {
            return new Abomination();
        } else if (randomNumber < probCumulFatty) {
            return new Fatty();
        } else if (randomNumber < probCumulRunner) {
            return new Runner();
        } else {
            return new Walker();
        }
    }

   



    /**
     * Method to reset the noise level in all cells of the city.
     */
    public void resetNoise() {
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                this.city.getCellList().get(y).get(x).setNoise(0);
            }
        }
    }

    /**
     * Method to make all actors play their actions.
     */
    public void makeActorsPlay() {
    	int actionfree = 1;
List<Action> actionList = new ArrayList<>();
        actionList.add(new Use(this.city));
        actionList.add(new Search(this.city));
        actionList.add(new OpenDoor(this.city));
        actionList.add(new Move(this.city)); 
        actionList.add(new LookAround(this.city)); 
        actionList.add(new Heal(city));
        actionList.add(new Equip());
        actionList.add(new Attack(this.city)); 
        actionList.add(new SkipTurn());
        InteractiveListChooser<Action> actorchooser = new InteractiveListChooser<>();
        List<Actor> allActors = new ArrayList<>();
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                allActors.addAll(this.city.getCellList().get(y).get(x).getAllActors());
            }
        }
        List<Player> players = new ArrayList<>();
        List<Zombie> zombies = new ArrayList<>();
        for (Actor actor : allActors) {
            if (actor instanceof Player) {
                players.add((Player) actor);
            } else if (actor instanceof Zombie) {
                zombies.add((Zombie) actor);
            }
        }
        for (Player player : players) {
            int remainingActions = player.getActionpoints();
            while (remainingActions > 0) {
                Action actions = actorchooser.choose(player.getName()+" , which action you want to do?",actionList);
                if (actions instanceof Use) {
                    Use use = new Use(this.city);
                    use.Do(player);
                } else if (actions instanceof Search) {
                	if(player instanceof Nosy && actionfree == 1) {
                		int actionp = player.getActionpoints();
                		player.setActionpoints(actionp+1);
                		actionfree = 0;
                	}
                    Search search = new Search(this.city);
                    search.Do(player);
                } else if (actions instanceof OpenDoor) {
                    OpenDoor openDoor = new OpenDoor(this.city);
                    openDoor.Do(player);
                } else if (actions instanceof Move) {
                    Move move = new Move(this.city);
                    move.Do(player);
                    this.city.displayCity();
                } else if (actions instanceof LookAround) {
                    LookAround lookAround = new LookAround(this.city);
                    lookAround.Do(player);
                } else if (player instanceof Healer && actions instanceof Heal) {
                        Healer healer = (Healer) player;
                        Heal heal = new Heal(city);
                        heal.Do(healer);
                } 
                else if (!(player instanceof Healer) && actions instanceof Heal) {
                	System.out.println("You must be a Healer!");
                }
                else if (actions instanceof Equip) {
                    Equip equip = new Equip();
                    equip.Do(player);
                } else if (actions instanceof Attack) {
                    Attack attack = new Attack(this.city);
                    attack.Do(player);
                } else if (actions instanceof SkipTurn) {
                    SkipTurn skipTurn = new SkipTurn();
                    skipTurn.Do();
                    player.setActionpoints(0);
                }
                remainingActions = player.getActionpoints();
            }
        }
        
        List<Actor> allActors2 = new ArrayList<>();
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                allActors2.addAll(this.city.getCellList().get(y).get(x).getAllActors());
            }
        }
        List<Player> players2 = new ArrayList<>();
        List<Zombie> zombies2 = new ArrayList<>();
        for (Actor actor : allActors2) {
            if (actor instanceof Player) {
                players2.add((Player) actor);
            } else if (actor instanceof Zombie) {
                zombies2.add((Zombie) actor);
            }
        }
        for (Zombie zombie : zombies2) {
            int remainingActions = zombie.getActionpoints();
            while (remainingActions > 0) {
                Cell currentCell = this.city.getCellList().get(zombie.getY()).get(zombie.getX());
                List<Actor> actors = currentCell.getAllActors();
                List<Player> targetedPlayers = new ArrayList<Player>();
                for (Actor actor : actors) {
                	if (actor instanceof Player) {
                		targetedPlayers.add((Player) actor);
                	}
                }
                if (targetedPlayers.isEmpty() ) {
                    Move move = new Move(this.city);
                    move.moveToLoudestCell(zombie);
                } else {
                    Attack attack = new Attack(this.city);
                    attack.Do(zombie);
                }
                remainingActions--;
            }
        }
    
    }
    
    

    
    
    /**
     * Method to check if the game has ended.
     *
     * @return True if the game has ended, false otherwise.
     */
    public boolean isGameOver() {
        int zombieCount = 0;
        int playerCount = 0;
        int totalSurvivorLevel = 0;
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                for (Actor actor : this.city.getCellList().get(y).get(x).getAllActors()) {
                    if (actor instanceof Zombie) {
                        zombieCount++;
                    } else if (actor instanceof Player) {
                        totalSurvivorLevel += ((Player) actor).getLevel();
                        playerCount++;
                    }
                }
            }
        }
        return zombieCount == 0 || totalSurvivorLevel >= 30 || playerCount == 0;
    }
    
    /**
     * Method to display the game over message.
     *
     * @return The game over message.
     */
    public void MessageGameOver() {
        int playerCount = 0;
        int totalSurvivorLevel = 0;
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                for (Actor actor : this.city.getCellList().get(y).get(x).getAllActors()) {
                    if (actor instanceof Player) {
                        totalSurvivorLevel += ((Player) actor).getLevel();
                        playerCount++;
                    }
                }
            }
        }
        if (playerCount == 0) {
            System.out.println("All survivors are dead. You have lost...");
        } else if (totalSurvivorLevel >= 30) {
            System.out.println("All players are level 30 or higher. You have won!");
        } else {
            System.out.println("All zombies are dead. You have won!");
        } 
    }

    /**
     * Method to reset the action points of all actors in the city.
     */
    public void resetActionPoints() {
        for (int y = 0; y < this.city.getLength(); y++) {
            for (int x = 0; x < this.city.getWidth(); x++) {
                for (Actor actor : this.city.getCellList().get(y).get(x).getAllActors()) {
                    if (actor instanceof Zombie) {
                        if (actor instanceof Runner) {
                            actor.setActionpoints(2);
                        } else {
                            actor.setActionpoints(1);
                        }
                    } else if (actor instanceof Player) {
                        int extraPoints = 0;
                        if (((Player) actor).getLevel() > 11) {
                            extraPoints += 3;
                        } else if (((Player) actor).getLevel() > 7) {
                            extraPoints += 2;
                        } else if (((Player) actor).getLevel() > 3) { 
                            extraPoints += 1;
                        }
                        actor.setActionpoints(3 + extraPoints);
                    }
                }
            }
        }
    }
}
