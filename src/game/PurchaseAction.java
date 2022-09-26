package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * To carry out purchase action
 * @see VendingMachine, Action
 */
public class PurchaseAction extends Action implements Transaction {
    /**
     * new instance
     */
    Transaction.Points ecopoints = new Transaction.Points();




    /**
     * Constructor
     *
     */
    public PurchaseAction(){

    }

    /**
     * carries out action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int selection;
        do{
            selection =  VendingMachine.itemMenu();
            switch (selection){
                case 1:
                    if(ecopoints.removepoints(30) != 0 ){
                        actor.addItemToInventory(new Fruit());
                        System.out.println("Purchased fruit");
                    }else{
                        System.out.println("Insufficient eco points");
                    }
                    break;
                case 2:
                    if(ecopoints.removepoints(100) != 0 ){
                        actor.addItemToInventory(new VegetarianMealKit());

                    }
                    System.out.println("Purchased Vegetarian meal kit");
                    break;
                case 3:
                    if(ecopoints.removepoints(500) != 0 ){
                        actor.addItemToInventory(new CarnivoreMealKit());
                        System.out.println("Purchased Carnivore meal kit ");
                    }else{
                        System.out.println("Insufficient eco points");
                    }

                    break;
                case 4:
                    if(ecopoints.removepoints(200) != 0 ){
                        actor.addItemToInventory(new StegosaurEgg());
                        System.out.println("Purchased Stegosaur eggs");
                    }else{
                        System.out.println("Insufficient eco points");
                    }
                    break;
                case 5:
                    if(ecopoints.removepoints(500) != 0 ){
                        actor.addItemToInventory(new BrachiosaurEgg());
                        System.out.println("Purchased  Brachiosaur eggs");
                    }else{
                        System.out.println("Insufficient eco points");
                    }

                    break;
                case 6:
                    if(ecopoints.removepoints(1000) != 0 ){
                        actor.addItemToInventory(new AllosaurEgg());
                        System.out.println("Purchased  Allosaur eggs");
                    }else{
                        System.out.println("Insufficient eco points");
                    }

                    break;
                case 7:
                    if(ecopoints.removepoints(200) != 0 ){
                        actor.addItemToInventory(new PterodactylsEgg());
                        System.out.println("Purchased  Pterodactyls Egg");
                    }else{
                        System.out.println("Insufficient eco points");
                    }
                    break;

                case 8:
                    if(ecopoints.removepoints(500) != 0 ){
                        actor.addItemToInventory(new LaserGun());
                        System.out.println("Purchased  Laser gun");
                    }else{
                        System.out.println("Insufficient eco points");
                    }
                    break;
                case 9:
                    System.out.println(ecopoints.displaypoints());
                case 10:
                    System.out.println(actor.getInventory());
            }
        }while(selection!=11);



        return menuDescription(actor);
    }



    /**
     * Message to diasplay at UI
     * @param actor The actor performing the action.
     * @return String message
     */

    @Override
    public String menuDescription(Actor actor) {

            return actor + " wants to use vending machine?" ;
    }









}
