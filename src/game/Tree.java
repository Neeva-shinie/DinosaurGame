package game;

import edu.monash.fit2099.engine.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implements tree growth
 * @see Ground
 */
public class Tree extends Ground implements Transaction {
//	Flying Flying;
	Transaction.Points ecopoints = new Transaction.Points();
	/**
	 * Attributes
	 */
	private int age = 0;

	/**
	 * Attributes
	 */
	private int temp = 0;
	/**
	 * Attributes
	 */
	private List<Fruit> fruits = new ArrayList<>();

	/**
	 * Constructor for tree
	 */
	public Tree() {
		super('+');
	}

	/**
	 * Implement tree growth and produce fruit
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);
		Random rand = new Random();
		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';
		//50% will produce fruit
		if ((Math.random()*2)<1){
			Fruit fruit =  new Fruit();
			fruits.add(fruit);
			ecopoints.addpoints(1);
		}//5% fruit will fall onto ground
		if(location.getItems().size()==0 && rand.nextBoolean() && fruits.size()>0 && (Math.random()*20)<1){
			location.addItem(fruits.get(0));
			ecopoints.addpoints(10);

		}
		if (location.getItems().size()>0){
			temp++;
		}//15 turns will rot
		if(temp==15){
			location.removeItem(fruits.remove(0));
		}



	}

	/**
	 * Able to make a menu and engage with user
	 * @param actor     the Actor acting
	 * @param location  the current Location
	 * @param direction the direction of the Ground from the Actor
	 * @return Actions
	 */

	@Override
	public Actions allowableActions(Actor actor, Location location, String direction) {
		ecopoints.addpoints(10);
		return new Actions(new PickUpItemAction(new Fruit()));
	}

	/**
	 * this method is override from Ground and used to check either the dinosaur could pass through the tree or not.
	 * @param actor the Actor to check
	 * @return true if the actor has the capability of flying.
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		if(actor.hasCapability(Flying.FLYING)){
			return super.canActorEnter(actor);
		}else{
			return super.canActorEnter(null);
		}


	}





}








