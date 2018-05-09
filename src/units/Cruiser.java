package units;

import player.Player;

import java.util.Objects;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Cruiser is a unit in Twilight Imperium.
 * A Cruiser has a combat value, a resource cost, movement speed, a capacity and an owner.
 * combatValue, resourceCost, movementSpeed and capacity could be made local variables or a single value int their
 * getters, as they are a static value, however this would reduce readability, as it would not be obvious what
 * information Cruiser contains at a glance. */
public class Cruiser implements Unit {
    //Cruiser's combat value
    private static int combatValue = 7;
    //Cruiser's resource cost
    private static int resourceCost = 2;
    //Cruiser's movement speed
    private static int movementSpeed = 2;
    //Cruiser's capacity
    private static int capacity = 0;
    //Cruiser's owner
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

    /* Method used to determine equality.
     * Cruisers are equals if owner is the same
     * There is no need to check other variables as they always are the same */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cruiser)) return false;
        Cruiser cruiser = (Cruiser) o;
        return Objects.equals(getOwner(), cruiser.getOwner());
    }

    /* Method returns a hashcode value for Cruiser.
     * Hashcode uses Owner. */
    @Override
    public int hashCode() {

        return Objects.hash(getOwner());
    }
}
