package bsearch;
import java.util.Random;
import java.util.ArrayList;

public class GenerateKeyId {

    Random n = new Random();
    public int defaultKey = 100;
    public int generatedKey;
    public static int orderedKey;
    private int lowestLine=50;
    private int highestLine=150;
    ArrayList<Integer> createdKeyIdList = new ArrayList<Integer>();

    private boolean keyExists( int key) {

        if (createdKeyIdList.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public int generateKeyId() {
        int randomId = defaultKey;

        //exclude the key identifier is equal to root identifier
        while (keyExists(randomId) || randomId == defaultKey) {
            randomId = n.nextInt(highestLine - lowestLine) + lowestLine;
        }

        //System.out.println("Random key is: " + randomId);

        if(randomId == lowestLine) {
            lowestLine = lowestLine - 10;
        }
        if (randomId == highestLine) {
            highestLine = highestLine + 10;
        }

        createdKeyIdList.add(randomId);

        generatedKey = randomId;
        return generatedKey;

    }
    
    public int generateOrderedKey() {
        orderedKey++;
        return orderedKey;
    }
    
    
}
