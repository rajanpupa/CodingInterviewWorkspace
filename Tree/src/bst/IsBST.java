package bst;

import java.util.ArrayList;
import java.util.List;

public class IsBST {
	
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
		IsBST ibst = new IsBST();
		System.out.println(" is the root BST ? = " + ibst.isBst(root));// should be false
		
		root.left.right.val=15;
		System.out.println(" is the root BST ? = " + ibst.isBst(root));// should be true
		
		root.left.right.val=10;
		System.out.println(" is the root BST ? = " + ibst.isBst(root));//should be false but this algorithm will return true
	}

	/*
	 * inorder traversal of BSt is in ascending order
	 */
	public boolean isBst(Node n){
		List<Integer> lst = new ArrayList<>();
		inOrderFillArr(n, lst);
		
		for(int i=1; i<lst.size(); i++){
			if(lst.get(i) < lst.get(i-1)){
				return false;
			}
		}
		
		return true;
	}
	
	public void inOrderFillArr(Node n, List<Integer> lst){
		if(n == null) return;
		inOrderFillArr(n.left, lst);
		lst.add(n.val);
		inOrderFillArr(n.right, lst);
	}
}

