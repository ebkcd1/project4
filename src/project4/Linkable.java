package project4;

/**
 * Provides the methods required to implement a linked list of nodes.
 * 
 * Note:  A node implementing this interface can be used 
 *        with a Singly-Linked List or a Binary Tree.
 *
 * This interface MUST be implemented by a class.
 * i.e., public class Node implements Linkable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 */
public interface Linkable {
    /**
     * Returns the current node's left child node. 
     * @return the current node's left child node.
     */
    public Node getLeftChild();
    
    /**
     * Returns the node to the right of the current node.
     * @return the node to the right of the current node.
     */
    public Node getNext();
    
    /**
     * Returns the node to the left of the current node.
     * @return the node to the left of the current node.
     */
    public Node getPrevious();
    
    /**
     * Returns the current node's right child node. 
     * @return the current node's right child node.
     */
    public Node getRightChild();
    
    /**
     * Returns the state object stored in the current node.
     * @return the state object stored in the current node.
     */
    public State getState();
    
    /**
     * Sets the current node's left child node.
	 * @param node the node to assign to the left child.
     */
    public void setLeftChild(Node node);
    
    /**
     * Sets the next pointer to the node to the right of the current node.
     * @param node the node to assign to the next pointer.
     */
    public void setNext(Node node);
    
    /**
     * Sets the previous pointer to the node to the left of the current node.
     * @param node the node to assign to the previous pointer.
     */
    public void setPrevious(Node node);
        
    /**
     * Sets the current node's right child node.
	 * @param node the node to assign to the right child.
     */
    public void setRightChild(Node node);
}
