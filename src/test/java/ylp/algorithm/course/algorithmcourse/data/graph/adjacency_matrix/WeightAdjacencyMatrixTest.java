package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_matrix;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WeightAdjacencyMatrixTest {

    @Test
    void buildMatrix() {
        // Given
        WeightAdjacencyMatrix matrix = new WeightAdjacencyMatrix(5);

        Stream<Edge> edges = Stream.of(
                new Edge(1, 2, 1),
                new Edge(2, 1, 5),
                new Edge(1, 3, 3),
                new Edge(3, 5, 2),
                new Edge(3, 4, 6),
                new Edge(4, 2, 1)
        );

        // When
        edges.forEach(matrix::add);

        // Then
    }

    @Test
    void searchBFS() {
        // Given
        WeightAdjacencyMatrix matrix = new WeightAdjacencyMatrix(5);
        Stream.of(
                new Edge(1, 2, 1),
                new Edge(2, 1, 5),
                new Edge(1, 3, 3),
                new Edge(3, 5, 2),
                new Edge(3, 4, 6),
                new Edge(4, 2, 1)
        ).forEach(matrix::add);

        // When
        List<Integer> path = matrix.bfs(1, 4);

        // Then
        assertThat(path)
                .containsExactly(1, 3, 4);
    }

    @Test
    void searchBFSnoPath() {
        // Given
        WeightAdjacencyMatrix matrix = new WeightAdjacencyMatrix(5);
        Stream.of(
                new Edge(1, 2, 1),
                new Edge(2, 1, 5),
                new Edge(1, 3, 3),
                new Edge(3, 5, 2),
                new Edge(3, 4, 6),
                new Edge(4, 2, 1)
        ).forEach(matrix::add);

        // When
        List<Integer> path = matrix.bfs(5, 2);

        // Then
        assertThat(path)
                .containsExactly();
    }
}