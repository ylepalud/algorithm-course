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
}
