package bheap;
import java.util.Random;
import java.util.ArrayList;

public class GenerateKeyId {

    Random n = new Random();
    public int generatedKey = 2;
    public static int orderedKey;
    private int lowestLine=2;
    private int highestLine=20;
    ArrayList<Integer> createdKeyIdList = new ArrayList<Integer>();

    private boolean keyExists( int key) {

        if (createdKeyIdList.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public int generateKeyId() {

        //exclude the key identifier is equal to root identifier
        while (keyExists(generatedKey) ) {
            generatedKey = n.nextInt(highestLine - lowestLine) + lowestLine;
        }

        //System.out.println("Random key is: " + randomId);

        if (generatedKey == highestLine) {
            highestLine = highestLine + 10;
        }

        createdKeyIdList.add(generatedKey);

        return generatedKey;

    }
    
    public int generateOrderedKey() {
        orderedKey++;
        return orderedKey;
    }
    
    
}
