package ylp.algorithm.course.algorithmcourse.data.structure.doubly_linked_list;

import ylp.algorithm.course.algorithmcourse.data.structure.MyList;

import java.util.Optional;

public class DoublyLinkedList<T> implements MyList<T> {

    private int length;

    private Optional<Node<T>> head;

    public DoublyLinkedList() {
        length = 0;
        head = Optional.empty();
    }

    @Override
    public void append(T element) {
        length++;


    }

    @Override
    public void prepend(T element) {
        length++;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void insertAt(T element, int index) {

    }

    @Override
    public Optional<T> getAt(int index) {
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(T element) {
        return Optional.empty();
    }

    @Override
    public boolean contain(T value) {
        return false;
    }
}
