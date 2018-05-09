package myExceptions;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Exception used when there are too many players in a system
public class TooManyPlayersInSystemException extends RuntimeException {
    public TooManyPlayersInSystemException(String message) {
        super(message);
    }
}
