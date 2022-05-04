package usingjcapi;

import java.util.Comparator;

public class sortByName implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        
        TrafficCard tc1 = (TrafficCard)o1;
        TrafficCard tc2 = (TrafficCard)o2;

        return tc1.mOwnerName.compareTo(tc2.mOwnerName);
        
    }

    
}
