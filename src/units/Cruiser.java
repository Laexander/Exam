package units;

import player.Player;

/* Cruiser is a unit in Twilight Imperium.
 * A Cruiser has a combat value, a resource cost, movement speed, a capacity and a owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Cruiser contains at a glance. */
public class Cruiser implements Unit
{
    private int combatValue = 7;
    private int resourceCost = 2;
    private int movementSpeed = 2;
    private int capacity = 0;
    Player owner;

    public Cruiser(Player owner) {
        this.owner = owner;
    }

    @Override
    public int getCombatValue() {
        return combatValue;
    }

    @Override
    public int getResourceCost() {
        return resourceCost;
    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
}
