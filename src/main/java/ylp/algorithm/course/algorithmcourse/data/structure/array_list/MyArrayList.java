package ylp.algorithm.course.algorithmcourse.data.structure.array_list;

import ylp.algorithm.course.algorithmcourse.data.structure.MyList;

import java.util.Optional;

public class MyArrayList<T> implements MyList<T> {

    private static final int SLICE_SIZE = 10;

    private int capacity;
    private int size;

    private T[] container;

    public MyArrayList() {
        size = 0;
        capacity = SLICE_SIZE;
        container = (T[]) new Object[SLICE_SIZE]; // Hack https://stackoverflow.com/questions/50266224/how-to-initialize-generic-array
    }


    @Override
    public void append(T element) {
        if (size == capacity) {
            int totalSlices = getnumberOfSlices();
            totalSlices++;
            
            T[] old = container;
            
            container = (T[]) new Object[totalSlices]; // Hack https://stackoverflow.com/questions/50266224/how-to-initialize-generic-array

            System.arraycopy(old, 0, container, 0, old.length);
        }
        
        size++;
        
        container[size] = element;
    }

    private int getnumberOfSlices() {
        return capacity / SLICE_SIZE;
    }

    @Override
    public void prepend(T element) {
        // Costy operation because you have to realloc memory
        T[] old = container;
        if (size + 1 > capacity) {
            container = (T[]) new Object[getnumberOfSlices() + 1];
        } else {
            container = (T[]) new Object[getnumberOfSlices()];
        }

        container[0] = element;
        
        System.arraycopy(old, 1, container, 1, old.length);
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void insertAt(T element, int index) {
        // Costy operation because you have to realloc memory
        if (index > size + 1) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Optional<T> getAt(int index) {
        if (index < size) {
            return Optional.empty();
        }
        return Optional.of(container[index]);
    }

    @Override
    public Optional<T> remove(T element) {
        return Optional.empty();
    }

    @Override
    public boolean contain(T value) {
        for (T t : container) {
            if (value == t)
                return true;
        }
        return false;
    }
}
