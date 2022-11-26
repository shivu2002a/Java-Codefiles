package DisjointSets;
/**
 * @author Shivanagouda S A
 * {@summary Implementation of Union Find Algorithm with both union by rank and union by size }
 */
public class DisjointSet {

    int[] parent, rank, size;

    public DisjointSet(int n) {
        this.parent = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //Path compression and finding parent
    public int findUltParent(int node){
        if(node == parent[node])
            return node;
        return parent[node] = findUltParent(parent[node]); 
    }

    void unionByRank(int u, int v){
        int ultParent_u = findUltParent(u);
        int ultParent_v = findUltParent(v);
        //They're belonging to the same parent, I don't need to do anything.
        if(ultParent_u == ultParent_v) return;
        if(ultParent_u < ultParent_v){
            parent[ultParent_u] =  ultParent_v;
        }else if(rank[ultParent_u] < rank[ultParent_v]){
            parent[ultParent_u] = ultParent_v;
        }else{
            //Connect any to any
            parent[ultParent_v] = ultParent_u;
            rank[ultParent_u]++;
        }
    }

    void unionBySize(int u, int v){
        int ultParent_u = findUltParent(u);
        int ultParent_v = findUltParent(v);
        if(ultParent_u == ultParent_v) return;
        if(size[ultParent_u] < size[ultParent_v]){
            parent[ultParent_u] = ultParent_v;
            size[ultParent_v] += size[ultParent_u];
        }else{
            parent[ultParent_v] = ultParent_u;
            size[ultParent_u] += size[ultParent_v];
        }
    }

    public static void main(String[] args) {
        var ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        //Check if 3 and 7 belong to same component or not
        if (ds.findUltParent(3) == ds.findUltParent(7)) {
            System.out.println("Same component");
        }else  
            System.out.println("Not same");
        ds.unionBySize(3, 7);
        System.out.println(ds.findUltParent(3) == ds.findUltParent(7) ? "Same" : "Not same");

    }
    
}
