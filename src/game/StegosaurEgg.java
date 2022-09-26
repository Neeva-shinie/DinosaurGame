package game;

import edu.monash.fit2099.engine.Location;

/**
 * Class for StegosaurEgg
 * @see Egg
 */
public class StegosaurEgg extends Egg implements Transaction {
    /**
     * Create new instance
     */
    Transaction.Points ecopoints = new Transaction.Points();
    /**
     * Attribute
     */
    private int turn;


    /**
     * Constructor method for StegosaurEgg class
     */
    public StegosaurEgg() {
        super("StegosaurEgg", '1');
    }

    /**
     * This is method override from Item class and used to produce BabyStegosaur after certain turns
     * @param location location of the Stegosaur Egg
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (location.getItems().contains(new BrachiosaurEgg())) {
            if (turn == 10) {
                location.removeItem(new StegosaurEgg());
                location.addActor(new BabyStegosaur("BabyStegosaur"));
                ecopoints.addpoints(100);
            } else {
                turn++;

            }
        }
    }



}

