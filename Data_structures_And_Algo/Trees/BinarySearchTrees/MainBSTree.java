package Data_structures_And_Algo.Trees.BinarySearchTrees;

public class MainBSTree {
    
    public static void main(String[] args) {
        BinarySearchTree bsTree = new BinarySearchTree();
        bsTree.insert(25, bsTree.root);
        bsTree.insert(20, bsTree.root);
        bsTree.insert(15, bsTree.root);
        bsTree.insert(27, bsTree.root);
        bsTree.insert(30, bsTree.root);
        bsTree.insert(29, bsTree.root);
        bsTree.insert(26, bsTree.root);
        bsTree.insert(22, bsTree.root);
        bsTree.insert(32, bsTree.root);
        // System.out.print("In-order: ");
        bsTree.traverseInOrder();     
        // System.out.print("\nPre-Order: ");
        // bsTree.traversePreOrder();   
        // System.out.print("\nPost-Order: ");
        // bsTree.traversePostOrder();
        // System.out.print("\nLevel-order: " );
        // bsTree.traverseLevelOrder();
        // System.out.println("\nMin:"+ bsTree.getMin(bsTree.root)  + " Max: " + bsTree.getMax(bsTree.root));
        // System.out.println("Height: " + bsTree.getHeight());
        // System.out.println("Sum of data: " + bsTree.sum());
        // System.out.println("Number of nodes: " + bsTree.nodeCount());
        // System.out.println("Number of leaf nodes : "+ bsTree.leafNodeCount());
    }
}
