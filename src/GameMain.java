import Actor.Player.Fighter;
import Actor.Player.Healer;
import Actor.Player.Lucky;
import Actor.Player.Nosy;
import Actor.Zombie.Walker;
import City.City;
import Equipment.Consumable.HealingVial;
import Equipment.Weapon.Pistol;

public class GameMain {
	public static void main(String[] args) {
		if (args.length == 3) {
			City city = new City(Integer.parseInt(args[0]),Integer.parseInt(args[1])); 
			city.initCity();
			
			int cX = city.getCrossroadX();
			int cY = city.getCrossroadY();
			
			
			Fighter Ilyes = new Fighter("Ilyes");
			Lucky Sacha = new Lucky("Sacha");
			Nosy Adil = new Nosy("Adil");
			Healer Samuel = new Healer("Samuel");
			// Les survivants sont regroupés sur une même zone d’une rue 
			int numPlayers = Integer.parseInt(args[2]);
            if (numPlayers < 2) {
                System.out.println("We need at least 2 players!");
                return;
            }
            switch (numPlayers) {
            case 2:
                city.placeActor(Ilyes, cX, cY);
                city.placeActor(Samuel, cX, cY);
                break;
            case 3:
                city.placeActor(Ilyes, cX, cY);
                city.placeActor(Samuel, cX, cY);
                city.placeActor(Sacha, cX, cY);
                break;
            case 4:
                city.placeActor(Ilyes, cX, cY);
                city.placeActor(Samuel, cX, cY);
                city.placeActor(Sacha, cX, cY);
                city.placeActor(Adil, cX, cY);
                break;
            default:
                System.out.println("Too much players to be supported!");
                return;
            }

			//pistolet en main pour tous
			Pistol pistol1 = new Pistol();
			Adil.setHand(pistol1);

			Pistol pistol2 = new Pistol();
			Sacha.setHand(pistol2);

			Pistol pistol3 = new Pistol();
			Ilyes.setHand(pistol3);

			Pistol pistol4 = new Pistol();
			Samuel.setHand(pistol4);
			
			Game game = new Game(city);
			
			game.Play();
		} else {
			System.out.println("You need to specify 3 arguments to launch the main!");

		}
		
		}

}
