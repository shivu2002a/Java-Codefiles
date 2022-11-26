package DisjointSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    public static void main(String[] args) {
        String ac[][] = {
            {"John","johnsmith@mail.com","john_newyork@mail.com"},
            {"John","johnsmith@mail.com","john00@mail.com"},
            {"Mary","mary@mail.com"},
            {"John","johnnybravo@mail.com"}
        };
        System.out.println(acountMerge(ac));
    }

    private static List<List<String>> acountMerge(String[][] ac) {
        int n = ac.length;
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mapMailNode = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < ac[i].length; j++) {
                String mail = ac[i][j];
                if(mapMailNode.containsKey(mail)){
                    ds.unionBySize(i, mapMailNode.get(mail));
                }else {
                    mapMailNode.put(mail, i);
                }
            }
        }
        List<String> mergedMail[] = new ArrayList[n];
        for (int i = 0; i < mergedMail.length; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> e : mapMailNode.entrySet()){
            String mail = e.getKey();
            int node = e.getValue();
            int parent = ds.findUltParent(node);
            mergedMail[parent].add(mail);
        }
        
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < mergedMail.length; i++) {
            if(mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            mergedMail[i].add(0, ac[i][0]);
            res.add(mergedMail[i]);
        }
        return res;
    }
}
