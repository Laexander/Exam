package galaxyMap;

import myExceptions.HasNeighborException;
import myExceptions.TooManyPlanetsException;
import myExceptions.TooManyPlayersInSystemException;
import player.Player;
import units.ResourceCostComparator;
import units.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The SolarSystem class is a representation of a system in the game Twilight Imperium.
 * A SolarSystem has a list of planets in the SolarSystem with between 0 and 3 planets,
 * a list of all ships in the SolarSystem and a list of neighboring SolarSystems color.
 * In the list of neighboring SolarSystems each position represents the direction the neighboring SolarSystem is.
 * 0 is NORTH, 1 is NORTH_EAST, 2 is SOUTH_EAST, 3 is SOUTH, 4 is SOUTH_WEST, 5 is NORTH_WEST
 * This is done so every SolSystem know which other SolarSystems are bordering it.
 * This also means the Galaxy does not have a fixed size or shape. However it is inefficient for large galaxies. */
public class SolarSystem {
    //SolarSystem's list of Planets
    private List<Planet> planets = new ArrayList<>();
    //SolarSystem's list of Ships
    private List<Unit> ships = new ArrayList<>();
    //SolarSystem's list of bordering SolarSystems
    private List<SolarSystem> neighbors = new ArrayList<>();

    private boolean isCenterSystem;

    /* Constructor for SolarSystem
     * Parameter planets: List of planets in the SolarSystem
     * Parameter ships: List of ships currently in the SolarSystem
     * Throws TooManyPlanetsException if there are more than three planets */
    public SolarSystem(List<Planet> planets, List<Unit> ships) throws TooManyPlanetsException {
        this.ships = ships;
        this.isCenterSystem = false;

        //Ensure that planets does not exceed 3, if it does throws TooManyPlanetsException()
        if (planets.size() <= 3) {
            this.planets = planets;
        } else {
            throw new TooManyPlanetsException("A SolarSystem cannot contain more than 3 planets");
        }

        //Creates a empty list, so that neighbors can be added to the right positions later
        for (int i = 0; i < 6; i++) {
            this.neighbors.add(null);
        }
    }

    /* Method used to add a neighboring SolarSystem to this SolarSystem
     * Parameter direction: The direction in which the SolarSystem is found
     * Parameter newNeighbor: The new neighboring SolarSystem
     * Throws HasNeighborException if there is a neighbor at given direction */
    public void addNeighbor(NeighborDirection direction, SolarSystem newNeighbor) throws HasNeighborException {
        //If there are no neighbor in the direction of newNeighbor
        if (getNeighbor(direction) == null) {
            //If there are no neighbor where this system should be
            if (newNeighbor.getNeighbor(direction.getOppositeDirection()) == null) {
                //Remove null and add neighbor
                neighbors.remove(direction.getIndex());
                neighbors.add(direction.getIndex(), newNeighbor);

                //Adds this system as neighbor in the opposite direction to newNeighbor
                newNeighbor.addNeighborHelpMethod(direction.getOppositeDirection(), this);
            }
        } else {
            throw new HasNeighborException("This system already has a neighbor in this direction");
        }
    }

    /* A help method for addNeighbor
     * Parameter direction: direction that neighbor should be added
     * Parameter originalSystem: the system to be added as a neighbor */
    public void addNeighborHelpMethod(NeighborDirection direction, SolarSystem originalSystem) {
        this.neighbors.remove(direction.getIndex());
        this.neighbors.add(direction.getIndex(), originalSystem);
    }

    /* Method for returning SolarSystem in given direction
     * Parameter direction: The direction of the SolarSystem to return
     * Return: Neighboring SolarSystem in given direction, can return null */
    public SolarSystem getNeighbor(NeighborDirection direction) {
        return neighbors.get(direction.getIndex());
    }

    //Returns a copy of the list of neighboring SolarSystems
    public List<SolarSystem> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    /* Returns a copy of the list of current ships in the SolarSystem.
     * This stops accidental changes to ships through this method */
    public List<Unit> getShips() {
        return new ArrayList<>(ships);
    }

    /* Method to add incoming ships to the list of ships in SolarSystem
     * Parameter ship: Ship to add to list of current ships in SolarSystem */
    public void addShip(Unit ship) {
        ships.add(ship);
    }

    /* Method to remove outgoing ships from the list of ships current ships in SolarSystem
     * Parameter ship: Ship that leaves the SolarSystem*/
    public void removeShip(Unit ship) {
        ships.remove(ship);
    }

