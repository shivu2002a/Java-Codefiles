package Data_structures_And_Algo.Trees.BinaryTrees;

import java.util.*;

import Data_structures_And_Algo.Trees.TreeNode;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(){
        root = null;
    }
    
    public BinaryTree(int... a){
        for (int i : a) {
            if(root == null){
                this.root = new TreeNode(i);
            }else{
                insert(i);
            }
        }
    }
    
    //Inserting at first available position in level order
    public void insert(int data){
        if(root == null){
            root = new TreeNode(data);
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if(temp.left == null){
                temp.left = new TreeNode(data);
                break;
            }else {
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new TreeNode(data);
                break;
            }else{
                q.add(temp.right);
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

    public int getHeight(){
        if (root == null) {
            return -1;
        } else {
            return root.getHeight();
        }
    }
    
    public void printCurrentLevel(TreeNode root, int level) {
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

    public int leafNodes(TreeNode root){
        if(root == null){
            return -1;
        }
        return root.leafNodeCount();
    }

    public int nodeCount(TreeNode root){
        if(root == null)
            return 0;
        return root.nodeCount();
    }

    public int sumNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.sumNodes();
    }
 
}
