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
    public int defaultKey = 100;
    private String data;
    private BinaryTree left;
    private BinaryTree right;
    private String sideMarker;
    public int leaveHeight;

    public Node(String value, int item) {
        data = new String(value);
        key = item;
        left = right = null;
        if(key == 100)
            sideMarker = "juurisolmu";

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
    public String getSideMarker() {
        if (sideMarker == null)
            return "";
        else
            return sideMarker;
    }
    public void setSideMarker(String marker) {
        sideMarker = marker;
    }
    public int getLeaveHeight() {
        return leaveHeight;
    }
    public void setLeaveHeight(int lh) {
        leaveHeight = lh;
    }


}
