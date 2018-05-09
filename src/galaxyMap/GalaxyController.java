package galaxyMap;

import player.Player;
import player.PlayerColor;
import player.Race;
import units.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static galaxyMap.NeighborDirection.*;
import static player.PlayerColor.BLUE;
import static player.PlayerColor.RED;
import static player.Race.EMIRATES_OF_HACAN;
import static player.Race.FEDERATION_OF_SOL;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* This class incapsulates methods used for generating galaxies.
 * The class is final as there should never be subclasses of this class
 * As there is no reason to create a object of this class methods are static
 * The private methods are help functions for other methods and are not meant to be used outside this class */
public final class GalaxyController {
    /* Method used to create the galaxy described in problem 7 */
    public static Galaxy createProblem7Galaxy() {
        //Creates a list for all players in the galaxy
        List<Player> allPlayers = new ArrayList<>();

        //Creates the Players
        Player playerCrassus = new Player("Crassus", EMIRATES_OF_HACAN, BLUE);
        Player playerPompey = new Player("Pompey", FEDERATION_OF_SOL, RED);

        //Adds players to the list of all players
        allPlayers.add(playerCrassus);
        allPlayers.add(playerPompey);

        //Creates the ships for playerCrassus
        Dreadnought dreadnoughtCrassus1 = new Dreadnought(playerCrassus);
        Dreadnought dreadnoughtCrassus2 = new Dreadnought(playerCrassus);
        Destroyer destroyerCrassus1 = new Destroyer(playerCrassus);

        //Creates a list containing Crassus' ships
        List<Unit> crassusShips = new ArrayList<>();
        crassusShips.add(dreadnoughtCrassus1);
        crassusShips.add(dreadnoughtCrassus2);
        crassusShips.add(destroyerCrassus1);

        //Creates the ships for playerPompey
        Cruiser cruiserPompey1 = new Cruiser(playerPompey);
        Cruiser cruiserPompey2 = new Cruiser(playerPompey);
        Carrier carrierPompey1 = new Carrier(playerPompey);

        //Creates a list containing Pompey's ships
        List<Unit> pompeyShips = new ArrayList<>();
        pompeyShips.add(carrierPompey1);
        pompeyShips.add(cruiserPompey1);
        pompeyShips.add(cruiserPompey2);

        //Creates the center system with Mecatol Rex
        Planet mecatol = new Planet("Mecatol Rex", 1);
        SolarSystem centerSystem = new SolarSystem(new ArrayList<>(Arrays.asList(mecatol)), crassusShips);

        //Creates the northern system with Vega Minor and Vega Major
        Planet vegaMinor = new Planet("Vega Minor", 0);
        Planet vegaMajor = new Planet("Vega Major", 1);
        SolarSystem northSystem = new SolarSystem(new ArrayList<>(Arrays.asList(vegaMajor, vegaMinor)), pompeyShips);

        //Creates northeastern empty system
        SolarSystem northEastSystem = new SolarSystem(new ArrayList<>(), new ArrayList<>());

        //Creates the southeastern system with Industrex
        Planet industrex = new Planet("Industrex", 4);
        SolarSystem southEastSystem = new SolarSystem(Arrays.asList(industrex), new ArrayList<>());

        // Creates the southern system with Rigel I and Rigel II
        Planet rigel1 = new Planet("Rigel I", 3);
        Planet rigel2 = new Planet("Rigel II", 1);
        SolarSystem southSystem = new SolarSystem(Arrays.asList(rigel1, rigel2), new ArrayList<>());

        //Creates the southwestern empty system
        SolarSystem southWestSystem = new SolarSystem(new ArrayList<>(), new ArrayList<>());

        //Creates the northwestern system with Mirage
        Planet mirage = new Planet("Mirage", 0);
        SolarSystem northWestSystem = new SolarSystem(Arrays.asList(mirage), new ArrayList<>());

        //Set neighbors for center system
        centerSystem.addNeighbor(NORTH, northSystem);
        centerSystem.addNeighbor(NORTH_EAST, northEastSystem);
        centerSystem.addNeighbor(SOUTH_EAST, southEastSystem);
        centerSystem.addNeighbor(SOUTH, southSystem);
        centerSystem.addNeighbor(SOUTH_WEST, southWestSystem);
        centerSystem.addNeighbor(NORTH_WEST, northWestSystem);

        //Set remaining neighbor for north system
        northSystem.addNeighbor(SOUTH_EAST, northEastSystem);
        northSystem.addNeighbor(SOUTH_WEST, northWestSystem);

        //Set remaining neighbors for north east system
        northEastSystem.addNeighbor(SOUTH, southEastSystem);

        //Set remaining neighbors for south east system
        southWestSystem.addNeighbor(SOUTH_WEST, southSystem);

        //Set remaining neighbors for south system
        southSystem.addNeighbor(NORTH_WEST, southWestSystem);

        //Set remaining neighbors for south west system
        southWestSystem.addNeighbor(NORTH, northWestSystem);

        return new Galaxy(allPlayers, centerSystem);
    }

