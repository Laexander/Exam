package myExceptions;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//An exception used if a SolarSystem already has a neighbor at given direction
public class HasNeighborException extends RuntimeException {
    public HasNeighborException(String message) {
        super(message);
    }
}
