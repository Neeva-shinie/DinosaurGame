package game;

/**
 * This is an abstract class used to collect all different types of Egg
 * @see FoodSource
 */
public abstract class Egg extends FoodSource {
    /**
     * Constructor method for Egg abstract class
     * @param name name of the egg
     * @param displayChar the display character on the game map
     */
    public Egg(String name, char displayChar) {
        super(name, displayChar);
    }

}

