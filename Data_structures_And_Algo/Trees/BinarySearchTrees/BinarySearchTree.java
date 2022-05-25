package Data_structures_And_Algo.Trees.BinarySearchTrees;

import Data_structures_And_Algo.Trees.TreeNode;

public class BinarySearchTree {
    
    public TreeNode root;

    public BinarySearchTree(int... a){
        for (int i : a) {
            insert(i, root);
        }
    }

    public void insert(int val, TreeNode rootGiven){
        if(root == null){
            root = new TreeNode(val);
        } else {
            if (val < rootGiven.data) {
                if (rootGiven.left == null) {
                    rootGiven.left = new TreeNode(val);
                } else {
                    insert(val, rootGiven.left);
                }
            } else {
                if (rootGiven.right == null) {
                    rootGiven.right = new TreeNode(val);
                } else {
                    insert(val, rootGiven.right);
                }
            }
        }
    }

    public void traverseInOrder(){
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public void traversePreOrder(){
        if (root != null) {
            root.traversePreOrder();
        }
    }

    public void traversePostOrder(){
        if (root != null) {
            root.traversePostOrder();
        }
    }
    
    public void traverseLevelOrder(){
        for (int i = 1; i <= getHeight(); i++) {
            printCurrentLevel(root, i);
        }
    }

    private void printCurrentLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1){
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }


    public int getMin(TreeNode root){
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
        }
    }

    public int getMax(TreeNode root){
        if (root.right == null) {
            return root.data;
        } else {
            return getMax(root.right);
        }
    }

    public int getHeight(){
        if (root == null) {
            return -1;
        } else {
            return root.getHeight();
        }
    }
    
    public int sum(){
        if (root == null) {
            return 0;
        } else {
            return root.sum();
        }
    } 

    public int nodeCount(){
        if(root == null) {
            return -1;
        }else {
            return root.nodeCount();
        }
    }

    public int leafNodeCount(){
        if(root == null) {
            return -1;
        }else {
            return root.leafNodeCount();
        }
    }

}
