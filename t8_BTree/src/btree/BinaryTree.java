/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    public static BinaryTree found; // findWithPreOrder()-operaation apurakenne

    public BinaryTree(String rootValue, int keyId) {
        root = new Node(rootValue, keyId);
    }

    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */

    public void showFoundNode (int key) {
        this.setNotFound();
        found = this.findWithPreOrder(key); 
        System.out.println("Läheinen solmu on: ");
        System.out.println("******");
        System.out.println(found.root.getData()+ "[" + found.root.getKey() + "] - " + found.root.getSideMarker());
        System.out.println("******");
    }

    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+ "[" + root.getKey() + "] - " + root.getSideMarker());
            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }

    // löydetty alipuu asetetaan staattiseen muuttujaan found
    public BinaryTree findWithPreOrder(int key) {

        if (root != null) {
            // pääseekö vasemmalle?
            if (found == null && root.left() != null && key < root.getKey()) {
                found = root.left().findWithPreOrder(key);
                return found;

            } 
            // pääseekö oikealle?
            if (found == null && root.right() != null && key > root.getKey()) {
                found = root.right().findWithPreOrder(key);
                return found;
            }  

        } 

        // Ei ole solmu vasemalla ja oikealla
        found = this;
        return found;

    }
    public void setNotFound() {
        found = null;
    }
    public static BinaryTree getFound() {
        return found;
    }

    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }

    public void setNode(BinaryTree tree, int key) {

        //vähemmän kuin oletus arvo
        if(key < root.defaultKey) {
            if(key < root.getKey() && root.right() != null )  {
                tree.root.setSideMarker("oikeinsolmu");
                root.setLeft(tree);
            } else {
                tree.root.setSideMarker("vasensolmu");
                root.setRight(tree);
            }

        } else {
            if(key > root.getKey() && root.left() == null) {
                tree.root.setSideMarker("oikeinsolmu");
                root.setLeft(tree);
            } else {
                tree.root.setSideMarker("vasensolmu");
                root.setRight(tree);
            }
            
        }
    }
}
