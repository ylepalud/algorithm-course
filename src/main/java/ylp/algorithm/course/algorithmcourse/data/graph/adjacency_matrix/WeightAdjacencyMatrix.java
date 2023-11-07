package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_matrix;

import java.util.*;

public class WeightAdjacencyMatrix {

    private final int[][] matrix;
    private final int numberOfNode;

    public WeightAdjacencyMatrix(int numberOfNode) {
        this.numberOfNode = numberOfNode;
        matrix = new int[numberOfNode][numberOfNode];
    }

    public void add(Edge edge) {
        int startNode = edge.startNode() - 1;
        if (startNode > numberOfNode) {
            throw new RuntimeException("Out of bound for startNode");
        }

        int endNode = edge.endNode() - 1;
        if (endNode > numberOfNode) {
            throw new RuntimeException("Out of bound for endNode");
        }

        matrix[startNode][endNode] = edge.weight();
    }

    public List<Integer> bfs(int source,
                             int needle) {
        source--;
        needle--;
        boolean[] seen = new boolean[numberOfNode];
        int[] prev = new int[numberOfNode];
        Arrays.fill(prev, -1);

        seen[source] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        do {
            Integer current = q.poll();
            
            if (current == needle) {
                break;
            }

            int[] currentAdjacency = matrix[current];

            for (int i = 0; i < matrix.length; i++) {
                if (currentAdjacency[i] == 0) {
                    continue;
                }

                if (seen[i]) {
                    continue;
                }

                seen[i] = true;
                prev[i] = current;
                q.add(i);
            }
        } while (!q.isEmpty());

        // Build it backwards
        int current = needle;
        ArrayList<Integer> out = new ArrayList<>();

        while (prev[current] != -1) {
            out.add(current + 1);
            current = prev[current];
        }
        if (out.isEmpty()) {
            return List.of();
        }

        out.add(source + 1);

        return out.reversed();
    }
}
