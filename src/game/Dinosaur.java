package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;


/**
 * main dino class
 */
public class Dinosaur extends Actor {
    /**
     * Arraylist for dinosaur
     */
    private ArrayList<Dinosaur> dinosaur;
    /**
     * Behaviour of dinosaur
     */
    private Behaviour behaviour;
    /**
     * Location
     */
    private Location location;
    /**
     * water points of dinosaur
     */
    private int waterPoints;
    /**
     * maximum water points of dinosaur
     */
    private int maxWaterPoints;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, int maxhitpoint, int waterPoints, int maxWaterPoints) {
        super(name, displayChar, hitPoints);
        this.maxWaterPoints = maxhitpoint;
        this.waterPoints = waterPoints;
        this.maxWaterPoints = maxWaterPoints;
    }

    /**
     * Getter for the name of dinosaur
     *
     * @return name of the dinosaur
     */

    public String getName() {
        return name;
    }

    /**
     * this method is used to reduce water points of the dinosaur
     * @param points water points which you desire to reduce
     */
    public void reduceWaterPts(int points) {
        waterPoints -= points;
    }

    /**
     * this method is used to add water points of the dinosaur and wont exceed the dinosaur maximum water points
     * @param points water points which you desire to add
     */
    public void addWaterPts(int points) {
        waterPoints += points;
        waterPoints = Math.min(waterPoints, maxWaterPoints);
    }

    /**
     * this method is the getter of water points of the dinosaur
     * @return water points of the dinosaur currently
     */
    public int getWaterPts() {
        return this.waterPoints;

    }

    /**
     * this method is to check the dinosaur is conscious or unconscious due to the dinosaur water points is 0.
     * @return true if the dinosaur has insufficient water points and vice versa.
     */
    public boolean isConsciousThirsty() {
        return waterPoints <= 0;
    }


    /**
     * stores type of dino
     *
     * @return array
     */

    public ArrayList<Dinosaur> dinosaurType() {
        dinosaur.add(new Stegosaur("Stegosaur"));
        dinosaur.add(new Brachiosaur("Brachiosaur"));
        dinosaur.add(new Allosaur("Allosaur"));
        return dinosaur;
    }

    /**
     * Play turn
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return action
     */

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        if (lastAction.getNextAction() != null) {
            return null;
        }
        return null;
    }

    /**
     * Hunger
     *
     * @return Behaviour
     */

    public Behaviour Hunger() {
        return new HungerBehaviour();
    }

    /**
     * Breed
     *
     * @return Behaviour
     */

    public Behaviour Breed() {
        if (new Stegosaur("Stegosaur").hitPoints > 50) {

        }
        if (new Brachiosaur("Brachiosaur").hitPoints > 70) {

        }
        if (new Allosaur("Allosaur").hitPoints > 50) {

        }
        return new BreedBehaviour();

    }

    /**
     * growth
     *
     * @param actor dino
     * @return actor
     */
    public Actor growUp(Actor actor) {
        int turns = 0;
        if (actor == new BabyStegosaur("BabyStegosaur")) {
            if (turns == 30) {
                actor = new Stegosaur("Stegosaur");
                return actor;
            }
        } else if (actor == new BabyBrachiosaur("BabyBrachiosaur")) {
            if (turns == 50) {
                actor = new Stegosaur("Brachiosaur");
                return actor;
            }
        } else if (actor == new BabyAllosaur("BabyAllosaur")) {
            if (turns == 50) {
                actor = new BabyAllosaur("Allosaur");
                return actor;
            }
        }
        return actor;
    }

    /**
     * death method
     */

    public void death() {
        int turn = 0;
        if (new Stegosaur("Stegosaur").isConscious() || new Allosaur("Allosaur").isConscious()) {
            Item stegosaurCorpse = new PortableItem("Stegosaur game.Corpse", '%');
            Item allosaurCorpse = new PortableItem("AllosaurCorpse", '%');
            location.addItem(stegosaurCorpse);
            location.addItem(allosaurCorpse);
            if (turn == 20) {
                location.removeItem(stegosaurCorpse);
                location.removeItem(allosaurCorpse);

            }


        } else if (new Brachiosaur("Brachiosaur").isConscious()) {
            Item brachiosaurCorpse = new PortableItem("Brachiosaur game.Corpse", '%');
            location.addItem(brachiosaurCorpse);
            if (turn == 40) {
                location.removeItem(brachiosaurCorpse);
            }
        }

    }

    /**
     * allows creates communication using UI
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new EatingAction());
    }

    /**
     * This is to get the maximum hitpoints of the dinosaur
     * @return maximum hitpoints of dinosaur
     */
    public int getMaxhitpoint() {
        return maxHitPoints;
    }

    /**
     * this method is to get the arraylist of all dinosaur
     * @return arraylist of all dinosaur
     */
    public ArrayList<Dinosaur> getDinosaur() {
        return dinosaur;
    }


}
