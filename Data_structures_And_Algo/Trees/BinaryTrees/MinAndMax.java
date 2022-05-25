package Data_structures_And_Algo.Trees.BinaryTrees;

import Data_structures_And_Algo.Trees.TreeNode;

public class MinAndMax {

    public static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1, 45, 23, 6, 7, 9, -3, 8, 45, 2);
        findMinAndMax(binaryTree.root);
        System.out.println("Min: "+ min + ", Max:  " + max);
    }

    private static void findMinAndMax(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.data < min){
            min = root.data;
        }
        if(root.data > max){
            max = root.data;
        }
        findMinAndMax(root.left);
        findMinAndMax(root.right);

    }   
}
