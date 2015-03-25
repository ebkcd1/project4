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
public class Node implements Linkable {

    public State state;
    public Node next;
    public Node previous;
    public Node leftChild, rightChild;

    /**
     * Node Constructor
     *
     * @param state This parameter is stored within the Node as data
     */
    public Node(State state) {
        this.state = state;
        this.next = null;
        this.previous = null;
    }

    /**
     * Returns the node to the right of the current node.
     *
     * @return the node to the right of the current node.
     */
    @Override
    public Node getNext() {
        return next;
    }

    /**
     * Returns the node to the left of the current node.
     *
     * @return the node to the left of the current node.
     */
    @Override
    public Node getPrevious() {
        return previous;
    }

    /**
     * Returns the State object stored in the current node.
     *
     * @return the State object stored in the current node.
     */
    @Override
    public State getState() {
        return state;
    }

    /**
     * Returns the node containing the specified name.
     *
     * @param stateName The name to search for.
     * @param node The node to start searching from.
     * @return the node containing the specified name.
     */
    public Node searchNodes(String stateName, Node node) {
        Node temp = node;
        boolean found = false;

        while (temp != null && !found) {
            // Check the nodes stateName against the search term
            if (temp.getState().getStateName().equals(stateName)) {
                found = true;
            } else {
                temp = temp.getNext(); // Go to the next node (can’t go backwards)
            }
        }
        return temp;
    }

    /**
     * Sets the next pointer to the node to the right of the current node.
     *
     * @param node the node to assign to the next pointer.
     */
    @Override
    public void setNext(Node node) {
        this.next = node;
    }

    /**
     * Sets the previous pointer to the node to the left of the current node.
     *
     * @param node the node to assign to the previous pointer.
     */
    @Override
    public void setPrevious(Node node) {
        this.previous = node;
    }

    /**
     * Returns a formatted string containing the State data.
     *
     * @return a formatted string containing the State data.
     */
    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public Node getLeftChild() {
        return leftChild;
    }

    @Override
    public Node getRightChild() {
        return rightChild;
    }

    @Override
    public void setLeftChild(Node node) {
        leftChild = node;
    }

    @Override
    public void setRightChild(Node node) {
        rightChild = node;
    }
}
