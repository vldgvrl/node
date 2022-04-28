package bsearch;
import java.util.Random;

public class GenerateKeyId {

    Random n = new Random();
    public int defaultKey = 100;
    private int leftKeyIdentifier = 100;
    private  int rightKeyIdentifier = 100;
    public int generatedKey;

    public int generateKeyId() {
        if(n.nextInt(10) > 5) {
            rightKeyIdentifier++;
            generatedKey = rightKeyIdentifier;
            return generatedKey;
        }
        else {
            leftKeyIdentifier--;
            generatedKey = leftKeyIdentifier;
            return generatedKey;
        } 
    }
    
    
}
