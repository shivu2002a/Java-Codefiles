package Data_structures_And_Algo.Trees;
import java.util.*;

import Data_structures_And_Algo.Trees.BinaryTrees.BinaryTree;

public class MaxLevelSum {

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree(3, 6, 8, 1, 5, 7, 19, 19, 11);
        int sum = maxLevelSum(bTree.root);
        System.out.println(sum);
    }

    private static int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0, maxSum = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                sum += curr.data;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
            }
            sum = 0;
        }
        return maxSum;
    }
    
}
