package ylp.algorithm.course.algorithmcourse.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        // Given
        int[] array = {2, 4, 5, 1, 2, 5};

        // When
        int[] sorted = QuickSort.sort(array);

        // Then
        assertThat(sorted)
                .containsExactly(1, 2, 2, 4, 5, 5);
    }
}