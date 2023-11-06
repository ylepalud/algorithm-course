package ylp.algorithm.course.algorithmcourse.data.tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public BinarySearchTree(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * In order to compute complexity of tree, we look at the height of it
     * Complexity = [O(log(n)) O(n)]
     *
     */
    public boolean find(T value) {
        return findRecurse(value, root);
    }

    private boolean findRecurse(T value, BinaryNode<T> currentNode) {
        // Base Case
        if (currentNode == null) {
            return false;
        }

        if (currentNode.getValue().equals(value)) {
            return true;
        }

        // Recurse
        if (currentNode.getValue().compareTo(value) > 0) {
            return findRecurse(value, currentNode.getLeft());
        }

        return findRecurse(value, currentNode.getRight());
    }

    public void insert(T value) {
        insertRecurse(null, root, value);
    }

    private void insertRecurse(BinaryNode<T> parent, BinaryNode<T> currentValue, T value) {
        // Base case
        if (currentValue == null) {
            if (parent.getValue().compareTo(value) <= 0) {
                parent.setRight(new BinaryNode<>(value));
            } else {
                parent.setLeft(new BinaryNode<>(value));
            }
            return;
        }

        // Recursion
        if (currentValue.getValue().compareTo(value) <= 0) {
            insertRecurse(currentValue, currentValue.getRight(), value);
        } else {
            insertRecurse(currentValue, currentValue.getLeft(), value);
        }
    }

    public boolean delete(T value) {
        throw new RuntimeException("Not implemented");
    }
}
