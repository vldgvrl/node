/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bheap;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                MinHeap minHeap = new MinHeap (50);
                GenerateKeyId key = new GenerateKeyId();
                String data;
                do {

                        System.out.println("\n\t\t\t1. Luo binaarikasa.");
                        System.out.println("\t\t\t2. Lisää.");
                        System.out.println("\t\t\t3. Poista.");
                        System.out.println("\t\t\t4. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            for (int i=0; i<11; i++) {
                                minHeap.insert(key.generateKeyId());
                            }
                            System.out.println("======================================");
                            minHeap.print();
                            break;
                        case '2':
                            System.out.println("Anna solmun avain)");
                            int newKey = Lue.kluku(); 
                            minHeap.insert(newKey);
                            minHeap.print();
                            break;
                        case '3':
                            //System.out.println("Anna solmun avain, joka haluat poistaa");
                            //int keyToDelete = Lue.kluku(); 
                            minHeap.remove();
                            break;
                        case '4':
                            break;
                        }
                }
                while (select != '4');
        }
//printMenu loppuu ----------------------------------------------------------------
}

