package project4;

/**
 *
 * @author eric
 */
public class BinaryTree implements Treeable {

    private Node root;

    /**
     * Deletes a node from the binary` tree where both children are null and
     * sets the appropriate child of the parent to null
     *
     * @param parent Parent node of the node to be deleted
     * @param leftChild Boolean of whether or not the current node is the left
     * child
     */
    private void deleteNoChildren(Node parent, boolean leftChild) {
        if (parent == root && parent.getLeftChild() == null) {
            root = null;
        } else {
            if (leftChild == true) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        }
    }

    /**
     * Deletes a node from the binary tree where only one child is null set the
     * appropriate child of the parent to the existing child of the node to
     * delete
     *
     * @param parent Parent of the current node
     * @param leftChild Boolean of whether the current node is the leftchild
     * @param temp Temp node to store the current node
     */
    private void deleteSingleChild(Node parent, boolean leftChild, Node temp) {
        if (temp.getLeftChild() == null) { // Determine which child exists
            if (leftChild) { // Determine path from parent deleted node is on
                parent.setLeftChild(temp.getRightChild()); // Update parent’s left pointer
            } else {
                parent.setRightChild(temp.getRightChild()); // Update parent’s right pointer
            }
        } else {
            if (leftChild) { // Determine path from parent deleted node is on
                parent.setLeftChild(temp.getLeftChild()); // Update parent’s left pointer
            } else {
                parent.setRightChild(temp.getLeftChild()); // Update parent’s right pointer
            }
        }
    }

    /**
     * Deletes a node from the binary tree where both children exist
     *
     * @param parent
     * @param leftChild
     * @param temp
     */
    private void deleteWithChildren(Node parent, boolean leftChild, Node temp) {
        Node lastNode = null;

        if (leftChild) { // If the node to delete is parent’s left child
            lastNode = temp.getRightChild(); // Start with the node’s right child path
            while (lastNode.getLeftChild() != null) { // Find lowest left child on the path
                lastNode = lastNode.getLeftChild();
            }
            // Update the leftChild pointers of the parent node and the last node
            lastNode.setLeftChild(temp.getLeftChild());
            parent.setLeftChild(temp.getRightChild());
        } else { // If the node to delete is parent’s left child
            lastNode = temp.getLeftChild(); // Start with the node’s left child path
            while (lastNode.getRightChild() != null) { // Find lowest right child on the path
                lastNode = lastNode.getRightChild();
            }
            // Update the rightChild pointers of the parent node and the last node
            lastNode.setRightChild(temp.getRightChild());
            parent.setRightChild(temp.getLeftChild());
        }
    }

    /**
     *
     * @param ascending
     */
    @Override
    public void display(boolean ascending) {
        if (ascending) {
            displayTreeLNR(root);
        } else {
            displayTreeRNL(root);
        }
    }

    /**
     * Displays the contents of the tree in ascending order
     *
     * @param node
     */
    private void displayTreeLNR(Node node) {
        if (node != null) {
            displayTreeLNR(node.getLeftChild());
            System.out.println(node.toString());
            displayTreeLNR(node.getRightChild());
        }
    }

    /**
     * Displays the contents of the tree in descending order
     *
     * @param node
     */
    private void displayTreeRNL(Node node) {
        if (node != null) {
            displayTreeRNL(node.getRightChild());
            System.out.println(node.toString());
            displayTreeRNL(node.getLeftChild());
        }
    }

    /**
     * Inserts the provided state object into the binary tree
     *
     * @param item
     */
    @Override
    public void insert(Node item) {
        if (root == null) {
            root = item;
        } else {
            insert(root, item);
        }
    }

    /**
     * Inserts the provided state object into the binary tree
     *
     * @param current The node within the tree that is being compared against
     * the node to be inserted
     * @param node The node to be inserted
     */
    private void insert(Node current, Node node) {
        //Variable declarations
        int currentNodePopulation, nodePopulation;

        //Variable assignment
        nodePopulation = node.getState().getPopulation();
        currentNodePopulation = current.getState().getPopulation();

        //If nodePopulation is <= to currentNodePopulation, find insertion point
        //on the left branch of currentNode. Else go down the right branch
        if (nodePopulation <= currentNodePopulation) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(node);
            } else {

                //Recursive call
                insert(current.getLeftChild(), node);
            }
        } else {
            if (current.getRightChild() == null) {
                current.setRightChild(node);
            } else {

                //Recursive call
                insert(current.getRightChild(), node);
            }
        }
    }

    /**
     *
     * @return true if the tree is empty
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Removes a State object with the specified population from the Bianry
     * Tree. Note: The isEmpty method should be called first to prevent errors.
     *
     * @param population The population of the State to remove.
     * @return The State object that was removed.
     */
    @Override
    public Node remove(int population) {
        boolean found = false;
        boolean leftChild = false;
        Node currentNode = root;
        Node parentNode = null;
        int currentNodePopulation = root.getState().getPopulation();

        if (currentNodePopulation == population) {
            found = true;
        }
        while (!found && currentNode != null) {
            if (currentNodePopulation == population) {
                found = true;
            } else {
                if (population < currentNodePopulation) {
                    // Value is to the left of current node
                    parentNode = currentNode;
                    currentNode = currentNode.getLeftChild();
                    currentNodePopulation = currentNode.getState().getPopulation();
                    leftChild = true;
                } else {
                    // Value is to the right of current node
                    parentNode = currentNode;
                    currentNode = currentNode.getRightChild();
                    currentNodePopulation = currentNode.getState().getPopulation();
                    leftChild = false;
                }
            }
        }
        if (currentNode != null) {
            if (currentNode.getLeftChild() != null && currentNode.getRightChild() != null) {
                deleteWithChildren(parentNode, leftChild, currentNode);
            } else if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                deleteNoChildren(currentNode, leftChild);
            } else if (currentNode.getLeftChild() != null || currentNode.getRightChild() != null) {
                deleteSingleChild(parentNode, leftChild, currentNode);
            }
        }
        return currentNode;
    }
}
