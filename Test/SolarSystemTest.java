import galaxyMap.GalaxyController;
import galaxyMap.Planet;
import galaxyMap.SolarSystem;
import myExceptions.TooManyPlanetsException;
import org.junit.jupiter.api.Test;
import player.Player;
import units.Carrier;
import units.Cruiser;
import units.Destroyer;
import units.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static galaxyMap.NeighborDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static player.PlayerColor.GREEN;
import static player.Race.BARONY_OF_LETNEV;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Test for the class SolarSystem
 * The method shipCombat is not tested due to it's random nature
 * Tests are not exhaustive as I was running low on time */
public class SolarSystemTest {

    /* Method to create a new SolarSystem with a given number of planets
     * Parameter numberOfPlanets: Number of Planets the SolarSystem has
     * Return: SolarSystem with number if planets equals to numberOfPlanets*/
    SolarSystem createTestSolarSystem(int numberOfPlanets) {
        List<Planet> planets = new ArrayList<>();
        List<Unit> ships = new ArrayList<>();

        for (int i = 0; i < numberOfPlanets; i++) {
            planets.add(new Planet("PlanetName", 0));
        }

        return new SolarSystem(planets, ships);
    }

    /* Test SolarSystem can 3 planets */
    @Test
    void testNumberOfPlanets01() {
        SolarSystem solarSystem = createTestSolarSystem(3);
        assertEquals(3, solarSystem.getPlanets().size());
    }

    /* Test SolarSystem cannot have more than 3 Planets */
    @Test
    void testTooManyPlanets01() {
        assertThrows(TooManyPlanetsException.class,
                () -> {
                    SolarSystem solarSystem = createTestSolarSystem(4);
                });
    }

    /* Test that the list of neighbors is 6 long */
    @Test
    void testNeighborsList01() {
        SolarSystem solarSystem = createTestSolarSystem(0);
        assertEquals(6, solarSystem.getNeighbors().size());
    }

    /* Test addNeighbor adds systems to the right position i list */
    @Test
    void testAddNeighbor01() {
        SolarSystem solarSystem = createTestSolarSystem(0);
        SolarSystem neighborSystem = createTestSolarSystem(0);
        solarSystem.addNeighbor(NORTH_EAST, neighborSystem);
        assertEquals(neighborSystem, solarSystem.getNeighbor(NORTH_EAST));
    }

    /* Test that addNeighbor removes the correct null from list */
    @Test
    void testAddNeighbor02() {
        SolarSystem solarSystem = createTestSolarSystem(0);
        SolarSystem neighborSystem1 = createTestSolarSystem(0);
        SolarSystem neighborSystem2 = createTestSolarSystem(0);

        solarSystem.addNeighbor(NORTH, neighborSystem1);
        solarSystem.addNeighbor(SOUTH, neighborSystem2);

        List<SolarSystem> testSystems = new ArrayList<>(
                Arrays.asList(neighborSystem1, null, null, neighborSystem2, null, null)
        );

        assertEquals(testSystems, solarSystem.getNeighbors());
    }

    /* Test that addShip adds a ship to the list of current ships in SolarSystem */
    @Test
    void testShipEnters01() {
        SolarSystem solarSystem = createTestSolarSystem(0);
        List<Unit> ships = new ArrayList<>();
        Carrier testship = new Carrier(new Player("name", BARONY_OF_LETNEV, GREEN));

        solarSystem.addShip(testship);
        ships.add(testship);

        assertEquals(ships, solarSystem.getShips());
    }

    /* Test that removeShip removes the ship from the list of current ships in SolarSystem */
    @Test
    void testShipLeaves01() {
        Player testplayer = new Player("name", BARONY_OF_LETNEV, GREEN);
        Carrier testCarrier = new Carrier(testplayer);
        Cruiser testCruiser = new Cruiser(testplayer);
        List<Planet> planets = new ArrayList<>();
        List<Unit> ships = new ArrayList<>(
                Arrays.asList(testCarrier, testCruiser)
        );

        SolarSystem solarSystem = new SolarSystem(planets, ships);

        solarSystem.removeShip(testCarrier);
        ships.remove(testCarrier);

        assertEquals(ships, solarSystem.getShips());
    }

    //Test that playerInControl returns the correct player
    @Test
    void testPlayerInControl() {
        Player testPlayer = new Player("Test Player", BARONY_OF_LETNEV, GREEN);
        SolarSystem testSystem = new SolarSystem(GalaxyController.createPlanets(2, "Test"),
                new ArrayList<>());

        testSystem.addShip(new Destroyer(testPlayer));

        assertEquals(testPlayer, testSystem.playerInControl());
    }
}
