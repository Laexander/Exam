package units;

import player.Player;

/* Destroyer is a unit in Twilight Imperium.
 * A Destroyer has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Destroyer contains at a glance. */
public class Destroyer implements Unit
{
    //Destroyer combat value
    private int combatValue = 9;
    //Destroyer resource cost
    private int resourceCost = 1;
    //Destroyer movement speed
    private int movementSpeed = 2;
    //Destroyer capacity
    private int capacity = 0;
    //Destroyer owner
    private Player owner;

    //Constructor for Destroyer
    public Destroyer(Player owner)
    {
        this.owner = owner;
    }

    //Returns combat value
    @Override
    public int getCombatValue()
    {
        return combatValue;
    }

    //Returns resource cost
    @Override
    public int getResourceCost()
    {
        return resourceCost;
    }

    //Returns movement speed
    @Override
    public int getMovementSpeed()
    {
        return movementSpeed;
    }

    //Returns capacity
    @Override
    public int getCapacity()
    {
        return capacity;
    }

    //Returns owner
    @Override
    public Player getOwner()
    {
        return owner;
    }
}
