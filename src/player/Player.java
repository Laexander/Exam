package player;

import java.util.Objects;

/* The Player class is a representation of a player in the game Twilight Imperium.
 * A Player has a name, a race and a player color. */
public class Player
{
    //Player name
    private String name;
    //Player race
    private Race playerRace;
    //Player color
    private PlayerColor color;

    //Constructor for Player
    public Player(String name, Race player_race, PlayerColor color)
    {
        this.name = name;
        this.playerRace = player_race;
        this.color = color;
    }

    //Returns name
    public String getName()
    {
        return name;
    }

    //Returns playerRace
    public Race getPlayerRace()
    {
        return playerRace;
    }

    //Returns color
    public PlayerColor getColor()
    {
        return color;
    }

    /* Method used to determine equality.
     * Players are equals if name, race and color are the same */
    @Override
    public boolean equals(Object o)
    {
        //TODO Figure out if color is the only important determiner in equality
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                getPlayerRace() == player.getPlayerRace() &&
                getColor() == player.getColor();
    }

    /* Method returns a hashcode value for Player
     * Hashcode uses name, race and color */
    @Override
    public int hashCode()
    {
        //TODO Figure out if color is the only important determiner in equality
        return Objects.hash(getName(), getPlayerRace(), getColor());
    }

    /* toString returns a string with the class and its fields */
    @Override
    public String toString()
    {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerRace=" + playerRace +
                ", color=" + color +
                '}';
    }
}
