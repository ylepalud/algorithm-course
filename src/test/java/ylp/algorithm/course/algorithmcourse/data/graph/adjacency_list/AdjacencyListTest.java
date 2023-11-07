package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest {

    @Test
    void add() {
        // Given
        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.add(1, 3, 4);
        adjacencyList.add(3, 5, 4);
        adjacencyList.add(3, 3, 4);
        adjacencyList.add(4, 2, 4);
        adjacencyList.add(1, 2, 4);
        adjacencyList.add(2, 1, 4);
        // When

        // Then
    }

    @Test
    void dfs() {
        // Given
        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.add(1, 3, 4);
        adjacencyList.add(3, 5, 4);
        adjacencyList.add(3, 4, 4);
        adjacencyList.add(4, 2, 4);
        adjacencyList.add(1, 2, 4);
        adjacencyList.add(2, 1, 4);

        // When
        List<Integer> path = adjacencyList.dfs(1, 4);

        // Then
        Assertions.assertThat(path)
                .containsExactly(1, 3, 4);
    }

    @Test
    void dfsNoAvailablePath() {
        // Given
        AdjacencyList adjacencyList = new AdjacencyList();

        adjacencyList.add(1, 3, 4);
        adjacencyList.add(3, 5, 4);
        adjacencyList.add(3, 4, 4);
        adjacencyList.add(4, 2, 4);
        adjacencyList.add(1, 2, 4);
        adjacencyList.add(2, 1, 4);

        // When
        List<Integer> path = adjacencyList.dfs(5, 4);

        // Then
        Assertions.assertThat(path)
                .isEmpty();
    }
}