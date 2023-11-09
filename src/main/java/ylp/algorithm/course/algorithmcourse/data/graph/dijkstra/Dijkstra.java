package ylp.algorithm.course.algorithmcourse.data.graph.dijkstra;

import ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list.Graph;

import java.util.List;

public abstract class Dijkstra {

    protected final Graph graph;

    public Dijkstra() {
        this.graph = new Graph();
    }

    public void add(int from, int to, int weight) {
        graph.addDijkstra(from, to, weight);
    }
    public abstract List<Integer> find(int source, int seek);

}
