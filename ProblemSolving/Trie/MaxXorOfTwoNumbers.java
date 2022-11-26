/**
 * MaxXorOfTwoNumbers
 */

class Node {
  Node links[] = new Node[2];

  Node() {

  }

  void put(int bit) {
    links[bit] = new Node();
  }

  boolean containsKey(int bit) {
    return links[bit] != null;
  }

  Node get(int bit) {
    return links[bit];
  }

}

class Trie {
  Node root = new Node();

  Trie() {

  }

  void insert(int num) {
    Node node = root;
    for (int i = 31; i >= 0; i--) {
      int bit = (num >> i) & 1;
      if (!node.containsKey(bit)) {
        node.put(bit);
      }
      node = node.get(bit);
    }
  }

  int getMax(int num) {
    Node node = root;
    int max = 0;
    for (int i = 31; i >= 0; i--) {
      int bit = (num >> i) & 1;
      if (node.containsKey(1 - bit)) {
        max = max | (1 << i);
        node = node.get(1 - bit);
      } else
        node = node.get(bit);
    }
    return max;
  }
}

public class MaxXorOfTwoNumbers {

  public static void main(String[] args) {
    int arr[] = { 9, 8, 7, 5, 4 };
    int x = 8;
    maxXor(arr, x);
  }

  private static void maxXor(int[] arr, int x) {
    Trie trie = new Trie();
    for (int i : arr) {
      trie.insert(i);
    }
    System.out.println(trie.getMax(x));
  }

}