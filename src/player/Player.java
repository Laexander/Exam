package player;

import java.util.Objects;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The Player class is a representation of a player in the game Twilight Imperium.
 * A Player has a name, a race and a player color. */
public class Player {
    //Player's name
    private String name;
    //Player's race
    private Race playerRace;
    //Player's color
    private PlayerColor color;

    /* Constructor for Player
     * Parameter name: The name of Player
     * Parameter playerRace: The race of Player
     * Parameter color: The color of Player*/
    public Player(String name, Race playerRace, PlayerColor color) {
        this.name = name;
        this.playerRace = playerRace;
        this.color = color;
    }

    //Returns name
    public String getName() {
        return name;
    }

    //Returns playerRace
    public Race getPlayerRace() {
        return playerRace;
    }

    //Returns color
    public PlayerColor getColor() {
        return color;
    }

    /* Method used to determine equality of players.
     * Players are equals if name, race and color are the same
     * Parameter o: Other object to be compared to this object
     * Return: True if equals, false if not. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                getPlayerRace() == player.getPlayerRace() &&
                getColor() == player.getColor();
    }

    /* Method used to generate hashcode value for Player
     * Hashcode uses name, race and color
     * Return: hashcode of object*/
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPlayerRace(), getColor());
    }

    /* Method used to return a string representation of the class and its fields
     * Return: String representation of Player */
    @Override
    public String toString() {
        return name + " " +
                "(" + playerRace + ")  " +
                color;
    }
}
