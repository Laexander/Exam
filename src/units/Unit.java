package units;

import player.Player;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Unit is a interface for implementing different units in Twilight Imperium.
 * Unit contains getter for all relevant information of the units in Twilight Imperium. */
public interface Unit {
    //Returns combat value
    int getCombatValue();

    //Returns resource cost
    int getResourceCost();

    //Returns movement speed
    int getMovementSpeed();

    //Returns capacity
    int getCapacity();

    //returns owner
    Player getOwner();
}
