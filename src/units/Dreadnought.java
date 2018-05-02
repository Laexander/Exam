package units;

import player.Player;

/* Dreadnought is a unit in Twilight Imperium.
 * A Dreadnought has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Dreadnought contains at a glance. */
public class Dreadnought implements Unit
{
    //Dreadnought combat value
    private int combatValue = 5;
    //Dreadnought resource cost
    private int resourceCost = 5;
    //Dreadnought movement speed
    private int movementSpeed = 1;
    //Dreadnought capacity
    private int capacity = 0;
    //Dreadnought owner
    Player owner;

    //Constructor for Dreadnought
    public Dreadnought(Player owner) {
        this.owner = owner;
    }

    //Returns combat value
    @Override
    public int getCombatValue() {
        return combatValue;
    }

    //Returns resource cost
    @Override
    public int getResourceCost() {
        return resourceCost;
    }

    //Returns movement speed
    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    //Returns capacity
    @Override
    public int getCapacity() {
        return capacity;
    }

    //Returns owner
    @Override
    public Player getOwner() {
        return owner;
    }
}
