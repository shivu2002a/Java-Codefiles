package ShortestPathAlgos.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Print shortest path from first to nth (last) node.
 * @author Shivanagouda S A 
 */

public class PrintShortestPath {

    public static void main(String[] args) {
        int edges[][] = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}}; 
        int n = 5, m = 6;
        System.out.println(shortestPath(n, m, edges));
    }

    static class Pair {
        int node, distance;

        Pair(int n, int d) {
            this.node = n;
            this.distance = d;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Pair>> graph = new ArrayList<List<Pair>>();

        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int dist[] = new int[n + 1];
        int parent[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < n + 1; i++)
            parent[i] = i;
        dist[1] = 0;
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {

            int node = q.peek().node;
            int distance = q.poll().distance;

            for (Pair list : graph.get(node)) {
                int dest = list.node;
                int cost = list.distance;
                if (distance + cost < dist[dest]) {
                    dist[dest] = cost + distance;
                    q.add(new Pair(dest, dist[dest]));
                    parent[dest] = node;
                }
            }
        }
        int node = n;
        List<Integer> res = new ArrayList<>();
        while (parent[node] != node) {
            res.add(node);
            node = parent[node];
        }
        if (res.size() == 0) {
            res.add(-1);
            return res;
        }
        res.add(1);
        Collections.reverse(res);
        return res;

    }
}
