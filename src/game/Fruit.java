package game;



/**
 * Fruit class
 * @see FoodSource
 */
public class Fruit extends FoodSource {
    /**
     * Attribute
     */
    private int points;

    /**
     * constructor
     */
    public Fruit() {
        super("Fruit", '*');

    }

    /**
     * get points
     * @return points
     */
    public int getPoints() {
        return points;
    }




}
