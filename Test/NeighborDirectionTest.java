import galaxyMap.NeighborDirection;
import org.junit.jupiter.api.Test;

import static galaxyMap.NeighborDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* Tests for the enum NeighborDirection
 * Tests are not exhaustive as I was running low on time */
public class NeighborDirectionTest {
    //Test that get direction returns the right NeighborDirection
    @Test
    void testGetDirection01() {
        assertEquals(NORTH, NeighborDirection.getDirection(0));
    }

    //Test that get direction returns the right NeighborDirection
    @Test
    void testGetDirection02() {
        assertEquals(SOUTH, NeighborDirection.getDirection(3));
    }

    //Test that getOppositeDirection returns the opposite direction
    @Test
    void testGetOppositeDirection01() {
        assertEquals(SOUTH, NORTH.getOppositeDirection());
    }

    //Test that getOppositeDirection returns the opposite direction
    @Test
    void testGetOppositeDirection02() {
        assertEquals(NORTH_EAST, SOUTH_WEST.getOppositeDirection());
    }
}
