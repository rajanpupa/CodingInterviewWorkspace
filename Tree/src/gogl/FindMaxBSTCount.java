package gogl;

/*
 * Given a binary tree, find the max elements in the subset tree which is a binary search tree.
 */

public class FindMaxBSTCount {
	
	public static void main(String[] args) {
		Node rnode = Node.createBST(20, 10, 5, 15, 30, 25, 35, 40);
		Node lnode = Node.createBST(100, 50, 45, 55, 150, 151);
		
		Node n = new Node (200);
		n.right = rnode;
		n.left = lnode;
		
		FindMaxBSTCount fmbc = new FindMaxBSTCount();
		System.out.println(fmbc.countMaxBst(n));
		
		/*should be a single binary search tree*/
		Node n2 = new Node (42);
		n2.right = lnode;
		n2.left = rnode;
		System.out.println("second max bst count " + fmbc.countMaxBst(n2));
	}
	
	public int countMaxBst(Node n){
		if(n==null) return 0;
		
		if(isBST(n)) return countNodes(n);
		
		int lcount = countMaxBst(n.left);
		int rcount = countMaxBst(n.right);
		
		boolean isbstLeft = isBST(n.left);
		boolean isbstRight = isBST(n.right);
		
		int countWithLeft = lcount;
		int countWithRight = rcount;
		
		if( isbstLeft ){
			if(n.left != null && n.left.val < n.val) countWithLeft ++;
		}else if( isbstRight ){
			if(n.right != null && n.right.val > n.val) countWithRight ++;
		}
		
		return countWithLeft > countWithRight ? countWithLeft : countWithRight;
		
	}

	private int countBST(Node node) {
		if(isBST(node)) return(countNodes(node));
		
		
		
		return 0;
	}

	private int countNodes(Node n) {
		if(n==null) return 0;
		int lcount = countNodes(n.left);
		int rcount = countNodes(n.right);
		
		return lcount + rcount + 1;
	}

	private boolean isBST(Node n){
		if(n==null) return true;
		
		if(isBST(n.left) && isBST(n.right)){
			if(n.left != null && n.left.val > n.val) return false;
			if(n.right!= null && n.right.val < n.val) return false;
			
			return true;
		}
		return false;
	}
}

class Node{
	int val;
	Node left;
	Node right;
	
	public Node(int val){
		this.val = val;
	}
	
	static Node createBST(int ...n){
		
		if(n.length == 0) return null;
		else{
			Node parent = null;
			for(int i=0; i<n.length; i++){
				parent = Node.insertNode(parent, new Node(n[i]));
			}
			return parent;
		}
		
		
	}
	
	static Node insertNode(Node parent, Node n){
		Node p1 = parent;
		
		if(p1 == null) return n;
		
		else{
			while(p1 != null ){
				if(p1.val > n.val ){
					// go left
					if(p1.left != null){
						p1 = p1.left;
					}else{
						p1.left = n;
						break;
					}
				}else if(p1.val < n.val){
					// go right
					if(p1.right != null){
						p1 = p1.right;
					}else{
						p1.right = n;
						break;
					}
				}
			}
		}
		
		return parent;
		
	}
}


