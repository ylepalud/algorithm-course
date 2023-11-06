package ylp.algorithm.course.algorithmcourse.data.structure.doubly_linked_list;

import java.util.Optional;

public class Node<T> {

    private T value;

    private Optional<Node<T>> prev;

    private Optional<Node<T>> next;

    public Node(T value) {
        this.value = value;
        this.prev = Optional.empty();
        this.next = Optional.empty();
    }

    public void setPrev(Node<T> prev) {
        this.prev = Optional.ofNullable(prev);
    }

    public void setNext(Node<T> next) {
        this.next = Optional.ofNullable(next);
    }
}
