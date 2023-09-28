package ylp.algorithm.course.algorithmcourse.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @ParameterizedTest
    @CsvSource({
            "1,true",
            "6,false",
    })
    void hasItem(int value, boolean shouldBeIn) {
        // Given
        int[] array = {1, 2, 3, 4, 5};

        // When
        boolean hasValue = LinearSearch.hasItem(array, value);

        // Then
        assertThat(hasValue)
                .isEqualTo(shouldBeIn);
    }
}