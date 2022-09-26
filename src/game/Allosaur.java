package game;

import edu.monash.fit2099.engine.*;

/**
 * Class for Allosaur which is a carnivorous dinosaur
 * @see Dinosaur
 */
public class Allosaur extends Dinosaur {
    /**
     * Behaviour of Allosaur
     */
    private Behaviour behaviour;
    /**
     * number of turn experienced by the Allosaur
     */
    private int turn;


    /**
     * Constructor method for Allosaur
     * @param name  the name of the Actor
     */
    public Allosaur(String name) {
        super(name, 'A', 50,100,60,100);
        behaviour = new WanderBehaviour();
    }
    /**
     * method from main dinosaur class
     * @return behaviour
     */
    @Override
    public Behaviour Hunger() {
        if(hitPoints <90){
            return super.Hunger();
        }
        return super.Hunger();
    }
    /**
     * user interacting with UI
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map current GameMap
     * @return
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new FeedingAction(otherActor,map));
    }
    /**
     * method from main dinosaur class
     * @return behaviour
     */
    @Override
    public Behaviour Breed(){
        if(hitPoints>50){
            return super.Breed();
        }
        return super.Breed();
    }


    /**
     * this method which is override from Actor class is
     * to let the actor could experience the time and action would be returned according to the Allosaur condition.
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
        if (this.isConsciousThirsty()){ //check the Allosaur is conscious or unconscious due to water points is 0
            turn++;
            if (turn==15){
                map.removeActor(this);
            }return new DoNothingAction();
        }

        if(this.getWaterPts()<=40){ // check the Allosaur is thirsty or not
            return new ThirstyBehaviour().getAction(this, map);
        }

        if (wander != null)
            return wander;

        return new DoNothingAction();
    }
}
