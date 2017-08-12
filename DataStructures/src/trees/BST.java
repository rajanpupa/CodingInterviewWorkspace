package trees;

public class BST {
	
	Node<Integer> root;
	
	public static class Node<E>{
		E data;
		Node<E> left;
		Node<E> right;
		public Node(E data){
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		int[] arr = {25,10,20,5,1,7,50,100,20,30,40, 27, 75, 150};
		
		for(int a: arr){
			bst.add(a);
		}
		
		bst.inorder();
		bst.preorder();
		bst.postorder();
		
		bst.delete(20);
		
		bst.inorder();
	}
	
	// TODO: implement del with two childs
	public void delete(int data){
		if(root==null)return;
		
		Node<Integer> n = root;
		
		while(n!=null ){
			if(data < n.data){
				if(data==n.left.data){
					delete(data, n);
					break;
				}
				n = n.left;
			}else{
				if(data==n.right.data){
					delete(data, n);
					break;
				}
				n=n.right;
			}
		}
	}
	
	private void delete(int data, Node<Integer> parent) {
		Node<Integer> tobeDelNode ;
		
		if(data < parent.data){
			tobeDelNode= parent.left;
			
			if(tobeDelNode.left==null || tobeDelNode.right==null){
				// only one child
				if(tobeDelNode.left==null){
					parent.left = tobeDelNode.right;
				}else{
					parent.left = tobeDelNode.left;
				}
			}else{
				// two children
				// get min element in right, leaf
				Node minRight = removeMin(parent.left.right);
			}
			
		}else{
			tobeDelNode = parent.right;
			
			if(tobeDelNode.left==null || tobeDelNode.right==null){
				// only one child
				if(tobeDelNode.left==null){
					parent.right = tobeDelNode.right;
				}else{
					parent.right = tobeDelNode.left;
				}
			}else{
				// TODO: two child
			}
		}
	}
	
	private Node removeMin(Node node) {
		Node n = node;
		
		while(n.left != null) n = n.left;
		
		return n;
	}

	private void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node n) {
		if(n==null) return;
		
		postorder(n.left);
		postorder(n.right);
		System.out.printf(" " + n.data);
	}

	private void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node n) {
		if(n==null)return;
		
		System.out.printf(" %d", n.data);
		
		preorder(n.left);
		preorder(n.right);
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}
	
	private void inorder(Node n){
		if(n==null)return;
		
		inorder(n.left);
		System.out.printf(" %d", n.data);
		inorder(n.right);
	}

	public void add(int data){
		if(root == null){
			root = new Node(data);
		}else{
			if(data <= root.data && root.left==null){
				root.left = new Node(data);
			}else if(data<=root.data && root.left != null){
				add(data, root.left);
			}else if(data > root.data && root.right == null){
				root.right = new Node(data);
			}else{
				add(data, root.right);
			}
		}
	}
	
	private void add(int data, Node<Integer> n){
		if(data <= n.data){
			if(n.left==null){
				n.left = new Node(data);
			}else{
				add(data, n.left);
			}
		}else{
			if(n.right == null){
				n.right = new Node(data);
			}else{
				add(data, n.right);
			}
		}
	}

}
