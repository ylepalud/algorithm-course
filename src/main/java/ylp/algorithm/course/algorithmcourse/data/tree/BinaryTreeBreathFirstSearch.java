package ylp.algorithm.course.algorithmcourse.data.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeBreathFirstSearch<T> {

    private BinaryNode<T> root;

    public BinaryTreeBreathFirstSearch(BinaryNode<T> root) {
        this.root = root;
    }

    public boolean contain(T needle) {
        Queue<BinaryNode<T>> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode<T> current = queue.poll();

            if (current.getValue().equals(needle)) {
                return true;
            }

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return false;
    }

}
