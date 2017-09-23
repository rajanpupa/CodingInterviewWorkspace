package construct.from.traversal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
	
	public static void main(String[] args) {
		int [] in = {1,2,3};
		int [] pre = {2,1,3};
		
		Solution s = new Solution();
		s.buildTree(pre, in);
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 ) return null;
        
        List<Integer> pre = IntStream.of(preorder).boxed().collect(Collectors.toList());
        List<Integer> in = IntStream.of(inorder).boxed().collect(Collectors.toList());
        
        //System.out.println(pre.size());
        
        TreeNode root = buildTree(pre, in);
        
        return root;
        
    }
    
    private TreeNode buildTree(List<Integer> pre, List<Integer> in){
        Integer rootval = pre.get(0);
        TreeNode root = new TreeNode(rootval);
        
        if(pre.size()==1) return root;
        
        // left subtree
        int inrootindex = in.indexOf(rootval);
        if(inrootindex > 0){
            List<Integer> inleft = in.subList(0, inrootindex);
            
            int preleftind=inrootindex < in.size()-1?pre.indexOf(in.get(inrootindex + 1)):pre.size();
            
            List<Integer> preleft = pre.subList(1, preleftind);
            root.left = buildTree(preleft, inleft);
        }
        
        
        
        // right subtree
        
        if(inrootindex<in.size()-1){
            List<Integer> inright = in.subList(inrootindex + 1, in.size());
            
            int preleftind=inrootindex < in.size()-1?pre.indexOf(in.get(inrootindex + 1)):pre.size();
            
            List<Integer> preright = pre.subList(preleftind, pre.size());
            root.right=buildTree(preright, inright);
        }
        
        return root;
        
    }
}


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
