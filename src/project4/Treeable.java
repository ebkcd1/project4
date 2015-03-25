package project4;

/**
 * Provides the methods required to implement a Binary Tree.
 * 
 * This interface MUST be implemented by a class.
 * i.e., public class BinaryTree implements Treeable {
 * 
 * @author Jim Littleton
 * @since February 14, 2014
 */
public interface Treeable {
    /**
     * Displays the State objects stored in the Bianry Tree.
     * @param ascending True if State objects ordered from smallest to largest; otherwise, from largest to smallest.
     */
    public void display(boolean ascending);
    
    /**
     * Adds a State object to the appropriate location of the Bianry Tree.
     * @param state The State object to add.
     */
    public void insert(Node state);
    
    /**
     * Determines if the Bianry Tree is empty.
     * @return True if the Bianry Tree is empty; otherwise, false.
     */
    public boolean isEmpty();
	
	/**
     * Removes a State object with the specified population from the Bianry Tree.
     * 
     * Note:  The isEmpty method should be called first to prevent errors.
     * @param population The population of the State to remove.
     * @return The State object that was removed.
     */
    public Node remove(int population);
}