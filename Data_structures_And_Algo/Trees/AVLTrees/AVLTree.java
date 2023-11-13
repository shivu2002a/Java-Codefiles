package Data_structures_And_Algo.Trees.AVLTrees;

/**
 * @author Shivanagouda S A
 * @implSpec General implementation of AVL Trees (self balancing binary trees)
 * @implSpec
 */
class AVLTreeNode {

    int val, height;
    AVLTreeNode left, right;

    AVLTreeNode(int val) {
        this.val = val;
    }
}

public class AVLTree {

    public AVLTreeNode root;

    public AVLTree() {

    }

    public void insert(int val) {
        root = insert(val, this.root);
    }

    public int height() {
        return height(this.root);
    }

    public int height(AVLTreeNode node) {
        if(node == null) return -1;
        return node.height;
    }

    public AVLTreeNode insert(int val, AVLTreeNode node) {
        if (node == null) {
            node = new AVLTreeNode(val);
            return node;
        } else {
            if (val < node.val) {
                node.left = insert(val, node.left);
            } else {
                node.right = insert(val, node.right);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    public AVLTreeNode rotate(AVLTreeNode node) {
        // Left case
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                // L-L case
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                // L-R case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // Right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // R-R case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // L-R case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    /*
                    p                   c
                c      t3  ->      t1       p
            t1    t2                     t2    t3
     */
    public AVLTreeNode rightRotate(AVLTreeNode p) {
        AVLTreeNode c = p.left;
        AVLTreeNode t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

     /*
                    p                 c
                c      t3  <-    t1       p
            t1    t2                   t2    t3
     */
    public AVLTreeNode leftRotate(AVLTreeNode c) {
        AVLTreeNode p = c.right;
        AVLTreeNode t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }
}
