package myExceptions;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Exception used when there are too many planets in a SolarSystem
public class TooManyPlanetsException extends RuntimeException {
    public TooManyPlanetsException(String message) {
        super(message);
    }
}
