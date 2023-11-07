package ylp.algorithm.course.algorithmcourse.data.graph.dijkstra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void find() {
        // Given
        Dijkstra dijkstra = new Dijkstra();

        dijkstra.add(0, 1, 1);
        dijkstra.add(0, 2, 5);
        dijkstra.add(1, 2, 7);
        dijkstra.add(1, 3, 6);
        dijkstra.add(3, 2, 1);
        dijkstra.add(2, 4, 1);

        // When
        List<Integer> path = dijkstra.find(0, 4);

        // Then
        Assertions.assertThat(path)
                .containsExactly(0, 2, 4);
    }
}