/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bsearch;

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
                BinaryTree tree = null, upDated = null; 
                BinaryTree autoTree = new BinaryTree("ROOT", 100);
                GenerateKeyId key = new GenerateKeyId();
                String data;
                do {

                        System.out.println("\n\t\t\t1. Luo juurisolmu.");
                        System.out.println("\t\t\t2. Päivitä uusi solmu.");
                        System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t4. Etsi puusta avain.");
                        System.out.println("\t\t\t5. Näytä puu test");
                        System.out.println("\t\t\t6. Poista solmu -operaatio");
                        System.out.println("\t\t\t7. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna juuren sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            tree = new BinaryTree(data, key.defaultKey);
                            break;
                        case '2':
                            if (tree == null) {
                                System.out.println("=============");
                                autoTree.preOrder();
                                autoTree.countTreeElements();
                            }
                            else {
                                System.out.println("Anna solmun sisältö (merkkijono)");
                                BinaryTree newTree = new BinaryTree(new String(Lue.rivi()), key.generateKeyId());

                                tree.setNotFound();
                                upDated = tree.findWithPreOrder(key.generatedKey);
                                upDated.setNode(newTree, key.generatedKey);
                            }
                            System.out.println("=============");
                            tree.preOrder();
                            tree.countTreeElements();
                            break;
                        case '3':
                            if(tree == null) {
                                autoTree.preOrder();
                            } else {
                            tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            }
                            break;
                        case '4':
                            System.out.println("Anna solmun avain arvo"); // pyttään antamaan avain arvo
                            int findByKeyValue = Lue.kluku(); 

                            System.out.println("Etsitaan puussa avain: " + findByKeyValue);
                            if(tree == null) {
                                autoTree.showFoundNode(findByKeyValue);
                            } else {
                                tree.showFoundNode(findByKeyValue);
                            }
                            break;
                        case '5':
                            for (int i=0; i<26; i++) {
                                BinaryTree autoTreeLeaf = new BinaryTree(key.generateKeyId());
                                autoTree.setNode(autoTreeLeaf, key.generatedKey);
                                //BinaryTree autoTreeLeafTwo = new BinaryTree(key.generateOrderedKey());

                                //System.out.println("Ordered key is: " + GenerateKeyId.orderedKey);
                                //System.out.println("New generated key is: " + key.generateOrderedKey());
                                
                                //autoTree.setNode(autoTreeLeafTwo, GenerateKeyId.orderedKey);
                            }
                            System.out.println("=============");
                            autoTree.preOrder();
                            autoTree.countTreeElements();
                            autoTree.showTreeInTable();
                            break;
                        case '6':
                            System.out.println("***** Solmun poistaminen ******"); // pyttään antamaan avain arvo
                            System.out.println("Anna solmun avain arvo"); // pyttään antamaan avain arvo
                            int itemToRemove = Lue.kluku(); 

                            if(tree == null) {
                                autoTree.delete(itemToRemove);
                                System.out.println("=============");
                                autoTree.preOrder();
                            } else {
                                tree.delete(itemToRemove);
                                System.out.println("=============");
                                tree.preOrder();
                            }
                            
                            break;
                        case '7':
                            break;
                        }
                }
                while (select != '7');
        }
//printMenu loppuu ----------------------------------------------------------------
}

