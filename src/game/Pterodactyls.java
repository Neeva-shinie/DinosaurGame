package game;

import edu.monash.fit2099.engine.*;

/**
 * Class for Pterodactyls which is a dinosaur could fly
 * @see Dinosaur
 */
public class Pterodactyls extends Dinosaur {
    /**
     * Attribute
     */
    private int flytime = 30;

    /**
     * determine flight time
     */
    public void addFlytime(){
        if (flytime == 0){
            flytime +=30;
        }

    }

    /**
     * decrease flighttime
     */
    public void removeFlytime(){
        if(flytime == 30){
            flytime -=10;
        }

    }
    /**
     * Attribute
     */
    Behaviour behaviour;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     *
     */
    public Pterodactyls(String name) {
        super(name, 'P', 100, 200,60,100);
        addCapability(Flying.FLYING);
        behaviour = new WanderBehaviour();
    }

    /**
     * override hunger
     * @return hunger method
     */
    @Override
    public Behaviour Hunger() {
        return super.Hunger();
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
        return new Actions(new FeedingAction(otherActor,map));
    }

    /**
     * Breeding behaviour
     * @return behaviour
     */
    @Override
    public Behaviour Breed(){return super.Breed();}

    /**
     * Figure out what to do next.
     * <p>
     * FIXME: Pterodactyls wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     *
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        Location location = map.locationOf(this);
        if(location.getGround().hasCapability(LakeHasFish.LAKE_HAS_FISH)){
            actions.add(new EatFishAction(location.getGround()));
        }

        if (flytime == 0){
            removeCapability(Flying.FLYING);
            if (location.getGround().equals(new Tree())){
                location.addActor(this);
                return new DoNothingAction();
            }
            addFlytime();
        }
        if(this.getWaterPts()<=40){
            return new ThirstyBehaviour().getAction(this, map);
        }

        Action wander = behaviour.getAction(this, map);
        hurt(1);
        if (wander != null)
            return wander;
        removeFlytime();

        return new DoNothingAction();
    }
}
