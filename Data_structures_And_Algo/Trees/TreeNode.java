package Data_structures_And_Algo.Trees;

public class TreeNode {

    public TreeNode right, left;
    public int data;

    public TreeNode(){
        
    }
    
    public TreeNode(int data){
        this.data = data;
    }

    public void traverseInOrder() {
        if (left != null) {
            left.traverseInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.traverseInOrder();
        }
    }

    public void traversePreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.traversePreOrder();
        }
        if (right != null) {
            right.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (left != null) {
            left.traversePostOrder();
        }
        if (right != null) {
            right.traversePostOrder();
        }
        System.out.print(data + " ");
    }

    public int getHeight(){
        if (left == null || right == null) {
            return 1;
        }
        int lheight = left.getHeight();
        int rheight = right.getHeight();
        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    public int sum(){
        if (left == null && right != null ) {
            return right.sum();
        } else if(right == null && left != null ){
            return left.sum();
        } else if (left == null && right == null) {
            return data;
        }
        return data + left.sum()+right.sum();
    }
    
    public int nodeCount(){
        if (left == null && right != null ) {
            return right.nodeCount();
        } else if(right == null && left != null ){
            return left.nodeCount();
        } else if (left == null && right == null) {
            return 1;
        }
        return 1 + left.nodeCount() + right.nodeCount();
    }

    public int leafNodeCount(){
        if (left == null && right != null ) {
            return right.leafNodeCount();
        } else if(right == null && left != null ){
            return left.leafNodeCount();
        } else if (left == null && right == null) {
            return 1;
        }
        return left.leafNodeCount() + right.leafNodeCount();
    }

    public int sumNodes(){
        if(left == null && right == null){
            return data;
        }
        if(left != null && right == null){
            left.sumNodes();
        }
        if(left == null && right != null){
            right.sumNodes();
        }
        return data + left.sumNodes() + right.sumNodes();
    }
}
