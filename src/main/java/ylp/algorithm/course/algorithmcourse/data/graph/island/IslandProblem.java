package ylp.algorithm.course.algorithmcourse.data.graph.island;

import java.util.List;

public class IslandProblem {

    private static final List<Direction> directions = List.of(
            new Direction(1, 0),
            new Direction(-1, 0),
            new Direction(0, 1),
            new Direction(0, -1)
    );

    public static int solve(int[][] graph) {
        boolean[][] seen = new boolean[graph.length][graph[0].length];
        return 0;
    }

    private static boolean recursive(
            Point currentPoint,
            int[][] graph,
            boolean[][] seen
    ) {
        // Base case
        if (currentPoint.x() > graph.length || currentPoint.y() > graph[0].length) {
            return false;
        }

        if (seen[currentPoint.x()][currentPoint.y()]) {
            return false;
        }

        // Recursion
        // Pre

        // Recurse

        // Post
        return false;
    }

}
