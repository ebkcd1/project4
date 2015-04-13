package project4;

/**
 *
 * @author eric
 */
public class Stack implements Stackable {

    private Node top;

    /**
     * Displays the items stored in the stack.
     */
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }

    /**
     * Determines if the stack is empty.
     *
     * @return True if the stack is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Determines if the stack is full.
     *
     * @return True if the stack is full; otherwise, false.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * Removes a item from the top of the stack.
     *
     * Note: The isEmpty method should be called first to prevent errors.
     *
     * @return The item that was removed.
     */
    public Node pop() {
        Node temp = top;
        top = temp.getNext();
        return temp;
    }

    /**
     * Adds a item to the top of the stack.
     *
     * Note: The isFull method should be called first to prevent errors.
     *
     * @param item The item to add.
     */
    public void push(Node item) {
        item.setNext(top);
        top = item;
    }
}
