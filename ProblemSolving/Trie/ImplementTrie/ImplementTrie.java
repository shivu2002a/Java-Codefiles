package ImplementTrie;

class Node {
    Node child[] = new Node[26];
    boolean flag = false;
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
            node = node.child[ind];
        }
        node.flag = true;
    }

    public boolean search(String word){
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            int ind = word.charAt(i) - 'a';
            if(node.child[ind] == null)
                return false;
            node = node.child[ind];
        }
        return node.flag;
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
}

class ImplementTrie{
    public static void main(String[] args) {
        Trie trie = new Trie();
        String words[] = {"apple", "app", "bat", "bac"};
        for (String string : words) {
            trie.insert(string);
        }
        for (String string : words) {
            System.out.print(trie.search(string) + ", ");
        }
        System.out.print(trie.search("iam") + ", ");
    }
}