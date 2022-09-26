package game;


import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.GameMap;

/**
 * class for Stegosaur which is a herbivorous dinosaur.
 * @see Dinosaur
 */
public class Stegosaur extends Dinosaur {
    /**
     * Attribute
     */
    private int turn;
    /**
     * Attribute
     */
    private Behaviour behaviour;


    /**
     * Constructor.
     * All Stegosaurs are represented by a 'd' and have 100 hit points.
     * @param name Stegosaur
     */
    public Stegosaur(String name) {
        super(name, 'S', 50,100,60,100);

        behaviour = new WanderBehaviour();
    }

    /**
     * override hunger from Dinosaur class
     * @return hunger method
     */
    @Override
    public Behaviour Hunger() {
        if(hitPoints < 90){
            return super.Hunger();
        }

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
     * Breed override from Dinosaur class
     * @return breed behaviour
     */
    @Override
    public Behaviour Breed(){
        if (hitPoints >50){
            return super.Breed();
        }
        return super.Breed();
    }



    /**
     * Figure out what to do next.
     * <p>
     * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        Action wander = behaviour.getAction(this, map);
        hurt(1);
        reduceWaterPts(1);
        if (this.isConsciousThirsty()){ //check the Stegosaur is conscious or unconscious due to water points is 0
            turn++;
            if (turn==15){
                map.removeActor(this);
            }return new DoNothingAction();
        }

        if(this.getWaterPts()<=40){ //check the Stegosaur is thirsty or not
            return new ThirstyBehaviour().getAction(this, map);
        }

        if (wander != null)
            return wander;

        return new DoNothingAction();
    }


}
