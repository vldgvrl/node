/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package treeset;

import java.util.Set;
import java.util.TreeSet;

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
                Set<Integer> tree = new TreeSet<>();
                Integer objInt;
                GenerateKeyId autoKey = new GenerateKeyId();
                do {

                        System.out.println("\t\t\t1. Päivitä uusi solmu.");
                        System.out.println("\t\t\t2. Generoi TreeSet");
                        System.out.println("\t\t\t3. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                                System.out.println("Anna solmun avain:");
                                int newKey = Lue.kluku();
                                objInt = new Integer(newKey);

                                // convert int to object
                                tree.add(objInt);
                                
                                //show tree
                                System.out.println("=============");
                                System.out.println(tree);
                            break;
                        case '2':
                                /*
                                for (int i = 0; i <= 100000; i++) {
                                        objInt = new Integer (autoKey.generateKeyId() );
                                        tree.add(objInt);
                                }
                                */
                                while(tree.size() < 100000) {
                                        objInt = new Integer (autoKey.generateKeyId() );
                                        tree.add(objInt);
                                }
                                
                                System.out.println("=============");
                                System.out.println(tree);
                                System.out.println("Puun koko: " + tree.size());

                            break;
                        case '3':
                            break;
                        }
                }
                while (select != '3');
        }
//printMenu loppuu ----------------------------------------------------------------
}

