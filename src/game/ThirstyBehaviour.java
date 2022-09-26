package game;

import edu.monash.fit2099.engine.*;


/**
 * This class is to let the thirsty dinosaur walk towards to the lake and override getAction method from Behaviour interface.
 * @see Behaviour
 */
public class ThirstyBehaviour implements Behaviour{


    /**
     * return MoveActorAction next to a lake if the dinosaur is thirsty
     * if dinosaur is not thirsty, returns null.
     * @param actor the Actor acting for dinosaur only
     * @param map the GameMap containing the Actor
     * @return an Action, or null if dinosaur is not thirsty.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        Dinosaur dinosaur =  (Dinosaur)location.getActor();
        if (dinosaur.getWaterPts()<= 40) {
            System.out.println(dinosaur.getName()+"at (" + location.x()+","+ location.y()+") is getting thirsty!");
            return new MoveActorAction(map.at(50,9),"Towards");
        }
        return null;
    }
}
