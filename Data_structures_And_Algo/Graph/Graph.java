package Data_structures_And_Algo.Graph;

import java.util.*;

public class Graph {

    public static final String NEWLINE = System.getProperty("line.separator");
    public final int V;
    public int E;

    private boolean[][] adjMatrix;

    // Empty graph with vertices
    public Graph(int V){
        if( V  < 0){
            throw new IllegalArgumentException("Too few vertices");
        }
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
    }

    public Graph(int V, int E){
        this(V);
        if(E > (long) V*(V-1)/2 + V)
            throw new IllegalArgumentException("Too many edges");
        if(E < 0)
            throw new IllegalArgumentException("Too few edges");
        Random r = new Random();
        //Inefficient
        while (this.E != E) {
            int u = r.nextInt(V);
            int v = r.nextInt(V);
            addEdge(u,v);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    //Adding undirected edge u-v
    public void addEdge(int u, int v){
        if(!adjMatrix[u][v])
            E++;
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Undirected graph" + NEWLINE);
        sb.append("Verticces:" + V + " and Edges: " + E + NEWLINE);
        for (int i = 0; i < V; i++) {
            sb.append(i + ":  ");
            for (int j = 0; j < adjMatrix.length; j++) {
                sb.append(adjMatrix[i][j] ? "1 " : "0 ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int V = 5, E = 7;
        Graph graph = new Graph(V, E);
        System.out.println(graph);

    }
}
