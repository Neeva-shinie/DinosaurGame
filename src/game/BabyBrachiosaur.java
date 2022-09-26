package game;

import edu.monash.fit2099.engine.*;
/**
 * Class for BabyBrachiosaur
 * @see Dinosaur
 */
public class BabyBrachiosaur extends Dinosaur{
    /**
     * Behaviour of BabbyBrachiosaur
     */
    private Behaviour behaviour;
    /**
     * Number of turns experienced by BabybBrachiosaur
     */
    private int turn;

    /**
     * Constructor method for BabyBrachiosaur
     * @param name BabyBrachiosaur
     */
    public BabyBrachiosaur(String name) {
        super(name, 'b', 10,100,60,200);
    }
    /**
     * method from main dinosaur class
     * @return behaviour
     */
    @Override
    public Behaviour Hunger() {
        return super.Hunger();
    }
    /**
     * interacting with user interface
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }
    /**
     * method from main dinosaur class
     * @return behaviour
     */
    public Actor growUp() {
        return super.growUp( new BabyAllosaur("BabyAllosaur"));
    }

    /**
     * this method which is override from Actor class
     * is to let the actor could experience the time and action would be returned according to the BabyBrachiosaur condition.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return action
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        Action wander = behaviour.getAction(this, map);
        hurt(1);
        reduceWaterPts(1);
        if (this.isConsciousThirsty()){ //check the BabyBrachiosaur is conscious or unconscious due to water points is 0
            turn++;
            if (turn==15){
                map.removeActor(this);
            }return new DoNothingAction();
        }

        if(this.getWaterPts()<=40){ // check the BabyBrachiosaur is thirsty or not
            return new ThirstyBehaviour().getAction(this, map);
        }

        if (wander != null)
            return wander;

        return new DoNothingAction();
    }
}