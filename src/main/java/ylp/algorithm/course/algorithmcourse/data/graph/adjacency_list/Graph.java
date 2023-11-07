package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list;

import java.util.*;
import java.util.stream.Stream;

public class Graph {

    private final Map<Integer, Map<Integer, Edge>> graph;

    private final Set<Integer> nodes;

    public Graph() {
        graph = new HashMap<>();
        nodes = new HashSet<>();
    }

    public void add(int from, int to, int weight) {
        from--;
        to--;
        nodes.add(from);
        nodes.add(to);
        Map<Integer, Edge> edges = graph.computeIfAbsent(from, key -> new HashMap<>());
        edges.computeIfAbsent(to, key -> new Edge(key, weight));
    }

    public Map<Integer, Edge> getConnectedNodes(int from) {
        return graph.getOrDefault(from, Map.of());
    }
    public int size() {
        return nodes.size();
    }
}
