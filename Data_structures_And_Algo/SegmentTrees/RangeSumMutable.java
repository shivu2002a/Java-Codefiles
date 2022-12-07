package Data_structures_And_Algo.SegmentTrees;
/**
 * @author Shivanagouda S A
 * {@summary 
 *  This is a classical problem of Segment tree. 
 *  You'll be given an array where there will be online queries. 
 *  You must find the range sum [subarray sum] after particular query.
 * }
 * {@code 
 *  Time complexity - O(NlogN)
 * }
 * 
 */
class RangeSumMutable extends SegmentTree {
    
    public RangeSumMutable(int n) {
        super(n);
    }

    public void build(int nums[]){
        helper_build(0, nums.length - 1, 0, nums);
    }

    public int query(int l, int r) {
        return query_helper(0, n-1, l, r, 0);
    }
    
    public void update(int ind, int val){
        super.update_helper(0, n-1, ind, val, 0);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8};
        RangeSumMutable tree = new RangeSumMutable(8);
        tree.build(nums);

        //Sum of elements from 0th - 4th index
        System.out.println(tree.query(0, 4));
        System.out.println(tree.query(4, 4));

        //Add 'val' to the element at index 'ind' 
        tree.update(0, 2);
        System.out.println(tree.query(0, 1));
    }
}