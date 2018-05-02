import player.Player;
import org.junit.jupiter.api.Test;

import static player.PlayerColor.Black;
import static player.Race.Barony_of_Letnev;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static player.PlayerColor.Green;
import static player.Race.Clan_of_Saar;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/* Tests for the class Player */
public class PlayerTest
{
    /* Tests that Players with the same name, race and color are equals */
    @Test
    void testEquals01()
    {
        Player player1 = new Player("TestName", Clan_of_Saar, Green);
        Player player2 = new Player("TestName", Clan_of_Saar, Green);

        assertEquals(player1, player2);
    }

    /* Test that players with different names are not equals. */
    @Test
    void testNotEquals01()
    {
        Player player1 = new Player("TestName", Clan_of_Saar, Green);
        Player player2 = new Player("WrongTestName", Clan_of_Saar, Green);

        assertNotEquals(player1, player2);
    }

    /* Test that players with different races are not equals. */
    @Test
    void testNotEquals02()
    {
        Player player1 = new Player("TestName", Clan_of_Saar, Green);
        Player player2 = new Player("TestName", Barony_of_Letnev, Green);

        assertNotEquals(player1, player2);
    }

    /* Test that players with different colors are not equals. */
    @Test
    void testNotEquals03()
    {
        Player player1 = new Player("TestName", Clan_of_Saar, Green);
        Player player2 = new Player("TestName", Clan_of_Saar, Black);

        assertNotEquals(player1, player2);
    }
}
