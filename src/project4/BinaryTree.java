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
     * @param leftChild Boolean of whether or not the current node is the
     * leftchild
     */
    private void deleteNoChildren(Node parent, boolean leftChild) {
        if (leftChild == true) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
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
        if (leftChild) {
            temp = parent.getLeftChild();
            if (temp.getLeftChild() != null) {
                parent.setLeftChild(temp.getLeftChild());
            } else {
                parent.setRightChild(temp.getRightChild());
            }
        } else {
            temp = parent.getRightChild();
            if (temp.getLeftChild() != null) {
                parent.setLeftChild(temp.getLeftChild());
            } else {
                parent.setRightChild(temp.getRightChild());
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

    }

    @Override
    public void display(boolean ascending) {

    }

    private void displayTreeLNR(Node node) {

    }

    private void displayTreeRNL(Node node) {

    }

    /**
     *
     * @param item
     */
    @Override
    public void insert(Node item) {
        if (root == null) {
            root = item;
        } else {
            if (item.getState().getPopulation() <= root.getState().getPopulation()) {
                insert(item);
            }
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
        
        if(nodePopulation <= currentNodePopulation){
            if(current.getLeftChild() == null){
                current.setLeftChild(node);
            }else{
                insert(current.getLeftChild(), node);
            }
        }else{
            if(current.getRightChild() == null){
                current.setRightChild(node);
            }else{
                insert(current.getRightChild(), node);
            }
        }
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
