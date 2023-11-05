package ylp.algorithm.course.algorithmcourse.recursion;

import java.util.List;
import java.util.Stack;

public class MazeSolver {


    private static final String WALL = "#";

    private static final String NOTHING = " ";

    private static final String START = "S";

    private static final String END = "E";

    private static final int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static final String[][] maze = {
            {WALL, WALL, WALL, END, WALL},
            {WALL, NOTHING, NOTHING, NOTHING, WALL},
            {WALL, NOTHING, NOTHING, NOTHING, WALL},
            {WALL, NOTHING, NOTHING, NOTHING, WALL},
            {WALL, START, WALL, WALL, WALL},
    };

    public static void main(String[] args) {
        System.out.println(solve(maze, new Point(4, 1), new Point(0, 3)));
    }

    /**
     * Entry point, you don't want to recurse on that
     * Some initialisation stuff then solve the problem
     */
    public static List<Point> solve(String[][] maze,
                              Point start,
                              Point end) {

        Stack<Point> path = new Stack<>();

        // Because boolean are primitive type, unspecified boolean is false
        boolean[][] seen = new boolean[maze.length][maze[0].length];

        walk(
                maze,
                start,
                end,
                seen,
                path
        );

        return path;
    }

    private static boolean walk(String[][] maze,
                         Point currentPoint,
                         Point end,
                         boolean[][] seen,
                         Stack<Point> path) {
        // 1. Base case
        // Off the map
        if (currentPoint.x() < 0 || currentPoint.x() >= maze[0].length
                || currentPoint.y() < 0 || currentPoint.y() >= maze.length
        ) {
            return false;
        }

        if (maze[currentPoint.x()][currentPoint.y()].equals(WALL)) {
            return false;
        }

        if (seen[currentPoint.x()][currentPoint.y()]) {
            return false;
        }

        if (currentPoint.y() == end.y() && currentPoint.x() == end.x()) {
            path.push(end);
            return true;
        }

        // 2. Recursive
        // Pre
        seen[currentPoint.x()][currentPoint.y()] = true;

        path.push(currentPoint);

        // Recurse

        for (var direction : directions) {
            boolean isSuccessful = walk(
                    maze,
                    new Point(
                            currentPoint.x() + direction[0],
                            currentPoint.y() + direction[1]
                    ),
                    end,
                    seen,
                    path
            );

            if (isSuccessful) return true;
        }

        // Post
        path.pop();

        return false;
    }
}
