package leet.symmetric;

import leet.Node;

/**
 * 1339. Maximum Product of Splitted Binary Tree
 * 
 *  Given a binary tree root. 
 *  Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 *  Since the answer may be too large, return it modulo 10^9 + 7.
 *
 */
public class MaxProductSumSubtrees {
	long p = 0L;
    public int maxProduct(Node root) {
        if(root == null) return 0;
        
        long treesum = sumSubTree(root);
        
        maxp(root, treesum);
        //maxp(root.right, treesum);
        return (int) (p % (Math.pow(10, 9) + 7));
    }
    
    // this method is optimized to first find the sum of the child subtree and use that
    // rather than calculating the complete sum again.
    private Long maxp(Node root, long sum){
    	if(root == null) return 0L;
        
        long left = maxp(root.left, sum );
        long right = maxp(root.right, sum );
        long thissubtreesum = left + right + root.val;
        
        long otherSubtreeSum = sum - thissubtreesum;
        p = Math.max(p,thissubtreesum * (sum - thissubtreesum));
        
        return thissubtreesum;
    } 
    
    private long sumSubTree(Node root){
        if(root == null) return 0;
        
        long lsum = sumSubTree(root.left);
        long rsum = sumSubTree(root.right);
        return root.val + lsum + rsum;
    }
    
    public static void main(String[] args) {
		Integer[] tree1 = {1,null,2,3,4,null,null,5,6};
		Node root = Node.construct(tree1);
		
		System.out.println(
				new MaxProductSumSubtrees().maxProduct(root)
		);
		
	}
}



