package units;

import player.Player;

/* Unit is a interface for implementing different units in Twilight Imperium.
 * Unit contains getter for all relevant information of the units in Twilight Imperium. */
public interface Unit
{
    int getCombatValue();
    int getResourceCost();
    int getMovementSpeed();
    int getCapacity();
    Player getOwner();
}
