package units;

import player.Player;

import java.util.Objects;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Carrier is a unit in Twilight Imperium.
 * A Carrier has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Carrier contains at a glance. */
public class Carrier implements Unit {
    //Carrier's combat value, it is static as the value can  never change.
    private static int combatValue = 9;
    //Carrier's resource cost, it is static as the value can  never change.
    private static int resourceCost = 3;
    //Carrier's movement speed, it is static as the value can  never change.
    private static int movementSpeed = 1;
    //Carrier's capacity, it is static as the value can  never change.
    private static int capacity = 6;
    // Carrier's owner
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

    /* Method used to determine equality.
     * Carriers are equals if owner is the same
     * There is no need to check other variables as they always are the same */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrier)) return false;
        Carrier carrier = (Carrier) o;
        return Objects.equals(getOwner(), carrier.getOwner());
    }

    /* Method returns a hashcode value for Carrier.
     * Hashcode uses Owner. */
    @Override
    public int hashCode() {

        return Objects.hash(getOwner());
    }
}
