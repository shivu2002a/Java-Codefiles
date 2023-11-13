package Data_structures_And_Algo.Trees.AVLTrees;

public class Main {
    
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        for(int i = 0; i < 1000; i++) {
            avlTree.insert(i);
        }
        System.out.println(avlTree.height());   // Prints 9 because Math.log2(1000) = 9     
    }
}
