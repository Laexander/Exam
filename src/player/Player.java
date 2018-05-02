package player;

import java.util.Objects;

/* The Player class is a representation of a player in the game Twilight Imperium.
 * A Player has a name, a race and a player color. */
public class Player
{
    // Player name
    private String name;
    //Player race
    private Race playerRace;
    //Player color
    private PlayerColor color;

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

    //returns playerRace
    public Race getPlayerRace()
    {
        return playerRace;
    }

    // Returns color
    public PlayerColor getColor()
    {
        return color;
    }

    /* */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                getPlayerRace() == player.getPlayerRace() &&
                getColor() == player.getColor();
    }

    @Override
    public int hashCode()
    {

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
