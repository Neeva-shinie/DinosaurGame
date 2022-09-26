package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Actor {
	/**
	 * new instance
	 */
	Transaction.Points ecopoints = new Transaction.Points();
	/**
	 * Attribute
	 */
	private int targetpoints;
	/**
	 * Attribute
	 */
	private int turns;

	private Menu menu = new Menu();

	/**
	 * Constrductor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	public Player(String name, char displayChar, int hitpoints, int initpoints, int initturns) {
		super(name, displayChar, hitpoints);
		targetpoints = initpoints;
		turns = initturns;
	}

	/**
	 * Get interaction menu to perform action
	 * @param otherActor the Actor that might be performing attack
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return Action
	 */
	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new FeedingAction(otherActor, map));

	}

	/**
	 * The number of turns
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return turns
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		turns -= 1;
		int point = Integer.parseInt(ecopoints.displaypoints());
		if (turns == 0) {

			if (point == targetpoints || point >= targetpoints) {
				System.out.println("Player has won the challenge");
				System.out.println(ecopoints.displaypoints());
				map.removeActor(this);
			} else {
				System.out.println("Player lost the challenge");
				System.out.println(ecopoints.displaypoints());
				map.removeActor(this);
			}


		} else {
			// Handle multi-turn Actions
			if (lastAction.getNextAction() != null) {
				return lastAction.getNextAction();


			}



		}
		return menu.showMenu(this, actions, display);

	}
}


