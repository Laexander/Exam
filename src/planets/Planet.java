package planets;

import myExceptions.InvalidResourceProductionException;

/* The Planet class is a representation of a planet in the game Twilight Imperium
 * A Planet has a name and a resource production between 0 and 6. */
public class Planet
{
    // Planet name.
    private String name;
    // Planet resource production.
    private int resourceProduction;

    // Planet constructor
    public Planet(String name, int resourceProduction) {
        this.name = name;

        // Ensures that resource production is between 0 and 6, if not throws InvalidResourceProductionException.
        if (resourceProduction <= 6 && resourceProduction >= 0) {
            this.resourceProduction = resourceProduction;
        }
        else
        {
            throw new InvalidResourceProductionException();
        }
    }

    //Returns name.
    public String getName() {
        return name;
    }

    //Returns resourceProduction.
    public int getResourceProduction() {
        return resourceProduction;
    }
}
