package ylp.algorithm.course.algorithmcourse.data.graph.dijkstra;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DijkstraNaiveTest {

    @Test
    void find() {
        // Given
        DijkstraNaive dijkstraNaive = new DijkstraNaive();

        dijkstraNaive.add(0, 1, 1);
        dijkstraNaive.add(0, 2, 5);
        dijkstraNaive.add(1, 2, 7);
        dijkstraNaive.add(1, 3, 6);
        dijkstraNaive.add(3, 2, 1);
        dijkstraNaive.add(2, 4, 1);

        // When
        List<Integer> path = dijkstraNaive.find(0, 4);

        // Then
        Assertions.assertThat(path)
                .containsExactly(0, 2, 4);
    }
}