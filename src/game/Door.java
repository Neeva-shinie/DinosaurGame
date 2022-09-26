package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Item;

/**
 * item to travel
 * @see Application
 */
public class Door extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Door(String name, char displayChar, boolean portable) {
        super(name, '/', portable);
    }

    /**
     * To add action
     * @param action get action
     */

    public void addAction(Action action){
        this.allowableActions.add(action);

    }
}
