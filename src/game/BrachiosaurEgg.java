package game;

import edu.monash.fit2099.engine.Location;

public class BrachiosaurEgg extends Egg implements Transaction {
    /**
     * new instance
     */
    Transaction.Points ecopoints = new Transaction.Points();
    /**
     * Attribute
     */
    private int turn = 0;

    /**
     * Constructor
     */
    public BrachiosaurEgg() {
        super("BrachiosaurEgg", '2');
    }

    /**
     * This is method override from Item class and used to produce BabyAllosaur after certain turns
     * @param location lcoation of AllosaurEgg
     */
@Override
    public void tick(Location location) {
        super.tick(location);
        if (location.getItems().contains(new BrachiosaurEgg())) {
            if (turn == 10) {
                location.removeItem(new BrachiosaurEgg());
                location.addActor(new BabyBrachiosaur("BabyBrachiosaur"));
                ecopoints.addpoints(1000);
            } else {
                turn++;

            }
        }
    }


}

