package CompleteString;

/**
 * @author Shivanagouda S A
 * {@summary Finds the longest word in the array in which has all its prefix words are in the array 
 *  If two strings meet that condition and have equal length, lexicographically smallest one is returned} 
 * 
*/

class Node {
    Node child[] = new Node[26];
    boolean flag = false;
}

class Trie {
    Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(curr.child[ind] == null)
                curr.child[ind] = new Node();
            curr = curr.child[ind];
        }
        curr.flag = true;
    }
    
    private boolean prefixExists(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(curr.child[ind] == null || !curr.child[ind].flag)
                return false;
            curr = curr.child[ind];
        }
        return curr.flag;
    }

    public String completeString(String arr[]){
        for (String s : arr) {
            insert(s);
        }
        String longest = "";
        for (String s : arr) {
            if(prefixExists(s)){
                if(longest.length() == s.length()){
                    longest = longest.compareTo(s) > 0 ? s : longest;
                }else if (longest.length() < s.length()) {
                    longest = s;
                }
            }
        }
        return longest;
    }
}

public class CompleteString {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        String arr[] = {"n", "ninja", "nin", "ninj", "ninga", "ni"};
        System.out.println(trie.completeString(arr));
    }
}
