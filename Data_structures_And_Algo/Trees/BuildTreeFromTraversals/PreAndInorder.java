package Data_structures_And_Algo.Trees.BuildTreeFromTraversals;

import Data_structures_And_Algo.Trees.TreeNode;

public class PreAndInorder {

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int in[] = {8, 4, 9, 2, 5, 1, 6, 3, 7};
        TreeNode treeNode = buildTree(pre, in);
        treeNode.traverseInOrder();
    }

    public static TreeNode buildTree(int[] pre, int[] in) {
        if(pre.length != in.length){
            return null;
        }
        return buildTree(pre, in, 0, 0, pre.length-1, in.length-1);
    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder, int preStart, int inStart, int preEnd, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int data = preOrder[preStart];
        TreeNode curr = new TreeNode(data);
        int offset;
        for (offset = inStart; offset < inEnd; offset++) {
            if(inOrder[offset] == data)
                break;
        }
        curr.left = buildTree(preOrder, inOrder, preStart+1, inStart, preEnd+offset-inStart, offset-1);
        curr.right = buildTree(preOrder, inOrder, preStart+offset-inStart+1, offset+1, preEnd, inEnd);
        return curr;
    }
    
}
