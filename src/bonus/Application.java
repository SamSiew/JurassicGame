package bonus;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.World;
import game.*;

public class Application {

	/**
	 * @param args argument of main driver class
	 */
	public static void main(String[] args) {
		World world = new JurrasicWorld(new Display()); 

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
		newgameMap.at(7, 12).addActor(new Protoceratops("Protoceratops"));
		newgameMap.at(10, 12).addActor(new Protoceratops("Protoceratops"));
		newgameMap.at(10, 11).addActor(new Protoceratops("Protoceratops"));
		newgameMap.at(50, 6).addActor(new Pteranodon("Pteranodon"));
		
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
		newgameMap.at(8, 3).addActor(shop1);
		
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
		shop2.addItemToInventory(new RedPill("pill", '?', 1000));
		gameMap.at(8, 3).addActor(shop2);
		
		newgameMap.at(8, 4).addActor(new Criminal("c", 'm', 100, 2));
		
		Actor player = new Neo("Player", '@', 100,1000);
		
		world.addPlayer(player, newgameMap.at(45, 4));
		
		world.run();
	}
	
	
}
