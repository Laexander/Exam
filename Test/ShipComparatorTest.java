import org.junit.jupiter.api.Test;
import player.Player;
import units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static player.PlayerColor.RED;
import static player.Race.BARONY_OF_LETNEV;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Tests for the class ShipComparator
public class ShipComparatorTest {

    //Test that compare function works correctly
    @Test
    void testCompare01() {
        Player player = new Player("Player", BARONY_OF_LETNEV, RED);
        List<Unit> testShips = new ArrayList<>(Arrays.asList(new Cruiser(player), new Destroyer(player),
                new Carrier(player), new Dreadnought(player)));
        List<Unit> expectedShips = new ArrayList<>(Arrays.asList(new Dreadnought(player), new Cruiser(player),
                new Carrier(player), new Destroyer(player)));

        ShipComparator comparator = new ShipComparator();
        testShips.sort(comparator);

        assertEquals(expectedShips, testShips);
    }
}
