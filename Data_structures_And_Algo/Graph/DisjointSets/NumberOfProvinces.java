package DisjointSets;

//Number of connected components
//Connecting graph
// Min Number of operations to make graph connected
public class NumberOfProvinces {

    public static void main(String[] args) {
        int adj[][] = {
            {1, 0, 1},
            {0, 1, 0},
            {1, 0, 1},
        };
        int n = 3;
        System.out.println(countProvinces(n, adj));
    }
    
    private static int countProvinces(int n, int[][] adj) {
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if(adj[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }       
        int provinces = 0;
        for (int i = 0; i < ds.parent.length; i++) {
            if(ds.parent[i] == i)
                provinces++;
        }
        // Number of provinces
        // return provinces;
        // Number of operations to make graph connected
        return provinces - 1;
    }
}
