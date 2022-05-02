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
                do {

                        System.out.println("\t\t\t1. Päivitä uusi solmu.");
                        System.out.println("\t\t\t2. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                                System.out.println("Anna solmun avain:");
                                int newKey = Lue.kluku();

                                // convert int to object
                                Integer objInt = new Integer(newKey);
                                tree.add(objInt);
                                
                                //show tree
                                System.out.println("=============");
                                System.out.println(tree);
                            break;
                        case '2':
                            break;
                        }
                }
                while (select != '2');
        }
//printMenu loppuu ----------------------------------------------------------------
}

