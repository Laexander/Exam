package player;

import myExceptions.InvalidIndexException;

import java.util.HashMap;
import java.util.Map;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The enumerate PlayerColor represents the color of a player.
 * As there are a maximum of 6 player in a game, there are 6 different colors.
 * Additionally this means that there will be no need for new colors, therefore color is represented as an enumerate. */
public enum PlayerColor {
    RED(0), BLUE(1), GREEN(2), PURPLE(3), BLACK(4), WHITE(5);

    //Variable to store index for each player color.
    private int index;

    //A map to associate an int to a player color
    private static Map<Integer, PlayerColor> colorMap = new HashMap<>();

    //Associates index to a player color
    static {
        for (PlayerColor colorEnum : PlayerColor.values()) {
            colorMap.put(colorEnum.index, colorEnum);
        }
    }

    //Constructor for PlayerColor
    PlayerColor(int index) {
        this.index = index;
    }

    /* Returns the player color corresponding to the given index
     * Parameter index: an integer between 0 and 5 used to determine player color to return
     * Throws: invalidIndexException if in index is too high or too low */
    public static PlayerColor getPlayerColor(int index) throws InvalidIndexException {
        if (index >= 0 && index < 6) {
            return colorMap.get(index);
        } else {
            throw new InvalidIndexException("Invalid index for Player Color, index must be between 0 and 5");
        }
    }
}
