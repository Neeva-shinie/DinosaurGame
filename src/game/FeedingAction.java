package game;

import edu.monash.fit2099.engine.*;

/**
 * To make player feed dinosaur
 * @see Action
 */
public class FeedingAction extends Action implements Transaction {
    /**
     * new instance
     */

    Actor player = new Player("Player",'@',100);
    /**
     * Attribute
     */
    private Action action;
    /** new instance
     *
     */
    Transaction.Points ecopoints = new Transaction.Points();

    /**
     * Constructor
     * @param actor
     * @param map
     */
    public FeedingAction(Actor actor, GameMap map){

    }
    /**
     * Execute action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return string meesage
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        Dinosaur otherActor = new Dinosaur("Dinosaur", '-',0,0,0,0);

        FoodSource food = new FoodSource("Food",'-');
        if(actor == player ){
            if(map.contains(otherActor)){
                    for(FoodSource elem: food.storeCarnivoreFood()){
                        if(actor.getInventory().contains(elem)){
                            if(elem.getCarnivoreFood().equals(new VegetarianMealKit()) || elem.getCarnivoreFood().equals(new CarnivoreMealKit())) {
                                actor.removeItemFromInventory(elem);
                                action =  new DropItemAction(elem);
                                otherActor.heal(otherActor.getMaxhitpoint());
                                location.removeItem(elem);
                            }


                        }
                    }for (FoodSource elem1 : food.storeFoodSource()){
                        if (actor.getInventory().contains(elem1)){
                            if (elem1.getFood().equals(new Fruit())){
                                actor.removeItemFromInventory(elem1);
                                ecopoints.addpoints(10);
                                otherActor.heal(20);
                                location.removeItem(elem1);
                            }
                        }
                }




            }

        }
        return menuDescription(actor);

    }

    /**
     * Message to UI
     * @param actor The actor performing the action.
     * @return message
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + "feeds dinosaur" ;
    }




}
