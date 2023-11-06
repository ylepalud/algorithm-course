package ylp.algorithm.course.algorithmcourse.data.tree;

import java.util.ArrayList;
import java.util.List;

public class TreePostOrder<T> {

    private BinaryNode<T> root;

    public TreePostOrder(BinaryNode<T> root) {
        this.root = root;
    }

    public List<T> preOrderSearch() {
        return walk(root, new ArrayList<>());
    }

    private List<T> walk(BinaryNode<T> currentNode, List<T> path) {
        // Base case
        if (currentNode == null) {
            return path;
        }

        // Recursion
        // Pre

        // Recurse
        walk(currentNode.getLeft(), path);
        walk(currentNode.getRight(), path);

        // Post
        path.add(currentNode.getValue());

        return path;
    }
}
