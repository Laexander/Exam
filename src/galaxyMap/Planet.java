package galaxyMap;

import myExceptions.InvalidResourceProductionException;

import java.util.Objects;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* The Planet class is a representation of a planet in the game Twilight Imperium
 * A Planet has a name and a resource production between 0 and 6. */
public class Planet {
    //Planet's name.
    private String name;
    //Planet's resource production.
    private int resourceProduction;

    /* Constructor for Planet
     * Parameter name: The name of Planet
     * Parameter resourceProduction: The resource production of Planet
     * Throws InvalidResourceProductionException if resource production isn't between 0 and 6 */
    public Planet(String name, int resourceProduction) throws InvalidResourceProductionException {
        this.name = name;

        //Ensures that resource production is between 0 and 6, if not throws InvalidResourceProductionException.
        if (resourceProduction <= 6 && resourceProduction >= 0) {
            this.resourceProduction = resourceProduction;
        } else {
            throw new InvalidResourceProductionException("Resource Production must be between 0 and 6");
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

    /* Method used to determine equality of planets.
     * Planets are equals if name and resource production are the same
     * Parameter o: Other object to be compared to this object
     * Return: True if equals, false if not. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return getResourceProduction() == planet.getResourceProduction() &&
                Objects.equals(getName(), planet.getName());
    }

    /* Method used to generate hashcode value for Planet
     * Hashcode uses name and resource production
     * Return: hashcode of object*/
    @Override
    public int hashCode() {

        return Objects.hash(getName(), getResourceProduction());
    }

    /* Method used to return a string representation of the class and its fields
     * Return: String representation of Planet */
    @Override
    public String toString() {
        return name;
    }
}
