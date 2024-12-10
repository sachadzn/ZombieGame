package City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import Cell.*;
import Cell.Room.*;
import Cell.Street.*;
import Equipment.Equipment;
import Equipment.Consumable.InfraredScop;
import Equipment.Consumable.Map;
import Equipment.Consumable.MasterKey;
import Equipment.Consumable.MedKit;
import Equipment.Weapon.Axe;
import Equipment.Weapon.Chainsaw;
import Equipment.Weapon.Crowbar;
import Equipment.Weapon.Pistol;
import Equipment.Weapon.Rifle;
import Actor.*;
import java.awt.Color;

public class City {
	protected int length;
	protected int width;
	protected ArrayList<ArrayList<Cell>> cellList;
	/**
     * Default constructor for the City class.
     * Initializes a city with default values for length, width, and an empty cell grid.
     */
	public City() {
		this.length = 5;
		this.width = 5;
		this.cellList = new ArrayList<>();
		this.nullCity();
	}
	/**
     * Parameterized constructor for the City class.
     *
     * @param length The length of the city grid.
     * @param width  The width of the city grid.
     */
	public City(int length, int width) {
		this.length = length;
		this.width = width;
		this.cellList = new ArrayList<>();
		this.nullCity();

	}
	/**
     * Get the length of the city grid.
     *
     * @return The length of the city grid.
     */
	public int getLength() {
		return length;
	}
	/**
     * Set the length of the city grid.
     *
     * @param length The new length of the city grid.
     */
	public void setLength(int length) {
		this.length = length;
	}
	/**
     * Get the width of the city grid.
     *
     * @return The width of the city grid.
     */
	public int getWidth() {
		return width;
	}
	/**
     * Set the width of the city grid.
     *
     * @param width The new width of the city grid.
     */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
     * Get the X-coordinate of the city grid center.
     *
     * @return The X-coordinate of the city grid center.
     */
	public int getCrossroadX() {
		return this.width/2;
	}
	/**
     * Get the Y-coordinate of the city grid center.
     *
     * @return The Y-coordinate of the city grid center.
     */
	public int getCrossroadY() {
		return this.length/2;
	}
	/**
     * Place an actor in the specified cell.
     *
     * @param actor The actor to be placed.
     * @param x     The X-coordinate of the cell.
     * @param y     The Y-coordinate of the cell.
     */
	public void placeActor(Actor actor,int x,int y) {
		this.cellList.get(y).get(x).addActor(actor);
		actor.setX(x);
		actor.setY(y);
	}
	/**
     * Get the cell grid of the city.
     *
     * @return The cell grid of the city.
     */
	public ArrayList<ArrayList<Cell>> getCellList() {
		return cellList;
	}
	/**
     * Set the cell grid of the city.
     *
     * @param cellList The new cell grid for the city.
     */
	public void setCellList(ArrayList<ArrayList<Cell>> cellList) {
		this.cellList = cellList;
	}
	/**
     * Randomly generate streets within a specified grid area.
     *
     * @param x0 Starting X-coordinate of the grid.
     * @param x  Ending X-coordinate of the grid.
     * @param y0 Starting Y-coordinate of the grid.
     * @param y  Ending Y-coordinate of the grid.
     */

