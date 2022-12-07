package Data_structures_And_Algo.SegmentTrees;

/**
 * @author Shivanagouda S A
 * Fenwick Tree or Binary Indexed trees are useful for query optimization technique.
 * You may also have used Segment tree but BIT trees require less space and easy to implement when compared to 
 * Segment Trees 
 */

import java.util.Arrays;
public class FenwickTrees {

    int ft[];
    int n;

    public FenwickTrees(int n){
        this.n = n;
        this.ft = new int[n];
    }

    void build(int nums[]){
        for(var i = 1; i < n; i++){
            update(i, nums[i]);
        }
    }

    void update(int ind, int val){
        while(ind < n){
            ft[ind] += val;
            //Find next index which will be affected by updating current index
            ind += ind & (-ind);
        }
    }

    int sum(int ind){
        int s = 0;
        while(ind > 0){
            s += ft[ind];
            ind -= ind & (-ind);
        }
        return s;
    }

    int rangeSum(int left, int right){
        return sum(right) - sum(left - 1);
    }

    public static void main(String args[]){
        //Fenwick tree follows 1-indexed structure, so 0th index is not considered
        int arr[] = {0,1,2,3,4,5,6,7,8};
        var ftree = new FenwickTrees(arr.length);
        ftree.build(arr);

        System.out.println(ftree.rangeSum(1,3));
        
        ftree.update(1, 4);
        
        System.out.println(ftree.rangeSum(1,3));
        System.out.println(ftree.rangeSum(4,5));


    }
    
}