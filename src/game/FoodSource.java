package game;

import java.util.ArrayList;

/**
 * Stores food
 * @see PortableItem
 */
public class FoodSource extends PortableItem {
    private ArrayList<FoodSource>food;
    private ArrayList<FoodSource>carnivoreFood;

    /**
     * Source
     * @param name name
     * @param displayChar character
     */
    public FoodSource(String name, char displayChar) {
        super(name, displayChar);
    }

    /**
     * get food
     * @return food
     */
    public ArrayList<FoodSource> getFood() {
        return food;
    }

    /**
     * get carnivore food
     * @return
     */
    public ArrayList<FoodSource> getCarnivoreFood() {
        return carnivoreFood;
    }

    /**
     * Store normal food
     * @return food
     */
    public ArrayList<FoodSource> storeFoodSource(){
        food = new ArrayList<>();
        food.add(new Fruit());
        food.add(new VegetarianMealKit());
        food.add(new CarnivoreMealKit());
        return food;

    }

    /**
     * Store carnivore food
     * @return food
     */
    public ArrayList<FoodSource> storeCarnivoreFood(){
        carnivoreFood.add(new CarnivoreMealKit());
        carnivoreFood.add(new StegosaurEgg());
        carnivoreFood.add(new BrachiosaurEgg());
        carnivoreFood.add(new AllosaurEgg());
        carnivoreFood.add(new VegetarianMealKit());
        carnivoreFood.add(new Fish());
        return carnivoreFood;
    }
}
