package usingjcapi;

import java.util.Comparator;

public class sortByNumber implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        
        TrafficCard tc1 = (TrafficCard)o1;
        TrafficCard tc2 = (TrafficCard)o2;
        
        if (tc1.mTravellerNumber == tc2.mTravellerNumber)
            return 0;
        else if ( tc1.mTravellerNumber > tc2.mTravellerNumber)
            return 1;
        else 
            return -1;
    }

    
}