    /* Method used to create a random galaxy
     * The galaxy has between 2 and 6 players and 7 systems
     * The outer systems have between 0 and 3 randomly generated planets
     * Players are not guaranteed to own a system with a planet.
     * All systems in the galaxy apart from the center system could potentially not have any planets */
    public static Galaxy createRandomGalaxy() {
        Random random = new Random();
        //Determines the number of players for the galaxy, number of players is between 2 and 6
        int numberOfPlayers = random.nextInt(5) + 2;
        //Creates a list with all the players in the galaxy
        List<Player> allPlayers = createPlayers(numberOfPlayers);

        //Creates the center system
        Planet mecatol = new Planet("Mecatol Rex", 1);
        SolarSystem centerSystem = new SolarSystem(new ArrayList<>(Arrays.asList(mecatol)), new ArrayList<>());

        //Creates the 6 remaining systems
        SolarSystem northSystem = new SolarSystem(createPlanets(random.nextInt(4), "Terminus"),
                new ArrayList<>());

        SolarSystem northEastSystem = new SolarSystem(createPlanets(random.nextInt(4), "Rigel"),
                new ArrayList<>());

        SolarSystem southEastSystem = new SolarSystem(createPlanets(random.nextInt(4), "Merkal"),
                new ArrayList<>());

        SolarSystem southSystem = new SolarSystem(createPlanets(random.nextInt(4), "Corpal"),
                new ArrayList<>());

        SolarSystem southWestSystem = new SolarSystem(createPlanets(random.nextInt(4), "Meka"),
                new ArrayList<>());

        SolarSystem northWestSystem = new SolarSystem(createPlanets(random.nextInt(4), "Heings"),
                new ArrayList<>());

        //Set neighbors for center system
        centerSystem.addNeighbor(NORTH, northSystem);
        centerSystem.addNeighbor(NORTH_EAST, northEastSystem);
        centerSystem.addNeighbor(SOUTH_EAST, southEastSystem);
        centerSystem.addNeighbor(SOUTH, southSystem);
        centerSystem.addNeighbor(SOUTH_WEST, southWestSystem);
        centerSystem.addNeighbor(NORTH_WEST, northWestSystem);

        //Set remaining neighbor for north system
        northSystem.addNeighbor(SOUTH_EAST, northEastSystem);
        northSystem.addNeighbor(SOUTH_WEST, northWestSystem);

        //Set remaining neighbors for north east system
        northEastSystem.addNeighbor(SOUTH, southEastSystem);

        //Set remaining neighbors for south east system
        southWestSystem.addNeighbor(SOUTH_WEST, southSystem);

        //Set remaining neighbors for south system
        southSystem.addNeighbor(NORTH_WEST, southWestSystem);

        //Set remaining neighbors for south west system
        southWestSystem.addNeighbor(NORTH, northWestSystem);

        //Creates the galaxy
        Galaxy galaxy = new Galaxy(allPlayers, centerSystem);
        //Creates an iterator for all planets
        Iterator<SolarSystem> systemIter = galaxy.getAllSystems().iterator();

        /* Goes through all players and adds a cruiser and a destroyer to a system in the galaxy
         * there are a maximum of 6 players and a minimum of 7 systems
         * so the loop will finish before the are no more systems */
        for (Player player : allPlayers) {
            SolarSystem system = systemIter.next();

            Destroyer destroyer = new Destroyer(player);
            Cruiser cruiser = new Cruiser(player);

            system.addShip(destroyer);
            system.addShip(cruiser);
        }

        return galaxy;
    }

