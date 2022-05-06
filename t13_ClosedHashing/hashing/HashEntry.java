package hashing;

public class HashEntry {
    int key;
    String data;

    public HashEntry (int key, String data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }
    
    
}
