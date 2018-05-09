package myExceptions;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Exception used when a planet's resource production isn't between 0 and 6
public class InvalidResourceProductionException extends RuntimeException {
    public InvalidResourceProductionException(String message) {
        super(message);
    }
}
