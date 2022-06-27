package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;

/**
 * The main class for the dinosaur park game.
 *
 */
public class Application {

	/**
	 * @param args argument of main driver class
	 */
	public static void main(String[] args) {
		JurrasicWorld world = new JurrasicWorld(new Display()); 

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Grass(), new Water());

		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#_____#....................................................................",
		".....#_____#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		
		List<String> newmap = Arrays.asList(
		"................................................................................",
		"................................................................................",
		"............................................................wwwwwwwwwwww........",
		"....................................................wwwwwwwwwwwwwwwwwwwwww......",
		".............+.++++..+++++.........................wwwwwwwwwwwwwwwwwwwwwwww.....",
		"...............+++++++++.......................wwwwwwwwwwwwwwwwwwwwwwwwwwwww....",
		"..................+++........................wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww...",
		"..............++++++.............................wwwwwwwwwwwwwwwwwwwwwwww.......",
		"........................................................wwwwwwwwwww.............",
		"............................................................www.................",
		"..........................................................wwwwww................",
		"..................................................wwwwwwwwwwwwwwwww.............",
		".................................................wwwwwwwwwwwwwwwwwwwwwww........",
		".......................................wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.......",
		"......................................wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww.........",
		"....................++...................wwwwwwwwwwwwwwwwwwwwwwwwwww............",
		"...................++.........................wwwwwwwwwwwwwwwwwwww..............",
		".................+++...............................wwwwwwwwwwww.................",
		"................................................................................",
		"................................................................................",
		"................................................................................",
		"....................................................+...........................",
		"...................................................+++..........................",
		"....................................................+++.........................",
		"................................................................................");

		TropicalGameMap newgameMap = new TropicalGameMap(groundFactory, newmap);
		world.addGameMap(newgameMap);
		
		TropicalGameMap gameMap = new TropicalGameMap(groundFactory, map, newgameMap);
		world.addGameMap(gameMap);
		
		// Place a pair of protoceratops in the middle of the map
		gameMap.at(15, 3).addActor(new Protoceratops("Protoceratops"));
		gameMap.at(10, 9).addActor(new Protoceratops("Protoceratops"));
		gameMap.at(9, 9).addActor(new Protoceratops("Protoceratops"));
		
		newgameMap.at(15, 5).addActor(new Protoceratops("Protoceratops"));
		newgameMap.at(10, 9).addActor(new Protoceratops("Protoceratops"));
		newgameMap.at(9, 9).addActor(new Protoceratops("Protoceratops"));
	
		Shop shop1 =new Shop("Shop1",'s',100,1000);
		shop1.addItemToInventory(new  HerbivoreFood());
		shop1.addItemToInventory(new Egg("VelociraptorEgg",new Velociraptor("Velociraptor"),1000));
		shop1.addItemToInventory(new Egg("ProtoceratopEgg",new Protoceratops("Protoceratop"), 50));
		shop1.addItemToInventory(new CarnivoreFood());
		shop1.addItemToInventory(new Tag());
		shop1.addItemToInventory(new Egg("PlesiosaurEgg",new Plesiosaur("Plesiosaur"), 3000));
		shop1.addItemToInventory(new Egg("PteranodonEgg",new Pteranodon("Pteranodon"), 3000));
		shop1.addItemToInventory(new Egg("TyrannosaursRexEgg",new TyrannosaursRex("TyrannosaursRex"), 10000));
		shop1.addItemToInventory(new MarineAnimalFood());
		shop1.addItemToInventory(new Boat(100));
		gameMap.at(8, 3).addActor(shop1);
		
		Shop shop2 =new Shop("Shop2",'s',100,1000);
		shop2.addItemToInventory(new  HerbivoreFood());
		shop2.addItemToInventory(new Egg("VelociraptorEgg",new Velociraptor("Velociraptor"),1000));
		shop2.addItemToInventory(new Egg("ProtoceratopEgg",new Protoceratops("Protoceratop"), 50));
		shop2.addItemToInventory(new CarnivoreFood());
		shop2.addItemToInventory(new Tag());
		shop2.addItemToInventory(new Egg("PlesiosaurEgg",new Plesiosaur("Plesiosaur"), 3000));
		shop2.addItemToInventory(new Egg("PteranodonEgg",new Pteranodon("Pteranodon"), 3000));
		shop2.addItemToInventory(new Egg("TyrannosaursRexEgg",new TyrannosaursRex("TyrannosaursRex"), 10000));
		shop2.addItemToInventory(new MarineAnimalFood());
		shop2.addItemToInventory(new Boat(100));
		newgameMap.at(8, 3).addActor(shop2);
		
		Actor player = new Player("Player", '@', 100,10000);
		world.addPlayer(player, gameMap.at(8, 4));
		world.run();
	}
}
