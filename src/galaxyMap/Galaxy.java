package galaxyMap;

import player.Player;
import units.ShipComparator;
import units.Unit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The Galaxy class a representation of a galaxy in Twilight Imperium
 * A Galaxy has a set with a span of all the systems in the galaxy
 * There is no field containing all ships in the galaxy, as the number of ships could change very often */
public class Galaxy {
    //A list of all players in the galaxy
    private List<Player> allPlayers = new ArrayList<>();
    /* A set of all systems in the galaxy
     * This is a set, as there can be no duplicates in a set */
    private Set<SolarSystem> allSystems = new HashSet<>();
    //A list of all planets in the galaxy
    private List<Planet> allPlanets = new ArrayList<>();

    //Constructor for Galaxy
    public Galaxy(List<Player> allPlayers, SolarSystem solarSystem) {
        this.allPlayers = allPlayers;

        //Boolean used to determine if a system was added
        boolean addedSystem;
        //A set used to store a temporary copy of allSystems to use for an iterator
        Set<SolarSystem> tempSystems = new HashSet<>();

        //Sets solarSystem to be center system
        solarSystem.setIsCenterSystem(true);
        allSystems.add(solarSystem);

        /* The loop adds all neighboring systems to systems in the set tempSystems.
         * Loop continues to run as long as new systems ar added to */
        do {
            addedSystem = false;
            //Adds new systems to tempSystems
            tempSystems.addAll(allSystems);

            //Uses tempSystems to make a iterator
            for (SolarSystem system : tempSystems) {
                //Checks for null
                if (system != null) {
                    //Adds new systems
                    if (allSystems.addAll((system.getNeighbors()))) {
                        //If new systems were added set addedSystems to true
                        addedSystem = true;
                    }
                }
            }

        } while (addedSystem);

        //Remove null from allSystems
        allSystems.remove(null);

        //Goes through all systems and adds their planet to the list of all planets
        for (SolarSystem system : allSystems) {
            allPlanets.addAll(system.getPlanets());
        }

    }

    //Returns a copy of the list of all players in the galaxy
    public List<Player> getAllPlayers() {
        return new ArrayList<>(allPlayers);
    }

    //Returns a copy of the set of all systems in the galaxy
    public Set<SolarSystem> getAllSystems() {
        return new HashSet<>(allSystems);
    }

    //Returns a copy of the list of all planets
    public List<Planet> getAllPlanets() {
        return new ArrayList<>(allPlanets);
    }

    //Finds all ships in the galaxy, adds them to a list and returns the list
    public List<Unit> getAllShips() {
        List<Unit> allShips = new ArrayList<>();

        //Goes through all systems and adds their ships to the list
        for (SolarSystem system : allSystems) {
            allShips.addAll(system.getShips());
        }

        return allShips;
    }

    /* Method used to find all ships belonging to a specific player
     * The list of ships returned are sorted based on combat value then resource cost
     * The ships with lower combat value comes first, if same combat value then the ship with higher resource cost
     * Parameter player: The player whose ships to return
     * Return: A sorted list of ships belonging to player */
    public List<Unit> findPlayerShips(Player player) {
        List<Unit> playerShips = new ArrayList<>();
        //Comparator to compare ships, sorts by combat value the resource cost
        ShipComparator shipComparator = new ShipComparator();

        //Goes through all ships and adds the ships belonging to player to the list playerShips
        for (Unit ship : this.getAllShips()) {
            if (ship.getOwner().getName().compareTo(player.getName()) == 0) {
                playerShips.add(ship);
            }
        }

        //Sorts the list playerShips
        playerShips.sort(shipComparator);

        return playerShips;
    }
}
