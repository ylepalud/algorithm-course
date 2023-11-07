package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AdjacencyList {

    private Graph graph;

    public AdjacencyList() {
        graph = new Graph();
    }

    public void add(int from, int to, int weight) {
        graph.add(from, to, weight);
    }

    /**
     * For every node, we iterate over every edge
     * Complexity = O(E*V)
     */
    public List<Integer> dfs(int source, int needle) {
        boolean[] seen = new boolean[graph.size()];
        Stack<Integer> path = new Stack<>();

        source--;
        needle--;

        walk(
                source,
                needle,
                seen,
                path
        );

        return path.stream().map(value -> value + 1 ).toList();
    }

    private boolean walk(int current,
                      int needle,
                      boolean[] seen,
                      Stack<Integer> path) {
        // Base case
        if (seen[current]) {
            return false;
        }

        seen[current] = true;
        // Recursion
        // Previous
        path.push(current);

        if (current == needle) {
            return true;
        }

        // Recurse
        boolean founded = graph.getConnectedNodes(current)
                .values()
                .stream()
                .anyMatch(edge -> walk(edge.to(), needle, seen, path));

        if (founded) return true;

        // Post
        path.pop();

        return false;
    }
}
