/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bsearch;

/**
 *
 * @author kamaj
 */
public class Node {
    int key;
    private String data;
    private BinaryTree left;
    private BinaryTree right;
    private String sideMarker;
    public int leaveHeight;
    private static int currentListId;
    private String[] autoTreeValues = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public Node(String value, int item) {
        data = new String(value);
        key = item;
        this.sideMarker = "juurisolmu";
        left = right = null;
    }

    public  Node (String value, BinaryTree left, BinaryTree right) {
        data = new String(value);
        this.left = left;
        this.right = right;
    }

    //generate Node with preassigned values
    public Node (int itemId) {
        //data = new String(autoTreeValues[currentListId]);
        data = new String("Id:"+itemId);
        currentListId++;
        key = itemId;
        left = right = null;
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

    public void showUsedKeys() {
    }


}
