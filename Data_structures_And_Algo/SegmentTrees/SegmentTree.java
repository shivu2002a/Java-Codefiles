package Data_structures_And_Algo.SegmentTrees;

/** 
 * @author Shivanagouda S A
 * @implNote Basic Segment Tree implementation for Range sum. 
 * You can also change it for finding min, max, frequency etc. in subarray.
 */
public class SegmentTree {
    
    int st[], n;
    
    public SegmentTree(int n) {
        this.n = n;
        this.st = new int[4 * n];
    }

    protected void helper_build(int start, int end, int node, int nums[]){

        // If start == end, you're at the leaf node. Just assign the value
        if(start == end){
            this.st[node] = nums[start];
            return;
        }
        int mid = (start + end) / 2;
        
        // left subtree (start, mid)
        helper_build(start, mid, node * 2 + 1, nums);
        
        // right subtree (mid+1, end)
        helper_build(mid + 1, end, node * 2 + 2, nums);
        
        //Store the value that serves for the given problem statement
        this.st[node] = this.st[node*2 + 1] + this.st[2 * node + 2];
    }

    protected int query_helper(int start, int end, int l, int r, int node) {
        // no-overlap
        if(start > r || end < l)
            return 0;

        //Complete overlap
        if(start >= l && end <= r) 
            return st[node];
        
        //Partial overlap
        int mid = (start + end) / 2;
        int q1 = query_helper(start, mid, l, r, 2*node + 1);
        int q2 = query_helper(mid + 1, end, l, r, 2*node + 2);
        return q1 + q2;
    }

    // Performing updates like changing an element at the given index  
    protected void update_helper(int start, int end, int ind, int val, int node) {
        int mid = (start + end) / 2;
        
        //If at leaf node, set the value and go back
        if(start == end){
            st[node] = val;
            return;
        }

        if(ind <= mid){
            update_helper(start, mid, ind, val, 2*node + 1);
        } else{
            update_helper(mid+1, end, ind, val, 2*node + 2);
        }

        //While coming back, update the parent nodes from child nodes 
        st[node] = st[2*node+1] + st[2*node+2]; 

    }

}
