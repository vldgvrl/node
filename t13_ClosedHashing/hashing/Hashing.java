package hashing;

public class Hashing {

    public static void main(String[] args) {

        runClosedHashing();

    }

    public static void runClosedHashing() {

        HashMap newHashMap = new HashMap();

        newHashMap.put(9, "9 mod 7 = 2");
        newHashMap.put(3, "3 mod 7 = 3");
        newHashMap.put(10, "10 mod 7 = 3");
        newHashMap.put(17, "17 mod 7 = 3");
        
        System.out.println("==== New HashMap created: ====");
        newHashMap.showHashMap();
        System.out.println("========");

        System.out.println("Add element with key, that already exists");
        newHashMap.put(9, "Item was modified");
        newHashMap.showHashMap();
        System.out.println("========");

        System.out.println("==== Get invalid element ==== ");
        newHashMap.get(102);
        System.out.println("========");

        System.out.println("==== Fulfill all free spaces ====");
        for ( int i=5; i<8; i++)
            newHashMap.put(i, "same 6 elements");
        newHashMap.showHashMap();
        System.out.println("========");

        
        System.out.println("========");
        System.out.println("==== Show item with key 17: ====");
        newHashMap.get(17);
        System.out.println("========");


        System.out.println("==== Add element, when table is full ====");
        newHashMap.put(11, "excessive");
        newHashMap.showHashMap();
        System.out.println("========");

        System.out.println("==== Find item, with invalid key, when table is full: ====");
        newHashMap.get(53);
        System.out.println("========");

    }

}