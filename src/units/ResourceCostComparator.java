package units;

import java.util.Comparator;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* ResourceCostComparator is a comparator used to sort implementations of Unit by their resource cost*/
public class ResourceCostComparator implements Comparator<Unit> {

    /* The list of ships are sorted based resource cost
     * The ships with the lower resource cost comes first*/
    @Override
    public int compare(Unit o1, Unit o2) {
        //Returns compared resource cost
        return Integer.compare(o1.getResourceCost(), o2.getResourceCost());
    }
}
