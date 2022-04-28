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
                GenerateKeyId key = new GenerateKeyId();
                String data;
                do {

                        System.out.println("\n\t\t\t1. Luo juurisolmu.");
                        System.out.println("\t\t\t2. Päivitä uusi solmu.");
                        System.out.println("\t\t\t3. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t4. Etsi puusta avain.");
                        System.out.println("\t\t\t5. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna juuren sisältö (merkkijono)");
                            data = new String(Lue.rivi());
                            tree = new BinaryTree(data, key.defaultKey);
                            break;
                        case '2':
                            if (tree == null)
                                System.out.println("Et ole muodostanut juurisolmua.");
                            else {
                                System.out.println("Anna solmun sisältö (merkkijono)");
                                BinaryTree newTree = new BinaryTree(new String(Lue.rivi()), key.generateKeyId());

                                tree.setNotFound();
                                upDated = tree.findWithPreOrder(key.generatedKey);
                                upDated.setNode(newTree, key.generatedKey);
                            }
                            System.out.println("=============");
                            tree.preOrder();
                            System.out.println("Puun koko: " + tree.getTreeSize(tree));
                            System.out.println("Puun korkeus: " + tree.getTreeHeight(tree));
                            break;
                        case '3':
                            tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '4':
                            System.out.println("Anna solmun avain arvo"); // pyttään antamaan avain arvo
                            int findByKeyValue = Lue.kluku(); 

                            System.out.println("Etsitaan puussa avain: " + findByKeyValue);
                            tree.showFoundNode(findByKeyValue);
                            break;
                        case '5':
                            break;
                        }
                }
                while (select != '5');
        }
//printMenu loppuu ----------------------------------------------------------------
}

