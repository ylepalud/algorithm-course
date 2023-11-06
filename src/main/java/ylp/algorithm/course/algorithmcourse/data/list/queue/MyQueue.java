package ylp.algorithm.course.algorithmcourse.data.list.queue;

import java.util.Optional;

public class MyQueue<T> {

    private int length;
    private Node<T> head;
    private Node<T> tail;

    public MyQueue() {
        this.length = 0;
    }

    public void queue(T t) {
        Node<T> newNode = new Node<>(t);

        length++;

        if (tail == null) {
            tail = head = newNode;
            return;
        }

        tail.setNext(newNode);

        tail = newNode;
    }

    public Optional<T> dequeue() {
        if (head == null) {
            return Optional.empty();
        }

        length--;

        Node<T> oldHead = head;

        this.head = this.head.getNext();

        return Optional.ofNullable(oldHead.getValue());
    }

    public Optional<T> peek() {
        return Optional.ofNullable(head)
                .map(Node::getValue);
    }

    public int size() {
        return length;
    }
}
