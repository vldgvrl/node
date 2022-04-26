/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author kamaj
 */
public class Node {
    int key;
    private String data;
    private BinaryTree left;
    private BinaryTree right;

    public Node(String value, int item) {
        data = new String(value);
        key = item;
        left = right = null;
    }
    public  Node (String value, BinaryTree left, BinaryTree right) {
        data = new String(value);
        this.left = left;
        this.right = right;
    }
    public String getData() {
        return data;
    }
    public BinaryTree left() {
        return left;
    }
    public BinaryTree right() {
        return right;
    }
    public void setLeft(BinaryTree tree) {
        left = tree;
    }
    public void setRight(BinaryTree tree) {
        right = tree;
    }
    public int getKey() {
        return key;
    }


}
