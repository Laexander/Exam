package player;

import myExceptions.InvalidIndexException;

import java.util.HashMap;
import java.util.Map;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The enumeration Race represents the Race of a player.
 * There are 16 different races in the game.
 * As the 16 races are predefined, they are represented as an enumeration.
 * I have chosen to use underscore when separating words in the race names to increase readability. */
public enum Race {
    BARONY_OF_LETNEV(0), CLAN_OF_SAAR(1), EMIRATES_OF_HACAN(2), FEDERATION_OF_SOL(3), MENTAK_COALITION(4),
    NAALU_COLLECTIVE(5), NEKRO_VIRUS(6), SARDAKK_NORR(7), UNIVERSITIES_OF_JOL_NAR(8), XXCHA_KINGDOM(9),
    YSSARIL_TRIBES(10), BROTHERHOOD_OF_YIN(11), EMBERS_OF_MUAAT(12), GHOSTS_OF_CREUSS(13), L1Z1X_MINDNET(14), WINNU(15);

    //Variable to store index for each race.
    private int index;

    //A map to associate an int to a race
    private static Map<Integer, Race> raceMap = new HashMap<>();

    //Associates index to a race
    static {
        for (Race raceEnum : Race.values()) {
            raceMap.put(raceEnum.index, raceEnum);
        }
    }

    //Constructor for Race
    Race(int index) {
        this.index = index;
    }

    /* Returns the Race corresponding to the given index
     * Parameter index: an integer between 0 and 15 used to determine Race to return
     * Throws: invalidIndexException if in index is too high or too low */
    public static Race getRace(int index) throws InvalidIndexException {
        if (index >= 0 && index < 16) {
            return raceMap.get(index);
        } else {
            throw new InvalidIndexException("Invalid index for Race, index must be between 0 and 15");
        }
    }
}
