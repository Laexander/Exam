package units;

import player.Player;

/* Cruiser is a unit in Twilight Imperium.
 * A Cruiser has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Cruiser contains at a glance. */
public class Cruiser implements Unit
{
    //Cruiser combat value
    private int combatValue = 7;
    //Cruiser resource cost
    private int resourceCost = 2;
    //Cruiser movement speed
    private int movementSpeed = 2;
    //Cruiser capacity
    private int capacity = 0;
    //Cruiser owner
    Player owner;

    //Construter for Cruiser
    public Cruiser(Player owner) {
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
