package ylp.algorithm.course.algorithmcourse.data.structure;

import java.util.Optional;

public class Node<T> {

    private T value;

    private Node<T> next;

    private Node<T> previous;

    public Node(Node<T> previous, T value, Node<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node<T> previous) {
        this.previous = previous;
        this.value = value;
    }



    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