    /* Method used to determine legality of a galaxy.
     * Parameter myGalaxy: The galaxy to be tested for legality
     * Return: true if galaxy is legal, return false if galaxy is not legal */
    public static boolean isGalaxyLegal(Galaxy galaxy) {
        //Creates a list of all planets that have been found in previous systems
        List<Planet> planetsInOtherSystems = new ArrayList<>();

        //Loop iterates through all systems in the galaxy
        for (SolarSystem system : galaxy.getAllSystems()) {

            //Checks the if the system is the center system, if yes check if the system the legal center system
            if (system.isCenterSystem() && !centerSystemIsLegal(system)) {
                //If the system does is not the legal center system, return false
                return false;
            }

            //Checks all planets in a system to see if they are elsewhere
            if (twoInstancesOfPlanet(system, planetsInOtherSystems)) {
                //If a planet is in other systems, return false
                return false;
            }

            /* Check that there is at most 3 planets in a system.
             * This check is redundant as a SolarSystem's constructor ensure a max of 3 planets
             * This has been added as the assignment requires it */
            if (system.getPlanets().size() > 3) {
                //If there are more than 3 planets, return false
                return false;
            }

            //Checks all system neighbors to see if they are properly adjacent to each other
            if (invalidNeighbors(system)) {
                //If neighbors are not properly adjacent, return false
                return false;
            }

            //Adds all planets in the system to planetsInOtherSystems
            planetsInOtherSystems.addAll(system.getPlanets());
        }

        //If galaxy is legal, return true
        return true;
    }

    /* Method used to generate a list of players
     * Parameter numberOfPlayers: number of players to be generated,
     * if numberOfPlayers is larger than 6 it is set to 6 as there is a maximum of 6 players in a game
     * Return: a list of Players
     * This method is public as a situation might occur where it would make sense to use this method outside the class */
    public static List<Player> createPlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<>();
        Random random = new Random();

        //If numberOfPlayers is larger than 6
        if (numberOfPlayers > 6) {
            //Set numberOfPlayers to 6
            numberOfPlayers = 6;
        }

        //Creates a number of players equals to numberOfPlayers and adds them to th list of players to return.
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = "Player " + i;

