package DisjointSets;
/** 
 * {@summary Two strings X and Y are similar if we can swap two letters (in different positions) of X, 
 * so that it equals Y. Also two strings X and Y are similar if they are equal.}
 * @return number of groups of similar strings
 */
class DS {
    int parent[], size[];

    DS(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i < parent.length; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findPar(int a){
        while(a != parent[a]){
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    void union(int a, int b){
        int pa = findPar(a);
        int pb = findPar(b);
        if(pa == pb) return;
        if(size[pa] > size[pb]){
            parent[pb] = pa;
            size[pa] += size[pa]; 
        }else{
            parent[pa] = pb;
            size[pb] += size[pa]; 
        }
    }
}

public class SimilarStrings {
    public static void main(String[] args) {
        String strs[] = {"tars", "stars", "rats", "arts"};
        System.out.println(numSimilarGroups(strs));

    }

    public static int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DS ds = new DS(n);
        for(int i = 0; i < n - 1; i++){
            for(int j = 1; j < n; j++){
                if(similar(strs[i], strs[j])){
                    ds.union(i, j);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(ds.parent[i] == i) ans++;
        }  
        return ans;
    }

    public static boolean similar(String a, String b){
        if(a == b) return true;
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count <= 2 ? true : false;
    }
}
