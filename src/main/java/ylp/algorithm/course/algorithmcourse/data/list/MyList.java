package ylp.algorithm.course.algorithmcourse.data.list;

import java.util.Optional;

public interface MyList<T> {
    void append(T element);
    void prepend(T element);
    int length();
    void insertAt(T element, int index);
    Optional<T> getAt(int index);
    Optional<T> remove(T element);
    boolean contain(T value );
}
