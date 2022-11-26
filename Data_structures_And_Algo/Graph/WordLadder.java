import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/**
 * Pair
 */
class Pair {
    String s;
    int level;
    
    public Pair(String s, int l) {
        this.s = s;
        this.level = l;
    }
}

public class WordLadder {

    public static void main(String[] args) {
        String words[] = {"hot", "dog", "cog", "dot", "lot", "log"};
        String start = "hit", end = "cog";
        System.out.println(ladder(words, start, end));
    }

    private static int ladder(String[] words, String start, String end) {
        Queue<Pair> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for (String string : words) {
            set.add(string);
        }
        set.remove(start);
        q.offer(new Pair(start, 1));
        while (!q.isEmpty()) {
            String word = q.peek().s;
            int level = q.poll().level;
            q.poll();
            if(word.equals(end)) return level;
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char original = word.charAt(i);

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    if(set.contains(sb.toString())){
                        q.offer(new Pair(sb.toString(), level+1));
                        System.out.println(sb.toString());
                        set.remove(sb.toString());
                    }
                }
                sb.setCharAt(i, original);
            }
        }
        return 0;   

    }
    
}
