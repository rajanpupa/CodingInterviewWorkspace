package construct.from.traversal;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import atree.TreeNode;

/*
 * Construct the binary tree from inorder and post order traversal
 */
public class FromInAndPostOrder<T> {
	public static void main(String[] args) {
		int [] inorder = {10, 30, 40, 50, 60, 70, 90};
		int [] postorder = {10,40,30, 60, 90,70,50};
		
		FromInAndPostOrder<Integer> c = new FromInAndPostOrder<>();
		TreeNode<Integer> t = c.construct(inorder, postorder);
		
		System.out.println("Work done. Debug and check");
	}

	/*
	 * The last node of the postorder is the root,
	 * In the inorder, the root divides the arr into left and right subtree
	 * In the postorder, the left subtree is followed by right-subtree followed by root
	 */
	public TreeNode<Integer> construct(int [] inorder, int[] postorder) {
		TreeNode<Integer> root = null;
		
		if(inorder == null || postorder == null) return null;
		if(inorder.length != postorder.length) {
			throw new RuntimeException("Size of inorder and postorder should match");
		}
		
		List<Integer> in = IntStream.of(inorder).boxed().collect(Collectors.toList());
		List<Integer> po = IntStream.of(postorder).boxed().collect(Collectors.toList());
		
		int len = inorder.length;
		root = postInConstruct(in, po, 0, len-1, 0, len-1);
		
		return root;
	}
	
	/*
	 * in => inorder arr
	 * po => postorder arr
	 * 
	 * we can recursively call this function and go on constructing the left subtree and the right subtree
	 */
	private TreeNode<Integer> postInConstruct(List<Integer> in,List<Integer> po,
			int instart, int inend, int postart, int poend ){
		if(instart == inend){// return immediately if size is 1
			return new TreeNode<Integer>(in.get(instart));
		}
		
		// root of this subtree is the last element of postorder traversal
		int rootval = po.get(poend);
		TreeNode<Integer> root = new TreeNode<>(rootval);
		
		//left subtree
		int instart2 = instart;
		int inend2 = in.indexOf(rootval)-1;
		int postart2 = po.indexOf(in.get(instart2));//1st elem of in and po will be same
		int poend2 = po.indexOf( in.get(inend2+2) )-1;
		TreeNode<Integer> left = postInConstruct(in, po, instart2, inend2, postart2, poend2);
		//right subtree
		instart2 = inend2+2;
		inend2 = inend;
		postart2=poend2 + 1;
		poend2 = poend -1;
		TreeNode<Integer> right = postInConstruct(in, po, instart2, inend2, postart2, poend2);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
}







