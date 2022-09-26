package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Bush class which is display as '^' in gameMap
 * @see Dirt
 */
public class Bush extends Dirt {
    /**
     * new instance
     */
    Transaction.Points Ecopoints = new Transaction.Points();

    /**
     * constructor
     */
    public Bush() {
        displayChar= '^';
    }

    /**
     * Attribute
     */
    Random rand = new Random();
    /**
     * number of turns
     */
    private int temp = 0;
    /**
     * list of Fruit instance
     */
    private List<Fruit> fruits = new ArrayList<>();

    /**
     * allow user to communication UI
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Ecopoints.addpoints(10);
        return new Actions(new PickUpItemAction(new Fruit()));
    }

    /**
     * checking entrance
     * @param actor the Actor to check
     * @return boolean
     */


    /**
     * this override method from Ground class is used to produce fruit
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
       if ((Math.random()*10)<1){
           Fruit fruit =  new Fruit();
           fruits.add(fruit);
       }
       if(location.getItems().size()==0 && rand.nextBoolean() && fruits.size()>0){
           location.addItem(fruits.get(0));
           Ecopoints.addpoints(10);

       }
       if (location.getItems().size()>0){
            temp++;
        }
       if(temp==15){
           location.removeItem(fruits.remove(0));
        }



        }

    /**
     * This override method from Ground class is used to check the actor can pass through the Bush or not
     * @param actor the Actor to check
     * @return true if the actor has the capability of flying
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(game.Flying.FLYING)){
            return super.canActorEnter(actor);
        }else{
            return super.canActorEnter(null);
        }


    }
    }




