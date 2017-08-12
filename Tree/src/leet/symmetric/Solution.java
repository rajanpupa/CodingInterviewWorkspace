package leet.symmetric;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.println(s.isSym(Arrays.asList(2,2)));
	}
	
	/*
	 * Breadth first search.
	 * put one level in an array, check if the array is symmetric or not
	 */
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> t = new ArrayList<>();
        t.add(root);
        
        List<TreeNode> temp = new ArrayList<>();
        int count = t.size();
        int tcount = 0;
        while( ! t.isEmpty() ){
            TreeNode tn = t.remove(0);
            count--;
            if(tn != null){
                temp.add(tn.left);
                temp.add(tn.right);
                tcount += 2;
                //System.out.printf(" adding to the list (%d, %d), tcount=%d \n", tn.left.val, tn.right.val, tcount);
            }
            if(count == 0){
                if( ! isSym(temp) ) return false;
                t.addAll(temp);
                temp = new ArrayList<>();
                count = tcount;
                tcount = 0;

                if (count ==0) break;
            }
        }
        
        return true;
    }
    
    private boolean isSym(List<TreeNode> lst){
        if(lst == null || lst.size()<=1) return true;
        int len = lst.size();
        System.out.println( lst.stream().map(a->a!=null?a.val:null).collect(Collectors.toList()) );
        
        for(int i=0; i<len/2; i++){
            System.out.printf("comparing index %d and %d \n", i, len-i-1);
            if(lst.get(i)==null && lst.get(len-i-1)==null){
                continue;
            }else if (lst.get(i)==null || lst.get(len-i-1)==null){
                return false;
            }else if(lst.get(i).val != lst.get(len-i-1).val ) { 
                System.out.printf(" %d != %d, returning false \n", lst.get(i).val, lst.get(len-i-1).val);
                return false;
            }
        }
        
        return true;
    }
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
