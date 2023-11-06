package ylp.algorithm.course.algorithmcourse.data.heap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyMinHeapTest {

    @Test
    void insert() {
        // Given
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // When
        heap.insert(5);
        heap.insert(2);
        heap.insert(7);
        heap.insert(1);
        heap.insert(10);

        // Then
        assertThat(heap.getSize())
                .isEqualTo(5);
        assertThat(heap.getData())
                .containsExactly(1, 2, 7, 5, 10);
    }

}