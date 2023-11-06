package ylp.algorithm.course.algorithmcourse.data.tree;

import java.util.ArrayList;
import java.util.List;

public class TreePreOder<T> {

    private BinaryNode<T> root;

    public TreePreOder(BinaryNode<T> root) {
        this.root = root;
    }

    public List<T> traverse() {
        return walk(root, new ArrayList<>());
    }

    private List<T> walk(BinaryNode<T> currentNode, List<T> path) {
        // Base case
        if (currentNode == null) {
            return path;
        }

        // Recursion
        // Pre
        path.add(currentNode.getValue());

        // Recurse
        walk(currentNode.getLeft(), path);
        walk(currentNode.getRight(), path);
        // Post

        return path;
    }
}
