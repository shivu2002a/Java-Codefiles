package Data_structures_And_Algo.SegmentTrees;

import java.util.Arrays;

public class LazyPropagationSegmentTree {
    int st[], lazy[], n;

    public LazyPropagationSegmentTree(int n) {
        this.n = n;
        this.st = new int[4 * n];
        this.lazy = new int[4 * n];
    }

    public void build(int nums[]) {
        helper_build(0, nums.length - 1, 0, nums);
    }

    // Same as segment tree build
    private void helper_build(int start, int end, int node, int nums[]) {

        // If start == end, you're at the leaf node. Just assign the value
        if (start == end) {
            this.st[node] = nums[start];
            return;
        }
        int mid = (start + end) >> 1;

        // left subtree (start, mid)
        helper_build(start, mid, node * 2 + 1, nums);

        // right subtree (mid+1, end)
        helper_build(mid + 1, end, node * 2 + 2, nums);

        // Store the value that serves for the given problem statement
        this.st[node] = this.st[node * 2 + 1] + this.st[2 * node + 2];
    }

    public int query(int l, int r) {
        return query_helper(0, n - 1, l, r, 0);
    }

    private int query_helper(int start, int end, int l, int r, int node) {
        if (lazy[node] != 0) {
            // Updating segment tree value
            st[node] += lazy[node] * (end - start + 1);
            // Lazy propagation the change to child nodes in lazy tree / clear a lazy value
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            // After propagation, set current value to 0
            lazy[node] = 0;
        }

        // no-overlap
        if (start > r || end < l)
            return 0;

        // Complete overlap
        if (start >= l && end <= r)
            return st[node];

        // Partial overlap
        int mid = (start + end) >> 1;
        int q1 = query_helper(start, mid, l, r, 2 * node + 1);
        int q2 = query_helper(mid + 1, end, l, r, 2 * node + 2);
        return q1 + q2;
    }

    public void update(int l, int r, int val) {
        update_helper(0, n - 1, l, r, val, 0);
    }

    // Performing updates
    private void update_helper(int start, int end, int l, int r, int val, int node) {

        if (lazy[node] != 0) {
            // Updating segment tree value
            st[node] += lazy[node] * (end - start + 1);
            // Lazy propagation the change to child nodes in lazy tree / clear a lazy value
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            // After propagation, set current value to 0
            lazy[node] = 0;
        }

        // Non - overlap case
        if (start > r || end < l) {
            return;
        }
        
        // Complete overlap
        if (start >= l && end <= r) {
            st[node] += val * (end - start + 1);
            // Lazy propagation the change to child nodes in lazy tree / clear a lazy value
            if (start != end) {
                lazy[2 * node + 1] += val;
                lazy[2 * node + 2] += val;
            }
            return;
        }

        // Partial overlap
        int mid = (start + end) / 2;
        update_helper(start, mid, l, r, val, 2 * node + 1);
        update_helper(mid + 1, end, l, r, val, 2 * node + 2);

        st[node] = st[2 * node + 1] + st[node * 2 + 2];
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 4, 5, 6, 7, 8, 9};
        LazyPropagationSegmentTree lst = new LazyPropagationSegmentTree(8);
        lst.build(nums);
        System.out.println(lst.query(0, 7));
        System.out.println(Arrays.toString(lst.st) + " " + Arrays.toString(lst.lazy));

        lst.update(0, 7, 1);
        System.out.println(lst.query(0, 7));
        System.out.println(Arrays.toString(lst.st) + " " + Arrays.toString(lst.lazy));
        lst.update(0, 0, 1);
        System.out.println(Arrays.toString(lst.st) + " " + Arrays.toString(lst.lazy));

        System.out.println(lst.query(0, 7));
        System.out.println(lst.query(0, 7));
        
    }

}