	protected void randStreets(int x0, int x, int y0, int y) {

		Random random = new Random();

		if ((x - x0 + 1) >= 5 && (y - y0 + 1) >= 5) {
			double Dquarter = random.nextDouble();
			if ( Dquarter <= 0.75 ) {

				int Rdvert = random.nextInt(x - x0 - 3) + x0 + 2;
				int RdHori = random.nextInt(y - y0 - 3) + y0 + 2;
				if (Dquarter <= 0.25) {
					this.placeVerticalStreet(x0, x, y0, y, Rdvert);

					//LeftGrid
					this.randStreets(x0, Rdvert-1, y0, y);
					//RightGrid
					this.randStreets(Rdvert+1, x, y0, y);
				}
				else if ( Dquarter > 0.25 && Dquarter <= 0.50 ) {
					this.placeHorizontalStreet(x0, x, y0, y, RdHori);

					//TopGrid
					this.randStreets(x0, x, RdHori+1, y);
					//BottomGrid
					this.randStreets(x0,x,y0,RdHori-1);
				}
				else if ( Dquarter < 0.50 ) {
					this.placeHorizontalStreet(x0, x, y0, y, RdHori);
					this.placeVerticalStreet(x0, x, y0, y, Rdvert);

					//TopLeftGrid
					this.randStreets(x0, Rdvert-1, RdHori+1, y);
					//TopRightGrid
					this.randStreets(Rdvert+1, x, RdHori + 1, y);
					//BottomLeftGrid
					this.randStreets(x0, Rdvert - 1, y0, RdHori-1);
					//BottomRightGrid
					this.randStreets(Rdvert + 1, x, y0, RdHori-1);
				}
			}
		}

		else if ((x-x0+1)>=5) {
			double Dquarter = random.nextDouble();
			if (Dquarter <= 0.75) {
				int Rd = random.nextInt(x - x0 - 3) + x0 + 2;
				this.placeVerticalStreet(x0, x, y0, y, Rd);

				//LeftGrid
				this.randStreets(x0, Rd-1, y0, y);
				//RightGrid
				this.randStreets(Rd+1, x, y0, y);
			}
		}
		else if ((y-y0+1)>=5) {
			double Dquarter = random.nextDouble();
			if ( Dquarter <= 0.75 ) {
				int Rd = random.nextInt(y - y0 - 3) + y0 + 2;
				this.placeHorizontalStreet(x0, x, y0, y, Rd);

				//TopGrid
				this.randStreets(x0, x, Rd+1, y);
				//BottomGrid
				this.randStreets(x0,x,y0,Rd-1);
			}
		}
	}

