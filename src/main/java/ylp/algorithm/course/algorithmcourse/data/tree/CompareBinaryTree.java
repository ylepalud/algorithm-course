package ylp.algorithm.course.algorithmcourse.data.tree;

public class CompareBinaryTree {

    /**
     * Compare if trees are equivalent both in value and in shape
     * We use BFS because this preserve the shape of the tree
     */
    public static <T> boolean compare(BinaryNode<T> a, BinaryNode<T> b) {
        // Base case
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.getValue() != b.getValue()) {
            return false;
        }

            // Recursion
        return compare(a.getLeft(), b.getLeft()) &&
                compare(a.getRight(), a.getRight());
    }
}
