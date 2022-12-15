package ShortestPathAlgos.Dijkstra;

import java.util.*;

class AdjListNode implements Comparable<AdjListNode> {
    
    public int v, w;   
    public AdjListNode(int v, int w) {
        this.v = v;
        this.w = w;
    }
    public int getV() {
        return v;
    }
    public int getW() {
        return w;
    }
    @Override
    public int compareTo(AdjListNode o) {
        return this.w - o.w;
    }   
    
}

public class DijkstraAdjacencyList {
    public static void main(String[] args) {
        int V = 9;
        List<List<AdjListNode>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new AdjListNode(1,4));
        graph.get(0).add(new AdjListNode(7,8));
        graph.get(1).add(new AdjListNode(2,8));
        graph.get(1).add(new AdjListNode(7,11));
        graph.get(1).add(new AdjListNode(0,7));
        graph.get(2).add(new AdjListNode(1, 8));
        graph.get(2).add(new AdjListNode(3, 7));
        graph.get(2).add(new AdjListNode(8, 2));
        graph.get(2).add(new AdjListNode(5, 4));
        graph.get(3).add(new AdjListNode(2, 7));
        graph.get(3).add(new AdjListNode(4, 9));
        graph.get(3).add(new AdjListNode(5, 14));
        graph.get(4).add(new AdjListNode(3, 9));
        graph.get(4).add(new AdjListNode(5, 10));
        graph.get(5).add(new AdjListNode(4, 10));
        graph.get(5).add(new AdjListNode(6, 2));
        graph.get(6).add(new AdjListNode(5, 2));
        graph.get(6).add(new AdjListNode(7, 1));
        graph.get(6).add(new AdjListNode(8, 6));
        graph.get(7).add(new AdjListNode(0, 8));
        graph.get(7).add(new AdjListNode(1, 11));
        graph.get(7).add(new AdjListNode(6, 1));
        graph.get(7).add(new AdjListNode(8, 7));
        graph.get(8).add(new AdjListNode(2, 2));
        graph.get(8).add(new AdjListNode(6, 6));
        graph.get(8).add(new AdjListNode(7, 1));
        
        int distance[] = dijkstra(graph.size(), graph, source);
        System.out.println(Arrays.toString(distance));
    }

    private static int[] dijkstra(int V, List<List<AdjListNode>> graph, int source   /* int dest */) {
        int distance[] = new int[V];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(/*(v1, v2) -> v1.getW()-v2.getW()*/ );
        pq.offer(new AdjListNode(source,0));
        while (!pq.isEmpty()) {
            AdjListNode curr = pq.poll();
            for(AdjListNode n : graph.get(curr.getV())){
                if(distance[curr.getV()] + n.getW() < distance[n.getV()]){
                    distance[n.getV()] = distance[curr.getV()] + n.getW();
                    //if dest is given
                    //if(n.getV() == dest)
                      //  break;
                    pq.add(new AdjListNode(n.getV(), distance[n.getV()]));
                }
            }
        }
        return distance;
    }
}