	/**
     * Initialize the streets of the city.
     * Places main vertical and horizontal streets, manholes, and random streets.
     */
	protected void initStreets() {
		if (this.length>=5  && this.width>=5) {
		
		this.placeVerticalStreet(0, this.width-1, 0, this.length-1, this.width/2);
		this.placeHorizontalStreet(0, this.width-1, 0, this.length-1, this.length/2);
		this.placeManHole();
		//BottomLeftGrid
		this.randStreets(0,this.width/2-1,this.length/2+1,this.length-1);
		//BottomRightGrid
		this.randStreets(this.width/2+1, this.width-1, this.length/2+1, this.length-1);
		//TopLeftGrid
		this.randStreets(0, this.width/2-1, 0, this.length/2-1);
		//TopRightGrid
		this.randStreets(this.width/2+1, this.width-1, 0, this.length/2-1);
		this.intersectionDoorMap();
		}
	}
	/**
     * Initialize the rooms of the city.
     * Places a pharmacy, a continental room, and fills other cells with classical rooms.
     */
	protected void initRooms() {
		if (this.cellList == null) {
			return; 
		}

		Random random = new Random();

		int pharmacyX = random.nextInt(this.width);
		int pharmacyY = random.nextInt(this.length);
		while (this.cellList.get(pharmacyY).get(pharmacyX)!=null ) {
				pharmacyX = random.nextInt(this.width);
				pharmacyY = random.nextInt(this.length);
			}
		Pharmacy p= new Pharmacy();
		this.cellList.get(pharmacyY).set(pharmacyX, p);
		placeDoorForRoom(pharmacyX,pharmacyY,p);
		

	
		int continentalX = random.nextInt(this.width);
		int continentalY = random.nextInt(this.length);
		while (this.cellList.get(continentalY).get(continentalX)!=null) {
				continentalX = random.nextInt(this.width);
				continentalY = random.nextInt(this.length);
			}
		Continental c = new Continental();
		this.cellList.get(continentalY).set(continentalX, c);
		placeDoorForRoom(continentalX,continentalY,c);

		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.width; j++) {
			
				if (this.cellList.get(i).get(j) == null) {
				
					ClassicalRoom cr = new ClassicalRoom();
					placeDoorForRoom(j,i,cr);
					this.cellList.get(i).set(j,cr);
				}
			}
		}
	}
	/**
     * Method for creating a door map with specified door states.
     *
     * @param a The state of the door in the north direction.
     * @param b The state of the door in the south direction.
     * @param c The state of the door in the east direction.
     * @param d The state of the door in the west direction.
     * @return A door map with specified door states.
     */
	protected HashMap<Cardinal,Boolean> createDoorMap(Boolean a,Boolean b,Boolean c,Boolean d) {
		HashMap<Cardinal,Boolean> map= new HashMap<Cardinal,Boolean>();
		map.put(Cardinal.NORTH, a);
		map.put(Cardinal.SOUTH, b);
		map.put(Cardinal.EAST, c);
		map.put(Cardinal.WEST, d);
		return map;
	}
	/**
     * Place doors for a room based on its position in the city grid.
     *
     * @param x    The X-coordinate of the room.
     * @param y    The Y-coordinate of the room.
     * @param room The room for which doors are to be placed.
     */
	protected void placeDoorForRoom(int x,int y,Room room) {

		if (x==0) {
			if (y==0) {
				HashMap<Cardinal,Boolean> TopRightDoor = createDoorMap(null,false,false,null);
				room.setDoorMap(TopRightDoor);
				return;
			}
			else if (y==this.length-1) {
				HashMap<Cardinal,Boolean> BotRightDoor = createDoorMap(false,null,false,null);
				room.setDoorMap(BotRightDoor);
				return;
			}
			else {
				HashMap<Cardinal,Boolean> TopBotRightDoor = createDoorMap(false,false,false,null);
				room.setDoorMap(TopBotRightDoor);
				return;
			}
		}
		if (x==this.width-1) {
			if (y==0) {
				HashMap<Cardinal,Boolean> TopLeftDoor = createDoorMap(null,false,null,false);
				room.setDoorMap(TopLeftDoor);
				return;
			}
			else if (y==this.length-1) {
				HashMap<Cardinal,Boolean> BotLeftDoor = createDoorMap(false,null,null,false);
				room.setDoorMap(BotLeftDoor);
				return;
			}
			else {
				HashMap<Cardinal,Boolean> TopBotLeftDoor = createDoorMap(false,false,null,false);
				room.setDoorMap(TopBotLeftDoor);
				return;
			}
		}
		if (y==this.length-1) {
			HashMap<Cardinal,Boolean> BotRightLeftDoor = createDoorMap(false,null,false,false);
			room.setDoorMap(BotRightLeftDoor);
			return;
		}
		if (y==0) {
			HashMap<Cardinal,Boolean> TopRightLeftDoor = createDoorMap(null,false,false,false);
			room.setDoorMap(TopRightLeftDoor);
			return;
		}
		else {
			HashMap<Cardinal,Boolean> AllDoor = createDoorMap(false,false,false,false);
			room.setDoorMap(AllDoor);
			return;
		}
	}
	
	private void intersectionDoorMap() {
	    for (int i = 0; i < this.length; i++) {
	        for (int j = 0; j < this.width; j++) {
	            if (isIntersection(i, j)) {
	            	if (this.cellList.get(i).get(j) != null) {
	                this.cellList.get(i).get(j).setDoorMap(createDoorMap(true, true, true, true));
	            	}
	            }
	        }
	    }
	}

	private boolean isIntersection(int i, int j) {
	    if (i > 0 && i < this.length- 1 && j > 0 && j < this.width- 1) {
	        // Vérifie les cellules voisines
	        boolean northIsStreet = this.cellList.get(i - 1).get(j) instanceof Street;
	        boolean southIsStreet = this.cellList.get(i + 1).get(j) instanceof Street;
	        boolean eastIsStreet = this.cellList.get(i).get(j + 1) instanceof Street;
	        boolean westIsStreet = this.cellList.get(i).get(j - 1) instanceof Street;
	        // Si au moins deux cellules voisines sont des rues, alors c'est une intersection
	        return (northIsStreet ? 1 : 0) + (southIsStreet ? 1 : 0) + (eastIsStreet ? 1 : 0) + (westIsStreet ? 1 : 0) >= 2;
	    }
	    return false;
	}

	/**
     * Place a vertical street in the city grid.
     *
     * @param x0 The starting X-coordinate.
     * @param x  The ending X-coordinate.
     * @param y0 The starting Y-coordinate.
     * @param y  The ending Y-coordinate.
     * @param Rd The X-coordinate of the vertical street.
     */
	protected void placeVerticalStreet(int x0, int x, int y0, int y, int Rd) {
		for (int i = y0; i <= y; i++) {
			for (int j = x0; j <= x; j++) {
				if (j == Rd) {
					Street s = new Street();
					if (i==this.length-1) {
						HashMap<Cardinal,Boolean> SouthDoor= createDoorMap(true,null,false,false);
						s.setDoorMap(SouthDoor);
						this.cellList.get(i).set(j,s);
					}
					else if (i==0) {
						HashMap<Cardinal,Boolean> NorthDoor = createDoorMap(null,true,false,false);
						s.setDoorMap(NorthDoor);
						this.cellList.get(i).set(j,s);
					}
					else {
						HashMap<Cardinal,Boolean> NorthSouthDoor = createDoorMap(true,true,false,false);
						s.setDoorMap(NorthSouthDoor);
						this.cellList.get(i).set(j,s);
					}
				}
			}
		}
	}

	/**
     * Place a horizontal street in the city grid.
     *
     * @param x0 The starting X-coordinate.
     * @param x  The ending X-coordinate.
     * @param y0 The starting Y-coordinate.
     * @param y  The ending Y-coordinate.
     * @param Rd The Y-coordinate of the horizontal street.
     */
	protected void placeHorizontalStreet(int x0, int x, int y0, int y, int Rd) {

		for (int i = y0; i <= y; i++) {
			for (int j = x0; j <= x; j++) {
				if (i == Rd) {
					Street s = new Street();
					if (j==0) {
						HashMap<Cardinal,Boolean> EastDoor = createDoorMap(false,false,true,null);
						s.setDoorMap(EastDoor);
						this.cellList.get(i).set(j,s);
					}
					else if (j==this.width-1) {
						HashMap<Cardinal,Boolean> WestDoor = createDoorMap(false,false,null,true);
						s.setDoorMap(WestDoor);
						this.cellList.get(i).set(j,s);
					}
					else {
						HashMap<Cardinal,Boolean> EastWestDoor = createDoorMap(false,false,true,true);
						s.setDoorMap(EastWestDoor);
						this.cellList.get(i).set(j,s);
					}
				}
			}
		}
	}
	/**
     * Place manholes on the main streets at the extremities of the city grid.
     */
	protected void placeManHole() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.width; j++) {
				if (i == 0) {
					if (this.cellList.get(i).get(j) instanceof Street) {
						Manhole m = new Manhole();
						HashMap<Cardinal, Boolean> NorthDoor = createDoorMap(null, true, false, false);
						m.setDoorMap(NorthDoor);
						this.cellList.get(i).set(j, m);
					}
				}
				if (i == this.length - 1) {
					if (this.cellList.get(i).get(j) instanceof Street) {
						Manhole m = new Manhole();
						HashMap<Cardinal, Boolean> SouthDoor = createDoorMap(true, null, false, false);
						m.setDoorMap(SouthDoor);
						this.cellList.get(i).set(j, m);
					}
				} else {
					if (j ==  0) {
						if (this.cellList.get(i).get(j) instanceof Street) {
							Manhole m = new Manhole();
							HashMap<Cardinal, Boolean> EastDoor = createDoorMap(false, false, true, null);
							m.setDoorMap(EastDoor);
							this.cellList.get(i).set(j, m);
						}
					} if (j== this.width-1) {
						if (this.cellList.get(i).get(j) instanceof Street) {
							Manhole m = new Manhole();
							HashMap<Cardinal, Boolean> WestDoor = createDoorMap(false, false, null, true);
							m.setDoorMap(WestDoor);
							this.cellList.get(i).set(j, m);
						}
					}
				}
			}
		}
	}


	
 	protected void nullCity() {

		for (int i = 0; i < this.length; i++) {
			ArrayList<Cell> row = new ArrayList<>();
			for (int j = 0; j < this.width; j++) {
				row.add(null);
			}
			this.cellList.add(row);
		}
		return; 
	}
 	public void spawnEquip() {
 	    Random random = new Random();
 	    int spawnRate = random.nextInt(4);
 	    List<Equipment> equipList = new ArrayList<>();
 	    equipList.add(new InfraredScop());
 	    equipList.add(new Map());
 	    equipList.add(new MasterKey());
 	    equipList.add(new MedKit()); 
 	    equipList.add(new Axe()); 
 	    equipList.add(new Chainsaw());
 	    equipList.add(new Crowbar());
 	    equipList.add(new Pistol());
 	    equipList.add(new Rifle());
 	    if (spawnRate <= 3) {
 	        for (ArrayList<Cell> row : cellList) {
 	            for (Cell cell : row) {
 	                if ((cell instanceof ClassicalRoom || cell instanceof Continental)) {
 	                    int numEquip = random.nextInt(4);
 	                    for (int i = 0; i < numEquip; i++) {
 	                        Equipment equipment = equipList.get(random.nextInt(equipList.size()));
 	                        cell.addEquipment(equipment);
 	                    }
 	                }
 	            }
 	        }
 	    }
 	}



 	public void displayCity() {
 	    for (int i = 0; i < this.length; i++) {
 	        for (int j = 0; j < this.width; j++) {
 	                System.out.print("\u001B[36m+---------\u001B[0m");
 	        }
 	        System.out.println("\u001B[36m+\u001B[0m");

 	        for (int j = 0; j < this.width; j++) {
 	            Cell cell = this.cellList.get(i).get(j);
 	                Color cellColor = cell.getColor();
 	                String cellColorCode = getColorCode(cellColor);
 	                System.out.print("\u001B[36m|\u001B[0m " + cellColorCode + cell.countZombie() +" "+ cell.toString() +" "+ cell.countPlayers() + " "+ "\u001B[0m" );
 	            }
 	        System.out.println("\u001B[36m|\u001B[0m");
 	    }
 	    for (int j = 0; j < this.width; j++) {
 	        System.out.print("\u001B[36m+---------\u001B[0m");
 	    }
 	    System.out.println("\u001B[36m+\u001B[0m");
 	}

 	private String getColorCode(Color color) {
 	    if (color.equals(Color.RED)) {
 	        return "\u001B[31m"; 
 	    } else if (color.equals(Color.GREEN)) {
 	        return "\u001B[32m"; 
 	    } else if (color.equals(Color.BLUE)) {
 	        return "\u001B[34m"; 
 	    } else if (color.equals(Color.CYAN)) {
 	    	return "\u001B[34m";
 	    } else if (color.equals(Color.YELLOW)) {
 	        return "\u001B[33m"; 
 	    } else if (color.equals(Color.BLACK)) {
 	        return "\u001B[30m"; 
 	    } else if (color.equals(Color.DARK_GRAY)) {
 	        return "\u001B[37m"; 
 	    } else if (color.equals(Color.GRAY)) {
 	        return "\u001B[90m"; 
 	    } else {
 	        return ""; 
 	    }
 	}



	/**
     * Initialize the city grid with streets and rooms.
     */
	public void initCity() {
		this.initStreets();
		this.initRooms();
		this.spawnEquip();
	}

}
