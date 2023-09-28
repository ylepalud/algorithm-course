package ylp.algorithm.course.algorithmcourse.sort;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {


    @Test
    void doest_it_sort() {
        // Given
        int[] array = {9, 8, 7, 6, 2, 5, 4, 1, 3};
        // When
        int[] sorted = BubbleSort.sort(array);

        // Then
        assertThat(sorted)
                .containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

}