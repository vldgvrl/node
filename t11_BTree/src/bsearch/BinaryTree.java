/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    public static BinaryTree found; // findWithPreOrder()-operaation apurakenne
    ArrayList <String> treeInList = new ArrayList<String>();

    public BinaryTree(String rootValue, int keyId) {
        root = new Node(rootValue, keyId);
    }

    public BinaryTree(int generateOrderedKey) {
        root = new Node(generateOrderedKey);
    }
    

    /*public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    } */


    public void showFoundNode (int key) {
        this.setNotFound();
        found = this.findWithPreOrder(key); 
        System.out.println("Läheinen solmu on: ");
        System.out.println("******");
        System.out.println("Taso: " + found.root.leaveHeight + " -> " + found.root.getData()+ "[" + found.root.getKey() + "] - " + found.root.getSideMarker());
        System.out.println("******");
    }

    public void preOrder() {

        if(root == null) {
            //root.setLeaveHeight(root.leaveHeight-1);
        } else {
            if (root.left() != null) { 
                if (root.left().root != null ) {
                    root.left().root.setLeaveHeight(root.leaveHeight+1);
                }
            }
            if (root.right() != null ) {
                if (root.right().root != null ) {
                    root.right().root.setLeaveHeight(root.leaveHeight+1);
                }
            }
        }
        if (root != null) {
            System.out.println("Taso: " + root.getLeaveHeight() + " -> " + root.getData()+ "[" + root.getKey() + "] - " + root.getSideMarker());
            //System.out.println("Alipuun korkeuden: " + root.getLeaveHeight());

            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // pääseekö oikealle?
                root.right().preOrder();
        }

    }

    // count total results (tree size and tree height)
    public void countTreeElements() {
        System.out.println("=============");
        System.out.println("Puun koko: " + this.getTreeSize(this));
        System.out.println("Puun korkeus: " + this.getTreeHeight(this));
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

        //System.out.println("New leaf: " + tree.root.getData());
        //System.out.println("Parent: " + root.getData());

        /*
        if (root.left() != null && root.right() != null) {
            System.out.println("--Left leaf: " + root.left().root.getData());
            System.out.println("--Right leaf: " + root.right().root.getData());
        }
        */

        //if(root.left() == null && root.right() == null) {
            if (tree.root.getSideMarker() != "juurisolmu") {

                //current key is bigger then new one
                if(root.getKey() > key) {
                    if(root.left() != null) {
                        root.left().setNode(tree, key);
                    } else {
                        root.setLeft(tree);
                        tree.root.setSideMarker("vasensolmu");
                    }
                } else {
                    if(root.right() != null) {
                        root.right().setNode(tree, key);
                    } else {
                        root.setRight(tree);
                        tree.root.setSideMarker("oikeinsolmu");
                    }
                }
            }
        //} else { 
        //}
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

    public void delete(int key) {
        
        if (root == null)
            return;
            
        if (root.left() == null && root.right() == null)
        {
            if (root.key == key)
            {
                root=null;
                return;
            }
            else
                return;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;
        
        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            
            if(temp != null) {

                if (temp.key == key)
                    keyNode = temp;
        
                if (temp.left() != null)
                    q.add(temp.left().root);
        
                if (temp.right() != null)
                    q.add(temp.right().root);
            } else {
                keyNode = null;
                System.out.println("Last element to delete not found");
            }
        }
    
        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        } else {
            System.out.println("Solmu ei löydetty");
        }
    }

    private void deleteDeepest(Node root, Node delNode) {

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        Node temp = null;
        
        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            
            if (temp == delNode) {
                temp = null;
                return;
            }

            if (temp.right()!=null) {
                if (temp.right().root == delNode) {
                    temp.right().root = null;
                    return;
                }
            else
                q.add(temp.right().root);
            }
        
            if (temp.left() != null) {
                if (temp.left().root == delNode) {
                    temp.left().root = null;
                    return;
                }
                else
                    q.add(temp.left().root);
            }
        }
    }


    private void generateTreeList(BinaryTree mainRoot) {
        /* Count item level
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
        */

        if (root != null) {

            //String rootItem = root.getLeaveHeight() + " -> " + root.getData()+ "[" + root.getKey() + "] - " + root.getSideMarker();
            String rootItem = root.getLeaveHeight() + " -> " + "[" + root.getKey() + "]" + root.getData();
            mainRoot.addLeafToList(rootItem);

            if (root.left() != null) // pääseeekö vasemmalle?
                root.left().generateTreeList(mainRoot);
            if (root.right() != null) // pääseekö oikealle?
                root.right().generateTreeList(mainRoot);
        }


    }

    private void addLeafToList(String item) {
        treeInList.add(item);
    }

    public void showTreeInTable() {
        
        generateTreeList(this);

        Collections.sort(treeInList);

        System.out.println("Binääripuu taulukossa:");
        System.out.println("********"); 

        for (int e=0; e<treeInList.size()-1; e++) {
           if(e==1)
                System.out.print(treeInList.get(e+1) + " | "); 
           else if(e==2) 
                System.out.print(treeInList.get(e-1) + " | "); 
           else 
                System.out.print(treeInList.get(e) + " | "); 

        }

        System.out.println(""); 
        System.out.println("********"); 
    }
}
