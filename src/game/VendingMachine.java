package game;

import edu.monash.fit2099.engine.*;

import java.util.Scanner;

/**
 * This program to implement for player to purchase stuffs using ecopoints
 * @see Ground, Transaction
 */
public class VendingMachine extends Ground  {
    /**
     * new instance
     */
    Actor player = new Player("Player",'@',100);
    /**
     * Attribute
     */

    private Flying Flying;

    /**
     * Vending machine constructor
     */
    public VendingMachine() {
        super('V');
    }


    /**
     * Item menu to use user interface
     * @return int choice
     */
    public static int itemMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Fruit");
        System.out.println("2) Vegetarian meal kit");
        System.out.println("3) Carnivore meal kit");
        System.out.println("4) Stegosaur eggs");
        System.out.println("5) Brachiosaur eggs");
        System.out.println("6) Allosaur eggs");
        System.out.println("7) Pterodactyls eggs");
        System.out.println("8) Laser gun");
        System.out.println("9) Display Ecopoints");
        System.out.println("10) Display inventory");
        System.out.println("11) Exit");
        System.out.println("-------------------");
        System.out.println("Select your choice: ");
        int choice = scanner.nextInt();
        return choice;
    }



    /**
     * To make the player to communicate with the other actor
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return Action
     */
    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        return new Actions(new PurchaseAction());
    }

    /**
     * To determine if the actor could pass through the item
     * @param actor the Actor to check
     * @return actor
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(game.Flying.FLYING)){
            return super.canActorEnter(actor);
        }else{
            return super.canActorEnter( player);
        }


    }
}

