package usingjcapi;

import java.util.Comparator;

public class sortByBalance implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        
        TrafficCard tc1 = (TrafficCard)o1;
        TrafficCard tc2 = (TrafficCard)o2;
        
        if (tc1.mBalance == tc2.mBalance)
            return 0;
        else if ( tc1.mBalance > tc2.mBalance)
            return 1;
        else 
            return -1;
    }

    
}
