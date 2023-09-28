package ylp.algorithm.course.algorithmcourse.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @ParameterizedTest
    @CsvSource({
            "1,true",
            "10,true",
            "3,true",
            "6,true",
            "15,false",
            "-2,false",
    })
    void hasItem(int value, boolean expected) {
        // Given
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // When
        boolean hasItem = BinarySearch.hasItem(array, value);

        // Then
        assertThat(hasItem)
                .isEqualTo(expected);
    }
}