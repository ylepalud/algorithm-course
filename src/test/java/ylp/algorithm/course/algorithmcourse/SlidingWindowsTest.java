package ylp.algorithm.course.algorithmcourse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowsTest {

    @Test
    void slidingWindow() {
        // Given
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        // When
        List<String> strings = SlidingWindows.slidingWindow(
                integers,
                3,
                elements -> elements.stream()
                        .map(Object::toString)
                        .reduce((a, b) -> a + " " + b)
                        .orElse("")
        );

        // Then
        assertThat(strings)
                .containsExactly(
                        "1 2 3",
                        "2 3 4",
                        "3 4 5"
                );
    }
}