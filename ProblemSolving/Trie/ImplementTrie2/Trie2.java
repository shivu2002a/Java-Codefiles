package ImplementTrie2;
class Node {
    Node child[] = new Node[26];
    int endsWWith = 0;
    int count = 0;
}

class Trie{
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(node.child[ind] == null){
                node.child[ind] = new Node();
            }
            node.count += 1;
            node = node.child[ind];
        }
        node.endsWWith += 1;
        node.count += 1;
    }

    public int countWordsStartWith(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            int ind = word.charAt(i) - 'a';
            if(node.child[ind] == null)
                return 0;
            node = node.child[ind];
        }
        return node.count;
    }

    public boolean startsWith(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            int ind = word.charAt(i) - 'a';
            if(node.child[ind] == null)
                return false;
            node = node.child[ind];
        }
        return true;
    }

    public boolean erase(String word){
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if(node.child[ind] == null || node.count == 0 )
                return false;
            node.count -= 1;
            node = node.child[ind];
        }
        if(node.count == 0)
            return false;
        node.count -= 1;
        node.endsWWith -= 1;
        return true;
    }
}

public class Trie2 {
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        String words[] = {"apple", "app", "apple", "bat", "bac"};
        for (String string : words) {
            trie.insert(string);
        }
        System.out.print(trie.countWordsStartWith("apple") + ", ");
        System.out.println(trie.erase("bat"));
        System.out.println(trie.erase("bat"));
        System.out.print(trie.countWordsStartWith("bat") + " ");
        System.out.print(trie.countWordsStartWith("bat") + ", ");
        System.out.print(trie.countWordsStartWith("a") + ", ");

    }    
}
