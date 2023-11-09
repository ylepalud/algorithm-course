package ylp.algorithm.course.algorithmcourse.lru;

import com.sun.jdi.VoidValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LRU<K, V> {

    private int length;
    private final int capacity;
    private Optional<Node<V>> head;
    private Optional<Node<V>> tail;
    private final Map<K, Node<V>> lookup;
    private final Map<Node<V>, K> reverseLookup;
    private final static int DEFAULT_CAPACITY = 10;;

    public LRU() {
        capacity = DEFAULT_CAPACITY;
        this.length = 0;
        head = Optional.empty();
        tail = Optional.empty();
        lookup = new HashMap<>();
        reverseLookup = new HashMap<>();
    }

    public LRU(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        head = Optional.empty();
        tail = Optional.empty();
        lookup = new HashMap<>();
        reverseLookup = new HashMap<>();
    }

    public void update(K key, V value) {
        // Check the cache for existence
        Node<V> node = lookup.get(key);


        // If not
        //  - check capacity and evict if over
        if (node == null) {
            node = new Node<>(value);
            length++;
            prepend(node);
            trimCache();
            lookup.put(key, node);
            reverseLookup.put(node, key);
        }
        // If it does, we need to update to the front of the list and update the value
        else {
            detach(node);
            prepend(node);
            node.value = value;
        }

    }

    public Optional<V> get(K key) {
        // Check the cache for existence
        Node<V> node = lookup.get(key);

        if (node == null) {
            return Optional.empty();
        }

        // Update the value we found and move it to the front
        detach(node);
        prepend(node);

        // return out the value found or not
        return Optional.of(node.value);
    }

    private void detach(Node<V> node) {
        node.previous
                .ifPresent(previous -> previous.next = node.next);

        node.next
                .ifPresent(next -> next.previous = node.previous);

        if (head.map(a -> a.equals(node)).orElse(false)) {
            head = Optional.of(node);
        }

        if (tail.map(a -> a.equals(node)).orElse(false)) {
            tail = Optional.of(node);
        }

        node.previous = Optional.empty();
        node.next = Optional.empty();
    }

    private void prepend(Node<V> node) {
        if (head.isEmpty()) {
            head = tail = Optional.of(node);
            return;
        }

        node.next = head;
        head.get().previous = Optional.of(node);
        head = Optional.of(node);
    }

    private void trimCache() {
        if (length <= capacity) {
            return;
        }

        Node<V> oldTail = tail.get(); // At that moment, we know that tail contain something

        detach(oldTail);

        K key = reverseLookup.get(oldTail);
        lookup.remove(key);
        reverseLookup.remove(oldTail);
        length--;
    }


    private class Node<T> {
        T value;
        Optional<Node<T>> next;

        Optional<Node<T>> previous;

        public Node(T value) {
            this.value = value;
            previous = Optional.empty();
            next = Optional.empty();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
