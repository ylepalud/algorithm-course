package ylp.algorithm.course.algorithmcourse.data.structure.stack;

import java.util.Optional;

public class MyStack<T> {

    private int size;

    private Node<T> head;

    public MyStack() {
        size = 0;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);

        size++;

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.setPrevious(head);

        head = newNode;
    }

    public Optional<T> pop() {
        if (head == null) {
            return Optional.empty();
        }

        size--;

        Node<T> oldHead = head;

        head = head.getPrevious();

        return Optional.of(oldHead.getValue());
    }

    public Optional<T> peek() {
        return Optional.ofNullable(head)
                .map(Node::getValue);
    }

    public int size() {
        return size;
    }
}
