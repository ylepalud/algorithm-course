package ylp.algorithm.course.algorithmcourse.data.tree;

import java.util.Optional;
import java.util.function.Function;

public class BinaryNode<T> {

    private T value;

    private BinaryNode<T> left;

    private BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }

    public <R> void visit(Function<T, R> vistFunction) {
        vistFunction.apply(value);
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public BinaryNode<T> setLeft(T value) {
        if (value == null) {
            left = null;
            return null;
        }
        this.left = new BinaryNode<>(value);
        return left;
    }

    public BinaryNode<T> setRight(T value) {
        if (value == null) {
            right = null;
            return null;
        }
        right = new BinaryNode<>(value);
        return right;
    }

    public T getValue() {
        return value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }
}
