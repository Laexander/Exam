package units;

import player.Player;

/* Carrier is a unit in Twilight Imperium.
 * A Carrier has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Carrier contains at a glance. */
public class Carrier implements Unit
{
    //Carrier combat value
    private int combatValue = 9;
    //Carrier resource cost
    private int resourceCost = 3;
    //Carrier movement speed
    private int movementSpeed = 1;
    //Carrier capacity
    private int capacity = 6;
    // Carrier owner
    Player owner;

    //Constructir for Carrier
    public Carrier(Player owner) {
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
