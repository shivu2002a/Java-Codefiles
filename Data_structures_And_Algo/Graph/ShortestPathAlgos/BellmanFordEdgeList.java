package ShortestPathAlgos;
// package Data_structures_And_Algo.Graph;

import java.util.Arrays;

class Edge {
    int from, to;
    double cost;

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class BellmanFordEdgeList {
    public static void main(String[] args) {
        int E = 10, V = 9, start = 0;
        Edge edgeList[] = new Edge[E];
        edgeList[0] = new Edge(0, 1, 1);
        edgeList[1] = new Edge(1, 2, 1);
        edgeList[2] = new Edge(2, 4, 1);
        edgeList[3] = new Edge(4, 3, -3);
        edgeList[4] = new Edge(3, 2, 1);
        edgeList[5] = new Edge(1, 5, 4);
        edgeList[6] = new Edge(1, 6, 4);
        edgeList[7] = new Edge(5, 6, 5);
        edgeList[8] = new Edge(6, 7, 4);
        edgeList[9] = new Edge(5, 7, 3);
        System.out.println(Arrays.toString(shortestDistance(edgeList, V, start)));
    }

    public static double[] shortestDistance(Edge[] edges, int V, int start) {
        double distance[] = new double[V];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        distance[0] = 0;
        // find shortest distance
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.from] + edge.cost < distance[edge.to]) {
                    distance[edge.to] = distance[edge.from] + edge.cost;
                }
            }
        }
        // find negative cycles, if found distance to that node is -inf;
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.from] + edge.cost < distance[edge.to]) {
                    distance[edge.to] = Double.NEGATIVE_INFINITY;
                }
            }
        }
        return distance;
    }
}
