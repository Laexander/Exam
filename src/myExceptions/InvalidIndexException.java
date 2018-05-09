package myExceptions;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

//Exception used when the index given is not valid (Used in enums).
public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException(String message) {
        super(message);
    }
}
