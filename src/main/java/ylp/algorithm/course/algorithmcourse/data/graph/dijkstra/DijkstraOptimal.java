package ylp.algorithm.course.algorithmcourse.data.graph.dijkstra;

import ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list.Graph;

import java.util.List;
import java.util.PriorityQueue;

public class DijkstraOptimal {
    private final Graph graph;

    public DijkstraOptimal() {
        this.graph = new Graph();
    }

    public void add(int from, int to, int weight) {
        graph.addDijkstra(from, to, weight);
    }

    public List<Integer> find(int source,
                              int seek) {
        PriorityQueue<Integer> distances = new PriorityQueue<>();

        // TODO Implement me please !!

        return List.of();
    }
}
