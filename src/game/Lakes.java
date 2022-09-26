package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing lakes in symbol of '~' in gameMap
 * @see Ground
 */
public class Lakes extends Ground {
    /**
     * capacity of Lakes
     */
    private int capacity;
    /**
     * number of turns
     */
    private int turns;
    /**
     * list of Fish instance
     */
    private List<Fish> fish = new ArrayList<>();

    /**
     * Lakes constructor
     */

    public Lakes() {
        super('~');
        this.capacity = 25;
        this.fish = setFish();
    }

    /**
     * List for fish in the lake and set 5 fish at the beginning in the lake.
     * @return fish list
     */

    public List<Fish> setFish() {
        for (int i = 0; i <= 5; i++) {
            fish.add(new Fish());
        }
        return fish;
    }

    /**
     * Add capacity of the lake
     * @param newCapacity the water added into the lake(raining)
     */

    public void addCapacity(int newCapacity) {
        capacity += newCapacity;
    }

    /**
     * Minus capacity of the lake
     * @param newCapacity the water reduced from the lake(dinosaur that drink water from the lake)
     */

    public void reduceCapacity(int newCapacity) {capacity-= newCapacity;}

    /**
     * Override method from Ground class and it is used for fish production and rainfall and when dinosaur is next to the lake,
     * their waterPoints attribute will be increased.
     * @param location The location of the Ground
     */

    @Override
    public void tick(Location location) {
        super.tick(location);
        turns++;
        GameMap map = location.map();
        int X = location.x();
        int Y = location.y();
       int x1 = X+1;
       int x2 = X-1;
       int y1 =Y+1;
       int y2= Y-1;
//location which is next to the lake
       ArrayList<Location> locations = new ArrayList<>();
        locations.add((map.at(x1, Y)));
        locations.add(map.at(X, y1));
        locations.add(map.at(x2, Y));
        locations.add(map.at(X, y2));
        locations.add(map.at(x1, y1));
        locations.add(map.at(x2, y2));
        locations.add(map.at(x1, y2));
        locations.add(map.at(x2, y1));

        if (turns == 10) {
            turns = 0;
            if ((Math.random() * 10) < 2) { //raining
                if (location.getDisplayChar() == '~') {
                    //amount of water added
                    addCapacity(20 * (int) Math.floor(Math.random() * (0.6 - 0.1 + 1) + 0.1));
                }
                if (location.containsAnActor()) {
                    Dinosaur dinosaur = (Dinosaur) location.getActor();
                    if (dinosaur.isConsciousThirsty()) {
                        dinosaur.addWaterPts(10);
                    }
                }


            }
        }
        //add fish into the lake
        if (location.getDisplayChar() == '~') {
            if ((Math.random() * 10) < 6) {
                fish.add(new Fish());
            }
            // increase water points for the dinosaur who is next to the lake
            for (Location target : locations) {
                if (target.containsAnActor()) {
                    Dinosaur dinosaur = (Dinosaur) target.getActor();
                    if (target.getActor().equals(new Brachiosaur("Brachiosaur")) ||
                            target.getActor().equals(new BabyBrachiosaur("BabyBrachiosaur"))) {
                        dinosaur.addWaterPts(80);
                    } else {
                        dinosaur.addWaterPts(30);
                    }
                    //any dinosaur who is next to the lake will reduce the lake capacity by 1
                    reduceCapacity(1);

                }
            }
        }
    }

    /**
     * This method is override from Ground class and is used to check either the dinosaur could enter the lake or not.
     * @param actor the Actor to check
     * @return true if the actor has the capability of flying.
     */
    @Override
    public boolean canActorEnter(Actor actor) {

            if(actor.hasCapability(game.Flying.FLYING)){
                return super.canActorEnter(actor);
            }else{
                return super.canActorEnter(null);
            }



    }


}


//In addition to bushed, dirt, and trees, the park must have a few lakes where dinosaurs can
// drink water. Each lake covers 1 square on the map. Use the tilde character (~) to
// represent water/lake and place some pools of water in the map.
// Each lake starts with a capacity of 25 sips. Every 10 turns, with a probability of 20%,
// the sky might rain which adds water to all lakes. The amount of water that is added to the
// lake is calculated by multiplying the rainfall by 20 sips where the
// rainfall is a random value between 0.1 and 0.6 inclusive.
//
//Each lake can also hold up to maximum 25 fish,
// each fish providing 5 food points.
// Lakes start the game with only 5 fish.
// Each turn, there is a probability of 60% for a new fish to be born
// (increasing the number of fish of the lake by 1).
