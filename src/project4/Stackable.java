package project4;

/**
 * Provides the methods required to implement a stack as a linked-list.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class Stack implements Stackable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 */
public interface Stackable {
    /**
     * Displays the items stored in the stack.
     */
    public void display();
    
    /**
     * Determines if the stack is empty.
     * @return True if the stack is empty; otherwise, false.
     */
    public boolean isEmpty();
    
    /**
     * Determines if the stack is full.
     * @return True if the stack is full; otherwise, false.
     */
    public boolean isFull();
    
    /**
     * Removes a item from the top of the stack.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @return The item that was removed.
     */
    public Node pop();
    
    /**
     * Adds a item to the top of the stack.
     * 
     * Note:  The isFull method should be called first to prevent errors.
     * @param item The item to add.
     */
    public void push(Node item);
}
