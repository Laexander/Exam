import org.junit.jupiter.api.Test;
import player.Player;
import units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static player.PlayerColor.RED;
import static player.Race.BARONY_OF_LETNEV;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Tests for the class ResourceCostComparator
public class ResourceCostTest {

    //Test that compare function works correctly
    @Test
    void testCompare01() {
        Player player = new Player("Player", BARONY_OF_LETNEV, RED);
        List<Unit> testShips = new ArrayList<>(Arrays.asList(new Cruiser(player), new Destroyer(player),
                new Carrier(player), new Dreadnought(player)));
        List<Unit> expectedShips = new ArrayList<>(Arrays.asList(new Destroyer(player), new Cruiser(player),
                new Carrier(player), new Dreadnought(player)));

        ResourceCostComparator comparator = new ResourceCostComparator();
        testShips.sort(comparator);

        assertEquals(expectedShips, testShips);
    }
}
