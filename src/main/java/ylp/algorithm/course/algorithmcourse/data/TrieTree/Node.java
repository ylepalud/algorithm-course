package ylp.algorithm.course.algorithmcourse.data.TrieTree;

import java.util.Optional;

public class Node {

    char value;
    Node[] linkedNode;

    boolean isWord;

    public Node() {
        linkedNode = new Node[26];
    }

    public Node(char value) {
        this.value = value;
        linkedNode = new Node[26];
    }

    public Optional<Node> getChild(char c) {
        int index = c - 97;
        return Optional.ofNullable(linkedNode[index]);
    }

    public Node insert(char c) {
        int index = c - 97;
        Node node = new Node(c);
        linkedNode[index] = node;
        return node;
    }
}
