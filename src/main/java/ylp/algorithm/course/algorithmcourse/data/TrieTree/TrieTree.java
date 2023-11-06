package ylp.algorithm.course.algorithmcourse.data.TrieTree;

import java.util.*;

public class TrieTree {

    private Node head;

    public TrieTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node current = head;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.getChild(c).isPresent()) {
                current = current.getChild(c).get();
            } else {
                current = current.insert(c);
            }
        }

        current.isWord = true;
    }

    public List<String> predict(String starWord) {
        Node current = head;

        // Todo make that work

        for (int i = 0; i < starWord.length(); i++) {
            char c = starWord.charAt(i);
            if (current.getChild(c).isPresent()) {
                current = current.getChild(c).get();
            } else {
                return List.of();
            }
        }

        return walk(current,
                new ArrayList<>())
                .stream()
                .map(endWord -> starWord + endWord)
                .toList();
    }

    private List<String> walk(Node currentNode,
                              List<String> words) {
        Stack<Node> letters = new Stack<>();
        letters.add(currentNode);

        while (!letters.isEmpty()) {
            Node current = letters.pop();

            letters.addAll(Arrays.stream(current.linkedNode).filter(Objects::nonNull).toList());

            if (current.isWord) {
                letters.stream()
                        .map(a -> a.value)
                        .map(String::valueOf)
                        .reduce((a, b) -> a + b)
                        .ifPresent(words::add);
            }

        }

        return words;
    }
}
