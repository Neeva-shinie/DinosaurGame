package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

/**
 * Class for Brachiosaur which is a herbivorous dinosaur
 * @see Dinosaur
 */
public class Brachiosaur extends Dinosaur{
    /**
     * Constructor method.
     *
     */
    private Behaviour behaviour;
    private int turn;
    public Brachiosaur(String name) {
        super(name,'B', 100,160,60,200);
        behaviour = new WanderBehaviour();
    }

    /**
     * method override from main dinosaur class
     * @return behaviour
     */
    @Override
    public Behaviour Hunger(){
        if(hitPoints <140){
            return super.Hunger();
        }
        return super.Hunger();
    }

    /**
     * user interacting with UI
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return FeedingAction
     */

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new FeedingAction(otherActor,map));
    }
    /**
     * method override from main dinosaur class
     * @return behaviour
     */
    @Override
    public Behaviour Breed(){
        if(hitPoints > 70){
            return super.Breed();
        }
        return super.Breed();
    }

    /**
     * this method which is override from Actor class
     * is to let the actor could experience the time and action would be returned according to the Brachiosaur condition.
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
        Random rand = new Random();
        if (map.contains(this)) {
            if (map.locationOf(this).getDisplayChar() == '^') {
                if (rand.nextInt(2) < 1) {
                    map.locationOf(this).setGround(new Dirt());
                }
            }//check the Brachiosaur is conscious or unconscious due to water points is 0
            if (this.isConsciousThirsty()){
                turn++;
                if (turn==15){
                    map.removeActor(this);
                }return new DoNothingAction();
            }
        }// check the Brachiosaur is thirsty or not
        if(this.getWaterPts()<=40){
            return new ThirstyBehaviour().getAction(this, map);
        }

        if (wander != null)
            return wander;

        return new DoNothingAction();

    }
}
