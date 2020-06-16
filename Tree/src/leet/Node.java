package leet;

import java.util.LinkedList;
import java.util.List;

public class Node {
	public int val;
	public Node left;
	public Node right;

	Node() {}
	Node(int val) {
		this.val = val;
	}
	Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static Node construct(Integer[] arr) {
		if(arr == null || arr.length==0) return null;
		Node root = new Node(arr[0]);
		
		List<Node> q = new LinkedList<>();
		q.add(root);
		int index = 1;
		
		while(!q.isEmpty() && index < arr.length) {
			Node n = q.remove(0);
			
			Integer nextval = arr[index++];
			if(nextval != null) {
				n.left = new Node(nextval);
				q.add(n.left);
			}else {
				n.left = null;
			}
			
			if(index >= arr.length) break;
			nextval = arr[index++];
			if(nextval != null) {
				n.right = new Node(nextval);
				q.add(n.right);
			}else {
				n.right = null;
			}
		}
		
		return root;
	}

}