    /* Method for handling ship combat in a system
     * Ship combat happens when there are ships from 2 and only 2 different players.
     * Return: if combat happened and there was a winner returns that player,
     * if there was no combat or both players lost all their ships return null
     * Throws: TooManyPlayersInSystemException if there are ships from more than 2 different players */
    public Player shipCombat() {
        //Checks id there is ships in the system
        if (!ships.isEmpty()) {
            //Creates lists for each players ships
            List<Unit> player1Ships = new ArrayList<>();
            List<Unit> player2Ships = new ArrayList<>();

            /* Sorts the ships so the lowest resource cost ships are first in the list
             * This is important for when ships are being destroyed,
             * as the ships has to be removed starting with the lowest resource cost first
             * It is done here to avoid sorting the ships multiple times */
            ships.sort(new ResourceCostComparator());

            //Sets player 1 to the owner of the first ship in the list
            Player player1 = ships.get(0).getOwner();
            //Sets player 2 to null
            Player player2 = null;

            //Goes through all ships involved in combat
            for (Unit ship : ships) {
                //If ship belongs to player 1
                if (ship.getOwner().equals(player1)) {
                    //Add ship to player1Ships
                    player1Ships.add(ship);
                }
                //If player 2 is null
                else if (player2 == null) {
                    //Sets player 2 to owner of the ship and adds ship to player2Ships
                    player2 = ship.getOwner();
                    player2Ships.add(ship);
                }
                //If ship belongs to player 2
                else if (ship.getOwner().equals(player2)) {
                    //Add ship to player2Ships
                    player2Ships.add(ship);
                }
                //If there are more than 2 players
                else {
                    //Throw TooManyPlayersInSystemException
                    throw new TooManyPlayersInSystemException("There are ships from 3 or more players in this system");
                }
            }

            //Creates a random to use as a die
            Random random = new Random();

            //As long as there are ships from both players in the system continue combat
            while (!player1Ships.isEmpty() && !player2Ships.isEmpty()) {
                //Number of hits landed by player 1
                int player1Hits = 0;
                //Goes through all player 1 ships
                for (Unit ship : player1Ships) {
                    //Rolls a 10 sided die, if the die is higher than ship's combat value
                    if (random.nextInt(10) + 1 >= ship.getCombatValue()) {
                        //Player 1 lands a hit
                        player1Hits++;
                    }
                }

                //Number of hits landed by player 2
                int player2Hits = 0;
                //Goes through all player 2 ships
                for (Unit ship : player2Ships) {
                    //Rolls a 10 sided die, if the die is higher than ship's combat value
                    if (random.nextInt(10) + 1 >= ship.getCombatValue()) {
                        //Player 2 lands a hit
                        player2Hits++;
                    }
                }

                /* Destroys ships belonging to player 2 equals to number of hits landed by player 1
                 * or until there are no more ships belonging to player 2 */
                while (player1Hits > 0 && !player2Ships.isEmpty()) {
                    ships.remove(player2Ships.get(0));
                    player2Ships.remove(0);
                    player1Hits--;
                }

                /* Destroys ships belonging to player 1 equals to number of hits landed by player 2
                 * or until there are no more ships belonging to player 1 */
                while (player2Hits > 0 && !player1Ships.isEmpty()) {
                    ships.remove(player1Ships.get(0));
                    player1Ships.remove(0);
                    player2Hits--;
                }
            }

            //If no player has any ships left in the system
            if (player1Ships.isEmpty() && player2Ships.isEmpty()) {
                //Return null
                return null;
            }
            //If only player 1 has ships in the system
            else if (player2Ships.isEmpty()) {
                //Return player 1
                return player1;
            }
            //If only player 2 has ships in the system
            else {
                //Return player 2
                return player2;
            }
        }

        //If there was no ships in the system return null
        return null;
    }

    //Returns a list of Planets in the SolarSystem
    public List<Planet> getPlanets() {
        return planets;
    }

    /* Method for determining the player in control of the system
     * Return: if no player is in control of the system returns null, otherwise returns player in control */
    public Player playerInControl() {
        //Check if there are ships in the system
        if (ships.size() == 0) {
            //If not return null
            return null;
        }

        //Gets player in control of a ship in the system
        Player player = ships.get(0).getOwner();

        //Goes through all ships in system and checks if the same player controls them all
        for (Unit ship : ships) {
            //Check if the ships owner are the same
            if (!ship.getOwner().equals(player)) {
                //If not return null
                return null;
            }
        }

        //Return player
        return player;
    }

    //Returns isCenterSystem
    public boolean isCenterSystem() {
        return isCenterSystem;
    }

    //Sets isCenterSystem to isCenterSystem
    public void setIsCenterSystem(boolean isCenterSystem) {
        this.isCenterSystem = isCenterSystem;
    }
}
