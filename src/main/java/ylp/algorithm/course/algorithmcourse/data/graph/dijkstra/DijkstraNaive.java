package ylp.algorithm.course.algorithmcourse.data.graph.dijkstra;

import ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list.Edge;
import ylp.algorithm.course.algorithmcourse.data.graph.adjacency_list.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraNaive extends Dijkstra {

    public DijkstraNaive() {
        super();
    }


    /*
    * Prev, seen, dist -> O(V)
    *
    * while is O(V)
    *
    * But hasUnVisited is O(V)
    * And getLowestUnvisited is O(V)
    *
    * -> O(v^2) Let's use a Min Heap in order to have a sweet O(log(v+E))
    * Complexity
    */
    public List<Integer> find(int source,
                              int seek) {
        Boolean[] seen = new Boolean[graph.size()];
        Arrays.fill(seen, false);

        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);

        int[] previous = new int[graph.size()];
        Arrays.fill(previous, -1);

        distances[source] = 0;

        while (hasUnVisited(seen, distances)) {
            int lowestUnvisited = getLowestUnvisited(seen, distances);

            seen[lowestUnvisited] = true;

            List<Edge> connectedNodes = graph.getConnectedNodes(lowestUnvisited)
                    .values()
                    .stream()
                    .toList();

            for (Edge edge: connectedNodes) {
                if (seen[edge.to()]) {
                    continue;
                }

                int distance = distances[lowestUnvisited] + edge.weight();

                if (distance < distances[edge.to()]) {
                    distances[edge.to()] = distance;
                    previous[edge.to()] = lowestUnvisited;
                }
            }
        }

        List<Integer> out = new ArrayList<>();
        int current = seek;

        out.add(seek);
        while(previous[current] != -1) {
            out.add(previous[current]);
            current = previous[current];
        }

        return out.reversed();
    }

    private boolean hasUnVisited(Boolean[] seen, int[] distance) {
        for (int i = 0; i < seen.length; i++) {
            if (!seen[i] && distance[i] < Integer.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    private int getLowestUnvisited(Boolean[] seen, int[] distance) {
        int index = -1;
        int lowestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < seen.length; i++) {
            if (seen[i]) {
                continue;
            }

            if (lowestDistance > distance[i]) {
                lowestDistance = distance[i];
                index = i;
            }
        }

        return index;
    }
}
