package ylp.algorithm.course.algorithmcourse.data.graph.adjacency_matrix;

public record Edge(
        int startNode,
        int endNode,
        int weight
) {

    public Edge {
        if (startNode < 0 || endNode < 0 || weight <0)  {
            throw new IllegalArgumentException("StartNode, endNode and weight can't be negative");
        }
    }
}
