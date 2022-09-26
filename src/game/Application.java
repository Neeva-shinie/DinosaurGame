package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.*;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	/**
	 * Select gamemode
	 * @return int
	 */
	public static int selectGameMode(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Jurrasic Park!!");
		System.out.println("Choose your mode");
		System.out.println("--------------------");
		System.out.println("1) Challenge mode");
		System.out.println("2) Sandbox mode");
		System.out.println("3) Exit");
		int choice = scanner.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		/**
		 * new instance
		 */
		Scanner input = new Scanner(System.in);
		/**
		 * Add system to run the chosen application mode
		 */
		int selection = selectGameMode();
		do{
			switch (selection){
				case 1:
					System.out.println("Choose your ecopoint limit");
					int targetpoint = input.nextInt();
					System.out.println("Choose turn limit");
					int turnLimit = input.nextInt();


					World world = new World(new Display());
					FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Bush(),new VendingMachine());

					List<String> map = Arrays.asList(
							"................................................................................",
							"................................................................................",
							".....#######....................................................................",
							".....#V____#....................................................................",
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
					GameMap gameMap = new GameMap(groundFactory, map);
					world.addGameMap(gameMap);

					List<String> map1 = Arrays.asList(
							"................................................................................",
							"................................................................................",
							".....#######....................................................................",
							".....#V____#....................................................................",
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
					GameMap gameMap1 = new GameMap(groundFactory,map1);
					world.addGameMap(gameMap1);


					Actor player = new Player("Player", '@', 100,targetpoint,turnLimit);
					world.addPlayer(player, gameMap.at(9, 4));
					Door door = new Door("Door",'/',false);
					Door door1 = new Door("Door",'/',false);
					door.addAction(new MoveActorAction(gameMap1.at(60,24),"to new world" ));
					door.addAction(new MoveActorAction(gameMap.at(14,0),"back to old world"));
					gameMap.at(13,0).addItem(door);
					gameMap1.at(61,24).addItem(door1);


					gameMap.at(50,10).setGround(new Lakes());
					gameMap.at(50,5).setGround(new Lakes());
					gameMap.at(50,15).setGround(new Lakes());
					gameMap1.at(50,10).setGround(new Lakes());
					gameMap1.at(50,5).setGround(new Lakes());
					gameMap1.at(50,15).setGround(new Lakes());

					gameMap1.at(50,10).setGround(new Lakes());
					gameMap1.at(50,5).setGround(new Lakes());
					gameMap1.at(50,15).setGround(new Lakes());


					// Place a pair of stegosaurs in the middle of the map
					gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(32, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(30, 13).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(31, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(33, 12).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(34, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(30, 14).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(32, 15).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(30, 16).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(31, 10).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(33, 11).addActor(new Stegosaur("Stegosaur"));
					gameMap.at(34, 10).addActor(new Stegosaur("Female Stegosaur"));
					gameMap.at(8, 6).addActor(new Stegosaur("Female Stegosaur"));


					//Place 2 male 2 female brachiosaur
					gameMap.at(52, 23).addActor(new Brachiosaur("Brachiosaur"));
					gameMap.at(53, 23).addActor(new Brachiosaur("Brachiosaur"));
					gameMap.at(48, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap.at(49, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap.at(47, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap.at(54, 22).addActor(new Brachiosaur("Brachiosaur"));

//		//Allosaur
					gameMap.at(33, 17).addActor(new Allosaur("Allosaur"));
					gameMap.at(33, 18).addActor(new Allosaur("Allosaur"));
					gameMap.at(36, 17).addActor(new Allosaur("Female Allosaur"));
					gameMap.at(34, 18).addActor(new Allosaur("Female Allosaur"));
					gameMap.at(31, 17).addActor(new Allosaur("Allosaur"));
					gameMap.at(32, 18).addActor(new Allosaur("Allosaur"));
					gameMap.at(35, 17).addActor(new Allosaur("Female Allosaur"));
					gameMap.at(37, 18).addActor(new Allosaur("Female Allosaur"));
					gameMap.at(31, 19).addActor(new Allosaur("Allosaur"));
					gameMap.at(32, 20).addActor(new Allosaur("Allosaur"));
					gameMap.at(35, 15).addActor(new Allosaur("Female Allosaur"));
					gameMap.at(37, 16).addActor(new Allosaur("Female Allosaur"));

					//Ptelodactyl
					gameMap.at(11,12).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(12,12).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(13,13).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(14,13).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(15,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(16,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(17,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(18,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(19,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(20,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(21,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(40,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(41,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(43,9).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(46,8).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(50,7).addActor(new Pterodactyls("Pterodactyls"));
					gameMap.at(47,10).addActor(new Pterodactyls("Pterodactyls"));


					world.run();

				case 2:
					World world1 = new World(new Display());
					FancyGroundFactory groundFactory1 = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(), new Bush(),new VendingMachine());

					List<String> map2 = Arrays.asList(
							"................................................................................",
							"................................................................................",
							".....#######....................................................................",
							".....#V____#....................................................................",
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
					GameMap gameMap2 = new GameMap(groundFactory1, map2);
					world1.addGameMap(gameMap2);

					List<String> map3 = Arrays.asList(
							"................................................................................",
							"................................................................................",
							".....#######....................................................................",
							".....#V____#....................................................................",
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
					GameMap gameMap3 = new GameMap(groundFactory1,map3);
					world1.addGameMap(gameMap3);


					Actor player1 = new Player("Player", '@', 100);
					world1.addPlayer(player1, gameMap2.at(9, 4));
					Door door2 = new Door("Door",'/',false);
					Door door3 = new Door("Door",'/',false);
					door2.addAction(new MoveActorAction(gameMap3.at(60,24),"to new world" ));
					door3.addAction(new MoveActorAction(gameMap2.at(14,0),"back to old world" ));
					gameMap2.at(13,0).addItem(door2);
					gameMap3.at(61,24).addItem(door3);


					gameMap2.at(50,10).setGround(new Lakes());
					gameMap2.at(50,5).setGround(new Lakes());
					gameMap2.at(50,15).setGround(new Lakes());
					gameMap3.at(50,10).setGround(new Lakes());
					gameMap3.at(50,5).setGround(new Lakes());
					gameMap3.at(50,15).setGround(new Lakes());

					gameMap3.at(50,10).setGround(new Lakes());
					gameMap3.at(50,5).setGround(new Lakes());
					gameMap3.at(50,15).setGround(new Lakes());


					// Place a pair of stegosaurs in the middle of the map
					gameMap2.at(30, 12).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(32, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(30, 13).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(31, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(33, 12).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(34, 12).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(30, 14).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(32, 15).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(30, 16).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(31, 10).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(33, 11).addActor(new Stegosaur("Stegosaur"));
					gameMap2.at(34, 10).addActor(new Stegosaur("Female Stegosaur"));
					gameMap2.at(8, 6).addActor(new Stegosaur("Female Stegosaur"));


					//Place 2 male 2 female brachiosaur
					gameMap2.at(52, 23).addActor(new Brachiosaur("Brachiosaur"));
					gameMap2.at(53, 23).addActor(new Brachiosaur("Brachiosaur"));
					gameMap2.at(48, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap2.at(49, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap2.at(47, 24).addActor(new Brachiosaur("Female Brachiosaur"));
					gameMap2.at(54, 22).addActor(new Brachiosaur("Brachiosaur"));

//		//Allosaur
					gameMap2.at(33, 17).addActor(new Allosaur("Allosaur"));
					gameMap2.at(33, 18).addActor(new Allosaur("Allosaur"));
					gameMap2.at(36, 17).addActor(new Allosaur("Female Allosaur"));
					gameMap2.at(34, 18).addActor(new Allosaur("Female Allosaur"));
					gameMap2.at(31, 17).addActor(new Allosaur("Allosaur"));
					gameMap2.at(32, 18).addActor(new Allosaur("Allosaur"));
					gameMap2.at(35, 17).addActor(new Allosaur("Female Allosaur"));
					gameMap2.at(37, 18).addActor(new Allosaur("Female Allosaur"));
					gameMap2.at(31, 19).addActor(new Allosaur("Allosaur"));
					gameMap2.at(32, 20).addActor(new Allosaur("Allosaur"));
					gameMap2.at(35, 15).addActor(new Allosaur("Female Allosaur"));
					gameMap2.at(37, 16).addActor(new Allosaur("Female Allosaur"));

					//Ptelodactyl
					gameMap2.at(11,12).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(12,12).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(13,13).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(14,13).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(15,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(16,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(17,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(18,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(19,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(20,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(21,16).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(40,14).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(41,15).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(43,9).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(46,8).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(50,7).addActor(new Pterodactyls("Pterodactyls"));
					gameMap2.at(47,10).addActor(new Pterodactyls("Pterodactyls"));


					world1.run();





			}
		}while(selection!=3);{
			System.out.println("Thank you for playing this game");

		}




	}
}
