import galaxyMap.Galaxy;
import galaxyMap.GalaxyController;
import galaxyMap.Planet;
import galaxyMap.SolarSystem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static galaxyMap.NeighborDirection.NORTH;
import static galaxyMap.NeighborDirection.NORTH_EAST;
import static org.junit.jupiter.api.Assertions.*;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Tests for the class GalaxyController
 * Tests are not exhaustive as I was running low on time */
public class GalaxyControllerTest {
    //Test that the right number of players is created with createPlayers
    @Test
    void testCreatePlayers01() {
        assertEquals(4, GalaxyController.createPlayers(4).size());
    }

    //Test that the right number of planets is created with createPlanets
    @Test
    void testCreatePlanets() {
        assertEquals(3, GalaxyController.createPlanets(3, "Test").size());
    }

    //Test that when isGalaxyLegal is true when given a legal galaxy
    @Test
    void testIsGalaxyLegal01() {
        Planet mecatol = new Planet("Mecatol Rex", 1);
        SolarSystem centerSystem = new SolarSystem(new ArrayList<>(Arrays.asList(mecatol)), new ArrayList<>());

        SolarSystem outerSystem = new SolarSystem(GalaxyController.createPlanets(2, "Test"),
                new ArrayList<>());

        centerSystem.addNeighbor(NORTH, outerSystem);

        Galaxy testGalaxy = new Galaxy(new ArrayList<>(), centerSystem);

        assertTrue(GalaxyController.isGalaxyLegal(testGalaxy));
    }

    //Test that when isGalaxyLegal is false when given a illegal galaxy
    @Test
    void testIsGalaxyLegal02() {
        SolarSystem centerSystem = new SolarSystem(GalaxyController.createPlanets(3, "Bad"),
                new ArrayList<>());
        SolarSystem outerSystem = new SolarSystem(GalaxyController.createPlanets(1, "Test"),
                new ArrayList<>());

        centerSystem.addNeighbor(NORTH_EAST, outerSystem);

        Galaxy testGalaxy = new Galaxy(new ArrayList<>(), centerSystem);

        assertFalse(GalaxyController.isGalaxyLegal(testGalaxy));
    }
}
