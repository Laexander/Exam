package units;

import player.Player;

/* Destroyer is a unit in Twilight Imperium.
 * A Destroyer has a combat value, a resource cost, movement speed, a capacity and a owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Destroyer contains at a glance. */
public class Destroyer implements Unit
{
    private int combatValue = 9;
    private int resourceCost = 1;
    private int movementSpeed = 2;
    private int capacity = 0;
    private Player owner;

    public Destroyer(Player owner)
    {
        this.owner = owner;
    }

    @Override
    public int getCombatValue()
    {
        return combatValue;
    }

    @Override
    public int getResourceCost()
    {
        return resourceCost;
    }

    @Override
    public int getMovementSpeed()
    {
        return movementSpeed;
    }

    @Override
    public int getCapacity()
    {
        return capacity;
    }

    @Override
    public Player getOwner()
    {
        return owner;
    }
}
