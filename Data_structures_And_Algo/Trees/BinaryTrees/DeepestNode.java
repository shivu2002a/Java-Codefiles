package Data_structures_And_Algo.Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import Data_structures_And_Algo.Trees.TreeNode;

public class DeepestNode {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(3, 5, 6, 8, 2, 9, 7, 2, 12, 24, 1);
        TreeNode found = deepestElement(binaryTree.root);
        System.out.println("Deepest element: " + found.data);
    }

    private static TreeNode deepestElement(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return curr;
    }
    
}
