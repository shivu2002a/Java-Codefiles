package Data_structures_And_Algo.Trees;

import java.util.*;

import Data_structures_And_Algo.Trees.BinaryTrees.*;

public class IterativeTraversals {
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        System.out.println("PreOrder: "+ iterativePreorder(tree.root));
        System.out.println("InOrder: "+ iterativeInOrder(tree.root));
        // System.out.println("\n" + iterativePostOrder(tree.root));
        System.out.println(iterativeLevelOrder(tree.root));
        
    }

    
    // Iterative Preorder
    public static ArrayList<Integer> iterativePreorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.data);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;        
    }
    
    public static ArrayList<Integer> iterativeInOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (true) { 
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    curr = stack.pop();
                    res.add(curr.data);
                    curr = curr.right;
                }                
            }
        }
        return res;
    }
    
    // Iterative postorder
    public static List<Integer> iterativePostOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null){
                    stack.push(curr.right);
                } else {
                    stack.pop();
                    res.add(curr.data);
                }
            } else if (curr.left == prev){
                if(curr.right != null){
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    res.add(curr.data);
                }
            } else if (curr.right == prev) { 
                stack.pop();
                res.add(curr.data);
            }
            prev = curr;
        }    
        return res;
    }

    private static List<List<Integer>> iterativeLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int level = q.size();
            for (int i = 0; i < level; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                list.add(q.poll().data);
            }
            result.add(0, list);
        }
        return result;
    }
}
