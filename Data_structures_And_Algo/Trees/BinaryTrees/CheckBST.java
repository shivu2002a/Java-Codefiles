package Data_structures_And_Algo.Trees.BinaryTrees;

import java.util.*;

/* 
Check if a given a tree is a BST
Author : Shivanagouda S A
*/

import Data_structures_And_Algo.Trees.*;

public class CheckBST {

    static boolean flag;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10, 11, 9, 7, 12, 15, 8);
        System.out.println(checkBST(tree.root));
        System.out.println(checkBST(new BinaryTree(6, 2, 8, 1, 9).root)); // recursive
        System.out.println(isBSTUtil(new BinaryTree(6, 2, 8, 1, 9).root)); // iterative

    }

    public static boolean checkBST(TreeNode root){
        if(root == null){
            return true;
        }else {
            return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public static boolean isBSTUtil(TreeNode root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return (isBSTUtil(root.left, min, root.data-1) && isBSTUtil(root.right, root.data+1, max));
    }  

    public static boolean isBSTUtil(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return true;
        }
        isBSTUtil(root.left);
        if(!result.isEmpty()){
            if(result.get(result.size()-1) > root.data){
                flag = false;
                return flag;
            }
        }
        result.add(root.data);
        isBSTUtil(root.right);
        return flag;
    }
}
