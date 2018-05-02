package planets;

import myExeptions.InvalidResourceProductionException;

public class Planet
{
    private String name;
    private int resourceProduction;

    public Planet(String name, int resourceProduction) {
        this.name = name;

        if (resourceProduction <= 6) {
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
