package myExeptions;

public class InvalidResourceProductionException extends RuntimeException
{
    public InvalidResourceProductionException()
    {
        super("Resource Production must be between 0 and 6");
    }
}
