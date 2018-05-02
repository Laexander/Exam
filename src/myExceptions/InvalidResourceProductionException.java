package myExceptions;

/* Exception used when a planet's resource production isn't between 0 and 6 */
public class InvalidResourceProductionException extends RuntimeException
{
    public InvalidResourceProductionException()
    {
        super("Resource Production must be between 0 and 6");
    }
}
