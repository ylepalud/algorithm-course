package ylp.algorithm.course.algorithmcourse.data.heap;

import java.util.ArrayList;
import java.util.List;

public class MyMinHeap<T extends Comparable<T>> {

    private int size;

    private List<T> data;

    public MyMinHeap() {
        size = 0;
        data = new ArrayList<>();
    }

    public void insert(T value) {
        data.add(value);
        heapifyUp(size);
        size++;
    }

    public T delete() {
        if (size == 0) {
            return null;
        }

        T out = data.get(0);
        size--;

        if (size == 0) {
            data = new ArrayList<>();
            return out;
        }

        data.set(0, data.get(size));
        heapifyDown(0);

        return out;
    }

    private void heapifyDown(int index) {
        if (index >= size) return;

        int leftChildIndex = getLeftChildIndex(index);

        if (leftChildIndex >= size) return;

        int rightChildIndex = getRightChildIndex(index);

        T leftValue = data.get(leftChildIndex);
        T rightValue = data.get(rightChildIndex);
        T currentValue = data.get(index);

        if (leftValue.compareTo(rightValue) > 0 && currentValue.compareTo(rightValue) > 0) {
            data.set(index, rightValue);
            data.set(rightChildIndex, currentValue);
            heapifyDown(rightChildIndex);
        } else if (rightValue.compareTo(leftValue) > 0 && currentValue.compareTo(leftValue) > 0) {
            data.set(index, leftValue);
            data.set(leftChildIndex, currentValue);
            heapifyDown(rightChildIndex);
        }
    }

    private void heapifyUp(int index) {
        if (index == 0) return;

        int parentIndex = getParentIndex(index);
        T parent = data.get(parentIndex);
        T currentValue = data.get(index);

        if (parent.compareTo(currentValue) > 0) {
            data.set(index, parent);
            data.set(parentIndex, currentValue);
            heapifyUp(parentIndex);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 2;
    }

    public int getSize() {
        return size;
    }

    public List<T> getData() {
        return data;
    }
}
