/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project4;

/**
 *
 * @author eric
 */
public class BinaryTree implements Treeable{
    private Node root;
    
    /**
     * Deletes a node from the binary` tree where both children are null
     * and sets the appropriate child of the parent to null
     * @param parent Parent node of the node to be deleted
     * @param leftChild Boolean of whether or not the current node is the leftchild
     */
    private void deleteNoChildren(Node parent, boolean leftChild) {
        if(leftChild == true){
            parent.setLeftChild(null);
        } else{
            parent.setRightChild(null);
        }
    }

    /**
     * Deletes a node from the binary tree where only one child is null
     * set the appropriate child of the parent to the existing child of the node to delete
     * @param parent Parent of the current node
     * @param leftChild Boolean of whether the current node is the leftchild
     * @param temp Temp node to store the current node
     */
    private void deleteSingleChild(Node parent, boolean leftChild, Node temp) {
        if(leftChild){
            temp = parent.getLeftChild();
            if(temp.getLeftChild() != null){
                parent.setLeftChild(temp.getLeftChild());
            }else{
                parent.setRightChild(temp.getRightChild());
            }
        }else{
            temp = parent.getRightChild();
            if(temp.getLeftChild() != null){
                parent.setLeftChild(temp.getLeftChild());
            }else{
                parent.setRightChild(temp.getRightChild());
            }
        }
    }

    private void deleteWithChildren(Node parent, boolean leftChild, Node temp) {

    }

    @Override
    public void display(boolean ascending) {

    }

    private void displayTreeLNR(Node node) {

    }

    private void displayTreeRNL(Node node) {

    }

    @Override
    public void insert(Node item) {
        
    }

    private void insert(Node current, Node node) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Node remove(int population) {
        
        return root;
    }
}
