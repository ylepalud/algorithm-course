package ylp.algorithm.course.algorithmcourse.data.list.linked_list;

import ylp.algorithm.course.algorithmcourse.data.list.MyList;

import java.util.Optional;

/**
 * This is a naive implementation of the linked list
 * Here the performance are bad because we heavily rely on traversing the list with a linear algorithm
 *
 * The important things to remember here is the concept of Node and how much it cost to operate element in the list
 * Complexite:
 *  append = o(1)
 *  prepend = o(1)
 *  length = o(1) and o(1) at insertion and deletion
 *  insertAt = o(n) is this case but there is better solutions
 *  getAt = o(n) is this case but there is better solutions
 *  remove = o(n) is this case but there is better solutions
 *  contain = o(n) is this case but there is better solutions
 * */
public class NaiveLinkedList<T> implements MyList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public NaiveLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public NaiveLinkedList(T ... fields) {
        for (T element: fields) {
            append(element);
        }
    }

    @Override
    public void append(T value) {
        var nodeToAdd = new Node<>(value);
        size ++;

        if (head == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
            return;
        }

        tail.setNext(nodeToAdd);
        nodeToAdd.setPrevious(tail);
        tail = nodeToAdd;
    }

    @Override
    public void prepend(T element) {
        var nodeToAdd = new Node<>(element);

        size ++;

        if (head == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
        }

        head.setPrevious(nodeToAdd);
        nodeToAdd.setNext(head);
        head = nodeToAdd;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void insertAt(T value, int index) {
        int currentIndex = 0;
        var currentNode = head;

        do {
            currentIndex++;
            currentNode = currentNode.next();
        } while (currentNode.hasNext() && currentIndex < index);

        if (currentIndex != index) {
            return;
        }

        var newNode = new Node<>(currentNode, value, currentNode.next());
        currentNode.setNext(newNode);
        newNode.setNext(currentNode);

        Node<T> previous = currentNode.getPrevious();

        if (previous == null) {
            head = newNode;
            return;
        }

        previous.setNext(newNode);
        newNode.setPrevious(previous);
        size ++;
    }

    @Override
    public Optional<T> getAt(int index) {
        if (index == 0) {
            return Optional.ofNullable(head)
                    .map(Node::getValue);
        }

        int currentIndex = 0;

        var currentNode = head;

        do {
            currentIndex++;
            if (!currentNode.hasNext()) {
                return Optional.empty();
            }
            currentNode = currentNode.next();
        } while (currentIndex < index);

        return Optional.ofNullable(currentNode)
                .map(Node::getValue);
    }

    @Override
    public Optional<T> remove(T value) {
        var currentNode = head;

        if (currentNode == null) return Optional.empty();

        if (currentNode.getValue() == value) {
            head = currentNode.next();
            size --;
            return Optional.of(currentNode.getValue());
        }

        while (currentNode.hasNext()) {
            if (currentNode.getValue() == value) {
                var nextNode = currentNode.next();
                var previous = currentNode.getPrevious();

                if (nextNode != null) {
                    nextNode.setPrevious(previous);
                }

                if (previous != null) {
                    previous.setNext(nextNode);
                }
                size --;
                return Optional.of(currentNode.getValue());
            }

            currentNode = currentNode.next();
        }

        return Optional.empty();
    }

    @Override
    public boolean contain(T value) {
        var currentNode = head;

        do {
            if (currentNode.getValue() == value) {
                return true;
            }
            currentNode = currentNode.next();
        } while (currentNode.hasNext());
        return false;
    }
}
