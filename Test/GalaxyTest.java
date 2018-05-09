import galaxyMap.Galaxy;
import galaxyMap.GalaxyController;
import galaxyMap.Planet;
import galaxyMap.SolarSystem;
import org.junit.jupiter.api.Test;
import player.Player;
import units.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static galaxyMap.NeighborDirection.NORTH;
import static galaxyMap.NeighborDirection.NORTH_EAST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static player.PlayerColor.BLUE;
import static player.PlayerColor.GREEN;
import static player.Race.BARONY_OF_LETNEV;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Tests for the class Galaxy
 * Tests are not exhaustive as I was running low on time */
public class GalaxyTest {

    /* Method to create a new SolarSystem with a given number of planets
     * Parameter numberOfPlanets: Number of Planets the SolarSystem has
     * Return: SolarSystem with number if planets equals to numberOfPlanets*/
    private SolarSystem createTestSolarSystem(int numberOfPlanets) {
        List<Planet> planets = new ArrayList<>();
        List<Unit> ships = new ArrayList<>();

        for (int i = 0; i < numberOfPlanets; i++) {
            planets.add(new Planet("PlanetName", 0));
        }

        return new SolarSystem(planets, ships);
    }

    /* Test that getAllPlanets returns the correct number of planets */
    @Test
    void testGetAllPlanets01() {
        SolarSystem system1 = createTestSolarSystem(2);
        SolarSystem system2 = createTestSolarSystem(0);
        SolarSystem system3 = createTestSolarSystem(3);

        system1.addNeighbor(NORTH_EAST, system2);
        system2.addNeighbor(NORTH, system3);

        Galaxy testGalaxy = new Galaxy(new ArrayList<>(), system1);

        assertEquals(5, testGalaxy.getAllPlanets().size());
    }

    /* Test that getAllShips return the correct number of ships */
    @Test
    void testGetAllShips01() {
        Player player1 = new Player("testPlayer1", BARONY_OF_LETNEV, GREEN);
        Player player2 = new Player("testPlayer2", BARONY_OF_LETNEV, BLUE);

        SolarSystem system1 = createTestSolarSystem(2);
        SolarSystem system2 = createTestSolarSystem(0);

        system1.addNeighbor(NORTH, system2);

        system1.addShip(new Carrier(player1));
        system1.addShip(new Cruiser(player1));
        system2.addShip((new Dreadnought(player2)));

        Galaxy testGalaxy = new Galaxy(new ArrayList<>(Arrays.asList(player1, player2)), system1);

        assertEquals(3, testGalaxy.getAllShips().size());
    }

    //Test that findPlayerShips returns the correct players ships
    @Test
    void testFindPlayerShips() {
        Galaxy testGalaxy = GalaxyController.createRandomGalaxy();
        Player testPlayer = testGalaxy.getAllPlayers().get(0);

        List<Unit> expectedShips = new ArrayList<Unit>(Arrays.asList(new Destroyer(testPlayer), new Cruiser(testPlayer)));
        List<Unit> testShips = testGalaxy.findPlayerShips(testPlayer);

        ShipComparator comparator = new ShipComparator();
        expectedShips.sort(comparator);
        testShips.sort(comparator);

        assertEquals(expectedShips, testShips);
    }
}
