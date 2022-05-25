package Data_structures_And_Algo.Trees.BinaryTrees;

public class BasicBTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(10, 11, 9, 7, 12, 15, 8);
        System.out.println("Height: " + tree.getHeight()+  "\nTotal number of nodes: " + tree.nodeCount(tree.root) + "\nLeafNodes: " + tree.leafNodes(tree.root));
        System.out.println("Sum of data: "  + tree.sumNodes(tree.root));
        tree.traverseLevelOrder();
    }
    
}
