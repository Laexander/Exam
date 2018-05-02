package units;

import player.Player;

/* Carrier is a unit in Twilight Imperium.
 * A Carrier has a combat value, a resource cost, movement speed, a capacity and a owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Carrier contains at a glance. */
public class Carrier implements Unit
{
    private int combatValue = 9;
    private int resourceCost = 3;
    private int movementSpeed = 1;
    private int capacity = 6;
    Player owner;

    public Carrier(Player owner) {
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
