package game;

import edu.monash.fit2099.engine.Location;

/**
 * Class for PterodactylsEgg
 * @see Egg
 */
public class PterodactylsEgg extends Egg implements Transaction {
    PterodactylsEgg pterodactylsEgg = new PterodactylsEgg();
    int turns;
    Transaction.Points ecopoints = new Transaction.Points();

    /**
     * Constructor method
     */
    public PterodactylsEgg() {
        super("Pterodactyl Eggs", '-');
    }

    /**
     * This is method override from Item class and used to produce BabyPterodactyls after certain turns
     * @param location location of PterodactylsEgg
     */
    public void tick(Location location) {
        super.tick(location);
        if (location.getItems().contains(pterodactylsEgg)) {
            if (turns == 10) {
                location.removeItem(pterodactylsEgg);
                location.addActor(new BabyPterodactyls("BabyPterodactyls"));
                ecopoints.addpoints(200);
            } else {
                turns++;

            }
        }
    }


}
