import player.Player;
import org.junit.jupiter.api.Test;

import static player.PlayerColor.BLACK;
import static player.Race.BARONY_OF_LETNEV;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static player.PlayerColor.GREEN;
import static player.Race.CLAN_OF_SAAR;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Tests for the class Player
 * Tests are not exhaustive as I was running low on time */
public class PlayerTest {
    /* Tests that Players with the same name, race and color are equals */
    @Test
    void testEquals01() {
        Player player1 = new Player("TestName", CLAN_OF_SAAR, GREEN);
        Player player2 = new Player("TestName", CLAN_OF_SAAR, GREEN);

        assertEquals(player1, player2);
    }

    /* Test that players with different names are not equals. */
    @Test
    void testNotEquals01() {
        Player player1 = new Player("TestName", CLAN_OF_SAAR, GREEN);
        Player player2 = new Player("WrongTestName", CLAN_OF_SAAR, GREEN);

        assertNotEquals(player1, player2);
    }

    /* Test that players with different races are not equals. */
    @Test
    void testNotEquals02() {
        Player player1 = new Player("TestName", CLAN_OF_SAAR, GREEN);
        Player player2 = new Player("TestName", BARONY_OF_LETNEV, GREEN);

        assertNotEquals(player1, player2);
    }

    /* Test that players with different colors are not equals. */
    @Test
    void testNotEquals03() {
        Player player1 = new Player("TestName", CLAN_OF_SAAR, GREEN);
        Player player2 = new Player("TestName", CLAN_OF_SAAR, BLACK);

        assertNotEquals(player1, player2);
    }
}
