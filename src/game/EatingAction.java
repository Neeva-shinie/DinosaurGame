package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * implement eating action
 */
public class EatingAction extends Action {

    /**
     * Attribute
     */
    private FoodSource foodItem;
    /**
     * Attribute
     */
    private Action action;
    /**
     * new instance
     */
    Corpse brachiosaurCorpse = new Corpse("Brachiosaur Corpse");
    /**
     * new instance
     *
     */
    Corpse femaleBrachiosaur = new Corpse(" Female Brachiosaur");
    /** new instance
     *
     */
    Corpse stegosaurCorpse = new Corpse("Stegosaur");
    /** new instance
     *
     */
    Corpse pterodactylsCorpse = new Corpse("Pterodactyls");
    /** new instance
     *
     */
    Actor player = new Player("Player",'@',100);
    /** new instance
     *
     */
    Dinosaur Allosaur = new Allosaur("Allosaur");
    /** new instance
     *
     */
    Dinosaur FemaleAllosaur = new Allosaur("Female Allosaur");
    /** new instance
     *
     */
    Dinosaur Stegosaur = new Stegosaur("Stegosaur");
    /** new instance
     *
     */
    Dinosaur FemaleStegosaur = new Stegosaur("Female Stegosaur");
    /** new instance
     *
     */
    Dinosaur Brachiosaur = new Brachiosaur("Brachiosaur");
    /** new instance
     *
     */
    Dinosaur FemaleBrachiosaur = new Stegosaur("Female Brachiosaur ");
    /** new instance
     *
     */
    Dinosaur Pterodactyls = new Stegosaur("Pterodactyls");
    /** new instance
     *
     */
    /**
     * Constructor
     */
    public EatingAction(){

    }

    /**
     * Execute eating method
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return message
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        //allosaur
        if(actor != player){
            if(actor == Allosaur || actor == FemaleAllosaur){
                if (map.locationOf(actor).getItems() == brachiosaurCorpse ){
                    map.locationOf(actor).removeItem(brachiosaurCorpse);
                    actor.heal(100);
                }else if (map.locationOf(actor).getItems() == femaleBrachiosaur){
                    map.locationOf(actor).removeItem(femaleBrachiosaur);
                    actor.heal(100);
                }else if (map.getActorAt(map.locationOf(actor))== Stegosaur) {
                    action = new AttackAction(Stegosaur);
                    if (map.locationOf(actor).getItems() == stegosaurCorpse) {
                        map.locationOf(actor).removeItem(stegosaurCorpse);
                        actor.heal(50);
                    }


                }else if(map.getActorAt(map.locationOf(actor))== Pterodactyls ){
                    action = new AttackAction(Pterodactyls);
                    if (location.getItems() == pterodactylsCorpse){
                        location.removeItem(pterodactylsCorpse);
                        actor.heal(30);
                    }


                }
            }else if( actor == Stegosaur || actor == FemaleStegosaur || actor == Brachiosaur ||actor == FemaleBrachiosaur){
                if(location.getItems() != null){
                    for(FoodSource elem : foodItem.storeFoodSource()){
                        if(location.getItems() == elem){
                            location.removeItem(elem);
                            actor.heal(10);
                        }
                    }
                }

            }else{
                if (map.locationOf(actor).getItems() == brachiosaurCorpse ){
                    map.locationOf(actor).removeItem(brachiosaurCorpse);
                    actor.heal(100);
                }else if (map.locationOf(actor).getItems() == femaleBrachiosaur) {
                    map.locationOf(actor).removeItem(femaleBrachiosaur);
                    actor.heal(100);
                }else if(map.locationOf(actor).getItems() == stegosaurCorpse)  {
                    location.removeItem(stegosaurCorpse);
                    actor.heal(50);
                }
            }
        }

//
        return menuDescription(actor);
    }


    /**
     * Message
     * @param actor The actor performing the action.
     * @return string
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + "eats";
    }

}
