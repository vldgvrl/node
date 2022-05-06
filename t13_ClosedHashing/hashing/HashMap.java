package hashing;

public class HashMap {

      private final static int TABLE_SIZE = 7;

      HashEntry[] table;

      HashMap() {

            table = new HashEntry[TABLE_SIZE];

            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }

 

      public void showHashMap() {

            for (int i=0; i<TABLE_SIZE; i++)
                  if(table[i] != null)
                        System.out.println("Key: " + table[i].getKey() + "; " + table[i].getData() + "; Hash: " + i);
      }

      public void get(int key) {

            int hash = (key % TABLE_SIZE);
            
            int listChecked = 0;


            while (table[hash] != null && table[hash].getKey() != key && listChecked <= TABLE_SIZE ){
                  hash = (hash + 1) % TABLE_SIZE;
                  listChecked++;
            }

            if(listChecked > TABLE_SIZE){
                  System.out.println("Item not found");
                  return;
            }

            if (table[hash] == null)
                  System.out.println("Item not registered");
            else
                  System.out.println(table[hash].getData());
      }


      public void put(int key, String value) {

            //quit if there is no empty space
            if (isOpenSpace()) {
                  int hash = (key % TABLE_SIZE);

                  while (table[hash] != null && table[hash].getKey() != key)

                        hash = (hash + 1) % TABLE_SIZE;

                  table[hash] = new HashEntry(key, value);
            } else {
                  System.out.println("There is no empty space. Max elements: " + TABLE_SIZE);
            } 


      }

      public boolean isOpenSpace() {
            //checks for open spaces in the table for insertion

            boolean isOpen = false;
            for (int i = 0; i < TABLE_SIZE; i++) {
                if (table[i] == null) {
                    isOpen = true;
                }
            }
            return isOpen;
      }

}