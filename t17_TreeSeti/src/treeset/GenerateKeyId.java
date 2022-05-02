package treeset;
import java.util.Random;
import java.util.ArrayList;

public class GenerateKeyId {

    Random n = new Random();
    public int defaultKey = 1;
    public int generatedKey;
    public static int orderedKey;
    private int lowestLine=2;
    private int highestLine=100;
    ArrayList<Integer> createdKeyIdList = new ArrayList<Integer>();

    private boolean keyExists( int key) {

        if (createdKeyIdList.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public int generateKeyId() {
        /*
        if (randomId == highestLine) {
            highestLine = highestLine + 10;
        }
        */

        generatedKey = n.nextInt(100000);

        //exclude the key identifier is equal to root identifier
        /*
        while (keyExists(randomId) || randomId == defaultKey) {
            randomId = n.nextInt(highestLine - lowestLine) + lowestLine;
        }
        */

        //System.out.println("Random key is: " + randomId);

        return generatedKey;

    }
    
    public int generateOrderedKey() {
        orderedKey++;
        return orderedKey;
    }
    
    
}
