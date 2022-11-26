package UniqueSubStringsOfOwn;

import java.util.HashSet;
import java.util.Set;

class Node {
    Node child[] = new Node[26];
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public int countDistinctSubstrings(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            Node curr = root;
            for (int j = i; j < word.length(); j++) {
                int ind = word.charAt(j) - 'a';
                if (curr.child[ind] == null) {
                    curr.child[ind] = new Node();
                    count++;
                }
                curr = curr.child[ind];
            }
        }
        return count + 1;
    }
}

public class UniqueSubStringsOfOwn {

    public static void main(String[] args) {
        String a = "abab";
        
        //Brute Force
        Set<String> set = new HashSet<>();
        for (int i = 0; i < a.length() - 1; i++) {
            for (int j = i + 1; j < a.length() + 1; j++) {
                set.add(a.substring(i, j));
            }
        }
        System.out.println(set.size() + 1);
        
        //With Trie
        Trie trie = new Trie();
        System.out.println(trie.countDistinctSubstrings(a));
    }
}
