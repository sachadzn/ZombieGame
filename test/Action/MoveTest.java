package Action;

import org.junit.jupiter.api.Test;

import Actor.Actor;
import Actor.Player.Fighter;
import Actor.Zombie.Runner;
import Actor.Zombie.Zombie;
import City.Cardinal;
import City.City;
import City.TrainingCity;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MoveTest {

	@Test
	public void testMoveNorth() {
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 1);
		Move move = new Move(city);

		move.Do(actor, Cardinal.NORTH);

		assertEquals(2, actor.getX());
		assertEquals(0, actor.getY());
	}

	@Test
	public void testMoveSouth() {
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 1);
		Move move = new Move(city);

		move.Do(actor, Cardinal.SOUTH);

		assertEquals(2, actor.getX());
		assertEquals(2, actor.getY());
	}

	@Test
	public void testMoveEast() {
		City city = new TrainingCity();
		city.initCity();
		Actor actor =  new Fighter("Adil");
		city.placeActor(actor, 2, 2);
		Move move = new Move(city);

		move.Do(actor, Cardinal.EAST);

		assertEquals(3, actor.getX());
		assertEquals(2, actor.getY());
	}

	@Test
	public void testMoveWest() {
		City city = new TrainingCity();
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 2);
		Move move = new Move(city);

		move.Do(actor, Cardinal.WEST);

		assertEquals(1, actor.getX());
		assertEquals(2, actor.getY());
	}

	@Test
	public void testMoveNorthWithLockedDoor() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 1, 2);
		Move move = new Move(city);

		move.Do(actor, Cardinal.NORTH);

		assertEquals("Door locked in the north direction", outputStream.toString().trim());
		assertEquals(1, actor.getX());
		assertEquals(2, actor.getY());
	}

	@Test
	public void testMoveSouthWithLockedDoor() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 1, 2);
		Move move = new Move(city);

		move.Do(actor, Cardinal.SOUTH);

		assertEquals("Door locked in the south direction", outputStream.toString().trim());
		assertEquals(1, actor.getX());
		assertEquals(2, actor.getY());
	}

	@Test
	public void testMoveEastWithLockedDoor() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 3);
		Move move = new Move(city);

		move.Do(actor, Cardinal.EAST);

		assertEquals("Door locked in the east direction", outputStream.toString().trim());
		assertEquals(2, actor.getX());
		assertEquals(3, actor.getY());
	}

	@Test
	public void testMoveWestWithLockedDoor() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 3);
		Move move = new Move(city);

		move.Do(actor, Cardinal.WEST);

		assertEquals("Door locked in the west direction", outputStream.toString().trim());
		assertEquals(2, actor.getX());
		assertEquals(3, actor.getY());
	}
	@Test
	public void testMoveEastWithNullDoorMap() {
		City city = new City(5, 5);
		city.initCity();
		Actor actor = new Fighter("Adil");
		city.placeActor(actor, 2, 2);
		city.getCellList().get(2).get(2).setDoorMap(null); // Set the door map to null
		Move move = new Move(city);

		move.Do(actor, Cardinal.EAST);

		assertEquals(2, actor.getX());
		assertEquals(2, actor.getY()); // Should stay in the same position due to null door map
	}

	@Test
	public void testMoveToLoudestCell() {
		City city = new City(5, 5);
		city.initCity();
		city.getCellList().get(1).get(2).upSound(5); 
		city.getCellList().get(2).get(1).upSound(3); 
		city.getCellList().get(2).get(3).upSound(7); 
		city.getCellList().get(3).get(2).upSound(2); 

		Runner zombie = new Runner();
		city.placeActor(zombie, 2, 2);
		Move move = new Move(city);
		move.moveToLoudestCell(zombie);
	}
	@Test
	public void testMethodFail() {
		City city = new City(5,5);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Move move = new Move(city);
		move.Do();
		assertEquals("To move you must specify an Actor and a cardinal", outputStream.toString().trim());
	}
	@Test
	public void testFacingAwall() {
		City city = new City(5,5);
		city.initCity();
		Fighter ilyes = new Fighter("Ilyes");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		city.placeActor(ilyes, 0, 4);
		Move move = new Move(city);
		move.Do(ilyes,Cardinal.WEST);
		assertEquals("You are facing a wall", outputStream.toString().trim());
	}
	//Problème de DoorMap : aux extremités nord sud est west (ils ne sont pas à null).
	@Test
    public void testToString() {
    	TrainingCity Trainingcity = new TrainingCity();
        Trainingcity.initCity();
        Move move = new Move(Trainingcity);
        String result = move.toString();
        assertEquals("The toString method should return 'Move'", "Move", result);
    }


}
