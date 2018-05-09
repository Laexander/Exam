package galaxyMap;

import myExceptions.InvalidIndexException;

import java.util.HashMap;
import java.util.Map;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The enumeration NeighborDirection are the directions which other systems neighbor a system.
 * Each direction has a index. This index indicates which position in a list is which direction.
 * If there is no system in a direction said position should be null. */
public enum NeighborDirection {
    NORTH(0), NORTH_EAST(1), SOUTH_EAST(2), SOUTH(3), SOUTH_WEST(4), NORTH_WEST(5);

    //Variable to store index for each direction.
    private int index;

    //A map to associate an int to a direction
    private static Map<Integer, NeighborDirection> directionMap = new HashMap<>();

    //Associates index to a direction
    static {
        for (NeighborDirection directionEnum : NeighborDirection.values()) {
            directionMap.put(directionEnum.index, directionEnum);
        }
    }

    //Constructor for NeighborDirection.
    NeighborDirection(int index) {
        this.index = index;
    }

    //Returns the index of direction.
    public int getIndex() {
        return index;
    }

    /* Returns the NeighborDirection corresponding to the given index
     * Parameter index: an integer between 0 and 5 used to determine NeighborDirection to return
     * Throws: invalidIndexException if in index is too high or too low */
    public static NeighborDirection getDirection(int index) throws InvalidIndexException {
        if (index >= 0 && index < 6) {
            return directionMap.get(index);
        } else {
            throw new InvalidIndexException("Invalid index for NeighborDirection, index must be between 0 and 5");
        }
    }

    /* Returns the opposite direction */
    public NeighborDirection getOppositeDirection() {
        //The opposite direction of any given direction is 3 away
        return directionMap.get((index + 3) % 6);
    }
}
