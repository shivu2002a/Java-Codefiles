package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(List<String> l : tickets) {
            map.computeIfAbsent(l.get(0), k -> new PriorityQueue<>());
            map.get(l.get(0)).offer(l.get(1));
        }
        ArrayList<String> res = new ArrayList<>();
        dfs(map, "JFK", res);
        return res;
    }

    public static void dfs(Map<String, Queue<String>> map, String start, ArrayList<String> res) {
        Queue<String> childs = map.get(start); 
        while(childs != null && !childs.isEmpty()) {
            String to = childs.poll();
            dfs(map, to, res);
        }
        res.add(0, start);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC","LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        System.out.println(
            findItinerary(tickets)
        );
    }
}
