package ylp.algorithm.course.algorithmcourse.data.structure.queue;

import java.util.Optional;

public class MyQueue<T> {

    private int length;
    private Node<T> head;
    private Node<T> tail;

    public MyQueue() {
        this.length = 0;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);

        length++;

        if (tail == null) {
            tail = head = newNode;
            return;
        }

        tail.setNext(newNode);

        tail = newNode;
    }

    public Optional<T> pop() {
        if (head == null) {
            return Optional.empty();
        }

        length--;

        Node<T> oldHead = head;

        this.head = this.head.getNext();

        return Optional.ofNullable(oldHead.getValue());
    }

    public Optional<T> peek() {
        return Optional.ofNullable(head.getValue());
    }

    public int size() {
        return length;
    }
}
