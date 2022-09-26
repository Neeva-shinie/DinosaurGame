package game;

import edu.monash.fit2099.engine.Location;

/**
 * AllosaurEgg class
 * @see Egg
 */
public class AllosaurEgg extends Egg implements Transaction {
    Transaction.Points ecopoints = new Transaction.Points();
    private int turns;

    /**
     * Constructor method for AllosaurEgg
     */
    public AllosaurEgg() {
        super("AllosaurEgg", '3');
    }

    /**
     * This is method override from Item class and used to produce BabyAllosaur after certain turns
     * @param location location of AllosaurEgg
     */
    public void tick(Location location) {
        super.tick(location);
        if (location.getItems().contains(new BrachiosaurEgg())) {
            if (turns == 10) {
                location.removeItem(new StegosaurEgg());
                location.addActor(new BabyStegosaur("BabyAllosaur"));
                ecopoints.addpoints(1000);
            } else {
                turns++;

            }
        }
    }


}


