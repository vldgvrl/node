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

        if(root == null) {
            root.setLeaveHeight(root.leaveHeight-1);
        } else {
            if (root.left() != null ) {
                root.left().root.setLeaveHeight(root.leaveHeight+1);
            }
            if (root.right() != null ) {
                root.right().root.setLeaveHeight(root.leaveHeight+1);
            }
        }
        if (root != null) {
            System.out.println(root.getData()+ "[" + root.getKey() + "] - " + root.getSideMarker());
            System.out.println("Alipuun korkeuden: " + root.getLeaveHeight());

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

        if(key < root.defaultKey-1) {
            if(key < root.getKey() && root.right() != null )  {
                tree.root.setSideMarker("vasensolmu");
                root.setLeft(tree);
            } else {
                tree.root.setSideMarker("oikeinsolmu");
                root.setRight(tree);
            }

        } else { //ensimmäinen solmu taso
            if(key < root.getKey() )  {
                tree.root.setSideMarker("vasensolmu");
                root.setLeft(tree);
            } else {
                tree.root.setSideMarker("oikeinsolmu");
                root.setRight(tree);
            }
        }

       
    }

    public int getTreeSize(BinaryTree tree) {
        if(tree == null) 
            return 0;
        else 
            return 1 + getTreeSize(tree.root.left()) + getTreeSize(tree.root.right());
    }

    public int getTreeHeight(BinaryTree tree) {

        int lh;     /* height of left subtree */
        int rh;     /* height of right subtree */

        if(tree == null) {
            return -1;
        } else {
            lh = getTreeHeight(tree.root.left());
            rh = getTreeHeight(tree.root.right());
            return 1 + (lh > rh ? lh : rh);
        }
    }
}