            players.add(new Player(playerName, Race.getRace(random.nextInt(16)),
                    PlayerColor.getPlayerColor(i - 1)));

        }

        //Returns list of players
        return players;
    }


    /* Method used to generate a list of planets
     * Parameter numberOfPlanets: number of planets to be generated,
     * if numberOfPlanets is larger than 3 it is set to 3
     * Return: a list of Planets
     * This method is public as a situation might occur where it would make sense to use this outside this class */
    public static List<Planet> createPlanets(int numberOfPlanets, String planetPrefix) {
        List<Planet> planets = new ArrayList<>();
        Random random = new Random();

        //If number of planets is larger than 3
        if (numberOfPlanets > 3) {
            //Set numberOfPlanets to 3
            numberOfPlanets = 3;
        }

        //Creates a number of planets equals to numberOfPlanets and adds them to th list of planets to return.
        for (int i = 1; i <= numberOfPlanets; i++) {
            String planetName = planetPrefix + " " + i;

            planets.add(new Planet(planetName, random.nextInt(7)));
        }

        //Returns a list of planets
        return planets;
    }

    /* Method used to write a list of players and the planets they control in the galaxy to a file
     * Parameter galaxy: the galaxy from where the list of players is based
     * Throws IOException */
    public static void writePlayerList(Galaxy galaxy) throws IOException {
        //Path for saving the file
        String path = "PlayerList.txt";

        //Gets all players in the galaxy
        List<Player> allPlayers = galaxy.getAllPlayers();
        //Gets all systems in the galaxy
        Set<SolarSystem> allSystems = galaxy.getAllSystems();

        //Creates a buffered writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            //Loop that goes through all players in the galaxy
            for (Player player : allPlayers) {
                //Write the player to file
                writer.write(player.toString());
                writer.newLine();

                //Creates a list for all planet controlled by the player
                List<Planet> playerControlledPlanets = new ArrayList<>();

                //Goes through all systems in the galaxy
                for (SolarSystem system : allSystems) {
                    //Checks if the player controls the system
                    if (system.playerInControl() != null && system.playerInControl().equals(player)) {
                        //adds planets in the system to playerControlledPlanets
                        playerControlledPlanets.addAll(system.getPlanets());
                    }

                }

                //Goes through all planets controlled by player
                for (Planet playerPlanet : playerControlledPlanets) {
                    //Writes the planets to file
                    writer.write("\t" + playerPlanet.toString());
                    writer.newLine();
                }

                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /* Method used to determine whether center system is legal
     * For the center system to be legel it must contain a planet with the name of "Mecatol Rex"
     * and resource production of 1
     * Parameter centerSystem: The center system of the galaxy. Assumes centerSystem is the center system in galaxy
     * Return: true if the system is correct, false if the system is incorrect */
    private static boolean centerSystemIsLegal(SolarSystem centerSystem) {
        //The "Mecatol Rex" planet that the system needs to be legal
        Planet mecatol = new Planet("Mecatol Rex", 1);

        //Checks if the system has "Mecatol Rex" as the only planet
        if (!centerSystem.getPlanets().equals(new ArrayList<>(Arrays.asList(mecatol)))) {
            //If false return false
            return false;
        }

        //If center system is legal return true
        return true;
    }

    /* Method used to determine if a system has planets that is used in other systems
     * Parameter system: the system to check
     * Parameter planetsInOtherSystems: a list of planets used in other systems
     * Return: true if there are two instances of the same planet, false if there are no repeat planets */
    private static boolean twoInstancesOfPlanet(SolarSystem system, List<Planet> planetsInOtherSystems) {
        //Goes through all planets in the system
        for (int i = 0; i < system.getPlanets().size(); i++) {
            //Checks if a planet is found in planetInOtherSystems
            if (planetsInOtherSystems.contains(system.getPlanets().get(i))) {
                //If there is a repeat planet return true
                return true;
            }
        }

        //If there is no repeat planet return false
        return false;
    }

    /* Method used to check if a system has invalid neighbors
     * If system A is to the north of System B then system B must be to the north of system A.
     * The same goes for the other directions
     * Parameter system: the system to check
     * Return: true if there are invalid neighbors, false if all neighbors are valid */
    private static boolean invalidNeighbors(SolarSystem system) {
        //Iterator used to test all neighbors
        Iterator<SolarSystem> neighborsIter = system.getNeighbors().iterator();

        //Goes through all neighbors of system
        for (int i = 0; neighborsIter.hasNext(); i++) {
            //Sets neighbor to the next neighbor to test
            SolarSystem neighbor = neighborsIter.next();

            //Checks if neighbor is null
            if (neighbor != null) {
                //Checks whether this systems north neighbor has this system as the south neighbor and vice versa
                if (neighbor.getNeighbor(NeighborDirection.getDirection(i).getOppositeDirection()) != system) {
                    //If neighbors aren't valid return true
                    return true;
                }
            }
        }

        //If all neighbors are valid return false
        return false;
    }
}
