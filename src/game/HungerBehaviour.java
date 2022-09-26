package game;

import edu.monash.fit2099.engine.*;

/**
 * To implement hunger behaviour
 * @see Behaviour,EatingAction,FeedingAction
 */
public class  HungerBehaviour implements Behaviour {
    private Behaviour behaviour;
    Actor player =  new Player("Player", '@',100);
    private Action action;

    /**
     * retrieve action to conduct
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        behaviour = new WanderBehaviour();
        if (map.locationOf(actor).getItems() != null) {
            return new EatingAction();
        } else if (map.isAnActorAt(location)) {
            if (location.getActor() != actor ) {
                return new EatingAction();
            }

        } else if (location.containsAnActor()) {
            if (location.getActor() == player) {
                return new FeedingAction(actor, map);
            }
        }
        return new EatingAction();
    }
}






