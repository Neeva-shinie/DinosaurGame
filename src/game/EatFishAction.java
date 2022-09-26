package game;

import edu.monash.fit2099.engine.*;
import game.Fish;

import java.util.Random;

/**
 * to allow pterodactyls to eat fish
 */
public class EatFishAction extends Action {
    /**
     * Attribute
     */
    private Location location;
    /**
     * Attribute
     */
    private Ground ground;
    /**
     * Attribute
     */

    Fish fish = new Fish();

    /**
     * Constructor
     * @param initGround type of ground
     */
    public EatFishAction(Ground initGround){
        ground = initGround;
    }

    /**
     * Allows actor to catch and eat fish
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        location = map.locationOf(actor);
        map.moveActor(actor,location);
        if(location.getItems() == fish){
            location.removeItem(fish);
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "catches fish";
    }
}
