package units;

import java.util.Comparator;

//Name: Alexander Pugholm Jankowski,
//Mail: ajanko17@student.aau.dk

/* ShipComparator is a comparator used to sort implementations of Unit */
public class ShipComparator implements Comparator<Unit> {

    /* The list of ships are sorted based on combat value then resource cost
     * The ships with lower combat value comes first, if same combat value then the ship with higher resource cost */
    @Override
    public int compare(Unit o1, Unit o2) {
        //Compares combat value
        int combatValueCmp = Integer.compare(o1.getCombatValue(), o2.getCombatValue());
        if (combatValueCmp != 0) {
            //Returns compared combat value
            return combatValueCmp;
        }

        //Returns compared resource cost
        return Integer.compare(o2.getResourceCost(), o1.getResourceCost());
    }
}
