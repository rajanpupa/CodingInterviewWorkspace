package bst;


public class IsBST2 {
	
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(10);
		root.left.right = new Node(25);
		
		root.right = new Node(30);
		root.right.left = new Node(25);
		root.right.right = new Node(40);
		
		chkIsBst(root);
	}

	private static void chkIsBst(Node root) {
		IsBST2 ibst = new IsBST2();
		System.out.println(" is the root BST ? = " + ibst.isBst(root));// should be false
		
		root.left.right.val=15;
		System.out.println(" is the root BST ? = " + ibst.isBst(root));// should be true
		
		root.left.right.val=10;
		System.out.println(" is the root BST ? = " + ibst.isBst(root));//should be false
	}

	/*
	 * inorder traversal of BSt is in ascending order
	 * chk cur element is greater than last element
	 */
	Integer lastVal = null;
	public boolean isBst(Node n){
		lastVal = null;
		return isBinarySearchTree(n);
	}

	private boolean isBinarySearchTree(Node n) {
		if(n==null) return true;
		
		if( ! isBinarySearchTree(n.left) ) return false;
		if(lastVal != null && n.val <= lastVal){
			//System.out.printf("%d <= %d \n" , n.val, lastVal);
			return false;
		}
		lastVal = n.val;
		if( ! isBinarySearchTree(n.right) ) {
			//System.out.printf("right is  not bst" );
			return false;
		}
		
		return true;
	}
	
}

class LastVal{
	int val;
	public LastVal(int val){
		this.val = val;
	}
}
