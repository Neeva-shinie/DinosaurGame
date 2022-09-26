package game;

import edu.monash.fit2099.engine.*;

/**
 * Breed behaviour
 */
public class BreedBehaviour implements Behaviour{
    /**
     * Attribute
     */
    private Behaviour behaviour;
    /**
     * Attribute
     */
    private Location location;
    /**
     * Attribute
     */
    private Actions action;

    /**
     * get action
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return action
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        int turns= 0;
        behaviour = new WanderBehaviour();
        if(location.getItems() != null ){
            location.addActor(actor);
        }if(location.containsAnActor()){
            if(location.getActor() == actor && actor.getDisplayChar()=='S'){
                action.add(new MoveActorAction(location,"Towards"));
               if(turns==10){
                   location.addItem(new StegosaurEgg());
               }
            }
                else if(location.getActor() == actor &&  actor.getDisplayChar()=='B'){
                action.add(new MoveActorAction(location,"Towards"));
                    if(turns==30){
                        location.addItem(new BrachiosaurEgg());
                    }
                }

            else if(location.getActor() == actor &&  actor.getDisplayChar()=='A'){
                action.add(new MoveActorAction(location,"Towards"));
                if(turns==20){
                    location.addItem(new AllosaurEgg());
                }
            }return action.get(action.size()-1);

        }
        return null;}





}
