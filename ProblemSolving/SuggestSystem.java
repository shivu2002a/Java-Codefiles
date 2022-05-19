package ProblemSolving;
import java.util.*;

/*
A simple implementation of auto-suggestion system
*/


class TrieNode{

    public TrieNode child[];
    public List<String> list;    
    public TrieNode(){
        list = new ArrayList<>();
        child = new TrieNode[26];
    }
}

class SuggestSystem {
    
    TrieNode root = new TrieNode();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //sort words so they will be added in a sorted order to nodes 
        Arrays.sort(products);
        
        TrieNode root = new TrieNode();
        for (String prod : products) {
            TrieNode n = root;
            for (char ch : prod.toCharArray()) {
                int i = ch - 'a';
                if (n.child[i] == null) {
                    n.child[i] = new TrieNode();
                }
                n = n.child[i];
                if (n.list.size() < 3)
                    n.list.add(prod);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        TrieNode n = root;
		//start going over the search word char by char
        for (int i = 0; i < searchWord.length(); i++) {
            n = n.child[searchWord.charAt(i) - 'a'];
			//if we met null - means no more matches possible, the result of result can be filled by empty lists
            if (n == null) {
                for (int j = i; j < searchWord.length(); j++)
                    res.add(new ArrayList<>());    
                break;
            }
            res.add(n.list);
        }
        return res;
    }
    
    public static void main(String[] args) {
        SuggestSystem ss = new SuggestSystem();
        String s[] = {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(ss.suggestedProducts(s, "mouse"));
    }
}