package ylp.algorithm.course.algorithmcourse.data.graph.island;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandProblemTest {

    @Test
    void solve() {
        // Given
        int[][] graph = {
                {1, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1}
        };

        // When
        int numberOfIsland = IslandProblem.solve(graph);

        // Then
        Assertions.assertThat(numberOfIsland)
                .isEqualTo(4);
    }
}