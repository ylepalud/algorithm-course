package ylp.algorithm.course.algorithmcourse.data.list.stack;

public class Node<T> {

    final private T value;

    private Node<T> previous;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
