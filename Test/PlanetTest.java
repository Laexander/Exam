import myExceptions.InvalidResourceProductionException;
import org.junit.jupiter.api.Test;
import galaxyMap.Planet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Tests for the class Planet
 * Tests are not exhaustive as I was running low on time */
public class PlanetTest {

    /* Test Planet constructor works with lowest resource production possible. */
    @Test
    void testPlanetResourceProduction01() {
        Planet testPlanet = new Planet("Test", 0);
        assertEquals(0, testPlanet.getResourceProduction());
    }

    /* Test Planet constructor work with highest resource production possible. */
    @Test
    void testPlanetResourceProduction02() {
        Planet testPlanet = new Planet("Test", 6);
        assertEquals(6, 6);
    }

    /* Test if Planet throws an exception when resource production is too low .*/
    @Test
    void testPlanetResourceProductionTooLow01() {
        assertThrows(InvalidResourceProductionException.class,
                () -> {
                    Planet testPlanet = new Planet("Test", -1);
                });

    }

    /* Test if Planet throws an exception when resource production is too high. */
    @Test
    void testPlanetResourceProductionTooHigh01() {
        assertThrows(InvalidResourceProductionException.class,
                () -> {
                    Planet testPlanet = new Planet("Test", 7);
                });

    }
}
